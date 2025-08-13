package com.example.british_time_converter.interfaces;

import java.time.LocalTime;

public interface TimePhraseStrategy {
    boolean matches(LocalTime time);
    String format(LocalTime time);
}
