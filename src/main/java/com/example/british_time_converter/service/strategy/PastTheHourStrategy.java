package com.example.british_time_converter.service.strategy;

import com.example.british_time_converter.constant.TimeEnum;
import com.example.british_time_converter.interfaces.TimePhraseStrategy;
import org.springframework.stereotype.Component;
import java.time.LocalTime;

@Component
public class PastTheHourStrategy implements TimePhraseStrategy {

    @Override
    public boolean matches(LocalTime time) {
        return time.getMinute() > 0 && time.getMinute() <= 30;
    }

    @Override
    public String format(LocalTime time) {
        int hourIn12 = time.getHour() % 12 == 0 ? 12 : time.getHour() % 12;
        return minutePhrase(time.getMinute()) + " past " + TimeEnum.getWordByNumber(hourIn12);
    }

    private String minutePhrase(int minute) {
        String word = TimeEnum.getWordByNumber(minute);
        if (word != null) return word;
        if (minute < 30) return "twenty-" + TimeEnum.getWordByNumber(minute - 20);
        throw new IllegalArgumentException("Invalid minute: " + minute);
    }
}

