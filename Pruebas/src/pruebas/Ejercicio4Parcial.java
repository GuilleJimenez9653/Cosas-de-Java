package pruebas;

public class Ejercicio4Parcial {

}

class Componente{
	private String nombre;
	private Componente siguiente;
	private Subcomponente subcomponentes;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Componente getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Componente siguiente) {
		this.siguiente = siguiente;
	}
	public Subcomponente getSubcomponentes() {
		return subcomponentes;
	}
	public void setSubcomponentes(Subcomponente subcomponentes) {
		this.subcomponentes = subcomponentes;
	}
	
	public int contar(int edad) {
		int cont = 0;
		Componente componente_aux = this;
		while(componente_aux != null) {
			cont += componente_aux.getSubcomponentes().contar(edad);
			componente_aux = componente_aux.getSiguiente();
		}
		return cont;
	}
}

class Subcomponente{
	private int edad;
	private Subcomponente siguiente;
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public Subcomponente getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Subcomponente siguiente) {
		this.siguiente = siguiente;
	}
	public int contar(int edad) {
		int cont = 0;
		Subcomponente subcomponente_aux = this;
		while(subcomponente_aux != null) {
			if(edad >= subcomponente_aux.getEdad()) { 
				cont += 1;
			}
			subcomponente_aux = subcomponente_aux.getSiguiente();
		}
		return cont;
	}
	
}
