package tasktrackerservice.spring.boot.notification.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application.yml")
public class BotConfig {


    @Value("${bot.name}")
    private String name;

    @Value("${bot.token}")
    private String token;

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setToken(String token) {
        this.token = token;
    }
}
