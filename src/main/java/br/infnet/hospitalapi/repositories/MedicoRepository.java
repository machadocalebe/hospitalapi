package br.infnet.hospitalapi.repositories;

import br.infnet.hospitalapi.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    // JPQL que realiza um LEFT JOIN com as consultas, agrupa por ID do médico e ordena de forma decrescente
    @Query("SELECT m FROM Medico m LEFT JOIN m.consultas c GROUP BY m.id ORDER BY COUNT(c) DESC")
    List<Medico> findMedicosOrdenadosPorConsultas();
}