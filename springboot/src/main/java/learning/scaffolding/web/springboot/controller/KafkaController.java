package learning.scaffolding.web.springboot.controller;

import learning.scaffolding.web.springboot.model.User;
import learning.scaffolding.web.springboot.service.KafkaExampleProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/kafka")
public class KafkaController {

  private final KafkaExampleProducer kafkaExampleProducer;

  @Autowired
  public KafkaController(KafkaExampleProducer kafkaExampleProducer) {
    this.kafkaExampleProducer = kafkaExampleProducer;
  }

  @PostMapping
  public String sendUserToKafka(@RequestBody User user) {
    this.kafkaExampleProducer.process(user.toString());
    return "processed";
  }
}
