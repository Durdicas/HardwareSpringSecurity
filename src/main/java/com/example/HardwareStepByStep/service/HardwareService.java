package com.example.HardwareStepByStep.service;
import com.example.HardwareStepByStep.dto.HardwareDTO;
import java.util.List;
import java.util.Optional;

public interface HardwareService {
    List<HardwareDTO> findAll();

    Optional<HardwareDTO> findByCode(String code);

    Optional<HardwareDTO> save(HardwareDTO hardwareDTO);

    Optional<HardwareDTO> update(String code, HardwareDTO updatedHardwareDTO);

    void deleteByCode(String code);
}