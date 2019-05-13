package codesquad.service;

import codesquad.domain.*;
import codesquad.dto.JoinDTO;
import codesquad.dto.LoginDTO;
import codesquad.dto.UserResponseDTO;
import codesquad.exception.AlreadyExistEmailException;
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
    public User save(JoinDTO joinDTO) {
        if (userRepository.findByEmail(joinDTO.getEmail()).isPresent()) {
            throw new AlreadyExistEmailException("이미 존재하는 이메일");
        }
        User user = new User(joinDTO);
        return userRepository.save(user.encode(passwordEncoder));
    }

    public User login(LoginDTO loginDTO) throws UnexpectedException {
        return userRepository.findByEmail(loginDTO.getEmail())
                .filter(user -> user.matchPassword(loginDTO))
                .orElseThrow(() -> new UnexpectedException("존재하지 않는 이메일"));
    }

    public List<UserResponseDTO> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(UserResponseDTO::new)
                .collect(Collectors.toList());
    }
}
