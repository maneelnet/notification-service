package tasktrackerservice.spring.boot.notification.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tasktrackerservice.spring.boot.notification.api.dto.PageDto;
import tasktrackerservice.spring.boot.notification.config.TaskTrackerServiceIntegration;

@EnableConfigurationProperties
@AllArgsConstructor
@Service
public class TaskTrackerServiceImp implements TaskTrackerService {
    private WebClient.Builder builder;
    private TaskTrackerServiceIntegration taskTrackerIntegration;
    @Override
    public PageDto getBugsByUserId(String userId, int page) {
        String url = taskTrackerIntegration.getUrl();
        String path = taskTrackerIntegration.getPathByUserId();
        String uri = url + path + userId + "?pageNumber=" + page;
        return builder.defaultHeader("Content-Type", "application/json")
                .build().get()
                .uri(uri)
                .retrieve().bodyToMono(PageDto.class)
                .block();
    }
}
