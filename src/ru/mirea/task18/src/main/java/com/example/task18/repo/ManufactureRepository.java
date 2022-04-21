package com.example.task18.repo;

import com.example.task18.entity.Manufacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ManufactureRepository extends JpaRepository<Manufacture, Long> {

    List<Manufacture> findAllByAddress(String address);

}
