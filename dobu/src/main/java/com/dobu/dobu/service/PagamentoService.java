package com.dobu.dobu.service;

import com.dobu.dobu.entity.Pagamento;
import com.dobu.dobu.repository.PagamentoRepository;
import org.springframework.stereotype.Service;
import com.dobu.dobu.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class PagamentoService {

    private final PagamentoRepository repository;

    public PagamentoService(PagamentoRepository repository) {
        this.repository = repository;
    }

    public List<Pagamento> listar() {
        return repository.findAll();
    }

    public Pagamento buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Histórico de pagamento não encontrado"));
    }

    public Pagamento salvar(Pagamento pagamento) {
        return repository.save(pagamento);
    }

    public Pagamento atualizar(Long id, Pagamento atualizado) {

        Pagamento pagamento = buscarPorId(id);

        pagamento.setValor(atualizado.getValor());
        pagamento.setFormaPagamento(atualizado.getFormaPagamento());
        pagamento.setDataPagamento(atualizado.getDataPagamento());
        pagamento.setConsulta(atualizado.getConsulta());

        return repository.save(pagamento);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}