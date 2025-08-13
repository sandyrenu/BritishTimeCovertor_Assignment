package com.example.british_time_converter.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BritishTimeConvertorServiceTest {

    @Autowired
    private BritishTimeConvertorService service;

    @Test
    void testExactHours() {
        assertEquals("one o'clock", service.toBritishSpokenForm(LocalTime.of(1, 0)));
        assertEquals("noon", service.toBritishSpokenForm(LocalTime.of(12, 0)));
        assertEquals("midnight", service.toBritishSpokenForm(LocalTime.of(0, 0)));
        assertEquals("eleven o'clock", service.toBritishSpokenForm(LocalTime.of(11, 0)));
    }

    @Test
    void testMinutesPastHour() {
        assertEquals("five past two", service.toBritishSpokenForm(LocalTime.of(2, 5)));
        assertEquals("ten past three", service.toBritishSpokenForm(LocalTime.of(3, 10)));
        assertEquals("quarter past four", service.toBritishSpokenForm(LocalTime.of(4, 15)));
        assertEquals("twenty past five", service.toBritishSpokenForm(LocalTime.of(5, 20)));
        assertEquals("twenty-five past six", service.toBritishSpokenForm(LocalTime.of(6, 25)));
        assertEquals("half past seven", service.toBritishSpokenForm(LocalTime.of(7, 30)));
    }

    @Test
    void testMinutesToHour() {
        assertEquals("twenty-five to eight", service.toBritishSpokenForm(LocalTime.of(7, 35)));
        assertEquals("twenty to nine", service.toBritishSpokenForm(LocalTime.of(8, 40)));
        assertEquals("quarter to ten", service.toBritishSpokenForm(LocalTime.of(9, 45)));
        assertEquals("ten to eleven", service.toBritishSpokenForm(LocalTime.of(10, 50)));
        assertEquals("five to twelve", service.toBritishSpokenForm(LocalTime.of(11, 55)));
    }

    @Test
    void testOtherMinutes() {
        assertEquals("twenty-eight to seven", service.toBritishSpokenForm(LocalTime.of(6, 32)));
        assertEquals("one to twelve", service.toBritishSpokenForm(LocalTime.of(11, 59)));
    }
}
