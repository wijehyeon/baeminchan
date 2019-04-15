package codesquad.web;

import codesquad.domain.LoginDTO;
import codesquad.domain.User;
import codesquad.domain.UserDTO;
import codesquad.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/users")
public class ApiUserController {

    @Resource(name = "userService")
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> create(@Valid @RequestBody UserDTO userDTO) {
        User user = userService.create(userDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/users/" + user.getId()));
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> login(@Valid @RequestBody LoginDTO loginDTO) {
        userService.login(loginDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
