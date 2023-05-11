package tasktrackerservice.spring.boot.notification.api.dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDto {

    @JsonSetter("id")
    private String id;


    @JsonSetter("firstName")
    private String firstname;

    @JsonSetter("lastName")
    private String lastname;

    @JsonSetter("email")
    private String email;

    @JsonSetter("phone")
    private String phone;

    @JsonSetter("telegramId")
    private String telegramId;



    @Override
    public String toString() {
        return "UserProfileDto{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", telegramId='" + telegramId + '\'' +
                '}';
    }
}
