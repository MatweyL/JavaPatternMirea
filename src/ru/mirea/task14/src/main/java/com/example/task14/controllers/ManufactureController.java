package com.example.task14.controllers;

import com.example.task14.entities.Manufacture;
import com.example.task14.entities.Worker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/manufacture")
public class ManufactureController {
    public static Map<Long, Manufacture> idToManufacture = new HashMap<>();
    private static AtomicLong counter = new AtomicLong();

    @RequestMapping("/new")
    public String createWorker(@ModelAttribute("manufacture") Manufacture manufacture) {
        return "manufacture/new";
    }

    @PostMapping()
    public String add(@ModelAttribute("manufacture") Manufacture manufacture) {
        Long id = counter.incrementAndGet();
        manufacture.setId(id);
        idToManufacture.put(id, manufacture);
        System.out.println(idToManufacture.toString());
        return "redirect:/manufacture";
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("manufactures", new ArrayList<>(idToManufacture.values()));
        return "manufacture/index";
    }

    @RequestMapping("/delete")
    public String deleteWorker(
            @RequestParam(name="id", required=true) Long id) {
        System.out.println();
        idToManufacture.remove(id);
        return "redirect:/manufacture";
    }


}
