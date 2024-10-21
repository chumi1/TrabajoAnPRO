package net.cfl.anpro.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.cfl.anpro.modelo.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Long>{
	List<Producto> findByCategoria(String categoria);
	List<Producto> findByMarca(String marca);
	List<Producto> findByMarcaAndCategoriaNombre(String marca, String Categoria);
	List<Producto>findByNombre(String nombre);
	List<Producto> findByNombreAndMarca(String nombre, String marca);
	Long countByNombreAndMarca(String nombre, String marca);
}
