package tasktrackerservice.spring.boot.notification.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import tasktrackerservice.spring.boot.notification.api.dto.BugDto;
import tasktrackerservice.spring.boot.notification.api.dto.PageDto;
import tasktrackerservice.spring.boot.notification.api.dto.UserProfileDto;

import java.util.List;

@EnableConfigurationProperties
@AllArgsConstructor
@Service
public class BugServiceImp implements BugService {
    private UserProfileService userProfileService;
    private TaskTrackerService taskTrackerService;
    private ObjectMapper mapper;

    @Override
    public PageDto findAllByAssigneeId(long telegramId, int page) {
        mapper.registerModule(new JavaTimeModule());
        UserProfileDto user = userProfileService.getUserByTelegramId(telegramId);
        PageDto<BugDto> pageDto = taskTrackerService.getBugsByUserId(user.getId(), page);
        pageDto.setItems(mapper.convertValue(pageDto.getItems(), new TypeReference<List<BugDto>>(){}));
        return pageDto;
    }
}
