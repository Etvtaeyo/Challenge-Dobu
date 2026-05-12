package com.dobu.dobu.service;

import com.dobu.dobu.dto.ConsultaDTO;
import com.dobu.dobu.entity.*;
import com.dobu.dobu.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final PetRepository petRepository;
    private final MedicoRepository medicoRepository;

    public ConsultaService(ConsultaRepository consultaRepository,
                           PetRepository petRepository,
                           MedicoRepository medicoRepository) {
        this.consultaRepository = consultaRepository;
        this.petRepository = petRepository;
        this.medicoRepository = medicoRepository;
    }

    public Consulta salvar(ConsultaDTO dto){

        Pet pet = petRepository.findById(dto.petId)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));

        Medico medico = medicoRepository.findById(dto.medicoId)
                .orElseThrow(() -> new RuntimeException("Médico não encontrado"));

        if(dto.data.isBefore(LocalDateTime.now())){
            throw new RuntimeException("Não pode agendar no passado");
        }

        if(consultaRepository.existsByMedicoAndData(medico, dto.data)){
            throw new RuntimeException("Médico já ocupado");
        }

        Consulta consulta = new Consulta();
        consulta.setData(dto.data);
        consulta.setDescricao(dto.descricao);
        consulta.setPet(pet);
        consulta.setMedico(medico);

        return consultaRepository.save(consulta);
    }
}
