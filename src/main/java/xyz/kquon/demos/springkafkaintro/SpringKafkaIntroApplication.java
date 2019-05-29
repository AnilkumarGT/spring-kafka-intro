package xyz.kquon.demos.springkafkaintro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication(scanBasePackages = "xyz.kquon.demos.springkafkaintro")
@EnableKafka
@EnableKafkaStreams
public class SpringKafkaIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaIntroApplication.class, args);
	}

}
