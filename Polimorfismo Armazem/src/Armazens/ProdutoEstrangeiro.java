package Armazens;

public class ProdutoEstrangeiro extends Produto{

		private double custoEntrega;
	
	
		public double getCustoEntrega() {
			return custoEntrega;
		}

		public void setCustoEntrega(double custoEntrega) {
			this.custoEntrega = custoEntrega;
		}


		
		public ProdutoEstrangeiro(String nome, double preco, int quantidade, double custoEntrega) {
			super(nome,preco, quantidade);
			this.custoEntrega = custoEntrega;
		}
		
		
		@Override
		public double precoVenda() {
			return this.getPreco() + this.getCustoEntrega();
		}
		
		
		//toString
		@Override
		public String toString() {
			return super.toString() + ", Custo Entrega: " + custoEntrega + "]\n";
		}
	
}//ProdutoEstrangeiro
