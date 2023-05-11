package tasktrackerservice.spring.boot.notification.service;

import tasktrackerservice.spring.boot.notification.api.dto.BugDto;
import tasktrackerservice.spring.boot.notification.api.dto.PageDto;

public interface BugService {

    PageDto<BugDto> findAllByAssigneeId(long telegramId, int page);

}
