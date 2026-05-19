package com.dobu.dobu.service;

import com.dobu.dobu.entity.Vacina;
import com.dobu.dobu.repository.VacinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacinaService {

    private final VacinaRepository repository;

    public VacinaService(VacinaRepository repository) {
        this.repository = repository;
    }

    public List<Vacina> listar() {
        return repository.findAll();
    }

    public Vacina buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Histórico de vacina não encontrada"));
    }

    public Vacina salvar(Vacina vacina) {
        return repository.save(vacina);
    }

    public Vacina atualizar(Long id, Vacina atualizada) {

        Vacina vacina = buscarPorId(id);

        vacina.setNomeVacina(atualizada.getNomeVacina());
        vacina.setDataAplicacao(atualizada.getDataAplicacao());
        vacina.setProximaDose(atualizada.getProximaDose());
        vacina.setPet(atualizada.getPet());

        return repository.save(vacina);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
