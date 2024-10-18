package net.cfl.anpro.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import net.cfl.anpro.modelo.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>{
	Categoria findByAtCategoria(String nombre);
	Categoria findByNombre(String nombre);
	boolean existsByNombre(String nombre);
}