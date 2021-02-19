package cc.nuvu.persona.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@ApiModel
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name="persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(name = "id", accessMode = AccessMode.READ_ONLY)
	private Long id;
	
	@ApiModelProperty(name = "tipoDocumento", required = true, value = "Tipo de documento de la persona")
	@NotNull(message = "El campo tipoDocumento no puede ser nulo")
	private String tipoDocumento;
	
	@ApiModelProperty(name = "numDocumento", required = true, value = "Numero de documento de la persona")
	@NotNull(message = "El campo numDocumento no puede ser nulo")
	private Long numDocumento;
	
	@ApiModelProperty(name = "nombres", required = true, value = "Nombres de la persona")
	@NotNull(message = "El campo nombres no puede ser nulo")
	private String nombres;
	
	@ApiModelProperty(name = "apellidos", required = true, value = "Apellidos de la persona")
	@NotNull(message = "El campo apellidos no puede ser nulo")
	private String apellidos;
	
	@ApiModelProperty(name = "correo", required = true, value = "Correo de la persona")
	@NotNull(message = "El campo correo no puede ser nulo")
	private String correo;
	
}
