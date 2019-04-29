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

    public boolean isCorrectPassword(PasswordEncoder passwordEncoder, LoginDTO loginDTO) {
        if (!passwordEncoder.matches(loginDTO.getPassword(), this.getPassword())) {
            throw new MismatchPasswordException("비밀번호가 다릅니다");
        }
        return true;
    }

    public User encode(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.getPassword());
        return this;
    }

}
