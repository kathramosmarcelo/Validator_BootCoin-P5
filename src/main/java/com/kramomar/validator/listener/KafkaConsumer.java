package com.kramomar.validator.listener;

import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kramomar.validator.util.Topic;

import org.slf4j.Logger;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
@Service
public class KafkaConsumer {

    private  final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    //private final PaymentComponent  paymentComponent;
    
	@KafkaListener(topics = Topic.CREATE_SHOPPING, groupId = "group_id")
//	@SendTo
	public void consume(String mesage){
		logger.info("TOPIC CREATE_SHOPPING_COIN from SHOPPING_COIN"+  mesage );

	}
	
}	