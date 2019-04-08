package codesquad.web;

import codesquad.domain.User;
import codesquad.domain.UserDTO;
import codesquad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class ApiUserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody UserDTO userDTO) {
        User user = userService.save(userDTO);


    }
}
