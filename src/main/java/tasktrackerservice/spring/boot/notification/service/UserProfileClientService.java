package tasktrackerservice.spring.boot.notification.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import tasktrackerservice.spring.boot.notification.api.dto.UserProfileDto;

public interface UserProfileClientService {

    public UserProfileDto findById(String id) throws JsonProcessingException;

}
