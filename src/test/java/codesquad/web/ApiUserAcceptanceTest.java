package codesquad.web;

import codesquad.domain.LoginDTO;
import codesquad.domain.UserDTO;
import codesquad.repository.UserRepository;
import codesquad.support.test.AcceptanceTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiUserAcceptanceTest extends AcceptanceTest {

    private static final String JOIN_URL = "/users";

    private static final String LOGIN_URL = "/users/login";

    private UserDTO userDTO;

    @Resource
    private UserRepository userRepository;

    @Before
    public void setUp() {
    }

    @Test
    public void 회원가입() {
        userDTO = new UserDTO("email", "name", "password", "password", "010-1234-1234");
        ResponseEntity<Void> responseEntity = template().postForEntity(JOIN_URL, userDTO, Void.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    public void 로그인() {
        LoginDTO loginDTO = new LoginDTO("t", "t");
        ResponseEntity<Void> responseEntity = template().postForEntity(LOGIN_URL, loginDTO, Void.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void 로그앤실패_비밀번호_불일치() {
        LoginDTO loginDTO = new LoginDTO("email", "1234");
        ResponseEntity<Void> responseEntity = template().postForEntity(LOGIN_URL, loginDTO, Void.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }
}
