package tasktrackerservice.spring.boot.notification.service;

import tasktrackerservice.spring.boot.notification.api.dto.UserProfileDto;

public interface UserProfileService {
    UserProfileDto getUserByTelegramId(long telegramId);
}
