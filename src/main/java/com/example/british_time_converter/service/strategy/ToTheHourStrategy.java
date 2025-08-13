package com.example.british_time_converter.service.strategy;

import com.example.british_time_converter.constant.TimeEnum;
import com.example.british_time_converter.interfaces.TimePhraseStrategy;
import org.springframework.stereotype.Component;
import java.time.LocalTime;

@Component
public class ToTheHourStrategy implements TimePhraseStrategy {

    @Override
    public boolean matches(LocalTime time) {
        return time.getMinute() > 30;
    }

    @Override
    public String format(LocalTime time) {
        int minsTo = 60 - time.getMinute();
        int nextHour = (time.getHour() + 1) % 12 == 0 ? 12 : (time.getHour() + 1) % 12;
        return minutePhrase(minsTo) + " to " + TimeEnum.getWordByNumber(nextHour);
    }

    private String minutePhrase(int minute) {
        String word = TimeEnum.getWordByNumber(minute);
        if (word != null) return word;
        if (minute < 30) return "twenty-" + TimeEnum.getWordByNumber(minute - 20);
        throw new IllegalArgumentException("Invalid minute: " + minute);
    }
}

