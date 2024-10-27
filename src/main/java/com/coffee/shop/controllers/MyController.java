package com.coffee.shop.controllers;

import com.coffee.shop.entities.Booked;
import com.coffee.shop.repos.BookedRepo;
import com.coffee.shop.services.MyTelegramBot;
import jdk.dynalink.beans.StaticClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class MyController {
    @GetMapping({"/","/home"})
    public  String home(Model mod){
        Booked booked =new Booked(
                0,
                "",
                "",
                "",
                LocalDate.now(),
                LocalTime.now(),
                0
        );
        mod.addAttribute("booked",booked);
        return "index";
    }
    @GetMapping ("/about")
    public String about (Model mod){
        return  "about";
    }
    @GetMapping ({"/services"})
    public  String services(Model mod){

        return "service"  ;
    }
    @GetMapping ({"/contact"})

    public  String contact(Model mod){
        return "contact";
    }
    @GetMapping ({"/menu"})
    public  String menu (Model mod) {
        return "menu";
    }
    @GetMapping ({"/reservation"})
    public  String reservation (Model mod) {
        Booked booked =new Booked(
              0,
                "",
                "",
                "",
                LocalDate.now(),
                LocalTime.now(),
                0
        );
        mod.addAttribute("booked",booked);
        return "reservation";
    }
    @GetMapping ({"/testimonial"})
    public  String testimonial (Model mod) {
        return "testimonial";
    }

    @Autowired
    private BookedRepo bookedRepo;

    @Autowired
    private  MyTelegramBot send;
    @PostMapping({"/success"})
    public String success (@ModelAttribute Booked booked)
    {
        bookedRepo.save(booked);
        send.sendMassage(booked.toString());
        return "success";
    }
}
