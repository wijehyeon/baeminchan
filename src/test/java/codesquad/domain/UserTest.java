package codesquad.domain;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private User user;

    @Before
    public void setUp(){
        user = new User(1l, "email@gmail.com", "tester", "password", "010-1234-1234");
    }

    @Test(expected = )
    public void 비밀번호_일치(){
        user.matchPassword()
    }
}
