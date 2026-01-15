package com.season.nevends.util;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtilMethods {

    public static String parseDateToString(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm"));
    }
}
