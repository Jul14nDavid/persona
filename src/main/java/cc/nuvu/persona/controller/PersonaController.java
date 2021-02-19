package cc.nuvu.persona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cc.nuvu.persona.business.PersonaBusiness;
import cc.nuvu.persona.model.Persona;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("persona")
@Api(tags = "#persona")
public class PersonaController {

	@Autowired
	private PersonaBusiness personaBusiness;
	

	@PostMapping("/guardar")
	@ApiOperation(value = "Crear Persona", response = Persona.class, httpMethod = "POST")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Persona creada."),
		@ApiResponse(code = 400, message = "Datos de entrada incorrectos."),
		@ApiResponse(code = 500, message = "Error inesperado.")
	})
	public Persona guardarPersona(@RequestBody Persona persona) {
		return this.personaBusiness.guardarPersona(persona);
	}
	
	@GetMapping("/consultar")
	@ApiOperation(value = "Consultar Personas", response = Persona.class, httpMethod = "GET", responseContainer = "List")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Personas consultadas."),
		@ApiResponse(code = 400, message = "Datos de entrada incorrectos."),
		@ApiResponse(code = 500, message = "Error inesperado.")
	})
	public List<Persona> consultarPersonas() {
		return this.personaBusiness.consultarPersonas();
	}
	
	@GetMapping("/consultar/{id}")
	@ApiOperation(value = "Consultar Persona por ID", response = Persona.class, httpMethod = "GET")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Persona consultada."),
		@ApiResponse(code = 400, message = "Datos de entrada incorrectos."),
		@ApiResponse(code = 500, message = "Error inesperado.")
	})
	public Persona consultarPersonaPorId(@PathVariable Long id) {
		return this.personaBusiness.consultarPersonaPorId(id);
	}
	
	@PutMapping("/actualizar")
	@ApiOperation(value = "Actualizar Persona", response = void.class, httpMethod = "PUT")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Persona actualizada."),
		@ApiResponse(code = 400, message = "Datos de entrada incorrectos."),
		@ApiResponse(code = 500, message = "Error inesperado.")
	})
	public void actualizarPersona(@RequestBody Persona persona) {
		this.personaBusiness.actualizarPersona(persona);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ApiOperation(value = "Eliminar Persona", response = void.class, httpMethod = "DELETE")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Persona eliminada."),
		@ApiResponse(code = 400, message = "Datos de entrada incorrectos."),
		@ApiResponse(code = 500, message = "Error inesperado.")
	})
	public void eliminarPersona(@PathVariable Long id) {
		this.personaBusiness.eliminarPersona(id);
	}
	
}
