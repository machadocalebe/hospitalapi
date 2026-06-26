package br.infnet.hospitalapi.repositories;
import br.infnet.hospitalapi.domain.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {}