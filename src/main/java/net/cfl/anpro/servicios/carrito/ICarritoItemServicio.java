package net.cfl.anpro.servicios.carrito;

public interface ICarritoItemServicio {
	void agregaItemAlCarrito(Long carritoId, Long productoId, int cantidad);
	void quitaItemDelCarrito(Long carritoId, Long productoId);
	void actualizaCantidadItem(Long carritoId, Long productoId, int cantidad);

}
