package codesquad.domain;

import codesquad.exception.MismatchPasswordException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {

    @NotBlank(message = "email을 입력해주세요.")
    @Email(message = "메일의 양식을 지켜주세요")
    private String email;

    @NotBlank(message = "name을 입력해주세요.")
    private String name;

    @NotBlank(message = "password를 입력해주세요.")
    private String password;

    @NotBlank(message = "password를 입력해주세요.")
    private String password2;

    @NotBlank(message = "전화번호를 작성해주세요")
    @Pattern(regexp = "[0-9]{10,11}", message = "10~11자리의 숫자만 입력가능합니다")
    private String phoneNumber;

    public boolean isPasswordCorrect(){
        if(!this.password.equals(password2))
            throw new MismatchPasswordException("mismatch password ");
        return this.password.equals(password2);
    }
}