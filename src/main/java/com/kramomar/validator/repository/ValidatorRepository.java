package com.kramomar.validator.repository;

import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;

import com.kramomar.validator.entity.ValidatorEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ValidatorRepository {

		private final ReactiveRedisOperations<String, ValidatorEntity> redisOperations;
		  private final ReactiveHashOperations<String,String, ValidatorEntity> hashOperations;

		  public static final String KEY = "Validator";
		  public ValidatorRepository(ReactiveRedisOperations<String, ValidatorEntity> redisOperations) {
		    this.redisOperations = redisOperations;
		    this.hashOperations = redisOperations.opsForHash();
		  }
		  
		  public Flux<ValidatorEntity> findall(){
		    return hashOperations.values(KEY);
		  }
		  
		  
		  public Mono<ValidatorEntity> save(ValidatorEntity validatorEntity){
			return hashOperations.put(KEY, validatorEntity.getId(), validatorEntity).map(isSaved -> validatorEntity);
		  }	  
}
