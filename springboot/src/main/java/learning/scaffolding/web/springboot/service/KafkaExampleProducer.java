package learning.scaffolding.web.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaExampleProducer {

  @Value("${app.topic}")
  private String topic;

  private final KafkaTemplate<String, String> kafkaTemplate;

  @Autowired
  public KafkaExampleProducer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void process(String message) {
    this.kafkaTemplate.send(topic, message);
  }
}
