package tasktrackerservice.spring.boot.notification.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
public class JsonKafkaConsumer {
    @KafkaListener(topics = "${kafka.topic}")
    public void consume(String message) {
        log.warn(String.format("Message received -> %s", message));
    }
}
