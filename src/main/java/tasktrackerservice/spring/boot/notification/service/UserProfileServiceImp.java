package tasktrackerservice.spring.boot.notification.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tasktrackerservice.spring.boot.notification.api.dto.UserProfileDto;
import tasktrackerservice.spring.boot.notification.config.UserProfileServiceIntegration;

@EnableConfigurationProperties
@AllArgsConstructor
@Service
public class UserProfileServiceImp implements UserProfileService {
    private WebClient.Builder builder;
    private UserProfileServiceIntegration userProfileIntegration;
    @Override
    public UserProfileDto getUserByTelegramId(long telegramId) {
        String url = userProfileIntegration.getUrl();
        String path = userProfileIntegration.getPathByTelegramId();
        String uri = url + path + telegramId;
        return builder.defaultHeader("Content-Type", "application/json")
                .build().get()
                .uri(uri)
                .retrieve().bodyToMono(UserProfileDto.class)
                .block();
    }
}
