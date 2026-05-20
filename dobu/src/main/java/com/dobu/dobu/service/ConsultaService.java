package com.dobu.dobu.service;

import com.dobu.dobu.entity.Consulta;
import com.dobu.dobu.repository.ConsultaRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public List<Consulta> buscarPorDescricao(String descricao){
        return repository.findByDescricaoContainingIgnoreCase(descricao);
    }
    @Cacheable("consultas")
    public List<Consulta> listar() {
        return repository.findAll();
    }

    public Page<Consulta> listar(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Consulta buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
    }

    public Consulta salvar(Consulta consulta) {
        return repository.save(consulta);
    }

    public Consulta atualizar(Long id, Consulta consultaAtualizada) {

        Consulta consulta = buscarPorId(id);

        consulta.setDescricao(consultaAtualizada.getDescricao());
        consulta.setValor(consultaAtualizada.getValor());
        consulta.setDataConsulta(consultaAtualizada.getDataConsulta());
        consulta.setPet(consultaAtualizada.getPet());
        consulta.setVeterinario(consultaAtualizada.getVeterinario());

        return repository.save(consulta);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
