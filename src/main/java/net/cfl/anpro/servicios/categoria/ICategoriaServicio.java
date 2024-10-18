package net.cfl.anpro.servicios.categoria;

import java.util.List;

import net.cfl.anpro.modelo.Categoria;

public interface ICategoriaServicio {
	Categoria listaCategoriaPorId(Long id);
	Categoria listaCategoriaPorNombre(String nombre);
	List<Categoria> listarCategorias();
	Categoria agregaCategoria(Categoria categoria);
	Categoria actualizaCategoria(Categoria categoria, Long id);
	void borrarCategoriaPorId(Long id);
}