package net.cfl.anpro.servicios.categoria;

import java.util.List;

import net.cfl.anpro.modelo.Categoria;

public interface ICategoriaServicio{
	Categoria listaCategoriaPorId(Long Id);
	Categoria listaCategoriaPorNombre(String nombre);
	List<Categoria> listarCategorias();
	Categoria arreglaCategoria(Categoria categoria);
	Categoria actualizaCategoria(Categoria categoria);
	void borrrarCateogoriaPorId(Long id);
}
