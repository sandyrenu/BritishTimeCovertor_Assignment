package com.example.british_time_converter.constant;

public enum TimeEnum {
    ZERO(0, "o'clock"),
    ONE(1, "one"),
    TWO(2, "two"),
    THREE(3, "three"),
    FOUR(4, "four"),
    FIVE(5, "five"),
    SIX(6, "six"),
    SEVEN(7, "seven"),
    EIGHT(8, "eight"),
    NINE(9, "nine"),
    TEN(10, "ten"),
    ELEVEN(11, "eleven"),
    TWELVE(12, "twelve"),
    THIRTEEN(13, "thirteen"),
    FOURTEEN(14, "fourteen"),
    QUARTER(15, "quarter"),
    SIXTEEN(16, "sixteen"),
    SEVENTEEN(17, "seventeen"),
    EIGHTEEN(18, "eighteen"),
    NINETEEN(19, "nineteen"),
    TWENTY(20, "twenty"),
    TWENTY_FIVE(25, "twenty-five"),
    HALF(30, "half");

    private final int number;
    private final String word;
    TimeEnum(int number, String word) {
        this.number = number;
        this.word = word;
    }
    public static String getWordByNumber(int number) {
        for (TimeEnum t : values()) {
            if (t.number == number) {
                return t.word;
            }
        }
        return "";
    }
}
