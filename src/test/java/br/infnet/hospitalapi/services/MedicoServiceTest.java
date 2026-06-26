package br.infnet.hospitalapi.services;

import br.infnet.hospitalapi.domain.Medico;
import br.infnet.hospitalapi.repositories.MedicoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MedicoServiceTest {

    @Mock
    private MedicoRepository repository;

    @InjectMocks
    private MedicoService service;

    @Test
    void deveCadastrarMedicoComSucesso() {
        Medico medicoMock = new Medico();
        medicoMock.setId(1L);
        medicoMock.setNome("Dra. Ana");
        medicoMock.setCrm("CRM/SP 99999");

        when(repository.save(any(Medico.class))).thenReturn(medicoMock);

        Medico salvo = service.cadastrar(new Medico());

        assertNotNull(salvo);
        assertEquals("Dra. Ana", salvo.getNome());
    }
}