package net.cfl.anpro.servicios.producto;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.cfl.anpro.excepciones.ProductoNoEncontradoEx;
import net.cfl.anpro.modelo.Producto;
import net.cfl.anpro.repositorio.ProductoRepositorio; 
 
@Service
@RequiredArgsConstructor

public class ProductoServicio implements IProductoServicio{
	private ProductoRepositorio productoRepositorio;
	
	@Override
	public Producto agregaProducto(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto listaProductoPorId(Long id) {
	
		return productoRepositorio.findById(id)
				.orElseThrow(() -> new ProductoNoEncontradoEx("Producto no encontrado"));
	}

	@Override
	public void borrarProducto(Long id) {
		productoRepositorio.findById(id)
		.ifPresentOrElse((productoRepositorio::delete), 
		()-> new ProductoNoEncontradoEx("Producto no encontrado"));
	}

	@Override
	public void actualizaProducto(Producto producto, Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Producto> listarProductos() {
		return productoRepositorio.findAll();
	}

	@Override
	public List<Producto> listarPorCategoria(String categoria) {
		return productoRepositorio.findByAtCategoria(categoria);
	}

	@Override
	public List<Producto> listarPorMarca(String marca) {
		return productoRepositorio.findByMarca(marca);
	}

	@Override
	public List<Producto> listarPorMarcaYCategoria(String marca, String categoria) {
		return productoRepositorio.findByMarcaYAtCategoria(marca, categoria);
	}

	@Override
	public List<Producto> listarPorNombre(String nombre) {
		return productoRepositorio.findByNombre(nombre);
	}

	@Override
	public List<Producto> listarPorNombreYMarca(String nombre, String marca) {
		return productoRepositorio.findByNombreYMarca(nombre, marca);
	}

	@Override
	public Long contarProductosPorNombreYMarca(String nombre, String marca) {
 		return productoRepositorio.countByNombreYMarca(nombre, marca);
	}

}
