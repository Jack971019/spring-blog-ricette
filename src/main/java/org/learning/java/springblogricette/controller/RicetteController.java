package org.learning.java.springblogricette.controller;

import org.learning.java.springblogricette.model.Ricetta;
import org.learning.java.springblogricette.repository.RicettaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/delete/{id}")
    public String deletebyId(@PathVariable Integer id) {
        ricettaRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Ricetta> result = ricettaRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("ricetta", result.get());
            return "/edit";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/edit/{id}")
    public String doEdit(@PathVariable Integer id, @ModelAttribute("ricetta") Ricetta editRicetta,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/edit";
        }
        ricettaRepository.save(editRicetta);
        return "redirect:/";
    }


}
