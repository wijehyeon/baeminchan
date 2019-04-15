package codesquad.service;

import codesquad.domain.LoginDTO;
import codesquad.domain.User;
import codesquad.domain.UserDTO;
import codesquad.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;


    private LoginDTO loginDTO;

    private UserDTO userDTO;

    @InjectMocks
    private UserService userService;

    @Before
    public void setUp() {
        userDTO = new UserDTO("email", "name", "password","password", "010-1234-1234");
        loginDTO = new LoginDTO("email", "password");
    }

    @Test
    public void 회원가입() {
        User user = new User(userDTO);
        when(userRepository.save(user)).thenReturn(user);
    }

    @Test
    public void 로그인_성공() {

    }

    @Test
    public void 로그인_실패_패스워드_불일치() {

    }


}
