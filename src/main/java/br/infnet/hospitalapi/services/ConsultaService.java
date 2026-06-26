package br.infnet.hospitalapi.services;

import br.infnet.hospitalapi.domain.Consulta;
import br.infnet.hospitalapi.domain.Medico;
import br.infnet.hospitalapi.domain.Paciente;
import org.springframework.stereotype.Service;
import br.infnet.hospitalapi.repositories.ConsultaRepository;
import java.time.LocalDateTime;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final PacienteService pacienteService;
    private final MedicoService medicoService;

    public ConsultaService(ConsultaRepository consultaRepository, PacienteService pacienteService, MedicoService medicoService) {
        this.consultaRepository = consultaRepository;
        this.pacienteService = pacienteService;
        this.medicoService = medicoService;
    }

    public Consulta cadastrar(Long pacienteId, Long medicoId, String observacoes) {
        Paciente paciente = pacienteService.buscarPorId(pacienteId);
        Medico medico = medicoService.listarTodos().stream()
                .filter(m -> m.getId().equals(medicoId)).findFirst()
                .orElseThrow(() -> new org.springframework.web.server.ResponseStatusException(org.springframework.http.HttpStatus.NOT_FOUND, "Médico não encontrado."));

        Consulta consulta = new Consulta();
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setDataConsulta(LocalDateTime.now());
        consulta.setObservacoes(observacoes);

        return consultaRepository.save(consulta);
    }
}