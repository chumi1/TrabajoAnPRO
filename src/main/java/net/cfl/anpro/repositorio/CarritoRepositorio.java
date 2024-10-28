package net.cfl.anpro.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import net.cfl.anpro.modelo.Carrito;

public interface CarritoRepositorio extends JpaRepository<Carrito, Long>{
	void deleteById(Long id);

	
}
