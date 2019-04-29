package codesquad.util;

import codesquad.domain.User;

import javax.servlet.http.HttpSession;
import java.util.Optional;

public class SessionUtil {
    public static final String LOGIN_SESSION_KEY = "loginedUser";

    public static void setUserSession(HttpSession session, User user) {
        session.setAttribute(LOGIN_SESSION_KEY, user);
    }

    public static User getUserSession(HttpSession session) {
        return Optional.ofNullable((User) session.getAttribute(LOGIN_SESSION_KEY))
                .orElseThrow(RuntimeException::new);
    }

    public static boolean isLoginUser(HttpSession session) {
        return session.getAttribute(LOGIN_SESSION_KEY) != null;
    }

    public static void removeUserSession(HttpSession session) {
        session.removeAttribute(LOGIN_SESSION_KEY);
    }
}
