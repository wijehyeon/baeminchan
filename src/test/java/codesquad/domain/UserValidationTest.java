package codesquad.domain;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;

public class UserValidationTest {
    private static Validator validator;

    @BeforeClass
    public static void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void 이메일_포맷_통과() {
        User user = new User(1l, "email@gmail.com", "name", "password", "010-1234-1234");

        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
        assertThat(constraintViolations.size()).isEqualTo(0);
    }




}
