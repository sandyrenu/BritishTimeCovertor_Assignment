package com.example.british_time_converter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    String input;
    String spoken;
    String error;
}
