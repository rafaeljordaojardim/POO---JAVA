
public abstract class Produto {
		
	private String nome;
	private double preco;
	private int quantidade;
	
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	public Produto(String nome, double preco, int quantidade) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	public Produto() {
		this("", 0.0, 0);
	}
	
	
	//pre condições
	
	
	//metodo abstrato
	public abstract double precoVenda();
	
	
	//toString
	@Override
	public String toString() {
		return "[nome=" + nome + ", preco=" + preco + ", quantidade= " + quantidade;
	}
	
	
}//Produto
