package net.cfl.anpro.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.cfl.anpro.modelo.Producto;
import net.cfl.anpro.respuesta.ApiRespuesta;
import net.cfl.anpro.servicios.categoria.ICategoriaServicio;
import net.cfl.anpro.servicios.producto.IProductoServicio;

@RequiredArgsConstructor 
@RestController
@RequestMapping("${api.prefix}/Productos") 
public class ProductoControlador {
	private final IProductoServicio productoServicio;
	@GetMapping ("/todos")
	public ResponseEntity<ApiRespuesta> listaTodosProductos(){
		List<Producto> productos = productoServicio.listarProductos();	
		
         return ResponseEntity.ok(new ApiRespuesta("Exito!", productos));	
         
	}
	public ResponseEntity<ApiRespuesta> listarProductoPorId(Long productoId){
		Producto producto= productoServicio.listaProductoPorId(productoId);
		return ResponseEntity.ok(new ApiRespuesta("Exito!", producto));
	}

}
