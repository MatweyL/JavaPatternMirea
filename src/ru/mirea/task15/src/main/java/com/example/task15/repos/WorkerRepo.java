package com.example.task15.repos;

import com.example.task15.entity.Worker;
import org.springframework.data.repository.CrudRepository;

public interface WorkerRepo extends CrudRepository<Worker, Long> {
}
