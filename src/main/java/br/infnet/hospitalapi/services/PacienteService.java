package br.infnet.hospitalapi.services;

import br.infnet.hospitalapi.domain.Paciente;
import br.infnet.hospitalapi.repositories.PacienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public Paciente cadastrar(Paciente paciente) {
        return repository.save(paciente);
    }

    public Paciente buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado."));
    }

    public List<Paciente> listarTodos() {
        return repository.findAll();
    }

    public void remover(Long id) {
        Paciente paciente = buscarPorId(id);
        repository.delete(paciente);
    }
}