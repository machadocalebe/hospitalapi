package br.infnet.hospitalapi.repositories;
import br.infnet.hospitalapi.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {}