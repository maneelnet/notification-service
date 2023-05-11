//package tasktrackerservice.spring.boot.notification.service;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.web.reactive.function.client.WebClient;
//import tasktrackerservice.spring.boot.notification.api.dto.UserProfileDto;
//import tasktrackerservice.spring.boot.notification.config.UserProfileServiceIntegration;
//
//
//public class UserProfileClientServiceImpl implements UserProfileClientService {
//
//    private WebClient.Builder builder = WebClient.builder();
//    private ObjectMapper objectMapper = new ObjectMapper();
//
//    public UserProfileDto findById(String id) throws JsonProcessingException {
//        String userId=id;
//        StringBuilder configPath=new StringBuilder();
//        configPath.append(UserProfileServiceIntegration.url);
//        configPath.append(UserProfileServiceIntegration.path);
//        configPath.append(userId);
//        String user = builder.defaultHeader("Content-Type", "application/json").build().get()
//                .uri(configPath.toString()).retrieve().bodyToMono(String.class).block();
//
//        return objectMapper.readValue(user, UserProfileDto.class);
//    }
//
//
//
//}
