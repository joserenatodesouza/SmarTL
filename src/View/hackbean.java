package View;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.swing.JOptionPane;

import Controler.IncluiRemoveObjetosSinal1;
import Controler.IncluiRemoveObjetosSinal2;
import Controler.IncluiRemoveObjetosSinal3;
import Controler.IncluiRemoveObjetosSinal4;
import Model.Carro;
import Model.Onibus;
import View.hack;


	@ManagedBean(name = "hackbean")
	@ViewScoped
	
	public class hackbean  {
		public ArrayList<Carro> ArrayCarrosSinal1 = new ArrayList();
		public ArrayList<Carro> ArrayCarrosSinal2 = new ArrayList();
		public ArrayList<Onibus> ArrayOnibus = new ArrayList();
		public int QtdSinalMaisCarros = 0;
		public int QtdCarros = 0;
		public int QtdCarrosSinal1 = 0;
		public  int QtdCarrosSinal2 = 0;
//		public int QtdCarrosSinal3 = 0;
//		public int QtdCarrosSinal4 = 0;
		public int TempoIncluiVeiculos =1000;
		public int TempoRemoveVeiculos = 100;
		public int TempoExecucao = 2;
		//Cria as sinaleiras
		 IncluiRemoveObjetosSinal1 Sinal1 = new IncluiRemoveObjetosSinal1();
		 IncluiRemoveObjetosSinal2 Sinal2 = new IncluiRemoveObjetosSinal2();
//		 IncluiRemoveObjetosSinal3 Sinal3 = new IncluiRemoveObjetosSinal3();
//		 IncluiRemoveObjetosSinal4 Sinal4 = new IncluiRemoveObjetosSinal4();
		
//	    public String testString;
//	    public String teste;
	   
	    @PostConstruct  
	    public void init() throws InterruptedException {
	        //testString = "Welcome to PrimeFaces!!!";
	        //teste = "teste123";
	        Executa();
	    }
			
	public  void Executa() throws InterruptedException {
	//	QtdCarros = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Carros"));
		int ini = 0;
		if (ini == 0){
			IncluiVeiculos();
			ini++;
		}
			
		
			QtdSinalMaisCarros = SinalMaisCarros();
			if (QtdSinalMaisCarros == 1){
				abreSinal1();
				Sinal2.IncluiCarro();
				Sinal1.IncluiCarro();
			} else {				
				abreSinal2();
				Sinal1.IncluiCarro();					
				Sinal2.IncluiCarro();
			}
	}
		


	public  void IncluiVeiculos() throws InterruptedException{
			new Thread().sleep(TempoIncluiVeiculos);
			Sinal1.IncluiCarro();
			QtdCarrosSinal1++;
			ArrayCarrosSinal1 = Sinal1.ExibeCarros();
			
			new Thread().sleep(TempoIncluiVeiculos);
			Sinal2.IncluiCarro();
			QtdCarrosSinal2++;
			ArrayCarrosSinal2 = Sinal2.ExibeCarros();
			
//			new Thread().sleep(TempoIncluiVeiculos);
//			Sinal3.IncluiCarro(1);
//			QtdCarrosSinal3++;
//			Sinal3.ExibeCarros();
//			
//			new Thread().sleep(TempoIncluiVeiculos);
//			Sinal4.IncluiCarro(1);
//			QtdCarrosSinal4++;
//			Sinal4.ExibeCarros();
			
			
		
	}
	
	public  void abreSinal1() throws InterruptedException {
		for(int i = 0 ; i < QtdCarrosSinal1 ; i++){
			Sinal1.RenoveCarro();
			QtdCarrosSinal1--;
			new Thread().sleep(TempoRemoveVeiculos);
		}
	}
	public  void abreSinal2() throws InterruptedException {
		for(int i = 0 ; i < QtdCarrosSinal2 ; i++){
			Sinal2.RenoveCarro();
			new Thread().sleep(TempoRemoveVeiculos);
		}
	}
//	public  void abreSinal3() throws InterruptedException {
//		for(int i = 0 ; i < QtdCarrosSinal3 ; i++){
//			Sinal3.RenoveCarro();
//			QtdCarrosSinal3--;
//			new Thread().sleep(TempoRemoveVeiculos);
//		}
//	}
//	public  void abreSinal4() throws InterruptedException {
//		for(int i = 0 ; i < QtdCarrosSinal4 ; i++){
//			Sinal4.RenoveCarro();
//			QtdCarrosSinal4--;
//			new Thread().sleep(TempoRemoveVeiculos);
//		}
//	}
	public  int SinalMaisCarros (){
		int maior = 0;
		if (Sinal1.ExibeCarros().size() > Sinal2.ExibeCarros().size()){
			System.out.println(Sinal1.ExibeCarros().size());
			System.out.println(Sinal2.ExibeCarros().size());
			maior = 1;
			
		} else maior = 2;
		
		return maior;
	}
	
//	 public String getTeste() {
//			return teste;
//		}
//
//		public void setTeste(String teste) {
//			this.teste = teste;
//		}
//
//
//	    public String getTestString() {
//	        return testString;
//	    }
//
//	    public void setTestString(String testString) {
//	        this.testString = testString;
//	    }  
//	    public ArrayList<Carro> getArrayCarros() {
//			return ArrayCarros;
//		}
//
//		public void setArrayCarros(ArrayList<Carro> arrayCarros) {
//			ArrayCarros = arrayCarros;
//		}

		public ArrayList<Onibus> getArrayOnibus() {
			return ArrayOnibus;
		}

		public void setArrayOnibus(ArrayList<Onibus> arrayOnibus) {
			ArrayOnibus = arrayOnibus;
		}

		public int getQtdSinalMaisCarros() {
			return QtdSinalMaisCarros;
		}

		public void setQtdSinalMaisCarros(int qtdSinalMaisCarros) {
			QtdSinalMaisCarros = qtdSinalMaisCarros;
		}

		public int getQtdCarros() {
			return QtdCarros;
		}

		public void setQtdCarros(int qtdCarros) {
			QtdCarros = qtdCarros;
		}

		public int getQtdCarrosSinal1() {
			return QtdCarrosSinal1;
		}

		public void setQtdCarrosSinal1(int qtdCarrosSinal1) {
			QtdCarrosSinal1 = qtdCarrosSinal1;
		}

		public int getQtdCarrosSinal2() {
			return QtdCarrosSinal2;
		}

		public void setQtdCarrosSinal2(int qtdCarrosSinal2) {
			QtdCarrosSinal2 = qtdCarrosSinal2;
		}

//		public int getQtdCarrosSinal3() {
//			return QtdCarrosSinal3;
//		}
//
//		public void setQtdCarrosSinal3(int qtdCarrosSinal3) {
//			QtdCarrosSinal3 = qtdCarrosSinal3;
//		}
//
//		public int getQtdCarrosSinal4() {
//			return QtdCarrosSinal4;
//		}
//
//		public void setQtdCarrosSinal4(int qtdCarrosSinal4) {
//			QtdCarrosSinal4 = qtdCarrosSinal4;
//		}

		public int getTempoIncluiVeiculos() {
			return TempoIncluiVeiculos;
		}

		public void setTempoIncluiVeiculos(int tempoIncluiVeiculos) {
			TempoIncluiVeiculos = tempoIncluiVeiculos;
		}

		public int getTempoRemoveVeiculos() {
			return TempoRemoveVeiculos;
		}

		public void setTempoRemoveVeiculos(int tempoRemoveVeiculos) {
			TempoRemoveVeiculos = tempoRemoveVeiculos;
		}

		public int getTempoExecucao() {
			return TempoExecucao;
		}

		public void setTempoExecucao(int tempoExecucao) {
			TempoExecucao = tempoExecucao;
		}

		public IncluiRemoveObjetosSinal1 getSinal1() {
			return Sinal1;
		}

		public void setSinal1(IncluiRemoveObjetosSinal1 sinal1) {
			Sinal1 = sinal1;
		}

		public IncluiRemoveObjetosSinal2 getSinal2() {
			return Sinal2;
		}

		public void setSinal2(IncluiRemoveObjetosSinal2 sinal2) {
			Sinal2 = sinal2;
		}

		public ArrayList<Carro> getArrayCarrosSinal1() {
			return ArrayCarrosSinal1;
		}

		public void setArrayCarrosSinal1(ArrayList<Carro> arrayCarrosSinal1) {
			ArrayCarrosSinal1 = arrayCarrosSinal1;
		}

		public ArrayList<Carro> getArrayCarrosSinal2() {
			return ArrayCarrosSinal2;
		}

		public void setArrayCarrosSinal2(ArrayList<Carro> arrayCarrosSinal2) {
			ArrayCarrosSinal2 = arrayCarrosSinal2;
		}

//		public IncluiRemoveObjetosSinal3 getSinal3() {
//			return Sinal3;
//		}
//
//		public void setSinal3(IncluiRemoveObjetosSinal3 sinal3) {
//			Sinal3 = sinal3;
//		}
//
//		public IncluiRemoveObjetosSinal4 getSinal4() {
//			return Sinal4;
//		}
//
//		public void setSinal4(IncluiRemoveObjetosSinal4 sinal4) {
//			Sinal4 = sinal4;
//		}

		
}

