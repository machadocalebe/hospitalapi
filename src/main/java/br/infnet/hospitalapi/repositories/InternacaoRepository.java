package br.infnet.hospitalapi.repositories;
import br.infnet.hospitalapi.domain.Internacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternacaoRepository extends JpaRepository<Internacao, Long> {}