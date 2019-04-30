package codesquad.domain;

import codesquad.exception.MismatchPasswordException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String email;


    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User(UserRequestDTO userRequestDTO) {
        this.email = userRequestDTO.getEmail();
        this.name = userRequestDTO.getName();
        this.password = userRequestDTO.getPassword();
        this.phoneNumber = userRequestDTO.getPhoneNumber();
    }

    public User encode(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.getPassword());
        return this;
    }

    public boolean match(LoginDTO loginDTO) {
        if (password != loginDTO.getPassword()) {
            return false;
        }
        return true;
    }
}
