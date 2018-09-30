package Controler;

import java.util.ArrayList;

import Model.Carro;
import Model.Onibus;

public class IncluiRemoveObjetos {

	static ArrayList<Carro> ArrayCarros = new ArrayList();
	static ArrayList<Onibus> ArrayOnibus = new ArrayList();
	
	public ArrayList<Carro> IncluiCarro(int qtd){
		
		for(int i = 0 ; i < qtd ; i++){
			Carro Car = new Carro();
			Car.setIdCarro(i);
			Car.setNomeCarro("carro" + i);
			ArrayCarros.add(Car);
			//System.out.println(Car.getNomeCarro());			
		}
		return ArrayCarros;

	}
	
	public void IncluiOnibus(int qtd){
		for(int i = 0 ; i < qtd ; i++){
			Onibus Bus = new Onibus();
			Bus.setIdOnibus(1);
			Bus.setNomeOnibus("bus" + i);
			ArrayOnibus.add(Bus);
			//System.out.println(Bus.getNomeOnibus());			
		}
	}
	
	public void RenoveCarro(){
		ArrayCarros.remove(0);		
	}
	
	public void RemoveOnibus(){
		ArrayOnibus.remove(0);
	}
	
	public void ExibeCarros(){
		for (int i = 0 ; i < ArrayCarros.size() ; i++){
			System.out.println("linha " + i + " - " + ArrayCarros.get(i).getNomeCarro());
		}
	}
	
	public void ExibeOnibus(){
		for (int i = 0 ; i < ArrayOnibus.size() ; i++){
			System.out.println("linha " + i + " - " + ArrayOnibus.get(i).getNomeOnibus());
		}		
	}
	
	
}
