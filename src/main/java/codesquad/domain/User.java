package codesquad.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
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

    public User(UserDTO userDTO) {
        if (userDTO.isPasswordCorrect()) {
            this.email = userDTO.getEmail();
            this.name = userDTO.getName();
            this.password = userDTO.getPassword();
            this.phoneNumber = userDTO.getPhoneNumber();
        }
    }

    public User(UserRequestDTO userRequestDTO){
        this.email = userRequestDTO.getEmail();
        this.name = userRequestDTO.getName();
        this.password = userRequestDTO.getPassword();
        this.phoneNumber = userRequestDTO.getPhoneNumber();
    }

    public User(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public boolean isCorrectPassword(PasswordEncoder passwordEncoder, LoginDTO loginDTO) {
        if (!passwordEncoder.matches(loginDTO.getPassword(), this.getPassword())) {
            return false;
        }
        return true;
    }

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }
}
