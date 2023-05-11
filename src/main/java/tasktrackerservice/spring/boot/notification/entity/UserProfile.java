package tasktrackerservice.spring.boot.notification.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@JsonDeserialize(builder = UserProfile.class)
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "userprofile")
public class UserProfile {



    @Id
    private String id;

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    private String email;

    private String phone;

    private String telegramId;

    @Override
    public String toString() {
        return "UserProfile{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", telegramId='" + telegramId + '\'' +
                '}';
    }
}
