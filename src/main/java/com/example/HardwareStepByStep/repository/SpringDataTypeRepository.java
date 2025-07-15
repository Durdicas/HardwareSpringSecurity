package com.example.HardwareStepByStep.repository;


import com.example.HardwareStepByStep.domain.Hardware;
import com.example.HardwareStepByStep.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpringDataTypeRepository extends JpaRepository<Hardware, Integer> {
    Type findByName(String name);
}