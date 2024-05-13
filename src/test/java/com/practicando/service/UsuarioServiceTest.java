package com.practicando.service;

import com.practicando.model.Usuario;
import com.practicando.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllUsuarios() {
        // Arrange
        Usuario usuario1 = new Usuario(1L, "Usuario 1", "usuario1@example.com");
        Usuario usuario2 = new Usuario(2L, "Usuario 2", "usuario2@example.com");
        List<Usuario> usuarios = Arrays.asList(usuario1, usuario2);

        when(usuarioRepository.findAll()).thenReturn(usuarios);

        // Act
        List<Usuario> resultado = usuarioService.getAllUsuarios();

        // Assert
        assertEquals(2, resultado.size());
        assertEquals("Usuario 1", resultado.get(0).getNombre());
        assertEquals("usuario2@example.com", resultado.get(1).getEmail());
    }
}
