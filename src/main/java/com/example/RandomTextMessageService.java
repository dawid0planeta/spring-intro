package com.example;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component("randomMessageService")
public class RandomTextMessageService implements MessageService {
    private final List<String> messages = Arrays.asList(
            "message1",
            "message2",
            "message3",
            "message4",
            "message5",
            "message6",
            "message7",
            "message8",
            "message9",
            "message10");

    @Override
    public String getMessage() {
        Random rand = new Random();
        int randIndex = rand.nextInt(messages.size());
        return messages.get(randIndex);
    }
}
