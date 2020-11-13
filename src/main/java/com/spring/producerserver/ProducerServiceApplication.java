package com.spring.producerserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ProducerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerServiceApplication.class, args);
	}

}

@RestController
class Producer {
	@Value("$ {message}")
	private String message;
	@Value("$ {global-message}")
	private String globalMessage;

	@RequestMapping(method = RequestMethod.GET)
	public Map<String,String> message(){
		Map<String,String> response = new HashMap<>();

	response.put("Message", message);
	response.put("Global.message", globalMessage);
	return response;
	}


}