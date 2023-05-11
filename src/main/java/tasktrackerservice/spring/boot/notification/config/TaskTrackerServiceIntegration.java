package tasktrackerservice.spring.boot.notification.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "task-tracker-service-integration")
@Data
public class TaskTrackerServiceIntegration {
    private String url;
    private String pathByUserId;
}


