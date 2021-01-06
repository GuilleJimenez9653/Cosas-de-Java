package pruebas;

import java.util.*;

public class Ejercicio2 {
	
	public static void main(String[] args) {

	}
}

class Capa{
	
	Capa siguiente;
	int posicion;
	int size;
	public A a = new A();
	ArrayList<A> objetos = new ArrayList<A>();
	
	//Funcion a resolver
	public A get(Filtro f,Reductor r) {
		Iterator<A> itr = objetos.iterator();
		A menor = null;
		Capa capaAux = this;
		while(capaAux.siguiente != null){
			while(itr.hasNext()) {
				A aux = itr.next();
				A aux1 = itr.next();
				if(f.filtrar(aux) && aux!=null && aux1!=null) {
					menor = r.reducir(aux,aux1);
				}
			}
			capaAux =capaAux.siguiente;
			itr = capaAux.objetos.iterator();
		}
		
		return menor;
	}
	
	public A get(int posicion) {
		A a1 = null;
		for(A a: objetos) {
			if (a.getPosicion() == posicion) {
				a1 = a;
			}
		}
		return a1;
	}
	
	public int size() {
		return this.size;
	}
	
}

class Reductor{
	
	public A reducir(A a1,A a2) {
		if(a1.getEnergia() <= a2.getEnergia()) {
			return a1;
		}else {
			return a2;
		}
	}
}

class A{
	
	int energia;
	int posicion;

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}
	
}

class Filtro{
	
	public boolean filtrar(A a) {
		return (a.getEnergia()) >= 100;
	}
}