package ar.edu.unlam.pb2.login;

import java.util.Objects;

public class Usuario {
	private Integer DNI;
	private String email;
	private String password;
	private String nombre;
	private Integer edad;

	public Usuario(Integer dni, String mail, String password, String nombre, Integer edad) {
		setDNI(dni);
		setEmail(mail);
		setPassword(password);
		this.nombre=nombre;
		this.edad=edad;
	}

	protected Integer getDNI() {
		return DNI;
	}

	protected void setDNI(Integer dNI) {
		DNI = dNI;
	}

	protected String getEmail() {
		
		return email;
	}

	protected void setEmail(String email) {
		if(verificarValidezMail(email))	this.email = email;
		
	}
	
	
	public Boolean verificarValidezMail(String mailCorrecto) {
		return  (mailCorrecto.contains("@") && mailCorrecto.contains(".com"));
			
	}

	public Boolean verificarPss(String pssCorrecta) {
		Boolean verifNumero=false;
		Boolean verifLength=false;
		if((pssCorrecta.contains("1")||pssCorrecta.contains("2")||pssCorrecta.contains("3")||pssCorrecta.contains("4")||pssCorrecta.contains("5")||pssCorrecta.contains("6")||pssCorrecta.contains("7")||pssCorrecta.contains("8")||pssCorrecta.contains("9")||pssCorrecta.contains("0"))) {
			verifNumero=true;
		}
		if(pssCorrecta.length()>=8) verifLength=true;
		return (verifNumero==true && verifLength==true);
	}
	

	protected String getPassword() {
		return password;
	}

	protected void setPassword(String password) {
		if(verificarPss(password)) this.password = password;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected Integer getEdad() {
		return edad;
	}

	protected void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email); //que compare los mails, esto reemplaza al equals
	}

	
	
	
	
	
	
}
