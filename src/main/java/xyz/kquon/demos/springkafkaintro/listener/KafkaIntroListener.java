package xyz.kquon.demos.springkafkaintro.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaIntroListener {

    @Value("${topics.intro-output}")
    private String outputTopic;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @KafkaListener(topics = "${topics.intro-input}")
    public void listen(@Payload String message) {

        log.info("Listener message: {}", message);

        kafkaTemplate.send(outputTopic, "From Listener" + message);

    }

}
