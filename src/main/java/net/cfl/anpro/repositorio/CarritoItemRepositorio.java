package net.cfl.anpro.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import net.cfl.anpro.modelo.CarritoItem;

public interface CarritoItemRepositorio extends JpaRepository<CarritoItem, Long> {
	void deleteAllByCarritoId(Long id);

}
