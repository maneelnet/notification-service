package tasktrackerservice.spring.boot.notification.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tasktrackerservice.spring.boot.notification.enums.Priority;
import tasktrackerservice.spring.boot.notification.enums.ProgressStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BugDto {
    private String id;
    private String name;
    private String description;
    private ProgressStatus status;
    private Priority priority;
    private String historyId;
    private String authorId;
    private String assigneeId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
