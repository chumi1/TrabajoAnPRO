package net.cfl.anpro.servicios.carrito;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.cfl.anpro.excepciones.RecursosNoEncontradoEx;
import net.cfl.anpro.modelo.Carrito;
import net.cfl.anpro.modelo.CarritoItem;
import net.cfl.anpro.repositorio.CarritoItemRepositorio;
import net.cfl.anpro.repositorio.CarritoRepositorio;

@Service
@RequiredArgsConstructor
public class CarritoServicio implements ICarritoServicio{
	private final CarritoRepositorio carritoRepositorio;
	private final CarritoItemRepositorio carritoItemRepositorio;
	@Override
	public Carrito traeCarrito(Long id) {
		Carrito carrito = carritoRepositorio.findById(id)
				.orElseThrow(() -> new RecursosNoEncontradoEx("Carrito No Encontrado"));
		BigDecimal montoTotal = carrito.getCostoTotal();
		carrito.setCostoTotal(montoTotal);
		return carritoRepositorio.save(carrito);
	}

	@Override
	public void limpiaCarrito(Long id) {
		Carrito carrito = traeCarrito(id);
		carritoItemRepositorio.deleteAllByCarritoId(id);
		carrito.getCarritoItems().clear();
		carritoRepositorio.deleteById(id);
		
	}

	@Override
	public BigDecimal traePrecioTotal(Long id) {
		Carrito carrito =traeCarrito(id);
		return carrito.getCostoTotal();
				.stream()
				.map(CarritoItem :: getPrecioTot)
				.reduce(BigDecimal.ZERO, BigDecimal :: add);
	}

}
