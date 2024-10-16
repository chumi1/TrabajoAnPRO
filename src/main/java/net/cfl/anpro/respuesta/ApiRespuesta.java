package net.cfl.anpro.respuesta;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiRespuesta {
	private String mensaje;
	private Object data;
	
}
