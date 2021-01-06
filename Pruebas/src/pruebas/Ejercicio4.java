package pruebas;

import java.util.*;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Casilla_ej_4{
	
	private int valor;
	private boolean tachada;
	
	public void tachar() {
		this.setTachada(true);
	}
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public boolean isTachada() {
		return tachada;
	}
	public void setTachada(boolean tachada) {
		this.tachada = tachada;
	}
	
}

class Restriccion{
	private int suma;
	ArrayList<Casilla_ej_4> casillas = new ArrayList<Casilla_ej_4>();
	
	public boolean seCumple() {
		int cont,resultado = 0;
		cont = 0;
		suma = 0;
		for(Casilla_ej_4 c: casillas) {
			if(cont == 0) {
				resultado = c.getValor();
			}else {
				cont += 1;
				if(!c.isTachada()) {
					suma += c.getValor();
				}
			}
		}
		return suma == resultado;
	}
}
