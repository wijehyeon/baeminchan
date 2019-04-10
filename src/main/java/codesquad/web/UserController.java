package codesquad.web;

import codesquad.util.SessionUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/signup")
    public String signup() {
        return "/user/join";
    }

    @GetMapping("/login")
    public String login() {
        return "/user/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        SessionUtil.removeUserSession(session);
        return "redirect:/";
    }
}
