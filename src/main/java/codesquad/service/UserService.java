package codesquad.service;

import codesquad.domain.User;
import codesquad.domain.UserDTO;
import codesquad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder
    public User save(UserDTO userDTO){
        User user = new User(userDTO);
    }


}
