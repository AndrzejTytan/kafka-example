package dev.danwys.kafka_example;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {
    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // record MessageRequest has parameter "message" - incoming HTTP request body
    // should contain a key named "message". e.g.:
    // {"message": "test msg 123"}
    @PostMapping
    public void publish(@RequestBody MessageRequest request) {
        kafkaTemplate.send("funds", request.message());
    }
}
