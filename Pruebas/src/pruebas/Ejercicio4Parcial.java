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
		Componente comp_aux = this;
		while(comp_aux != null) {
			Subcomponente sub_aux = comp_aux.getSubcomponentes();
			while(sub_aux != null) {
				if(edad >= sub_aux.getEdad()) {
					cont += 1;
				}
				sub_aux = sub_aux.getSiguiente();
			}
			comp_aux = comp_aux.getSiguiente();
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
		Subcomponente subcomp_aux = this;
		while(subcomp_aux != null) {
			if(edad >= subcomp_aux.getEdad()) {
				cont += 1;
			}
			subcomp_aux = subcomp_aux.getSiguiente();
		}
		return cont;
	}
	
}
