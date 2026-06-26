package br.infnet.hospitalapi.repositories;

import br.infnet.hospitalapi.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {


    @Query("SELECT m FROM Medico m LEFT JOIN m.consultas c GROUP BY m.id ORDER BY COUNT(c) DESC")
    List<Medico> findMedicosOrdenadosPorConsultas();
}