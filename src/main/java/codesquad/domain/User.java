package codesquad.domain;

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

    public User(JoinDTO joinDTO) {
        this.email = joinDTO.getEmail();
        this.name = joinDTO.getName();
        this.password = joinDTO.getPassword();
        this.phoneNumber = joinDTO.getPhoneNumber();
    }

    public User encode(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.getPassword());
        return this;
    }

    public void encodePassword(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(this.getPassword());
    }

    public String generateUrl() {
        return "/users/" + this.getId();
    }

    public boolean matchPassword(LoginDTO loginDTO) {
        if (!password.equals(loginDTO.getPassword())) {
            return false;
        }
        return true;
    }
}
