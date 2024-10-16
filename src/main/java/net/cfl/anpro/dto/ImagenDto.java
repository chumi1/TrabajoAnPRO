package net.cfl.anpro.dto;

import java.sql.Blob;

import lombok.Data;

@Data
public class ImagenDto {
	private Long ImagenId;
	private String ImagenNombre;
	private String descargaUrl;

}
