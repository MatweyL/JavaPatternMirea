package com.example.task16.controller;

import com.example.task16.driver.Driver;
import com.example.task16.entity.Manufacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManufactureController {
    private final Driver<Manufacture> manufactureDriver;

    @Autowired
    public ManufactureController(Driver<Manufacture> manufactureDriver) {
        this.manufactureDriver = manufactureDriver;
    }
    @PostMapping(value="/manufactures")
    public ResponseEntity<?> create(@RequestBody Manufacture manufacture){
        manufactureDriver.create(manufacture);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value="/manufactures")
    public ResponseEntity<List<Manufacture>> read() {
        final List<Manufacture> manufactures = manufactureDriver.readAll();
        return manufactures != null && !manufactures.isEmpty()
                ? new ResponseEntity<>(manufactures, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/manufactures/{id}")
    public ResponseEntity<Manufacture> read(@PathVariable(name="id") long id) {
        final Manufacture manufactures = manufactureDriver.read(id);
        return manufactures != null
                ? new ResponseEntity<>(manufactures, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value="/manufactures/{id}")
    public ResponseEntity<?> update(@PathVariable(name="id") long id, @RequestBody Manufacture manufacture) {
        final boolean updated = manufactureDriver.update(manufacture, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value="/manufactures/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") long id) {
        final boolean deleted = manufactureDriver.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}