package net.cfl.anpro.excepciones;

public class CategoriaExistenteEx extends RuntimeException{
	public CategoriaExistenteEx(String mensaje){
		super(mensaje);
	}
}
