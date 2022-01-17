package Proiect;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Meal {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    String data;

}
