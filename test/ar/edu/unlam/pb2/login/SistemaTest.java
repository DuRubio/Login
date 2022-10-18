package ar.edu.unlam.pb2.login;

import org.junit.Assert;
import org.junit.Test;

public class SistemaTest {

	@Test
	public void queSePuedaCrearUnUsuario() {
		Usuario usuario1 = new Usuario(235646, "jose@gmail.com", "12345Jose", "Jose", 23);
		Assert.assertNotNull(usuario1);

	}

	@Test
	public void verificarEmail() {
		Usuario usuario1 = new Usuario(235646, "jose@gmail.com", "12345Jose", "Jose", 23);
		String ve = "jose@gmail.com";
		Assert.assertEquals(ve, usuario1.getEmail());
	}

	@Test
	public void verificarPass() {
		Usuario usuario1 = new Usuario(235646, "jose@gmail.com", "12345Jose", "Jose", 23);
		String ve = "12345Jose";
		Assert.assertEquals(ve, usuario1.getPassword());
	}

	@Test
	public void queSePuedaCargarUnUsuarioCorrecto() {
		Usuario usuario1 = new Usuario(235646, "jose@gmail.com", "12345Jose", "Jose", 23);
		Sistema sistema1 = new Sistema();
		Assert.assertTrue(sistema1.agregarUsuario(usuario1));
	}

	@Test
	public void queNoSePuedaCargarUnUsuarioIncorrectoMailInvalido() {
		Usuario usuario1 = new Usuario(235646, "jose@gmailcom", "12345Jose", "Jose", 23);
		Sistema sistema1 = new Sistema();
		Assert.assertFalse(sistema1.agregarUsuario(usuario1));
	}

	@Test
	public void queNoSePuedaCargarUnUsuarioIncorrectoPassInvalida() {
		Usuario usuario1 = new Usuario(235646, "jose@gmail.com", "Jose", "Jose", 23);
		Sistema sistema1 = new Sistema();
		Assert.assertFalse(sistema1.agregarUsuario(usuario1));
	}

	@Test
	public void queSepuedaEliminarUnUsuario() {
		Sistema sistema1 = new Sistema();
		Usuario usuario = new Usuario(235646, "jose@gmail.com", "12345Jose", "Jose", 23);
		Usuario usuario1 = new Usuario(445554, "jose1@gmail.com", "12345Jose1", "Jose1", 35);
		Usuario usuario2 = new Usuario(454546, "jose2@gmail.com", "12345Jose2", "Jose2", 45);
		sistema1.agregarUsuario(usuario);
		sistema1.agregarUsuario(usuario1);
		sistema1.agregarUsuario(usuario2);
		sistema1.removerUsuario(usuario1);
		Integer ve = 2;
		Assert.assertEquals(ve, sistema1.getCantidadUsuarios());
	}
	
	@Test
	public void queSePuedaLoguearUnUsuarioSoloMailyPass() { //usando mail y pass
		Sistema sistema1 = new Sistema();
		Usuario usuario = new Usuario(235646, "jose@gmail.com", "12345Jose", "Jose", 23);
		Usuario usuario1 = new Usuario(445554, "jose1@gmail.com", "12345Jose1", "Jose1", 35);
		sistema1.agregarUsuario(usuario);
		sistema1.agregarUsuario(usuario1);
		String email = "jose@gmail.com";
		String pass = "12345Jose";
		Assert.assertTrue(sistema1.ingresarAlSistema(email, pass));	
	}
	
	@Test 
	public void queSePuedaLoguearUnUsuarioCompleto() { //usando el objeto
		Sistema sistema1 = new Sistema();
		Usuario usuario = new Usuario(235646, "jose@gmail.com", "12345Jose", "Jose", 23);
		Usuario usuario1 = new Usuario(445554, "jose1@gmail.com", "12345Jose1", "Jose1", 35);
		sistema1.agregarUsuario(usuario);
		sistema1.agregarUsuario(usuario1);
		Usuario prueba = new Usuario (23562246, "jose@gmail.com", "12345Jose", "Joseee", 24);
		Assert.assertTrue(sistema1.ingresarAlSistema(prueba));
	}
	
	@Test 
	public void queSePuedaLoguearUnUsuarioCompletoHash() { //usando el hashcode aun no probado
		Sistema sistema1 = new Sistema();
		Usuario usuario = new Usuario(235646, "jose@gmail.com", "12345Jose", "Jose", 23);
		Usuario usuario1 = new Usuario(445554, "jose1@gmail.com", "12345Jose1", "Jose1", 35);
		sistema1.agregarUsuario(usuario);
		sistema1.agregarUsuario(usuario1);
		Usuario prueba = new Usuario (23562246, "jose@gmail.com", "12345Jose", "Joseee", 24);
		Assert.assertTrue(sistema1.ingresarAlSistema(prueba));
	}
	
	@Test
	public void queNoSePuedaAgregarElMismoUsuario() {
		Sistema sistema1 = new Sistema();
		Usuario usuario = new Usuario(235646, "jose@gmail.com", "12345Jose", "Jose", 23);
		sistema1.agregarUsuario(usuario);
		sistema1.agregarUsuario(usuario);
		Integer ve = 1;
		Assert.assertEquals(ve, sistema1.getCantidadUsuarios());
		
	}
	
	@Test
	public void queNoSePuedaAgregarUsuarioDuplicado() {
		Sistema sistema1 = new Sistema();
		Usuario usuario = new Usuario(235646, "jose@gmail.com", "12345Jose", "Jose", 23);
		Usuario usuario2 = new Usuario(235646, "jose@gmail.com", "12345Jose", "Jose", 23);
		sistema1.agregarUsuario(usuario);
		sistema1.agregarUsuario(usuario2);
		Integer ve = 1;
		Assert.assertEquals(ve, sistema1.getCantidadUsuarios());
		
	}

}
