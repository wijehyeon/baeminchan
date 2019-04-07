package codesquad.domain;

import codesquad.exception.UnVerificationException;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    private User user;

    @Before
    public void setUp() {
        user = new User(1l, "email@gmail.com", "tester", "password", "010-1234-1234");
    }

    @Test(expected = UnVerificationException.class)
    public void 비밀번호_불일치() {
        user.isCorrectPassword("fakePassword");
    }

    @Test
    public void 비밀번호_일치() {
        assertThat(user.isCorrectPassword("password")).isTrue();
    }
}
