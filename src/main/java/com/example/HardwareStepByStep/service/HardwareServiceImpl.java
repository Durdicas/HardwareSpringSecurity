package com.example.HardwareStepByStep.service;
import lombok.AllArgsConstructor;

import com.example.HardwareStepByStep.domain.Hardware;
import com.example.HardwareStepByStep.dto.HardwareDTO;
import org.springframework.stereotype.Service;
import com.example.HardwareStepByStep.repository.SpringDataHardwareRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HardwareServiceImpl implements HardwareService {

    private final SpringDataHardwareRepository hardwareRepository;

    @Override
    public List<HardwareDTO> findAll() {
        return hardwareRepository.findAll().stream().map(HardwareDTO::new).collect(Collectors.toList());
    }

    @Override
    public Optional<HardwareDTO> findByCode(String code) {
        return hardwareRepository.findByCode(code).map(HardwareDTO::new);
    }

    @Override
    public Optional<HardwareDTO> save(HardwareDTO hardwareDTO) {
        return Optional.of(new HardwareDTO(hardwareRepository.save(new Hardware(hardwareDTO))));
    }

    @Override
    public Optional<HardwareDTO> update(String code, HardwareDTO updatedHardwareDTO) {

        Optional<Hardware> hardwareDTOOptional = hardwareRepository.findByCode(code);

        if(hardwareDTOOptional.isPresent()) {
            Hardware hardwareToUpdate = hardwareDTOOptional.get();
            hardwareToUpdate.setName(updatedHardwareDTO.getName());
            hardwareToUpdate.setCode(updatedHardwareDTO.getCode());
            hardwareToUpdate.setType(updatedHardwareDTO.getType());
            hardwareToUpdate.setStock(updatedHardwareDTO.getStock());
            hardwareToUpdate.setPrice(updatedHardwareDTO.getPrice());
            Hardware updatedHardware = hardwareRepository.save(hardwareToUpdate);
            return Optional.of(new HardwareDTO(updatedHardware));
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteByCode(String code) {
        Optional<Hardware> hardwareOptional = hardwareRepository.findByCode(code);
        hardwareOptional.ifPresent(hardwareRepository::delete);
    }
}
