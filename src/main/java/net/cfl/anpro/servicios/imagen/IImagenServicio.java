package net.cfl.anpro.servicios.imagen;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import net.cfl.anpro.dto.ImagenDto;
import net.cfl.anpro.modelo.Imagen;

public interface IImagenServicio {
	Imagen listaImagenPorId(Long id);
	void boarraImagenPorId(Long id);
	List<ImagenDto> guardaImagenes(List<MultipartFile> archivo, Long productoId);
	void actualizaImagen(MultipartFile archivo, Long imagenId);
}

















