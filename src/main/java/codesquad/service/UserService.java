package codesquad.service;

import codesquad.domain.*;
import codesquad.exception.BadRequestException;
import codesquad.exception.MismatchPasswordException;
import codesquad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.UnexpectedException;
import java.util.List;
import java.util.stream.Collectors;


@Service("userService")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public User save(UserRequestDTO userRequestDTO) {
        if (userRepository.findByEmail(userRequestDTO.getEmail()).isPresent()) {
            throw new BadRequestException("이미 존재하는 이메일입니다");
        }
        User user = new User(userRequestDTO);
        return userRepository.save(user.encode(passwordEncoder));
    }

    @Transactional(readOnly = true)
    public List<UserResponseDTO> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(UserResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public User login(LoginDTO loginDTO) throws UnexpectedException {

        return userRepository.findByEmail(loginDTO.getEmail())
                .filter(user -> user.match(loginDTO))
                .orElseThrow(() -> new UnexpectedException("존재하지 않는 이메일"));
    }
}
