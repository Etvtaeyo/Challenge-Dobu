package com.dobu.dobu.service;

import com.dobu.dobu.entity.Agendamento;
import com.dobu.dobu.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.dobu.dobu.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;

    public AgendamentoService(AgendamentoRepository repository) {
        this.repository = repository;
    }

    public Page<Agendamento> listar(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Agendamento buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Agendamento não encontrado"));
    }

    public Agendamento salvar(Agendamento agendamento) {
        return repository.save(agendamento);
    }

    public Agendamento atualizar(Long id, Agendamento atualizado) {

        Agendamento agendamento = buscarPorId(id);

        agendamento.setDataAgendamento(atualizado.getDataAgendamento());
        agendamento.setStatus(atualizado.getStatus());
        agendamento.setPet(atualizado.getPet());
        agendamento.setVeterinario(atualizado.getVeterinario());

        return repository.save(agendamento);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
