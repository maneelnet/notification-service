package tasktrackerservice.spring.boot.notification.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import tasktrackerservice.spring.boot.notification.entity.UserProfile;

@RestController(value = "/api/user")
public class UserController {
  /*  private   WebClient webClient;
   private String url = "localhost:8085/api/user-profile/find-by-telegram-id/someTelegramId";

@GetMapping
    public Mono<UserProfile> geUser(){
    return webClient.get().uri(url).retrieve().bodyToMono(UserProfile.class);
}*/
}
