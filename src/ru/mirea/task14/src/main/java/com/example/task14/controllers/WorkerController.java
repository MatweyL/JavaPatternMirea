package com.example.task14.controllers;

import com.example.task14.entities.Worker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/worker")
public class WorkerController {

    public static Map<Long, Worker> idToWorker = new HashMap<>();
    private static AtomicLong counter = new AtomicLong();

    @RequestMapping("/new")
    public String createWorker(@ModelAttribute("worker") Worker worker) {
        return "worker/new";
    }

    @PostMapping()
    public String add(@ModelAttribute("worker") Worker worker) {
        Long id = counter.incrementAndGet();
        worker.setId(id);
        idToWorker.put(id, worker);
        System.out.println(idToWorker.toString());
        return "redirect:/worker";
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("workers", new ArrayList<>(idToWorker.values()));
        return "worker/index";
    }

    @RequestMapping("/delete")
    public String deleteWorker(
            @RequestParam(name="id", required=true) Long id) {
        System.out.println();
        idToWorker.remove(id);
        return "redirect:/worker";
    }
}
