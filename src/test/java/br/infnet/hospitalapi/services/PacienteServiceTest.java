package br.infnet.hospitalapi.services;

import br.infnet.hospitalapi.domain.Paciente;
import br.infnet.hospitalapi.repositories.PacienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PacienteServiceTest {

    @Mock
    private PacienteRepository repository;

    @InjectMocks
    private PacienteService service;

    private Paciente pacienteMock;

    @BeforeEach
    void setUp() {
        pacienteMock = new Paciente();
        pacienteMock.setId(1L);
        pacienteMock.setNome("Carlos Teste");
        pacienteMock.setCpf("123.456.789-00");
    }

    @Test
    void deveCadastrarPacienteComSucesso() {
        when(repository.save(any(Paciente.class))).thenReturn(pacienteMock);

        Paciente salvo = service.cadastrar(new Paciente());

        assertNotNull(salvo);
        assertEquals("Carlos Teste", salvo.getNome());
        verify(repository, times(1)).save(any(Paciente.class));
    }

    @Test
    void deveBuscarPacientePorIdComSucesso() {
        when(repository.findById(1L)).thenReturn(Optional.of(pacienteMock));

        Paciente encontrado = service.buscarPorId(1L);

        assertNotNull(encontrado);
        assertEquals(1L, encontrado.getId());
    }

    @Test
    void deveLancarExcecaoQuandoPacienteNaoExistir() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> service.buscarPorId(99L));
    }

    @Test
    void deveRemoverPacienteComSucesso() {
        when(repository.findById(1L)).thenReturn(Optional.of(pacienteMock));
        doNothing().when(repository).delete(pacienteMock);

        assertDoesNotThrow(() -> service.remover(1L));
        verify(repository, times(1)).delete(pacienteMock);
    }
}