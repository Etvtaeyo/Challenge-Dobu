package com.dobu.dobu.service;

import com.dobu.dobu.entity.Raca;
import com.dobu.dobu.repository.RacaRepository;
import org.springframework.stereotype.Service;
import com.dobu.dobu.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class RacaService {

    private final RacaRepository repository;

    public RacaService(RacaRepository repository) {
        this.repository = repository;
    }

    public List<Raca> listar() {
        return repository.findAll();
    }

    public Raca buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Raça não encontrada"));
    }

    public Raca salvar(Raca raca) {
        return repository.save(raca);
    }

    public Raca atualizar(Long id, Raca atualizada) {

        Raca raca = buscarPorId(id);

        raca.setNome(atualizada.getNome());
        raca.setPorte(atualizada.getPorte());
        raca.setExpectativaVida(atualizada.getExpectativaVida());
        raca.setDescricao(atualizada.getDescricao());
        raca.setCuidados(atualizada.getCuidados());
        raca.setEspecie(atualizada.getEspecie());

        return repository.save(raca);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
