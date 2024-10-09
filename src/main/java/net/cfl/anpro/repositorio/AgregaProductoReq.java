package net.cfl.anpro.repositorio;

import java.math.BigDecimal;

import lombok.Data;
import net.cfl.anpro.modelo.Categoria;

@Data
public class AgregaProductoReq {
	private Long id;
	private String nombre;
	private String marca;
	private String descripcion;
	private BigDecimal precio;
	private int stock;
	private Categoria categoria;
}
