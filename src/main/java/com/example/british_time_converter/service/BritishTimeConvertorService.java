package com.example.british_time_converter.service;

import com.example.british_time_converter.constant.TimeEnum;
import com.example.british_time_converter.interfaces.TimePhraseStrategy;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.util.List;

@Service
public class BritishTimeConvertorService {
    private final List<TimePhraseStrategy> strategies;

    public BritishTimeConvertorService(List<TimePhraseStrategy> strategies) {
        this.strategies = strategies;
    }

    public String toBritishSpokenForm(LocalTime time) {
        return strategies.stream()
                .filter(s -> s.matches(time))
                .findFirst()
                .map(s -> s.format(time))
                .orElseThrow(() -> new IllegalArgumentException("No matching strategy for given time"));
    }

}
