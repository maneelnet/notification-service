package tasktrackerservice.spring.boot.notification.service;

import tasktrackerservice.spring.boot.notification.api.dto.PageDto;

public interface TaskTrackerService {
    PageDto getBugsByUserId(String userId, int page);
}
