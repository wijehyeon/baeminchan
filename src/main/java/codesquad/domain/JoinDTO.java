package codesquad.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class JoinDTO {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 1, max = 20)
    private String name;

    @NotBlank
    @Pattern(regexp = "^$|^\\d{3}-\\d{3,4}-\\d{4}$")
    private String phoneNumber;

    @NotBlank
    @Pattern(regexp = "^[0-9a-zA-Z]+")
    private String password;

    @NotBlank
    @Pattern(regexp = "^[0-9a-zA-Z]+")
    private String password2;

}