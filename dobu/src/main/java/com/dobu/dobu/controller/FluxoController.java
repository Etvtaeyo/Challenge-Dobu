package com.dobu.dobu.controller;

import com.dobu.dobu.entity.Agendamento;
import com.dobu.dobu.entity.Vacina;
import com.dobu.dobu.exception.ResourceNotFoundException;
import com.dobu.dobu.repository.AgendamentoRepository;
import com.dobu.dobu.repository.VacinaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/fluxos" )
public class FluxoController {
    private final AgendamentoRepository agendamentoRepository;
    private final VacinaRepository vacinaRepository;

    public FluxoController(AgendamentoRepository agendamentoRepository, VacinaRepository vacinaRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.vacinaRepository = vacinaRepository;
    }

    @PatchMapping("/agendamentos/{id}/confirmar")
    public ResponseEntity<Agendamento> confirmarAgendamento(@PathVariable Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agendamento não encontrado"));
        agendamento.setStatus("CONFIRMADO");
        return ResponseEntity.ok(agendamentoRepository.save(agendamento));
    }

    @PatchMapping("/vacinas/{id}/registrar-aplicacao")
    public ResponseEntity<Vacina> registrarAplicacao(@PathVariable Long id) {
        Vacina vacina = vacinaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vacina não encontrada"));
        vacina.setDataAplicacao(LocalDate.now());
        vacina.setProximaDose(LocalDate.now().plusYears(1));
        return ResponseEntity.ok(vacinaRepository.save(vacina));
    }

    @GetMapping("/vacinas/proximas")
    public List<Vacina> vacinasProximas(@RequestParam(defaultValue = "30") int dias) {
        LocalDate limite = LocalDate.now().plusDays(Math.max(1, Math.min(dias, 365)));
        return vacinaRepository.findByProximaDoseBetween(LocalDate.now(), limite);
    }
}
