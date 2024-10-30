package net.cfl.anpro.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.cfl.anpro.excepciones.RecursosNoEncontradoEx;
import net.cfl.anpro.respuesta.ApiRespuesta;
import net.cfl.anpro.servicios.carrito.ICarritoItemServicio;
import net.cfl.anpro.servicios.carrito.ICarritoServicio;

@RequiredArgsConstructor 
@RestController
@RequestMapping("${api.prefix}/items-carrito") 
public class CarritoItemControlador {
	private final ICarritoItemServicio carritoItemServicio;
	@PostMapping("/item/agrega")
	public ResponseEntity<ApiRespuesta> agregaItemAlCarrito(@RequestParam Long carritoId
														  , @RequestParam Long productoId,
														    @RequestParam Integer cantidad){
		try {
			carritoItemServicio.agregaItemAlCarrito(carritoId, productoId, cantidad); 
			return ResponseEntity.ok(new ApiRespuesta("item agregado con exito", null));
		} catch (RecursosNoEncontradoEx e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiRespuesta(e.getMessage(), null));
		}
	}
	@DeleteMapping("/{carritoId}/item/{productoId}/quitar")
	public ResponseEntity<ApiRespuesta> quitaItemCarrito(@PathVariable Long carritoId
													   , @PathVariable Long productoId){
		try {
			carritoItemServicio.quitaItemDelCarrito(carritoId, productoId);
			return ResponseEntity.ok(new ApiRespuesta("Item Quitado con exito", null));
		} catch (RecursosNoEncontradoEx e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiRespuesta(e.getMessage(), null));
		}
	}
	@PutMapping("/{carritoId}/item/{productoId}/actualiza")
	public ResponseEntity<ApiRespuesta> actualizaCantidadDelItem(@RequestParam Long carritoId,
																 @RequestParam Long productoId,
																 @RequestParam Integer cantidad ){
	try {
		carritoItemServicio.actualizaCantidadItem(carritoId, productoId, cantidad);
		return ResponseEntity.ok(new ApiRespuesta("Item actualizado con exito", null));
	} catch (RecursosNoEncontradoEx e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiRespuesta(e.getMessage(), null));
	}
	}
}
