
public class Ordem {
	
	//ACESSORES
	private Produto produto;
	private int quantidade;
	
	
	//construtor
	public Ordem(Produto produto, int quantidade) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}
	
}//Ordem
