package codesquad.web;

import codesquad.util.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "/index";
    }
    @GetMapping("/users/join")
    public String join(HttpSession session){
        if(SessionUtil.isLoginUser(session))
            return "redirect:/";
        return "/join";
    }
    @GetMapping("/users/login")
    public String login(HttpSession session){
        if(SessionUtil.isLoginUser(session))
            return "redirect:/";
        return "/login";
    }
}
