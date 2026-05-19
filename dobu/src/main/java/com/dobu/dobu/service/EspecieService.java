package com.dobu.dobu.service;

import com.dobu.dobu.entity.Especie;
import com.dobu.dobu.repository.EspecieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecieService {

    private final EspecieRepository repository;

    public EspecieService(EspecieRepository repository) {
        this.repository = repository;
    }

    public List<Especie> listar() {
        return repository.findAll();
    }

    public Especie buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Espécie não encontrada"));
    }

    public Especie salvar(Especie especie) {
        return repository.save(especie);
    }

    public Especie atualizar(Long id, Especie atualizada) {

        Especie especie = buscarPorId(id);

        especie.setNome(atualizada.getNome());
        especie.setDescricao(atualizada.getDescricao());

        return repository.save(especie);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
