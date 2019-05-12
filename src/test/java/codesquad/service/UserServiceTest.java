package codesquad.service;

import codesquad.domain.LoginDTO;
import codesquad.domain.User;
import codesquad.domain.JoinDTO;
import codesquad.exception.AlreadyExistEmailException;
import codesquad.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.rmi.UnexpectedException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Spy
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    private JoinDTO joinDTO;
    private LoginDTO loginDTO;


    @Before
    public void setUp() {
        joinDTO = new JoinDTO("email@email.com", "name", "010-1234-1234", "password", "password");
        loginDTO = new LoginDTO("email@email.com", "password");
    }

    @Test
    public void 회원가입() {
        User testUser = new User(joinDTO);
        when(userRepository.save(any(User.class))).thenReturn(testUser);
        assertThat(userService.save(joinDTO)).isEqualTo(testUser);
    }

    @Test(expected = AlreadyExistEmailException.class)
    public void 회원가입_실패_이메일중복() {
        User user = new User(joinDTO);
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
        userService.save(joinDTO);
    }

    @Test
    public void 로그인_성공() throws UnexpectedException {
        User user = new User(joinDTO);
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
        User loginUser = userService.login(loginDTO);
        assertThat(user).isEqualTo(loginUser);
    }
}
