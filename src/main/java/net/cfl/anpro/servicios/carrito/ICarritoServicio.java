package net.cfl.anpro.servicios.carrito;

import java.math.BigDecimal;

import net.cfl.anpro.modelo.Carrito;

public interface ICarritoServicio {
	Carrito traeCarrito(Long id);
	void limpiaCarrito(Long id);
	BigDecimal traePrecioTotal(Long id);
	
}
