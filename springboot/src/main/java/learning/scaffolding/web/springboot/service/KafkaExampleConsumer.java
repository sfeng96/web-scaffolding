package learning.scaffolding.web.springboot.service;

import lombok.extern.java.Log;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Log
@Service
public class KafkaExampleConsumer {

  private static final Logger logger = Logger.getLogger(KafkaExampleConsumer.class.getName());
  private static final String TOPIC = "test-topic";


  @KafkaListener(topics = TOPIC)
  public void listen(@Payload String message, Acknowledgment acknowledgment) {
    logger.log(Level.INFO, message);
    acknowledgment.acknowledge();
  }
}
