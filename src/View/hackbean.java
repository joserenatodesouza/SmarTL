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
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;


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
		public int TempoIncluiVeiculos = 1000;
		public int TempoRemoveVeiculos = 100;
		public int TempoExecucao = 2;
		public int onibusSinal1 = 0;
		public int onibusSinal2 = 0;
		//Cria as sinaleiras
		 IncluiRemoveObjetosSinal1 Sinal1 = new IncluiRemoveObjetosSinal1();
		 IncluiRemoveObjetosSinal2 Sinal2 = new IncluiRemoveObjetosSinal2();
	   
	    @PostConstruct  
	    public void init() throws InterruptedException {
	        Executa();
	    }
			
	    //Inicia a execucao
	public  void Executa() throws InterruptedException {
		
		IncluiVeiculos();
		QtdSinalMaisCarros = SinalMaisCarros();
		System.out.println(QtdSinalMaisCarros);
		if (QtdSinalMaisCarros == 1){
			System.out.println("teste1");
			abreSinal1();
			Sinal1.IncluiCarro();
			Sinal2.IncluiCarro();
			Sinal1.IncluiOnibus();
			Sinal2.IncluiOnibus();
		} else {
			System.out.println("teste2");
				abreSinal2();
				Sinal1.IncluiCarro();
				Sinal2.IncluiCarro();
				Sinal1.IncluiOnibus();
				Sinal2.IncluiOnibus();
				}
		
	}
		

	//inclui carro inicialmente
	public  void IncluiVeiculos() throws InterruptedException{
			new Thread().sleep(TempoIncluiVeiculos);
			Sinal1.IncluiCarro();
			QtdCarrosSinal1++;
			ArrayCarrosSinal1 = Sinal1.ExibeCarros();
			
			new Thread().sleep(TempoIncluiVeiculos);
			Sinal2.IncluiCarro();
			QtdCarrosSinal2++;
			ArrayCarrosSinal2 = Sinal2.ExibeCarros();
			
			new Thread().sleep(TempoIncluiVeiculos);
			onibusSinal1 = Sinal1.IncluiOnibus();;
			QtdCarrosSinal1++;
			ArrayCarrosSinal1 = Sinal1.ExibeCarros();
			
			new Thread().sleep(TempoIncluiVeiculos);
			onibusSinal2 = Sinal2.IncluiOnibus();;
			QtdCarrosSinal2++;
			ArrayCarrosSinal2 = Sinal2.ExibeCarros();
	
	}
	//Abre o sinal 1 para os carros sairem
	public  void abreSinal1() throws InterruptedException {
		
			Sinal1.RenoveCarro();
			Sinal1.RemoveOnibus();
			new Thread().sleep(TempoRemoveVeiculos);
	}
	//Abre o sinal2 para os carros sairem
	public  void abreSinal2() throws InterruptedException {
			Sinal2.RenoveCarro();
			Sinal2.RemoveOnibus();
			new Thread().sleep(TempoRemoveVeiculos);
	}
	
	//Verifica qual Sinal tem mais carros na fila e se tem onibus
	public  int SinalMaisCarros (){
		int sinal = 0;
		if (Sinal1.ExibeCarros().size() > Sinal2.ExibeCarros().size()){
			sinal = 1;
		} 
		
		if (Sinal2.ExibeCarros().size() > Sinal1.ExibeCarros().size()){
			sinal = 2;
		}
		if  (Sinal1.ExibeOnibus().size() > 0){
			sinal = 1;
		} 
		
		if (Sinal2.ExibeOnibus().size() > 0){
			sinal = 2;
		}		
		return sinal;
	}
	
//Get e Set do Bean
	
		public ArrayList<Onibus> getArrayOnibus() {
			return ArrayOnibus;
		}

		public int getOnibusSinal1() {
			return onibusSinal1;
		}

		public void setOnibusSinal1(int onibusSinal1) {
			this.onibusSinal1 = onibusSinal1;
		}

		public int getOnibusSinal2() {
			return onibusSinal2;
		}

		public void setOnibusSinal2(int onibusSinal2) {
			this.onibusSinal2 = onibusSinal2;
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
		
}

