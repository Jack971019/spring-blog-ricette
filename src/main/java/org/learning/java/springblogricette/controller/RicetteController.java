package org.learning.java.springblogricette.controller;

import org.learning.java.springblogricette.model.Ricetta;
import org.learning.java.springblogricette.repository.RicettaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class RicetteController {

    @Autowired
    private RicettaRepository ricettaRepository;

    @GetMapping
    public String ricette(Model model){
        List<Ricetta> ricettaList = ricettaRepository.findAll();
        model.addAttribute("ricette", ricettaList);
        return "ricettaList";
    }

}
