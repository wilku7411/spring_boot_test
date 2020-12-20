package com.example.demo;

import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private String Begin = "Z adresu pozyskałem następujące dane:";

    @RequestMapping("/")
    public String index() {
        return "Pierwszy projekt i działający server :-D";
    }

    @RequestMapping("/tajne")
    public String metoda() {
        return "Tajny adres :-D";
    }

    @RequestMapping("/tajniejsze")
    public List tajniejsze() {
        List<String> TajnaLista = new ArrayList<>();
        TajnaLista.add("raz");
        TajnaLista.add("dwa");
        TajnaLista.add("trzy");

        return TajnaLista;
    }

    @RequestMapping("/RequestParam")
    public String ExampleRequestParam(
            @RequestParam("imie") String imie,
            @RequestParam(value = "miasto", required = false) String miasto)
            throws Exception {
        String Result = ".";
        if (miasto != null) {
            Result = " mieszkasz w miescie: " + miasto;
        }
        return "Witaj " + imie + Result;
    }

    @GetMapping(value = "/{path1}/{jakiesId}")
    public String PrzykladZPath(@PathVariable String path1, @PathVariable Long jakiesId) throws Exception {
        String Result = Begin + String.format("zasob1 = %s, zasob2 = %d", path1, jakiesId);
        return Result;
    }

    @GetMapping(value = "/{s0}/{d0}/{s1}/{d1}")
    public String PrzykladZPath(
            @PathVariable String s0,
            @PathVariable Long d0,
            @PathVariable String s1,
            @PathVariable Long d1)
            throws Exception {
        String Result = Begin + String.format("%s, %d, %s, %d", s0, d0, s1, d1);
        return Result;
    }

    @GetMapping(value = "/{dzialanie}/{A}/{B}")
    public String Policz(
            @PathVariable String dzialanie,
            @PathVariable Long A,
            @PathVariable Long B)
            throws Exception {

        float Policzone = 0.0f;
        System.out.println(dzialanie);

        if(dzialanie.equals("dodaj")){
            Policzone = A+B;
        }else if(dzialanie.equals("odejmij")){
            Policzone = A-B;
        }else if(dzialanie.equals("mnoz")){
            Policzone = A*B;
        }else if(dzialanie.equals("dziel")){
            Policzone = A/B;
        }else{
            return "oj";
        }

        String Result = Begin + String.format(" Dzialanie: %s, A = %d, B = %d. Wynik = %f", A, B, Policzone);
        return Result;
    }
}