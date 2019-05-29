package xyz.kquon.demos.springkafkaintro.streams;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class KafkaIntroStreamHandler {

    @Value("${topics.intro-input}")
    private String inputTopic;

    @Value("${topics.intro-output}")
    private String outputTopic;

    @Bean
    public KStream<String, String> streamdata(StreamsBuilder builder) {
        KStream<String, String> mykstream = builder.stream(inputTopic, Consumed.with(Serdes.String(), Serdes.String()))
                .filter((key, value) -> value != null);


        mykstream.mapValues((readOnlyKey, value) -> {
            log.info("Streams message: {}", value);
            return value.concat("hello");
        }).to(outputTopic, Produced.with(Serdes.String(), Serdes.String()));

        return mykstream;
    }


}
