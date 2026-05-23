package com.dobu.dobu.service;

import com.dobu.dobu.entity.Prontuario;
import com.dobu.dobu.repository.ProntuarioRepository;
import org.springframework.stereotype.Service;
import com.dobu.dobu.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class ProntuarioService {

    private final ProntuarioRepository repository;

    public ProntuarioService(ProntuarioRepository repository) {
        this.repository = repository;
    }

    public List<Prontuario> listar() {
        return repository.findAll();
    }

    public Prontuario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prontuário não encontrado"));
    }

    public Prontuario salvar(Prontuario prontuario) {
        return repository.save(prontuario);
    }

    public Prontuario atualizar(Long id, Prontuario atualizado) {

        Prontuario prontuario = buscarPorId(id);

        prontuario.setDiagnostico(atualizado.getDiagnostico());
        prontuario.setObservacoes(atualizado.getObservacoes());
        prontuario.setConsulta(atualizado.getConsulta());

        return repository.save(prontuario);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
