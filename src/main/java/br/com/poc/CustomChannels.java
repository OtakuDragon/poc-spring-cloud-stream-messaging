package br.com.poc;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 
 * Por padrão o Spring Cloud Stream
 * oferece dois canais 'input' e 'output'
 * para definir outros canais basta declarar
 * uma interface, anota-la conforme abaixo,
 * configurar os canais no application.yml,
 * e incluir a interface a anotação @EnableBindings
 * na classe Application.
 */
public interface CustomChannels {

	@Input("myCustomInputChannel")
	SubscribableChannel myCustomInputChannel();
	
	@Output("myCustomOutputChannel")
	MessageChannel myCustomOutputChannel();
}
