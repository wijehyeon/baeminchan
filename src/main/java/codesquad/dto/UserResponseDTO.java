package codesquad.dto;

import codesquad.domain.User;
import lombok.Getter;

@Getter
public class UserResponseDTO {

    private Long id;

    private String name;

    private String phoneNumber;

    private String email;

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
    }

}
