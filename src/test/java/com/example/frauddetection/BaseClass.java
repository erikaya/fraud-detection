package com.example.frauddetection;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@AutoConfigureMessageVerifier
@SpringBootTest(classes = FraudDetectionApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class BaseClass {

    @Autowired
    FraudDetectionController fraudDetectionController;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.standaloneSetup(fraudDetectionController);
    }

    public void trigger(){
        this.fraudDetectionController.trigger();
    }
}
