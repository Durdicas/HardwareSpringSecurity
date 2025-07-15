package com.example.HardwareStepByStep.repository;
import com.example.HardwareStepByStep.domain.Hardware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SpringDataHardwareRepository extends JpaRepository<Hardware, Integer> {
    Optional<Hardware> findByCode(String name);
}