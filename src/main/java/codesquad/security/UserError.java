package codesquad.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserError {
    private String errorMessage;
    private String cause;

    @Override
    public String toString() {
        return "UserError [errorMessage=" + errorMessage + ", cause=" + cause + "]";
    }
}
