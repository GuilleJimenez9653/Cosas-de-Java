package pruebas;

import java.util.*;

public class Arboles {

	public static void main(String[] args) {

	}

}

class Nodo{
	
	private int dato;
	private Nodo hijoIzquierdo, hijoDerecho;
	Nodo raiz;
	
	public Nodo(int dato) {
		this.dato = dato;
		this.setHijoDerecho(null);
		this.setHijoIzquierdo(null);
	}
	public int getDato() {
		return dato;
	}
	public void setDato(int dato) {
		this.dato = dato;
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
	
	public void insertar(int dato) {
		Nodo nuevo = new Nodo(dato);
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

class ArbolBinario{
	
	Nodo raiz;

	public ArbolBinario() {
		raiz = null;
	}
	
	
	
	public boolean estaVacio() {
		return raiz == null;
	}
	
	public void inOrden(Nodo r) {
		if (r != null) {
			inOrden(r.getHijoIzquierdo());
			System.out.println(r.getDato());
			inOrden(r.getHijoDerecho());
		}
	}
	
	public void preOrden(Nodo r) {
		if (r != null) {
			System.out.println(r.getDato());
			preOrden(r.getHijoIzquierdo());
			preOrden(r.getHijoDerecho());
		}
	}
	
	public void postOrden(Nodo r) {
		if (r != null) {
			postOrden(r.getHijoIzquierdo());
			postOrden(r.getHijoDerecho());
			System.out.println(r.getDato());
		}
	}
	
}











