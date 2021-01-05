package pruebas;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

public class Hexa {

	public int puntos = 0;

	public boolean moverFicha(Casilla inicio, Casilla fin){
		if(fin.estaLibre() && (!inicio.estaLibre())){
			HashSet<Casilla> visitados = new HashSet<Casilla>();
			visitados.add(inicio);
			return inicio.vecindad.existeCamino(fin, visitados);
		}else{
			return false;
		}
	}

	public void ponerFicha(Ficha f, Casilla c){
		if(c.ficha == null){
			c.setFicha(f);
			validarMatch(f, c);
		}
	}

	public void validarMatch(Ficha f, Casilla c){

		HashSet<Casilla> casillasConMatch = new HashSet<Casilla>();

		casillasConMatch.add(c);

		c.vecindad.buscarMatch(f, casillasConMatch);

		if(casillasConMatch.size() >= 4){

			System.out.println(casillasConMatch);

			for(Casilla casilla : casillasConMatch){
				casilla.vaciar();
			}

			Ficha nueva = f.proximo();

			puntos += nueva.getValor().intValue();

			ponerFicha(nueva, c);
		}
	}

	public static void main(String[] argv){

		//Crear casillas
		HashMap<Integer, Casilla> casillas = new HashMap<Integer, Casilla>(); 
		for(int i=1; i<=12; i++){
			Casilla c = new Casilla();
			c.id = new Integer(i);
			casillas.put(c.id, c);
		}

		//Asignar fichas a casillas
		casillas.get(new Integer(1)).setFicha(new Ficha(new Integer(1)));
		casillas.get(new Integer(3)).setFicha(new Ficha(new Integer(1)));
		casillas.get(new Integer(9)).setFicha(new Ficha(new Integer(1)));
		casillas.get(new Integer(10)).setFicha(new Ficha(new Integer(2)));
		casillas.get(new Integer(11)).setFicha(new Ficha(new Integer(2)));
		casillas.get(new Integer(12)).setFicha(new Ficha(new Integer(8)));

		//Asignar vecindades
		casillas.get(new Integer(1)).vecindad.add(
			casillas.get(new Integer(3)));
		casillas.get(new Integer(1)).vecindad.add(
			casillas.get(new Integer(4)));


		casillas.get(new Integer(2)).vecindad.add(
			casillas.get(new Integer(3)));
		casillas.get(new Integer(2)).vecindad.add(
			casillas.get(new Integer(6)));

		casillas.get(new Integer(3)).vecindad.add(
			casillas.get(new Integer(1)));
		casillas.get(new Integer(3)).vecindad.add(
			casillas.get(new Integer(2)));
		casillas.get(new Integer(3)).vecindad.add(
			casillas.get(new Integer(4)));
		casillas.get(new Integer(3)).vecindad.add(
			casillas.get(new Integer(5)));
		casillas.get(new Integer(3)).vecindad.add(
			casillas.get(new Integer(6)));

		casillas.get(new Integer(4)).vecindad.add(
			casillas.get(new Integer(1)));
		casillas.get(new Integer(4)).vecindad.add(
			casillas.get(new Integer(3)));
		casillas.get(new Integer(4)).vecindad.add(
			casillas.get(new Integer(5)));
		casillas.get(new Integer(4)).vecindad.add(
			casillas.get(new Integer(7)));

		casillas.get(new Integer(5)).vecindad.add(
			casillas.get(new Integer(3)));
		casillas.get(new Integer(5)).vecindad.add(
			casillas.get(new Integer(4)));
		casillas.get(new Integer(5)).vecindad.add(
			casillas.get(new Integer(6)));
		casillas.get(new Integer(5)).vecindad.add(
			casillas.get(new Integer(7)));
		casillas.get(new Integer(5)).vecindad.add(
			casillas.get(new Integer(10)));
		casillas.get(new Integer(5)).vecindad.add(
			casillas.get(new Integer(11)));

		casillas.get(new Integer(6)).vecindad.add(
			casillas.get(new Integer(2)));
		casillas.get(new Integer(6)).vecindad.add(
			casillas.get(new Integer(3)));
		casillas.get(new Integer(6)).vecindad.add(
			casillas.get(new Integer(5)));
		casillas.get(new Integer(6)).vecindad.add(
			casillas.get(new Integer(11)));

		casillas.get(new Integer(7)).vecindad.add(
			casillas.get(new Integer(4)));
		casillas.get(new Integer(7)).vecindad.add(
			casillas.get(new Integer(5)));
		casillas.get(new Integer(7)).vecindad.add(
			casillas.get(new Integer(8)));
		casillas.get(new Integer(7)).vecindad.add(
			casillas.get(new Integer(9)));
		casillas.get(new Integer(7)).vecindad.add(
			casillas.get(new Integer(10)));


		casillas.get(new Integer(8)).vecindad.add(
			casillas.get(new Integer(7)));
		casillas.get(new Integer(8)).vecindad.add(
			casillas.get(new Integer(9)));

		casillas.get(new Integer(9)).vecindad.add(
			casillas.get(new Integer(7)));
		casillas.get(new Integer(9)).vecindad.add(
			casillas.get(new Integer(8)));
		casillas.get(new Integer(9)).vecindad.add(
			casillas.get(new Integer(10)));
		casillas.get(new Integer(9)).vecindad.add(
			casillas.get(new Integer(12)));

		casillas.get(new Integer(10)).vecindad.add(
			casillas.get(new Integer(5)));
		casillas.get(new Integer(10)).vecindad.add(
			casillas.get(new Integer(7)));
		casillas.get(new Integer(10)).vecindad.add(
			casillas.get(new Integer(9)));
		casillas.get(new Integer(10)).vecindad.add(
			casillas.get(new Integer(11)));
		casillas.get(new Integer(10)).vecindad.add(
			casillas.get(new Integer(12)));

		casillas.get(new Integer(11)).vecindad.add(
			casillas.get(new Integer(5)));
		casillas.get(new Integer(11)).vecindad.add(
			casillas.get(new Integer(6)));
		casillas.get(new Integer(11)).vecindad.add(
			casillas.get(new Integer(10)));

		casillas.get(new Integer(12)).vecindad.add(
			casillas.get(new Integer(9)));
		casillas.get(new Integer(12)).vecindad.add(
			casillas.get(new Integer(10)));

		//Jugar ...
		Hexa juego = new Hexa();
		//Mover de la casilla 9 a la casilla 2
		/*
		boolean existe;
		existe = juego.moverFicha(casillas.get(new Integer(9)), casillas.get(new Integer(2)));
		System.out.println(existe);

		casillas.get(new Integer(5)).setFicha(new Ficha(new Integer(3)));
		existe = juego.moverFicha(casillas.get(new Integer(9)), casillas.get(new Integer(2)));
		System.out.println(existe);

		existe = juego.moverFicha(casillas.get(new Integer(9)), casillas.get(new Integer(4)));
		System.out.println(existe);

		existe = juego.moverFicha(casillas.get(new Integer(9)), casillas.get(new Integer(8)));
		System.out.println(existe);
		*/

		casillas.get(new Integer(4)).setFicha(new Ficha(new Integer(1)));
		casillas.get(new Integer(6)).setFicha(new Ficha(new Integer(2)));
		juego.ponerFicha(new Ficha(new Integer(1)), casillas.get(new Integer(7)));
	}
}


