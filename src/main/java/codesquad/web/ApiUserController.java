package codesquad.web;

import codesquad.domain.LoginDTO;
import codesquad.domain.UserDTO;
import codesquad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        userService.create(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@Valid @RequestBody LoginDTO loginDTO){
        userService.login(loginDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
