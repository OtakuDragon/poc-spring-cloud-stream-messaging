package br.com.poc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@StreamListener(Sink.INPUT)
	public void consume(Message message) {
		logger.info(message.getMessage());
	}
	
	@StreamListener("myCustomInputChannel")
	public void customConsume(Message message) {
		logger.info(message.getMessage());
	}
}
