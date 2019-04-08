package codesquad.service;

import codesquad.domain.LoginDTO;
import codesquad.domain.User;
import codesquad.domain.UserDTO;
import codesquad.exception.UnAuthenticationException;
import codesquad.exception.UnVerificationException;
import codesquad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User create(UserDTO userDTO) {
        User user = new User(userDTO);
        user.encodePassword(passwordEncoder);
        return userRepository.save(user);
    }

    public User login(LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.getEmail()).orElseThrow(() -> new UnAuthenticationException("No Such User using having that email"));
        if (!user.isCorrectPassword(passwordEncoder, loginDTO)) {
            throw new UnVerificationException("비밀번호 불일치");
        }
        return user;
    }
}
