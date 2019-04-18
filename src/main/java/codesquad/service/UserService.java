package codesquad.service;

import codesquad.domain.*;
import codesquad.exception.BadRequestException;
import codesquad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service("userService")
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public User save(UserRequestDTO userRequestDTO) {
        if(userRepository.findByEmail(userRequestDTO.getEmail()).isPresent()){
            throw new BadRequestException("이미 존재하는 이메일입니다");
        }
        return userRepository.save(userRequestDTO.toEntity());
    }

    @Transactional(readOnly = true)
    public List<UserResponseDTO> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(UserResponseDTO::new)
                .collect(Collectors.toList());
    }
}
