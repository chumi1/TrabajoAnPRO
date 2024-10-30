package net.cfl.anpro.servicios.carrito;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import net.cfl.anpro.modelo.Carrito;
import net.cfl.anpro.modelo.CarritoItem;
import net.cfl.anpro.modelo.Producto;
import net.cfl.anpro.repositorio.CarritoItemRepositorio;
import net.cfl.anpro.repositorio.CarritoRepositorio;
import net.cfl.anpro.servicios.producto.IProductoServicio;

@RequiredArgsConstructor
@Service
public class CarritoItemServicio implements ICarritoItemServicio{
	private final CarritoItemRepositorio carritoItemRepositorio;
	private final IProductoServicio productoServicio;
	private final CarritoRepositorio carritoRepositorio;
	private final ICarritoServicio carritoServicio;

	@Override
	public void agregaItemAlCarrito(Long carritoId, Long productoId, int cantidad) {
		//1: Obtener carrito
		//2: Obtener el product
		//3: Verificar si el producto eiste en el carrito
		//4: si existe incrementar la cantidad con la cantidad reuqeirda 
		//5: SI no existe inicar el ingresp del item
		Carrito carrito = carritoServicio.traeCarrito(carritoId);
		Producto producto = productoServicio.listaProductoPorId(productoId);
		CarritoItem carritoItem = carrito.getCarritoItems()
				.stream()
				.filter(item -> item.getProducto().getId().equals(productoId))
				.findFirst().orElse(new CarritoItem());
		if (carritoItem.getId() == null) {
			carritoItem.setCarrito(carrito);
			carritoItem.setProducto(producto);
			carritoItem.setCantidad(cantidad);
			carritoItem.setPrecioUni(null);
		}
	}

	@Override
	public void quitaItemDelCarrito(Long carritoId, Long productoId) {
		Carrito carrito = carritoServicio.traeCarrito(carritoId);
		CarritoItem itemARemover = carrito.getCarritoItems()
				.stream()
				.filter(item -> item.getProducto().getId().equals(productoId))
				.findFirst()
				.orElseThrow();
	}

	@Override
	public void actualizaCantidadItem(Long carritoId, Long productoId, int cantidad) {
		Carrito carrito = carritoServicio.traeCarrito(carritoId);
		carrito.getCarritoItems()
		.stream()
		.filter(item ->item.getProducto().getId().equals(productoId))
		.findFirst()
		.orElseThrow();
		
		
	}

}
