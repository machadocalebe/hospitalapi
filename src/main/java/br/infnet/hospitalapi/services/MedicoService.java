package br.infnet.hospitalapi.services;

import br.infnet.hospitalapi.domain.Medico;
import br.infnet.hospitalapi.repositories.MedicoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    public Medico cadastrar(Medico medico) {
        return repository.save(medico);
    }

    public List<Medico> listarTodos() {
        return repository.findAll();
    }

    public List<Medico> obterRankingMedicos() {
        return repository.findMedicosOrdenadosPorConsultas();
    }
}