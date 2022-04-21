package com.example.task16.controller;


import com.example.task16.driver.Driver;
import com.example.task16.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/workers")
public class WorkerController {

    private final Driver<Worker> workerDriver;

    @Autowired
    public WorkerController(Driver<Worker> workerDriver) {
        this.workerDriver = workerDriver;
    }
    @PostMapping(value="")
    public ResponseEntity<?> create(@RequestBody Worker worker){
        workerDriver.create(worker);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value="")
    public ResponseEntity<List<Worker>> read() {
        final List<Worker> workers = workerDriver.readAll();
        return workers != null && !workers.isEmpty()
                ? new ResponseEntity<>(workers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Worker> read(@PathVariable(name="id") long id) {
        final Worker worker = workerDriver.read(id);
        return worker != null
                ? new ResponseEntity<>(worker, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<?> update(@PathVariable(name="id") long id, @RequestBody Worker worker) {
        final boolean updated = workerDriver.update(worker, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") long id) {
        final boolean deleted = workerDriver.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
