package cc.nuvu.persona.business.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.nuvu.persona.business.PersonaBusiness;
import cc.nuvu.persona.model.Persona;
import cc.nuvu.persona.repository.PersonaRepository;


@Service
public class PersonaBusinessImpl implements PersonaBusiness {
	
	@Autowired
	private PersonaRepository personaRepository;
	

	@Override
	public Persona guardarPersona(Persona persona) {
		return this.personaRepository.save(persona);
	}

	@Override
	public List<Persona> consultarPersonas() {
		return (List<Persona>) this.personaRepository.findAll();
	}

	@Override
	public Persona consultarPersonaPorId(Long id) {
		Optional<Persona> personaConsultada = this.personaRepository.findById(id);
		
		if (personaConsultada.isPresent()) {
			return personaConsultada.get();
		}
		
		return null;
	}

	@Override
	public void actualizarPersona(Persona persona) {
		this.personaRepository.save(persona);
	}

	@Override
	public void eliminarPersona(Long id) {
		this.personaRepository.deleteById(id);
		
	}

}
