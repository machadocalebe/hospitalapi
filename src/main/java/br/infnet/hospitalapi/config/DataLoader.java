package br.infnet.hospitalapi.config;

import br.infnet.hospitalapi.domain.Medico;
import br.infnet.hospitalapi.domain.Paciente;
import br.infnet.hospitalapi.repositories.MedicoRepository;
import br.infnet.hospitalapi.repositories.PacienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner iniciarBancoDeDados(PacienteRepository pacienteRepo, MedicoRepository medicoRepo) {
        return args -> {
            if (medicoRepo.count() == 0 && pacienteRepo.count() == 0) {
                // Inserção de Médicos
                Medico m1 = new Medico();
                m1.setNome("Dr. Arnold");
                m1.setCrm("CRM/SP 123456");
                m1.setEspecialidade("Cardiologista");

                Medico m2 = new Medico();
                m2.setNome("Dr. Christopher");
                m2.setCrm("CRM/RJ 654321");
                m2.setEspecialidade("Ortopedista");

                medicoRepo.saveAll(Arrays.asList(m1, m2));

                // Inserção de Pacientes
                Paciente p1 = new Paciente();
                p1.setNome("João Silva");
                p1.setCpf("111.111.111-11");
                p1.setDataNascimento(LocalDate.of(1985, 5, 20));
                p1.setTelephone("(11) 99999-9999");

                Paciente p2 = new Paciente();
                p2.setNome("Maria Oliveira");
                p2.setCpf("222.222.222-22");
                p2.setDataNascimento(LocalDate.of(1990, 8, 15));
                p2.setTelephone("(21) 88888-8888");

                pacienteRepo.saveAll(Arrays.asList(p1, p2));

                System.out.println("✅ Dados iniciais de médicos e pacientes carregados com sucesso!");
            }
        };
    }
}