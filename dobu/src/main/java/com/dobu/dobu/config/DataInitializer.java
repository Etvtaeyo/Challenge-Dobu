package com.dobu.dobu.config;

import com.dobu.dobu.entity.*;
import com.dobu.dobu.enums.TipoUsuario;
import com.dobu.dobu.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initData(UsuarioRepository usuarios, EspecieRepository especies, RacaRepository racas,
                               PetRepository pets, AgendamentoRepository agendamentos, VacinaRepository vacinas,
                               PasswordEncoder encoder,
                               @Value("${app.demo.password:123456}") String demoPassword) {
        return args -> {
            if (usuarios.count() > 0) return;
            Usuario dono = new Usuario();
            dono.setNome("Amandha Yumi"); dono.setEmail("dono@dobu.com"); dono.setSenha(encoder.encode(demoPassword)); dono.setTipoUsuario(TipoUsuario.DONO);
            usuarios.save(dono);

            Usuario veterinario = new Usuario();
            veterinario.setNome("Giovanna Bardella"); veterinario.setEmail("vet@dobu.com"); veterinario.setSenha(encoder.encode(demoPassword)); veterinario.setTipoUsuario(TipoUsuario.VETERINARIO);
            usuarios.save(veterinario);

            Especie especie = new Especie(); especie.setNome("Canina"); especie.setDescricao("Cães domésticos"); especies.save(especie);
            Raca raca = new Raca(); raca.setNome("Golden Retriever"); raca.setPorte("Grande"); raca.setExpectativaVida(12); raca.setEspecie(especie); racas.save(raca);

            Pet pet = new Pet(); pet.setNome("Nina"); pet.setIdade(4); pet.setRaca(raca); pet.setDono(dono); pets.save(pet);

            Agendamento agendamento = new Agendamento(); agendamento.setDataAgendamento(LocalDateTime.now().plusDays(5).withHour(14).withMinute(0)); agendamento.setStatus("PENDENTE"); agendamento.setPet(pet); agendamento.setVeterinario(veterinario); agendamentos.save(agendamento);

            Vacina vacina = new Vacina(); vacina.setNomeVacina("V8 - Reforço anual"); vacina.setDataAplicacao(LocalDate.now().minusYears(1)); vacina.setProximaDose(LocalDate.now().plusDays(12)); vacina.setPet(pet); vacinas.save(vacina);
        };
    }
}
