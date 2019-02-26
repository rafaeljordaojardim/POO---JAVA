package Armazens;
import java.util.ArrayList;

public class Compras {
	
	
	private ArrayList<Ordem> compras;
	
	//ACESSORES
	public ArrayList<Ordem> getCompras() {
		return compras;
	}
	public void setCompras(ArrayList<Ordem> compras) {
		this.compras = compras;
	}
	
	public Produto getProduto(int index) {
		return compras.get(index).getProduto();
	}
	public void setProduto(Produto produto, int quantidade, int index) {
		compras.set(index, new Ordem(produto, quantidade));
	}
	public int getQuantidade(int index) {
		return compras.get(index).getQuantidade();
	}
	//CONSTRUTORES
	public Compras () {
		compras = new ArrayList<Ordem>();
	}//
	//com parametro
	public Compras(Ordem ordem) {
		compras = new ArrayList<Ordem>();
		compras.add(ordem);
	}//fim de metodo
	
	//cópia
	public Compras(ArrayList<Ordem> compras) {
		this.compras = new ArrayList<Ordem>();
		for(int i = 0; i < compras.size(); i++)
			this.compras.set(i, compras.get(i));
	}//fim construtor
	
	
	//get para compras
	public Produto get(int index) {
		return compras.get(index).getProduto();
	}
	//metodo para adicionar uma ordem
	public void add(Produto produto, int quantidade) {
			compras.add(new Ordem(produto, quantidade));
			produto.setQuantidade(produto.getQuantidade() - quantidade);		
	}//add
	
	
	public boolean verificaQuantidadeArmazem(Produto produto, int quantidade) {
		if(produto.getQuantidade() >= quantidade) return true;
		return false;
	}

	//removendo produto pelo indice
	public void remove(int index) {
		compras.remove(index);
	}
	//removendo produto pelo nome
	public void remove(String nome) {
		int i = acharProduto(nome);
		if(i != -1)
			this.remove(i);
	}
	
	public int acharProduto(String nome) {
		for (int i = 0; i < compras.size(); i++) 
			if(compras.get(i).getProduto().getNome().toLowerCase().trim().equals(nome.toLowerCase().trim())) return i;
		
			return -1;
	}
	
	//listar compras
		public String listar() {
			StringBuilder s = new StringBuilder("");
			for (int i = 0; i < compras.size(); i++) {
				s.append(compras.get(i).getProduto().toString());
			}
			return s.toString();
	}//fim de listar compras
	
	
	
	//listar produtos estrangeiros
		public String listarEstrangeiro() {
			StringBuilder s = new StringBuilder("");
			for (Ordem compra : compras) 
				if (compra.getProduto() instanceof ProdutoEstrangeiro)
					s.append(String.format("%-10s %10d %10.2f",compra.getProduto().getNome(), compra.getProduto().getQuantidade(), compra.getProduto().precoVenda()));
			
			return s.toString();
		}
		//listar produtos nacionais
		public String listarNacional() {
			StringBuilder s = new StringBuilder("");
			for (Ordem compra : compras) 
				if (compra.getProduto() instanceof ProdutoNacional)
					s.append(String.format("%-10s %10d %10.2f",compra.getProduto().getNome(), compra.getProduto().getQuantidade(), compra.getProduto().precoVenda()));
			
			return s.toString();
		}
	
	public String listarComPrecoVenda() {
		String s = "";
		for(Ordem ordem : compras)s+= String.format("%-10s %10.2f %10d %12.2f\n",
				ordem.getProduto().getNome(),ordem.getProduto().precoVenda(),
				 ordem.getQuantidade(), ordem.getProduto().precoVenda() * ordem.getQuantidade());
		return s;
	}//listarComPrecoVenda
		
	
	public double total() {
		double total = 0.0;
		for (Ordem ordem : compras)total += ordem.getProduto().precoVenda() * ordem.getQuantidade();
		return total;
	}//fim de metodo
	
	
	
	//vendo se tem produtos
	public boolean temProdutos() {
		return compras.size() > 0;
	}
	//tem produtos nacionais
	public boolean temProdutoEstrangeiro() {
		for (Ordem compra : compras) 
			if(compra.getProduto() instanceof ProdutoEstrangeiro)
				return true;
		
		return false;
	}
	//tem produtos nacionais
	public boolean temProdutoNacional() {
		for (Ordem compra : compras) 
			if(compra.getProduto() instanceof ProdutoNacional)
				return true;
		
		return false;
	}

}//Compras
