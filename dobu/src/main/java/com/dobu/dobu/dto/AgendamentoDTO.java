package com.dobu.dobu.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class AgendamentoDTO {

    @NotNull
    private LocalDateTime dataAgendamento;

    @NotNull
    private String status;

    @NotNull
    private Long petId;

    @NotNull
    private Long veterinarioId;

    public AgendamentoDTO() {
    }

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDateTime dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public Long getVeterinarioId() {
        return veterinarioId;
    }

    public void setVeterinarioId(Long veterinarioId) {
        this.veterinarioId = veterinarioId;
    }
}
