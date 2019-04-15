package com.myway.kafka.consumer;

import com.myway.dto.EventRequest;
import com.myway.services.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

/**
 * @author Ebru Göksal
 */

public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    @Autowired
    private EventService eventService;

    public Receiver() {
    }

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "Kafka_Employee", groupId = "json")
    public void receiveForAdd(EventRequest employee) {
        LOGGER.info("received employee='{}'", employee.toString());
        saveEvent(employee);
        latch.countDown();
    }
    private void saveEvent(EventRequest foundEmployee) {
        eventService.save(foundEmployee);
    }
}
