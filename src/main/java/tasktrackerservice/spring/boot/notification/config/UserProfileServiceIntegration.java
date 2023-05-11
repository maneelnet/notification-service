package tasktrackerservice.spring.boot.notification.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "user-profile-integration")
@Data
public class UserProfileServiceIntegration {
    private String url;
    private String pathByTelegramId;
    private String pathById;
}
