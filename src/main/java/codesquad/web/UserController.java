package codesquad.web;

import codesquad.domain.UserDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @RequestMapping("/signUp")
    public void signUp(UserDTO userDTo){

    }
}
