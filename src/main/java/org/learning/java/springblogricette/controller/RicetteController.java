package org.learning.java.springblogricette.controller;

import org.learning.java.springblogricette.model.Ricetta;
import org.learning.java.springblogricette.repository.RicettaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class RicetteController {

    @Autowired
    private RicettaRepository ricettaRepository;

    @GetMapping
    public String ricette(Model model) {
        List<Ricetta> ricettaList = ricettaRepository.findAll();
        model.addAttribute("ricette", ricettaList);
        return "ricettaList";
    }

    @GetMapping("/show/{ricettaId}")
    public String show(@PathVariable("ricettaId") Integer id, Model model) {
        Optional<Ricetta> ricettaOptional = ricettaRepository.findById(id);
        if (ricettaOptional.isPresent()) {
            Ricetta ricettaFromDb = ricettaOptional.get();
            model.addAttribute("ricetta", ricettaFromDb);
            return "detail";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


}
