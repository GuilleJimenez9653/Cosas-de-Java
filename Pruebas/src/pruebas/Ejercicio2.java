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
			A menor = null;
			int cont;
			Capa capa_aux = this;
			while(capa_aux != null) {
				for(int i=0;i<capa_aux.objetos.size();i++) {
					if(f.filtrar(capa_aux.objetos.get(i)) && menor == null ) {
						menor = capa_aux.objetos.get(i);
					}else { 
						if(f.filtrar(capa_aux.objetos.get(i)) && f.filtrar(capa_aux.objetos.get(i+1)) ) {
							if(menor.getEnergia() > r.reducir(capa_aux.objetos.get(i),capa_aux.objetos.get(i+1)).getEnergia()) {
								menor = r.reducir(capa_aux.objetos.get(i),capa_aux.objetos.get(i+1));
							}
						}else if(f.filtrar(capa_aux.objetos.get(i+1))){
							cont = 1;
							while(!f.filtrar(capa_aux.objetos.get(i+cont)) && (i+cont)<capa_aux.objetos.size()){
								cont += 1;
							}
							if(f.filtrar(capa_aux.objetos.get(i+cont))) {
								if(menor.getEnergia() > r.reducir(capa_aux.objetos.get(i),capa_aux.objetos.get(i+1)).getEnergia()) {
									menor = r.reducir(capa_aux.objetos.get(i),capa_aux.objetos.get(i+1));
								}
							}
							i += cont;	
						}
					}		
				}
				capa_aux = capa_aux.siguiente;
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