package br.com.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

	@Autowired
	private CustomChannels customChannels;
	
	private Source source;
	
	//Injeta um source que é o ponto de saida para mensagens no Spring Cloud Stream.
	@Autowired
	public MessageProducer(Source source) {
		this.source = source;
	}
	
	public void publish(Message message) {
		source.output().send(MessageBuilder.withPayload(message).build());
	}
	
	public void customPublish(Message message) {
		customChannels.myCustomOutputChannel().send(MessageBuilder.withPayload(message).build());
	}
}
