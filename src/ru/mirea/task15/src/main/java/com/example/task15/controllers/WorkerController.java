package com.example.task15.controllers;


import com.example.task15.entity.Worker;
import com.example.task15.repos.WorkerRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/worker")
public class WorkerController {

    private final WorkerRepo workerRepo;

    public WorkerController(WorkerRepo workerRepo) {
        this.workerRepo = workerRepo;
    }

    @RequestMapping("/new")
    public String createWorker(@ModelAttribute("worker") Worker worker) {
        return "worker/new";
    }

    @PostMapping()
    public String add(@ModelAttribute("worker") Worker worker) {
        workerRepo.save(worker);
        return "redirect:/worker";
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("workers", workerRepo.findAll());
        return "worker/index";
    }

    @RequestMapping("/delete")
    public String deleteWorker(
            @RequestParam(name="id", required=true) Long id) {
        workerRepo.deleteById(id);
        return "redirect:/worker";
    }
}
