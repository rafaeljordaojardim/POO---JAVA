package Armazens;

import java.util.ArrayList;

public class Armazens {
	//Atributos
	private ArrayList<Armazem> armazens;
	
	//acessores
	public ArrayList<Armazem> getArmazens() {
		return armazens;
	}
	
	public void setArmazens(ArrayList<Armazem> armazens) {
		this.armazens = armazens;
	}
	
	public Armazem getArmazem(int index) {
		return armazens.get(index);
	}//getArmazem
	
	public void setArmazem(int index, Armazem armazem) {
		armazens.set(index, armazem);
	}//setArmazem
	

	//Construtores
	//iniciando com nenhum armazem
	public Armazens() {
		armazens = new ArrayList<Armazem>();
	}
	//iniciando com um armazem
	public Armazens(Armazem armazem) {
		armazens = new ArrayList<Armazem>();
		armazens.add(armazem);
	}
	//construtor recebendo um conjunto de armazens
	public Armazens(Armazem[] armazens) {
		this.armazens = new ArrayList<Armazem>();
		for (Armazem armazem : armazens) {
			this.armazens.add(armazem);
		}//for
	}//Armazens
	//comportamentos
	
	public void add(Armazem armazem) {
		armazens.add(armazem);
	}//add
	
	public void add() {
		this.add(new Armazem(0));
	}
	
	public String listar() {
		String resposta = "";
		for (Armazem armazem : armazens) {
			if(armazem.temProdutos())
				resposta += String.format("\t\t%s %d\n%s\n","Armazem", armazem.getCodigo(), armazem.listar());
			else
				resposta += String.format("\t\t%s %d\n%s\n","Armazem", armazem.getCodigo(), "\t\tNão há Produtos");
		}
		
		return resposta;
	}//listar
	
	public boolean existeProdutoEmAlgumArmazem(String nome) {
		
		for (int i = 0; i < armazens.size(); i++) {
			if (armazens.get(i).existeProduto(nome)) {
				return true;
			}
		}//for
		
		return false;
	}
	
	public String indexDosArmazensQueContemOsProdutos(String nome) {
		String resposta = "";
		for (int i = 0; i < armazens.size(); i++) {
				if (armazens.get(i).existeProduto(nome)) {
					resposta += String.format("%d %d \n", 
							armazens.get(i).getCodigo(), 
							armazens.get(i).acharProduto(nome));
				}
			}
		return resposta;
	}//indexDosArmazensQueContemOsProdutos
		
	
	//Mover produto de um armazem pra outro
	public void mover(Armazem armazemOrigem, String nomeProduto, Armazem armazemDestino) {
		int index = armazemOrigem.acharProduto(nomeProduto);
		if(index > -1) {
			Produto p = armazemOrigem.get(index);
			armazemOrigem.remove(index);
			armazemDestino.add(p);
		}//segundo if
	}//fim de metodo
	
	//complementares
}//Armazens
