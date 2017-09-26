package com.codex.devserver.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

@Configuration
public class MqttAdapter {
	
	private final Logger logger = LoggerFactory.getLogger(MqttAdapter.class);
	@Bean
    public MessageChannel mqttInputChannel() {
    		return new DirectChannel();
    }

	 @Bean
    public MessageProducer inbound() {
		 logger.debug("Inbound");
	    	MqttPahoMessageDrivenChannelAdapter adapter =
	    			new MqttPahoMessageDrivenChannelAdapter("tcp://tkks.asuscomm.com:27552", "log_dev",
	    			                                 "/hello/world");
	    	adapter.setCompletionTimeout(5000);
	    	adapter.setConverter(new DefaultPahoMessageConverter());
	    	adapter.setQos(1);
	    	adapter.setOutputChannel(mqttInputChannel());
	    	return adapter;
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
	    	return new MessageHandler() {
	    		@Override
	    		public void handleMessage(Message<?> message) throws MessagingException {
	    			System.out.println(message.getPayload());
	    		}
	
	    	};
    }
}
