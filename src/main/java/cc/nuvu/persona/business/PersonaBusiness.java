package cc.nuvu.persona.business;

import java.util.List;

import cc.nuvu.persona.model.Persona;

public interface PersonaBusiness {

	Persona guardarPersona(Persona persona);
	List<Persona> consultarPersonas();
	Persona consultarPersonaPorId(Long id);
	void actualizarPersona(Persona persona);
	void eliminarPersona(Long id);
	
}