class Casilla {

	public Ficha ficha = null;
	public Vecindad vecindad = new Vecindad();
	public Integer id = 0;

	public void setFicha(Ficha f){
		this.ficha = f;
	}

	public Ficha getFicha(){
		return this.ficha;
	}

	public void vaciar(){
		this.ficha = null;
	}

	public boolean estaLibre(){
		return ficha == null;
	}

	public String toString(){
		if(ficha!=null){
			return "casilla{id: "+id+", ficha"+ficha.getValor()+"}";
		}else{
			return "casilla{id: "+id+"}";
		}
	}
}


class Vecindad {
	public ArrayList<Casilla> vecinos = new ArrayList<Casilla>();

	public void add(Casilla c){
		vecinos.add(c);
	} 

	public boolean ocupadas(){
		boolean ocupadas = true;
		for(Casilla c : vecinos){
			if(c.estaLibre()){
				return false;
			}
		}
		return ocupadas;
	}




	public boolean existeCamino(Casilla destino, Set<Casilla> casillasVisitadas){
		if(ocupadas()){
			return false;
		} else if(vecinos.contains(destino) && (destino.estaLibre())){
			return true;
		} else {
			boolean existe = false;
			for(Casilla c : vecinos){
				if(c.estaLibre() && (!casillasVisitadas.contains(c))){
					casillasVisitadas.add(c);
					existe = existe || c.vecindad.existeCamino(destino, casillasVisitadas);
					if(existe){return true;}
					casillasVisitadas.remove(c);
				}
			}
		}
		return false;
	}





	public void buscarMatch(Ficha f, Set<Casilla> casillasConMatch){
		for(Casilla c : vecinos){ //Visito cada casilla de la vecindad
			if(!casillasConMatch.contains(c)){ //Si la casilla NO fue visitada
				if(!c.estaLibre()){ //Si la casilla NO esta libre
					if(c.getFicha().iguales(f)){ //Si la casilla tiene la misma Ficha
						casillasConMatch.add(c); //La agrego al conjunto de casillas que hacen Match
						c.vecindad.buscarMatch(f, casillasConMatch); //DELEGACION RECURSIVA
					}
				}
			}
		}
	}
}


class Ficha {
	public Integer valor = 0;

	public Ficha(Integer valor){ this.valor = valor;}

	public Ficha(){}

	public void setValor(Integer v){
		this.valor = v;
	}

	public Integer getValor(){
		return valor;
	}

	public Ficha proximo(){
		Ficha f = new Ficha();
		f.valor = this.valor*2; 
		return f;
	}

	public boolean iguales(Ficha f){
		return f.valor.intValue() == this.valor.intValue();
	}
}
