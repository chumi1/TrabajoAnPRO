package net.cfl.anpro.servicios.categoria;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.cfl.anpro.excepciones.RecursosNoEncontradoEx;
import net.cfl.anpro.modelo.Categoria;
import net.cfl.anpro.repositorio.CategoriaRepositorio;

@Service
@RequiredArgsConstructor
public class CategoriaServicio implements ICategoriaServicio{
	
	private final CategoriaRepositorio categoriaRepositorio;

	@Override
	public Categoria listaCategoriaPorId(Long Id) {
		return categoriaRepositorio.findById(Id)
				.orElseThrow(() -> new RecursosNoEncontradoEx("Categoria No Encontrada"));	
	}

	@Override
	public Categoria listaCategoriaPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> listarCategorias() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria arreglaCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria actualizaCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrrarCateogoriaPorId(Long id) {
		// TODO Auto-generated method stub
		
	}

}
