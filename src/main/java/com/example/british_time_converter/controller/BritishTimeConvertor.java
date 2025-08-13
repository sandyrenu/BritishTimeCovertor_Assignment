package com.example.british_time_converter.controller;

import com.example.british_time_converter.model.Response;
import com.example.british_time_converter.service.BritishTimeConvertorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("/api")
public class BritishTimeConvertor {
    @Autowired
    BritishTimeConvertorService britishTimeConvertorService;

    @GetMapping("/britishTime")
    public ResponseEntity<Response> getBritishTime(@RequestParam("time") String time){
        Response res = new Response();
        try {
            LocalTime localTime = LocalTime.parse(time);
            String spoken = britishTimeConvertorService.toBritishSpokenForm(localTime);
            res.setInput(time);
            res.setSpoken(spoken);
        } catch (DateTimeParseException e) {
            res.setError("Invalid time format. Use HH:mm (e.g., 07:35)");
            return ResponseEntity.badRequest().body(res);
        }
        catch (Exception e) {
            res.setError("Invalid Request");
            return ResponseEntity.badRequest().body(res);
        }
        return ResponseEntity.ok(res);
    }


}
