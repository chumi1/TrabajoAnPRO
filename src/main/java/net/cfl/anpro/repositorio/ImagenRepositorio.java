package net.cfl.anpro.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import net.cfl.anpro.modelo.Categoria;
import net.cfl.anpro.modelo.Imagen;

public interface ImagenRepositorio extends JpaRepository<Imagen, Long>{

}