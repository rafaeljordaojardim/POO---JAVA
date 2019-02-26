package Armazens;


public class Main {
		
		public static void main(String[] args) {
			Armazem armazem1 = new Armazem(10);
			Armazem armazem2 = new Armazem(1000);
			
			Armazem[] armazem = {armazem1, armazem2};
			Armazens armazens = new Armazens(armazem);
			Armazem armazem3 = new Armazem(22);
			
			armazens.add(armazem3);
			ProdutoNacional pn = new ProdutoNacional("vinho", 1.90, 10);
			
			armazens.getArmazem(0).add(pn);
			pn = new ProdutoNacional("maça", 1.98, 30);
			armazens.getArmazem(2).add(pn);
			armazem1.add(pn);
			armazem2.add(pn);
			ProdutoEstrangeiro pe = new ProdutoEstrangeiro("balas", 1.87, 299, 2);
			
			System.out.println("Lista armazem do codigo " + armazens.getArmazem(0).getCodigo());
			System.out.println("Total de produtos: " + armazens.getArmazem(0).quantos());
			System.out.println(armazens.getArmazem(0).listar());
			
			pn = new ProdutoNacional("celualr", 200.00, 19);
			
			
			armazens.getArmazem(1).add(pe);
			armazens.getArmazem(1).add(pn);
			System.out.println("Lista Armazem do codigo " + armazens.getArmazem(1).getCodigo());
			System.out.println("Total de produtos: " + armazens.getArmazem(1).quantos());
			System.out.println(armazens.getArmazem(1).listar());
			
			armazens.add(new Armazem(321));
			armazens.add();
			armazens.getArmazem(3).setCodigo(123);
			armazens.add();
			armazens.getArmazem(4).setCodigo(134);
			armazens.getArmazem(5).setCodigo(987);
			for (int i = 0; i < 5; i++) {
				armazens.getArmazem(i).add(new ProdutoNacional("k", 200.00, 19));
			}
			//System.out.println(armazens.listar());
			
			/*armazens.mover(armazens.getArmazem(0), "vinho", armazens.getArmazem(5));
			
			System.out.println("\n\narmazem 5   " + armazens.getArmazem(5).listar());
			
			System.out.println("\n\narmazem 0   " + armazens.getArmazem(0).listar());
			
			System.out.println(armazens.existeProdutoEmAlgumArmazem("vi"));*/
			
			System.out.println("Index dos produtos nos armazeens\n" + armazens.indexDosArmazensQueContemOsProdutos("k"));
			System.out.println("\n\n\n\n" + armazens.listar());
		}
	
}//Main()