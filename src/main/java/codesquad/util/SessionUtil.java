package codesquad.util;

import javax.servlet.http.HttpSession;

public class SessionUtil {
    public static final String LOGIN_SESSION_KEY = "loginedUser";

    public static boolean isLoginUser(HttpSession session) {
        return session.getAttribute(LOGIN_SESSION_KEY) != null;
    }
}
