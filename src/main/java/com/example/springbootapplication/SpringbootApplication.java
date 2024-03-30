package com.example.springbootapplication;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
	// /hello endpoint for application
	@GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name.toUpperCase());
    }
	// /datetime endpoint to get the date and time back
	@GetMapping("/datetime")
	public String getDateTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        
        String formattedDate = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String dayOfWeek = currentDateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        String formattedTime = currentDateTime.format(DateTimeFormatter.ofPattern("HH.mm.ss"));
        
        return "Today's Date is " + formattedDate + ", " + dayOfWeek + " and Time is " + formattedTime;
    }

}
