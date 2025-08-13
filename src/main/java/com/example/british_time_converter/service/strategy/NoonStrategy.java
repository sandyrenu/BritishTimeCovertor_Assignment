package com.example.british_time_converter.service.strategy;

import com.example.british_time_converter.interfaces.TimePhraseStrategy;
import org.springframework.stereotype.Component;
import java.time.LocalTime;

@Component
public class NoonStrategy implements TimePhraseStrategy {
    @Override
    public boolean matches(LocalTime time) {
        return time.getHour() == 12 && time.getMinute() == 0;
    }

    @Override
    public String format(LocalTime time) {
        return "noon";
    }
}

