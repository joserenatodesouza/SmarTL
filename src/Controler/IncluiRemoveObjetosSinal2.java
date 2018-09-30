package Controler;

import java.util.ArrayList;
import java.util.Random;

import Model.Carro;
import Model.Onibus;

public class IncluiRemoveObjetosSinal2 {

	static ArrayList<Carro> ArrayCarros = new ArrayList();
	static ArrayList<Onibus> ArrayOnibus = new ArrayList();
	static int qtd;
	public ArrayList<Carro> IncluiCarro(){
		qtd = Random();
		for(int i = 0 ; i < qtd ; i++){
			Carro Car = new Carro();
			Car.setIdCarro(i);
			Car.setNomeCarro("carroSinal2" + i);
			ArrayCarros.add(Car);
			//System.out.println(Car.getNomeCarro());			
		}
		return ArrayCarros;
	}
	
	public void IncluiOnibus(){
		qtd = Random();
		for(int i = 0 ; i < qtd ; i++){
			Onibus Bus = new Onibus();
			Bus.setIdOnibus(1);
			Bus.setNomeOnibus("busSinal2" + i);
			ArrayOnibus.add(Bus);
			//System.out.println(Bus.getNomeOnibus());			
		}
	}
	
	public void RenoveCarro(){
		ArrayCarros.removeAll(ArrayCarros);		
	}
	
	public void RemoveOnibus(){
		ArrayOnibus.removeAll(ArrayOnibus);
	}
	
	public ArrayList<Carro> ExibeCarros(){
		return ArrayCarros;
//		for (int i = 0 ; i < ArrayCarros.size() ; i++){
//			System.out.println("linha " + i + " - " + ArrayCarros.get(i).getNomeCarro());
//		}
	}
	
	public ArrayList<Onibus> ExibeOnibus(){
		return ArrayOnibus;
//		for (int i = 0 ; i < ArrayOnibus.size() ; i++){
//			System.out.println("linha " + i + " - " + ArrayOnibus.get(i).getNomeOnibus());
//		}		
	}
	public int Random() {
		 //instância um objeto da classe Random usando o construtor padrão
	     Random gerador = new Random();
	     return gerador.nextInt(4);
	}
	
}
