package View;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.swing.JOptionPane;

import Model.Carro;
import Model.Onibus;
import Controler.IncluiRemoveObjetosSinal1;
import Controler.IncluiRemoveObjetosSinal2;
import Controler.IncluiRemoveObjetosSinal3;
import Controler.IncluiRemoveObjetosSinal4;


public class hack {
	static ArrayList<Carro> ArrayCarros = new ArrayList();
	static ArrayList<Onibus> ArrayOnibus = new ArrayList();
	
	static int QtdSinalMaisCarros = 0;
	static int QtdCarros = 0;
	static int QtdCarrosSinal1 = 0;
	static int QtdCarrosSinal2 = 0;
	static int QtdCarrosSinal3 = 0;
	static int QtdCarrosSinal4 = 0;
	static int TempoIncluiVeiculos = 5000;
	static int TempoRemoveVeiculos = 1000;
	static int TempoExecucao = 10;
	//Cria as sinaleiras
	static IncluiRemoveObjetosSinal1 Sinal1 = new IncluiRemoveObjetosSinal1();
	static IncluiRemoveObjetosSinal2 Sinal2 = new IncluiRemoveObjetosSinal2();
	static IncluiRemoveObjetosSinal3 Sinal3 = new IncluiRemoveObjetosSinal3();
	static IncluiRemoveObjetosSinal4 Sinal4 = new IncluiRemoveObjetosSinal4();
			
	public static void Executa() throws InterruptedException {
		QtdCarros = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Carros"));
		
		while (TempoExecucao > 0){
			
			IncluiVeiculos(QtdCarros);

			QtdSinalMaisCarros = SinalMaisCarros();
			if (QtdCarrosSinal1 == QtdSinalMaisCarros){
				abreSinal1();
				Sinal2.IncluiCarro(1);
				Sinal4.IncluiCarro(1);
				if(QtdCarrosSinal2 == QtdSinalMaisCarros){
					abreSinal2();
					Sinal1.IncluiCarro(1);
					Sinal3.IncluiCarro(1);
					if(QtdCarrosSinal3 == QtdSinalMaisCarros){
						abreSinal3();
						Sinal2.IncluiCarro(1);
						Sinal4.IncluiCarro(1);
						if(QtdCarrosSinal4 == QtdSinalMaisCarros){
							abreSinal4();
							Sinal1.IncluiCarro(1);
							Sinal3.IncluiCarro(1);
						}
					}
				}
			}
		}
	}

	public static void IncluiVeiculos(int qtd) throws InterruptedException{
		for (int i = 0 ; i < qtd ; i++){
			new Thread().sleep(TempoIncluiVeiculos);
			Sinal1.IncluiCarro(1);
			QtdCarrosSinal1++;
			Sinal1.ExibeCarros();
			
			new Thread().sleep(TempoIncluiVeiculos);
			Sinal2.IncluiCarro(1);
			QtdCarrosSinal2++;
			Sinal2.ExibeCarros();
			
			new Thread().sleep(TempoIncluiVeiculos);
			Sinal3.IncluiCarro(1);
			QtdCarrosSinal3++;
			Sinal3.ExibeCarros();
			
			new Thread().sleep(TempoIncluiVeiculos);
			Sinal4.IncluiCarro(1);
			QtdCarrosSinal4++;
			Sinal4.ExibeCarros();
			
			
		}
	}
	
	public static void abreSinal1() throws InterruptedException {
		for(int i = 0 ; i < QtdCarrosSinal1 ; i++){
			Sinal1.RenoveCarro();
			QtdCarrosSinal1--;
			new Thread().sleep(TempoRemoveVeiculos);
		}
	}
	public static void abreSinal2() throws InterruptedException {
		for(int i = 0 ; i < QtdCarrosSinal2 ; i++){
			Sinal2.RenoveCarro();
			QtdCarrosSinal2--;
			new Thread().sleep(TempoRemoveVeiculos);
		}
	}
	public static void abreSinal3() throws InterruptedException {
		for(int i = 0 ; i < QtdCarrosSinal3 ; i++){
			Sinal3.RenoveCarro();
			QtdCarrosSinal3--;
			new Thread().sleep(TempoRemoveVeiculos);
		}
	}
	public static void abreSinal4() throws InterruptedException {
		for(int i = 0 ; i < QtdCarrosSinal4 ; i++){
			Sinal4.RenoveCarro();
			QtdCarrosSinal4--;
			new Thread().sleep(TempoRemoveVeiculos);
		}
	}
	public static int SinalMaisCarros (){
		int maior = 0;

		if (QtdCarrosSinal1 > QtdCarrosSinal2 && QtdCarrosSinal1 > QtdCarrosSinal3 && QtdCarrosSinal1 > QtdCarrosSinal4){
			maior = QtdCarrosSinal1;
			if(QtdCarrosSinal2 > QtdCarrosSinal3 && QtdCarrosSinal2 > QtdCarrosSinal4){
				maior = QtdCarrosSinal2;
				if(QtdCarrosSinal3 > QtdCarrosSinal4){
					maior = QtdCarrosSinal3;
				}
				else maior = QtdCarrosSinal4;
			}
		}
		return maior;
	}
	
	public String teste(){
		return "teste";
	}
	
}
