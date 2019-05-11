package codesquad.web;

import codesquad.domain.LoginDTO;
import codesquad.domain.JoinDTO;
import codesquad.support.test.AcceptanceTest;
import org.junit.ComparisonFailure;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiUserAcceptanceTest extends AcceptanceTest {

    private static final String JOIN_URL = "/users";

    private static final String LOGIN_URL = "/users/login";

    private JoinDTO joinDTO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void 회원가입() {
        joinDTO = new JoinDTO("emailtest@email.com", "name", "010-1234-1234", "password", "password");
        ResponseEntity<Void> responseEntity = template().postForEntity(JOIN_URL, joinDTO, Void.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test(expected = ComparisonFailure.class)
    public void 회원가입_실패_이메일형식() {
        joinDTO = new JoinDTO("email", "name", "010-1234-1234", "password", "password");
        ResponseEntity<Void> responseEntity = template().postForEntity(JOIN_URL, joinDTO, Void.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    public void 로그인() {
        LoginDTO loginDTO = new LoginDTO("email@email.com", "password");
        ResponseEntity<Void> responseEntity = template().postForEntity(LOGIN_URL, loginDTO, Void.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test(expected = ComparisonFailure.class)
    public void 로그앤실패_비밀번호_불일치() {
        LoginDTO loginDTO = new LoginDTO("email@email.com", "pass");
        loginDTO.setPassword(passwordEncoder.encode(loginDTO.getPassword()));
        ResponseEntity<Void> responseEntity = template().postForEntity(LOGIN_URL, loginDTO, Void.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }
}
