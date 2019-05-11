package codesquad.security;

import codesquad.exception.AlreadyExistEmailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;

@ControllerAdvice
public class UserExceptionControllerAdvice {
    private static final Logger log = LoggerFactory.getLogger(UserExceptionControllerAdvice.class);

    @Resource(name = "messageSourceAccessor")
    private MessageSourceAccessor msa;

    @ExceptionHandler(AlreadyExistEmailException.class)
    public ResponseEntity<UserError> AlreadyExistEmail(AlreadyExistEmailException exception){
        log.debug("Already Exist Email : " + exception.getMessage() + " Cause : " + exception.getCause());
        UserError userError = new UserError(exception.getMessage(), exception.getCause().toString());
        return new ResponseEntity<>(userError, HttpStatus.BAD_REQUEST);
    }
}
