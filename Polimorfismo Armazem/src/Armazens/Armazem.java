package Armazens;
import java.util.ArrayList;

public class Armazem {
	
	//ATRIBUTOS
	private ArrayList<Produto> produtos;//Arraylist do tipos de produtos
	private int codigo;
	
	//ACESSORES
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	//CONSTRUTORES
	public Armazem(ArrayList<Produto> produtos, int codigo) {
		super();
		this.produtos = produtos;
		this.codigo = codigo;
	}
	
	public Armazem(int codigo) {
		produtos = new ArrayList<>();
		this.codigo = codigo;
	}
	
	
	//ACESSORES
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	
	//PRE CONDIÇÕES
	public boolean temProdutos() {
		return produtos.size() > 0;
	}
	//verificando se existe produto no array produtos
	public boolean existeProduto(String nome) {
		for(int i = 0; i < produtos.size(); i++) 
			if(produtos.get(i).getNome().toLowerCase().trim().equals(nome.toLowerCase().trim())) return true;
		
		return false;
	}
	//metodo
	//Pegando um item do arraylist
	public Produto get (int index) {
		return produtos.get(index);
	}//item
	
	//colocando um produto na lista
	public void set(int index, Produto produto) {
		produtos.set(index, produto);
	}
	
	
	public void add(Produto produto) {
		produtos.add(produto);
	}
	//removendo um produto pelo nome
	public void remove(int index) {
		produtos.remove(index);
	}
	public void remove(String nome) {
		int i = acharProduto(nome);
		if(i != -1)
			this.remove(i);
	}
	//achando o produto pelo nome
	public int acharProduto(String nome) {
		for (int i = 0; i < produtos.size(); i++) 
			if(produtos.get(i).getNome().toLowerCase().trim().equals(nome.toLowerCase().trim())) return i;
		
			return -1;
	}
	//LISTAR
	public String listar() {
		String resposta = "";
		for(int i = 0; i<produtos.size(); i++) {
			resposta += "Produto " + i + ": " + produtos.get(i).toString();
		}//fim de for
		return resposta;
	}//listar
	
	//Pegando o total em valor do array
	
	public double totalValorDosProdutos() {
		if (this.temProdutos()) {
			double resposta = 0.0;
			for (Produto produto : produtos) {
				resposta += produto.getPreco() * produto.getQuantidade();
			}
			return resposta;	
		}
		return -1;
	}
	//TAMANHO DO ARRAY
	public int quantos() {
		return produtos.size();
	}
	
	public int quantosNacionais() {
		int valor = 0;
		for (Produto produto : produtos) {
			if (produto instanceof ProdutoNacional) {
				valor++;
			}
		}//for
		return valor;
	}//quantos nacioais
	
	public int quantosEstrangeiro() {
		int valor = 0;
		for (Produto produto : produtos) {
			if (produto instanceof ProdutoEstrangeiro) {
				valor++;
			}
		}//for
		return valor;
	}//quantos nacioais
	
	//listar produtos estrangeiro
	public String listarEstrangeiro() {
		StringBuilder s = new StringBuilder("");
		for (Produto produto : produtos) 
			if (produto instanceof ProdutoEstrangeiro)
				s.append(produto.toString());
		return s.toString();
	}
	
	//listar produtos estrangeiro
	public String listarNacional() {
		StringBuilder s = new StringBuilder("");
		for (Produto produto : produtos) 
			if (produto instanceof ProdutoNacional)
				s.append(produto.toString());
		return s.toString();
	}
	//listar para compra
	public String listarParaCompraNacional() {
		StringBuilder s = new StringBuilder("");
		for (Produto produto : produtos) 
			if (produto instanceof ProdutoNacional)
				s.append(String.format("%-10s %10d %10.2f ",produto.getNome(), produto.getQuantidade(), produto.precoVenda()));
		return s.toString();
	}
	public String listarParaCompraEstrangeiro() {
		StringBuilder s = new StringBuilder("");
		for (Produto produto : produtos) 
			if (produto instanceof ProdutoEstrangeiro)
				s.append(String.format("%-10s %10d %10.2f, %10.2f",
						produto.getNome(), produto.getQuantidade(), produto.precoVenda(), ((ProdutoEstrangeiro) produto).getCustoEntrega()));
																						/* foi feito um cast pois produto so mostraria os metodos
																						 * definidos em produto, como getEntrega pe especifico de 
																						 * Produto Estrangeiro, não há como acessar sem o cast,
																						 * transformando o produto em produto estrangeiro,
																						 * pois, produto estrangeiro so seria instanciado em tempo 
																						 * de execução, não compilação
																						 */
		return s.toString();
	}
	//tem produtos nacionais
	public boolean temProdutoNacional() {
		for (Produto produto : produtos) 
			if(produto instanceof ProdutoNacional)
				return true;
		
		return false;
	}
	
	
	//listar produtos estrangeiros
	public boolean temProdutoEstrangeiro() {
		for (Produto produto : produtos) 
			if(produto instanceof ProdutoEstrangeiro)
				return true;
		
		return false;
	}
}//Armazem
