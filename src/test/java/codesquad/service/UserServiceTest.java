package codesquad.service;

import codesquad.domain.LoginDTO;
import codesquad.domain.User;
import codesquad.domain.UserRequestDTO;
import codesquad.exception.BadRequestException;
import codesquad.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @InjectMocks
    private UserService userService;

    private UserRequestDTO userRequestDTO;
    private LoginDTO loginDTO;


    @Before
    public void setUp() {
        userRequestDTO = new UserRequestDTO("email@email.com", "name", "01012341234", "pass", "pass");
        loginDTO = new LoginDTO("email@email.com", "pass");
    }

    @Test
    public void 회원가입() {
        User user = new User(userRequestDTO);
        when(passwordEncoder.encode(anyString())).thenReturn("pass");
        assertThat(userRepository.save(userRequestDTO.toUserEntity(passwordEncoder))).isEqualTo(user);
    }

    @Test(expected = BadRequestException.class)
    public void 회원가입_실패_이메일중복() {
        User user = new User(userRequestDTO);
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
        userService.save(userRequestDTO);
    }

    @Test
    public void 로그인_성공() {
        User user = new User(userRequestDTO);
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
        userService.login(loginDTO);
    }

    @Test
    public void 로그인_실패_패스워드_불일치() {

    }

    @Test
    public void 로그인_실패_존재하지_않는_이메일() {

    }

}
