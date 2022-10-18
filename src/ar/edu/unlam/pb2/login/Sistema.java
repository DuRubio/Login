package ar.edu.unlam.pb2.login;

import java.util.ArrayList;
import java.util.LinkedList;

public class Sistema {

	private ArrayList <Usuario> usuarios;

	public Sistema() {
		usuarios = new ArrayList <>();
	}

	public Boolean agregarUsuario(Usuario usuario1) {
		Boolean sePudoCargar=false;

		for (Usuario usuarioX : usuarios) {
			if(usuarioX.equals(usuario1)) return false; //al sobrescribir el equals con el hashcode se puede utilizar el equals porque elijo yo los parametros de comparacion
		}
		
		//if(usuarios.contains(usuario1)) return false;  //no permite objetos duplicados (compara con equals la direccion de memoria)
		if(usuario1.getEmail()!=null && usuario1.getPassword()!=null) {
			usuarios.add(usuario1);
			sePudoCargar=true;
		}
		
		return sePudoCargar;
		
	}
	
	

	public Boolean removerUsuario(Usuario usuario1) {
		return usuarios.remove(usuario1);
		
	}

	public Integer getCantidadUsuarios() {
		return usuarios.size();
		
		
	}

	public Boolean ingresarAlSistema(String email, String pass) {
		for (Usuario usuario : usuarios) {
			if(usuario.getEmail().equals(email) && usuario.getPassword().equals(pass))
				return true;
		}
		return false;
		
	}
	
	public Boolean ingresarAlSistema(Usuario usuario) { //tiene poca logica ya que para ingresar se usaria el metodo de arriba
		for (Usuario usuarioX : usuarios) {
			if(usuarioX.getEmail().equals(usuario.getEmail()) && usuarioX.getPassword().equals(usuario.getPassword()))
				return true;
		}
		return false;
		
	}

}
