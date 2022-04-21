package com.example.task16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/workers")
public class WorkerController {
    private final WorkerDAO dao;

    @Autowired
    public WorkerController(WorkerDAO dao) {
        this.dao = dao;
    }


    @GetMapping(value="")
    public ResponseEntity<List<Worker>> read() {
        final List<Worker> workers = dao.readAll();
        return workers != null && !workers.isEmpty()
                ? new ResponseEntity<>(workers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Worker> read(@PathVariable(name="id") long id) {
        final Worker worker = dao.read(id);
        return worker != null
                ? new ResponseEntity<>(worker, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/firstName/{firstName}")
    public ResponseEntity<List<Worker>> findWorkersByFirstName(@PathVariable(name="firstName") String firstName) {
        final List<Worker> workers = dao.findWorkersByFirstName(firstName);
        return workers != null && !workers.isEmpty()
                ? new ResponseEntity<>(workers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
