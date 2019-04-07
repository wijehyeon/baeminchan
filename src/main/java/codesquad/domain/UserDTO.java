package codesquad.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    @Size(max = 30)
    private String email;

    @Size(max = 30)
    private String name;

    @Size(max = 30)
    private String password;

    @Size(max = 15)
    private String phoneNumber;

}