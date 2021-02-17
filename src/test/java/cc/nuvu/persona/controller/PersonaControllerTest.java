package cc.nuvu.persona.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import cc.nuvu.persona.business.impl.PersonaBusinessImpl;
import cc.nuvu.persona.model.Persona;

public class PersonaControllerTest {

	@Mock
	PersonaBusinessImpl personaBusinessImpl;
	
	@InjectMocks
	PersonaController personaController;
	
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void whenGuardarPersonaThenReturnVoid() {
		// Arrange
		Persona persona = Persona.builder()
			.id(1L)
			.tipoDocumento("CC")
			.numDocumento("1234567890")
			.nombres("Julian David")
			.apellidos("Infante Lara")
			.correo("julian@correo.com")
		.build();
		
		// Act
		doNothing().when(this.personaBusinessImpl).guardarPersona(Mockito.any());
		this.personaController.guardarPersona(persona);
		
		// Assert
		verify(this.personaBusinessImpl, times(1)).guardarPersona(persona);
	}
	
	@Test
	public void whenConsultarPersonasThenReturnPersonaList() {
		// Arrange
		Persona persona = Persona.builder()
			.id(1L)
			.tipoDocumento("CC")
			.numDocumento("1234567890")
			.nombres("Julian David")
			.apellidos("Infante Lara")
			.correo("julian@correo.com")
		.build();
		List<Persona> personas = new ArrayList<>();
		personas.add(persona);
		
		// Act
		when(this.personaBusinessImpl.consultarPersonas()).thenReturn(personas);
		List<Persona> personasConsultadas = this.personaController.consultarPersonas();
		
		// Assert
		assertNotNull(personasConsultadas);
	}
	
	@Test
	public void whenConsultarPersonaPorIdThenReturnPersona() {
		// Arrange
		long id = 1L;
		Persona persona = Persona.builder()
			.id(1L)
			.tipoDocumento("CC")
			.numDocumento("1234567890")
			.nombres("Julian David")
			.apellidos("Infante Lara")
			.correo("julian@correo.com")
		.build();
		
		// Act
		when(this.personaBusinessImpl.consultarPersonaPorId(Mockito.any())).thenReturn(persona);
		Persona personaConsultada = this.personaController.consultarPersonaPorId(id);
		
		// Assert
		assertNotNull(personaConsultada);
	}
	
	@Test
	public void whenActualizarPersonaThenReturnVoid() {
		// Arrange
		Persona persona = Persona.builder()
			.id(1L)
			.tipoDocumento("CC")
			.numDocumento("1234567890")
			.nombres("Julian David")
			.apellidos("Infante Lara")
			.correo("julian@correo.com")
		.build();
		
		// Act
		doNothing().when(this.personaBusinessImpl).actualizarPersona(Mockito.any());
		this.personaController.actualizarPersona(persona);
		
		// Assert
		verify(this.personaBusinessImpl, times(1)).actualizarPersona(persona);
	}
	
	@Test
	public void whenEliminarPersonaThenReturnVoid() {
		// Arrange
		Long id = 1L;
		
		// Act
		doNothing().when(this.personaBusinessImpl).eliminarPersona(Mockito.any());
		this.personaController.eliminarPersona(id);
		
		// Assert
		verify(this.personaBusinessImpl, times(1)).eliminarPersona(id);
	}
	
}
