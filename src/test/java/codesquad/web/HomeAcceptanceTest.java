package codesquad.web;

import codesquad.support.test.AcceptanceTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class HomeAcceptanceTest extends AcceptanceTest {

    private static final Logger log = LoggerFactory.getLogger(HomeAcceptanceTest.class);

    private static final String JOIN_URL = "/users/join";
    private static final String LOGIN_URL = "/users/login";

    @Test
    public void 회원가입화면() {
        ResponseEntity<String> responseEntity = template().getForEntity(JOIN_URL, String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        log.debug("body : {}", responseEntity.getBody());
    }

    @Test
    public void 로그인화면() {
        ResponseEntity<String> responseEntity = template().getForEntity(LOGIN_URL, String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
