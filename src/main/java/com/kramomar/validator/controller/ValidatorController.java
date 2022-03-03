package com.kramomar.validator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kramomar.validator.entity.ValidatorEntity;
import com.kramomar.validator.listener.KafkaConsumer;
import com.kramomar.validator.repository.ValidatorRepository;
import com.kramomar.validator.service.KafkaProducer;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ValidatorShopping")
public class ValidatorController {
	
private final KafkaProducer kafkaProducer;

private  final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

	private final ValidatorRepository validatorRepository;
	
	@GetMapping("/Data/status/{status}")
	public String SendPayment(@PathVariable String status) {

		logger.info("VALIDATION FROM VALIDATOR CONTROLLER: "+ status);
		return kafkaProducer.createValidator(status);
	}
	
	
	@GetMapping("/getall")
	public Flux<ValidatorEntity> all() {
	return validatorRepository.findall();
	}
	    
	 
	@PostMapping
	Mono<ValidatorEntity> createValidator(@RequestBody ValidatorEntity validatorEntity) {
	return validatorRepository.save(validatorEntity);
	}
	
	
	
}
