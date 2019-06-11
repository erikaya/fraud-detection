package com.example.frauddetection;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.messaging.support.MessageBuilder.withPayload;

@RestController
public class FraudDetectionController {

	private final Source source;

	public FraudDetectionController(Source source) {
		this.source = source;
	}

	@GetMapping("/frauds")
    ResponseEntity<List<String>> frauds(){
		return ResponseEntity.status(200).body(asList("marcin", "josh"));
	}

	@PostMapping("/trigger")
	void trigger(){
		this.source.output().send(withPayload(new Fraud("m"))
				.build());
	}

}

class Fraud {
	String name;

	public Fraud(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
