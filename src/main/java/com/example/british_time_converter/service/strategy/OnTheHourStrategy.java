package com.example.british_time_converter.service.strategy;

import com.example.british_time_converter.constant.TimeEnum;
import com.example.british_time_converter.interfaces.TimePhraseStrategy;
import org.springframework.stereotype.Component;
import java.time.LocalTime;

@Component
public class OnTheHourStrategy implements TimePhraseStrategy {
    @Override
    public boolean matches(LocalTime time) {
        return time.getMinute() == 0 && !(time.getHour() == 0 || time.getHour() == 12);
    }

    @Override
    public String format(LocalTime time) {
        int hourIn12 = time.getHour() % 12 == 0 ? 12 : time.getHour() % 12;
        return TimeEnum.getWordByNumber(hourIn12) + " o'clock";
    }
}

