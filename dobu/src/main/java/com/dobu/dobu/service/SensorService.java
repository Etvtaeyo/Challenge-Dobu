package com.dobu.dobu.service;

import com.dobu.dobu.entity.Sensor;
import com.dobu.dobu.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    private final SensorRepository repository;

    public SensorService(SensorRepository repository) {
        this.repository = repository;
    }

    public Sensor salvar(Sensor sensor){

        if(sensor.getTemperatura() > 30){
            throw new RuntimeException("Temperatura crítica para o pet!");
        }

        return repository.save(sensor);
    }

    public List<Sensor> listarPorPet(Long petId){
        return repository.findByPetId(petId);
    }
}
