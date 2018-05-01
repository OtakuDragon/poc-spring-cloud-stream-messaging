package br.com.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerEndpoint {

	@Autowired
	private MessageProducer messageProducer;
	
	@GetMapping(path="/produce/{message}")
	public void produce(@PathVariable("message") String message) {
		messageProducer.publish(new Message(message));
		messageProducer.customPublish(new Message(message));
	}
}
