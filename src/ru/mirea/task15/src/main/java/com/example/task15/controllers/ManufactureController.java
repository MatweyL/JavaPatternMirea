package com.example.task15.controllers;

import com.example.task15.entity.Manufacture;
import com.example.task15.repos.ManufactureRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/manufacture")
public class ManufactureController {

    private final ManufactureRepo manufactureRepo;

    public ManufactureController(ManufactureRepo manufactureRepo) {
        this.manufactureRepo = manufactureRepo;
    }

    @RequestMapping("/new")
    public String createWorker(@ModelAttribute("manufacture") Manufacture manufacture) {
        return "manufacture/new";
    }

    @PostMapping()
    public String add(@ModelAttribute("manufacture") Manufacture manufacture) {
        manufactureRepo.save(manufacture);
        return "redirect:/manufacture";
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("manufactures", manufactureRepo.findAll());
        return "manufacture/index";
    }

    @RequestMapping("/delete")
    public String deleteWorker(
            @RequestParam(name="id", required=true) Long id) {
        manufactureRepo.deleteById(id);
        return "redirect:/manufacture";
    }


}
