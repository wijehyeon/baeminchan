package codesquad.dto;

import codesquad.util.RegexUtil;
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
    @Pattern(regexp = RegexUtil.PHONE_NUMBER)
    private String phoneNumber;

    @NotBlank
    @Pattern(regexp = RegexUtil.PASSWORD)
    private String password;

    @NotBlank
    @Pattern(regexp = RegexUtil.PASSWORD)
    private String password2;

}