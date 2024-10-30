package net.cfl.anpro.controlador;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.cfl.anpro.excepciones.RecursosNoEncontradoEx;
import net.cfl.anpro.modelo.Carrito;
import net.cfl.anpro.respuesta.ApiRespuesta;
import net.cfl.anpro.servicios.carrito.ICarritoServicio;
import net.cfl.anpro.servicios.categoria.ICategoriaServicio;

@RequiredArgsConstructor 
@RestController
@RequestMapping("${api.prefix}/carritos") 
public class CarritoControlador {
	private final ICarritoServicio carritoServicio;
	@GetMapping("/{carritoId}/mi-carrrito")
	public ResponseEntity<ApiRespuesta> traeCarrito (@PathVariable Long carritoId){
		try {
			Carrito carrito = carritoServicio.traeCarrito(carritoId);
			return ResponseEntity.ok(new ApiRespuesta("Exito", carrito));	
		}catch(RecursosNoEncontradoEx e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiRespuesta(e.getMessage(), null));
		}
	}
	@DeleteMapping("{carritoId}/limpiar")
	public ResponseEntity<ApiRespuesta> limpiaCarrito(Long CarritoId){
		try {
			carritoServicio.limpiaCarrito(CarritoId);
			return ResponseEntity.ok(new ApiRespuesta("Exito", null));
		}catch (RecursosNoEncontradoEx e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiRespuesta(e.getLocalizedMessage(), null));
		}
	}
	@GetMapping("/{carritoId}/carrito/monto-total")
	public ResponseEntity<ApiRespuesta> calculaMontoTotal(@PathVariable Long carritoId){
		try {
			BigDecimal montoTotal = carritoServicio.traePrecioTotal(carritoId);
			return ResponseEntity.ok(new ApiRespuesta("Monto Total", montoTotal));
		} catch (RecursosNoEncontradoEx e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiRespuesta(e.getLocalizedMessage(), null));
		}
		
	}
}
