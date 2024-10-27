package com.coffee.shop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity (name = "tbl_booked")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booked {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Integer id;
    private  String name ;
    private  String phoneNumber;
    private  String email;
    @DateTimeFormat (pattern = "MM/dd/yyyy")
    private LocalDate date;
    @DateTimeFormat (pattern = "h:mm a")
    private  LocalTime time;
    private  Integer person;

    @Override
    public String toString() {
        return String.format(
                "Booking Details:\n" +
                        "ID: %d\n" +
                        "Name: %s\n" +
                        "Phone Number: %s\n" +
                        "Email: %s\n" +
                        "Date: %s\n" +
                        "Time: %s\n" +
                        "Number of Peop" +
                        "le: %d\n",
                id, name, phoneNumber, email, date, time, person
        );
    }

}






