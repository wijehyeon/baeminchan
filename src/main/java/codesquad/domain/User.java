package codesquad.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max=30)
    private String email;

    @NotNull
    @Size(max=30)
    private String name;

    @NotNull
    @Size(max=30)
    private String password;

    @NotNull
    @Size(max=15)
    private String phoneNumber;


}
