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

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private User user;

    private LoginDTO loginDTO;

    private UserDTO userDTO;

    @InjectMocks
    private UserService userService;

    @Before
    public void setUp() {
        userDTO = new UserDTO("email", "name", "password", "010-1234-1234");
        loginDTO = new LoginDTO("email", "password");
        user = new User(1l, "email", "name", "password", "010-1234-1234");
    }

    @Test
    public void 로그인_하지_않음() {

    }

    @Test
    public void 다른_사용자의_접근() {

    }


}
