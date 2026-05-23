package com.dobu.dobu.service;

import com.dobu.dobu.dto.ConsultaRequestDTO;
import com.dobu.dobu.dto.ConsultaResponseDTO;
import com.dobu.dobu.entity.Consulta;
import com.dobu.dobu.exception.ResourceNotFoundException;
import com.dobu.dobu.repository.ConsultaRepository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    @Cacheable("consultas")
    public Page<ConsultaResponseDTO> listar(Pageable pageable) {

        return repository.findAll(pageable)
                .map(this::converterParaDTO);
    }

    public ConsultaResponseDTO buscarPorId(Long id) {

        Consulta consulta = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Consulta não encontrada"));

        return converterParaDTO(consulta);
    }

    public List<ConsultaResponseDTO> buscarPorDescricao(String descricao) {

        return repository.findByDescricaoContainingIgnoreCase(descricao)
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public ConsultaResponseDTO salvar(ConsultaRequestDTO dto) {

        Consulta consulta = new Consulta();

        consulta.setDescricao(dto.getDescricao());
        consulta.setValor(dto.getValor());
        consulta.setDataConsulta(dto.getDataConsulta());

        Consulta salva = repository.save(consulta);

        return converterParaDTO(salva);
    }

    public ConsultaResponseDTO atualizar(Long id, ConsultaRequestDTO dto) {

        Consulta consulta = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Consulta não encontrada"));

        consulta.setDescricao(dto.getDescricao());
        consulta.setValor(dto.getValor());
        consulta.setDataConsulta(dto.getDataConsulta());

        Consulta atualizada = repository.save(consulta);

        return converterParaDTO(atualizada);
    }

    public void deletar(Long id) {

        repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Consulta não encontrada"));

        repository.deleteById(id);
    }

    private ConsultaResponseDTO converterParaDTO(Consulta consulta) {

        ConsultaResponseDTO dto = new ConsultaResponseDTO();

        dto.setId(consulta.getId());
        dto.setDescricao(consulta.getDescricao());
        dto.setValor(consulta.getValor());
        dto.setDataConsulta(consulta.getDataConsulta());

        return dto;
    }
}
