package com.dobu.dobu.service;

import com.dobu.dobu.entity.HistoricoSistema;
import com.dobu.dobu.repository.HistoricoSistemaRepository;
import org.springframework.stereotype.Service;
import com.dobu.dobu.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class HistoricoSistemaService {

    private final HistoricoSistemaRepository repository;

    public HistoricoSistemaService(HistoricoSistemaRepository repository) {
        this.repository = repository;
    }

    public List<HistoricoSistema> listar() {
        return repository.findAll();
    }

    public HistoricoSistema salvar(HistoricoSistema historico) {
        return repository.save(historico);
    }
}
