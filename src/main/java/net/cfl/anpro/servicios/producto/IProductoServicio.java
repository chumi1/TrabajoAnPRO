package net.cfl.anpro.servicios.producto;

import java.util.List;
import java.util.Optional;

import net.cfl.anpro.modelo.Producto;
import net.cfl.anpro.repositorio.AgregaProductoReq;
import net.cfl.anpro.request.ActualizaProductoReq;

public interface IProductoServicio {
	Producto agregaProducto(AgregaProductoReq request);
	Producto listaProductoPorId(Long id);
	void borrarProducto(Long id);
	Producto actualizaProducto(ActualizaProductoReq request, Long id);
	List<Producto> listarProductos();
	List<Producto> listarPorCategoria(String categoria);
	List<Producto> listarPorMarca(String marca);
	List<Producto> listarPorMarcaYCategoria(String marca, String categoria);
	List<Producto> listarPorNombre(String nombre);
	List<Producto> listarPorNombreYMarca(String nombre, String marca);
	Long contarProductosPorNombreYMarca(String nombre, String marca);
}
