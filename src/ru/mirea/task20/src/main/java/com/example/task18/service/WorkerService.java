package com.example.task18.service;

import com.example.task18.entity.Worker;
import com.example.task18.repo.WorkerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WorkerService implements AbstractService<Worker> {

    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public void create(Worker worker) {
        log.info("Save worker");
        workerRepository.save(worker);
    }

    @Override
    public List<Worker> readAll() {
        log.info("Read all workers");
        return workerRepository.findAll();
    }

    @Override
    public Worker read(long id) {
        log.info("Read worker by id = {}", id);
        return workerRepository.getById(id);
    }

    @Override
    public boolean update(Worker worker, long id) {
        log.info("Update worker with id = {}", id);
        worker.setId(id);
        workerRepository.save(worker);
        return true;
    }

    @Override
    public boolean delete(long id) {
        log.info("Delete worker by id = {}", id);
        workerRepository.deleteById(id);
        return true;
    }

    public List<Worker> findAllByFirstName(String firstName) {
        log.info("Find workers by name = {}", firstName);
        return workerRepository.findAllByFirstName(firstName);
    }

}
