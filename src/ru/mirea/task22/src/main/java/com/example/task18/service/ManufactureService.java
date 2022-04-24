package com.example.task18.service;

import com.example.task18.entity.Manufacture;
import com.example.task18.repo.ManufactureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class ManufactureService implements AbstractService<Manufacture>{

    private final ManufactureRepository manufactureRepository;
    private final EmailService emailService;

    @Autowired
    public ManufactureService(ManufactureRepository manufactureRepository, EmailService emailService) {
        this.manufactureRepository = manufactureRepository;
        this.emailService = emailService;
    }

    @Transactional
    @Override
    public void create(Manufacture manufacture) {
        log.info("Save manufacture");
        manufactureRepository.save(manufacture);
        emailService.sendNotification(manufacture);
    }

    @Transactional
    @Override
    public List<Manufacture> readAll() {
        log.info("Read all manufacture");
        return manufactureRepository.findAll();
    }

    @Transactional
    @Override
    public Manufacture read(long id) {
        log.info("Read manufacture by id = {}", id);
        return manufactureRepository.getById(id);
    }
    @Transactional
    @Override
    public boolean update(Manufacture manufacture, long id) {
        log.info("Update manufacture with id = {}", id);
        manufacture.setId(id);
        manufactureRepository.save(manufacture);
        return true;
    }

    @Transactional
    @Override
    public boolean delete(long id) {
        log.info("Delete manufacture by id = {}", id);
        manufactureRepository.deleteById(id);
        return true;
    }

    @Transactional
    public List<Manufacture> findAllByAddress(String address) {
        log.info("Find manufactures by address = {}", address);
        return manufactureRepository.findAllByAddress(address);
    }

}
