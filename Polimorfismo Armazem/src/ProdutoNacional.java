
public class ProdutoNacional extends Produto {

		private final double IVA = 0.23;//declarar como final para o iva como nuncca mudam
	
	
	
		public ProdutoNacional(String nome, double preco, int quantidade) {
			super(nome, preco, quantidade);
			// TODO Auto-generated constructor stub
		}
	
	
		@Override
		public double precoVenda() {
			// TODO Auto-generated method stub
			return this.getPreco() * (1 + IVA);
		}
		
		
		
		
		//toString
		@Override
		public String toString() {
			return super.toString() + ", IVA: " + IVA + "] \n";
		}

}
