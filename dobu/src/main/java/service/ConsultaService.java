package service;

import com.dobu.dobu.entity.Consulta;
import com.dobu.dobu.repository.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public Consulta salvar(Consulta consulta){

        if(consulta.getData().isBefore(LocalDateTime.now())){
            throw new RuntimeException("Não pode agendar no passado");
        }

        if(repository.existsByMedicoAndData(consulta.getMedico(), consulta.getData())){
            throw new RuntimeException("Médico já possui consulta nesse horário");
        }

        return repository.save(consulta);
    }
}
