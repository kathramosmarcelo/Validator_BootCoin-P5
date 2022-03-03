package com.kramomar.validator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kramomar.validator.entity.ValidatorEntity;
import com.kramomar.validator.util.Topic;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class KafkaProducer {


	@Autowired
	public  KafkaTemplate<String, ValidatorEntity> ShoppingkafkaTemplate;
	
	public String createValidator(String status) {
		ShoppingkafkaTemplate.send(Topic.INSERT_VALIDATOR, new ValidatorEntity("SHOP-001",status,150.0,"YUNKI","912119007"));
	    return "CORRECT VALIDATION :D";
	}

	public ValidatorEntity publishEventcreateValidator(ValidatorEntity validatorEntity){
		ShoppingkafkaTemplate.send(Topic.INSERT_VALIDATOR,validatorEntity);
	    return validatorEntity;
	}
	
	
	
	
	
}
