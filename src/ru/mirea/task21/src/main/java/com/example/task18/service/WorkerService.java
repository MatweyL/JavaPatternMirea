package com.example.task18.service;

import com.example.task18.entity.Worker;
import com.example.task18.repo.WorkerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class WorkerService implements AbstractService<Worker> {

    private final WorkerRepository workerRepository;
    private final EmailService emailService;

    @Autowired
    public WorkerService(WorkerRepository workerRepository, EmailService emailService) {
        this.workerRepository = workerRepository;
        this.emailService = emailService;
    }

    @Transactional
    @Override
    public void create(Worker worker) {
        log.info("Save worker");
        workerRepository.save(worker);
        emailService.sendNotification(worker);
    }

    @Transactional
    @Override
    public List<Worker> readAll() {
        log.info("Read all workers");
        return workerRepository.findAll();
    }

    @Transactional
    @Override
    public Worker read(long id) {
        log.info("Read worker by id = {}", id);
        return workerRepository.getById(id);
    }

    @Transactional
    @Override
    public boolean update(Worker worker, long id) {
        log.info("Update worker with id = {}", id);
        worker.setId(id);
        workerRepository.save(worker);
        return true;
    }

    @Transactional
    @Override
    public boolean delete(long id) {
        log.info("Delete worker by id = {}", id);
        workerRepository.deleteById(id);
        return true;
    }

    @Transactional
    public List<Worker> findAllByFirstName(String firstName) {
        log.info("Find workers by name = {}", firstName);
        return workerRepository.findAllByFirstName(firstName);
    }

}
