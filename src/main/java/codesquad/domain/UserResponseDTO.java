package codesquad.domain;

import lombok.Getter;

@Getter
public class UserResponseDTO {

    private Long id;

    private String name;

    private String phoneNumber;

    private String email;

    //TODO : Response인데 DTO로 감싼 이유 생각해보기
    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
    }

}
