package utils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateBuilder {
    public String currentTime(){

        ZonedDateTime date = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return date.format(formatter);
    }
}
