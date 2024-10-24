package net.cfl.anpro.servicios.producto;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.cfl.anpro.excepciones.ProductoNoEncontradoEx;
import net.cfl.anpro.modelo.Categoria;
import net.cfl.anpro.modelo.Producto;
import net.cfl.anpro.repositorio.AgregaProductoReq;
import net.cfl.anpro.repositorio.CategoriaRepositorio;
import net.cfl.anpro.repositorio.ProductoRepositorio;
import net.cfl.anpro.request.ActualizaProductoReq; 
 
@Service
@RequiredArgsConstructor
public class ProductoServicio implements IProductoServicio{
	
	private final ProductoRepositorio productoRepositorio;
	private final CategoriaRepositorio categoriaRepositorio;
	
	@Override
	public Producto agregaProducto(AgregaProductoReq request){
		Categoria categoria = Optional.ofNullable(categoriaRepositorio.findByAtCategoria(request.getCategoria().getNombre()))
				.orElseGet(() -> {
					Categoria nuevaCategoria = new Categoria(request.getCategoria().getNombre());
							return categoriaRepositorio.save(nuevaCategoria);
				});
		request.setCategoria(categoria);
		return productoRepositorio.save(creaProducto(request, categoria));
	}
	
	private Producto creaProducto(AgregaProductoReq request, Categoria categoria) {
		return new Producto(  
				request.getNombre(),
				request.getMarca(),
				request.getDescripcion(),
				request.getPrecio(),
				request.getStock(),
				categoria
				);
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
	public Producto actualizaProducto(ActualizaProductoReq request, Long productoId) {
		return productoRepositorio.findById(productoId)
				.map(productoExistente -> actualizaProductoExistente(productoExistente, request))
				.map(productoRepositorio::save)
				.orElseThrow(() -> new ProductoNoEncontradoEx("Producto no encontrado"));
	}
	public Producto actualizaProductoExistente(Producto productoExistente, ActualizaProductoReq request) {
		productoExistente.setNombre(request.getNombre());
		productoExistente.setMarca(request.getMarca());
		productoExistente.setDescripcion(request.getDescripcion());
		productoExistente.setPrecio(request.getPrecio());
		productoExistente.setStock(request.getStock());
		Categoria categoria = categoriaRepositorio.findByAtCategoria(request.getCategoria().getNombre());
		productoExistente.setCategoria(categoria);
		return productoExistente;
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
