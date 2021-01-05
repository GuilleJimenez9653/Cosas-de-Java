package pruebas;

import java.util.*;

public class Arboles {

	public static void main(String[] args) {

	}

}

class Nodo{
	
	private int dato, valor;
	private Nodo hijoIzquierdo, hijoDerecho;
	
	public Nodo(int dato, int valor) {
		this.dato = dato;
		this.valor = valor;
		this.setHijoDerecho(null);
		this.setHijoIzquierdo(null);
	}
	public int getDato() {
		return dato;
	}
	public void setDato(int dato) {
		this.dato = dato;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public Nodo getHijoIzquierdo() {
		return hijoIzquierdo;
	}
	public void setHijoIzquierdo(Nodo hijoIzquierdo) {
		this.hijoIzquierdo = hijoIzquierdo;
	}
	public Nodo getHijoDerecho() {
		return hijoDerecho;
	}
	public void setHijoDerecho(Nodo hijoDerecho) {
		this.hijoDerecho = hijoDerecho;
	}
	
}

class ArbolBinario{
	
	Nodo raiz;

	public ArbolBinario() {
		raiz = null;
	}
	
	public void agregarNodo(int dato, int valor) {
		Nodo nuevo = new Nodo(dato,valor);
		if(raiz == null) {
			raiz = nuevo;
		}else {
			Nodo aux  = raiz;
			Nodo padre;
			while(true){
				padre = aux;
				if(dato<aux.getDato()) {
					aux = aux.getHijoIzquierdo();
					if(aux == null) {
						padre.setHijoIzquierdo(nuevo);
						return;
					}
				}else {
					aux = aux.getHijoDerecho();
					if(aux == null) {
						padre.setHijoDerecho(nuevo);
						return;
					}
				}
			}
		}
	}
	
}











