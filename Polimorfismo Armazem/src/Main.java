import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class Main {
		
		public static void main(String[] args) {
			Armazem armazem = new Armazem();
			Compras compras = new Compras();
			int opcao = 1000;
			
			while(opcao != 0) {
				System.out.print(menu());
				Scanner input = new Scanner(System.in);
				opcao = input.nextInt();
				
				switch (opcao) {
					case 1:
						 inserirProdutoArmazem(armazem);
						break;
					case 2:
						removerProdutoArmazem(armazem);
						break;
					case 3:
						if (armazem.temProdutos()) {
							imprimirArmazem(armazem);	
						}else
							System.out.println("\nNão há produtos neste armazem");
						break;
					case 4:
						if (armazem.temProdutos()) {
							comprarProduto(armazem, compras);	
						}else
							System.out.println("\nNão há produtos neste armazem");	
						break;
					case 5:
						if(compras.temProdutos())removerProdutoCompras(compras, armazem);
						else System.out.println("\nNão há itens no seu carrinho\n");
						break;
					case 6:
						if(compras.temProdutos())
							System.out.println(compras.listarComPrecoVenda());
						else
							System.out.println("Não há produtos nas compras");
						break;
					case 7:
						if(compras.temProdutos())fecharCompra(compras);
						else System.out.println("Não há produtos nas compras");
						break;
					case 0:
						System.exit(0);
						break;
				default:
					System.out.println("Opção inválida");
					break;
				}//fim de switch
				
			}//fim de while
			
		}//main
	
	
	private static void fecharCompra(Compras compras) {
		System.out.println();
		System.out.printf("%-10s %11s %15s %13s ", "Produto", "Preço", "Quantidade", "Sub Total \n");
		System.out.println(compras.listarComPrecoVenda());
		System.out.println("Total: " + compras.total());
		Scanner input = new Scanner(System.in);
		System.out.println("Deseja pagar sua compra? Y");
		String resposta = input.nextLine();
		if(resposta.trim().toLowerCase().equals("y")) {
			compras.setCompras(new ArrayList<Ordem>());
			 if (!compras.temProdutos()) {
				 System.out.println("\nCompra feita com sucesso!\nSeu carrinho está vazio!");
			}//fim de if
		}
	}//fecharCompra


	private static void removerProdutoCompras(Compras compras, Armazem armazem) {
		Scanner input = new Scanner(System.in);
		System.out.print("Digite o nome do produto que deseja remover: ");
		String nome = input.nextLine();
		int index = compras.acharProduto(nome);
		if (index > -1) {
			int quantidade = armazem.get(index).getQuantidade() + compras.getQuantidade(index);
			armazem.get(index).setQuantidade(quantidade);
			compras.remove(index);
			if(compras.acharProduto(nome) == -1) System.out.println("\nProduto Removido\n");
		}else {
			System.out.println("\nProduto não encontrado\n");
		}
	}//removerProdutoCompras


	private static void comprarProduto(Armazem armazem, Compras compras) {
		if(armazem.temProdutoNacional()) {
			System.out.println("\n\n\tProdutos Nacionais disponíveis");
			System.out.printf("\n%-10s %10s %10s\n","Nome", "Quantidade", "Preço");
			System.out.println(armazem.listarParaCompraNacional());
		}
		if(armazem.temProdutoEstrangeiro()) {
			System.out.println("\n\n\tProdutos Estrangeiros disponíveis\n");
			System.out.printf("\n%-10s %10s %10s %17s\n","Nome", "Quantidade", "Preço", "Custo Entrega");
			System.out.println(armazem.listarParaCompraEstrangeiro());
		}
		Scanner input = new Scanner(System.in);
		int opcao;
		System.out.println(menuNacionalEstrangeiro());
		System.out.print("Opção: ");
		opcao = input.nextInt();
		if(opcao == 1) 
			if (armazem.temProdutoNacional())comprar(armazem, compras, 1);
			else System.err.println("Não há produtos nacionais");
		else if(opcao == 2) 
			if (armazem.temProdutoEstrangeiro()) comprar(armazem, compras, 2);
			else System.err.println("\nNão há produtos estrangeiros\n");
		else 
			System.out.println("\nOpção Inválida\n");
	}//comprarProduto


	private static void comprar(Armazem armazem, Compras compras, int opcao) {
		Scanner input = new Scanner(System.in);
		System.out.print("\nDigite o nome do produto: ");
		String nome = input.nextLine();
		int index = armazem.acharProduto(nome);
		if(index > -1 && armazem.get(index) instanceof ProdutoEstrangeiro && opcao == 1) {
			System.out.println("\nImpossível comprar, produto estrangeiro\n");}
		else if (index > -1 && armazem.get(index) instanceof ProdutoNacional && opcao == 2) {
			System.out.println("\nImpossível comprar, produto nacional\n");
		}else {
			if (index > -1) {
				System.out.print("\nDigite a quantidade: ");
				int quantidade = input.nextInt();
				if (compras.verificaQuantidadeArmazem(armazem.get(index), quantidade)) {
					compras.add(armazem.get(index), quantidade);
					if (compras.acharProduto(nome) == -1) System.out.println("\nFalha ao comprar\n");
					else System.out.println("\nProduto comprado com sucesso\n");
				}else {
					System.out.println("\nImpossível comprar, quantidade acima do stock");
					System.out.println("Há " + armazem.get(index).getQuantidade() + " " + armazem.get(index).getNome() + "(s) no stock\n");
				}
			}else 
				System.out.println("\nProduto não encontrado\n");
		}
	}//comprarNacional


	private static void imprimirArmazem(Armazem armazem) {
		System.out.println(menuNacionalEstrangeiro());
		System.out.println("3 - Todos");
		System.out.print("Opção: ");
		Scanner input = new Scanner(System.in);
		int opcao = input.nextInt();
		switch(opcao) {
		 	case 1:
		 		 if (armazem.temProdutoNacional()){
			 			 System.out.println("\t\nProdutos Nacionais");
			 			// System.out.printf("%-5s %16s %14s\n","Nome", "Preço","Quantidade\n");
			 			 System.out.println(armazem.listarNacional());
		 			 }else System.out.println("\nNão há produtos Nacionais\n");
		 		break;
		 	case 2:
		 		if(armazem.temProdutoEstrangeiro()) {
		 			System.out.println("\t\nProdutos Nacionais");
		 			//System.out.printf("%-5s %16s %14s %10s\n","Nome", "Preço","Quantidade");
		 			System.out.println(armazem.listarEstrangeiro());
		 		}else System.out.println("\nNão há produtos Estrangeiros\n");
		 		break;
		 	case 3:
		 		System.out.println("\t\nTodos os Produtos");
		 		System.out.println(armazem.listar());
		 		break;
		 	default:
		 		System.out.println("Opção Inválida");
		 		break;
		}
	}//imprimirArmazem

	
	private static void removerProdutoArmazem(Armazem armazem){
		if (armazem.temProdutos()) {
			Scanner input = new Scanner(System.in);
			System.out.print("Digite o nome do produto a ser removido: ");
			String nome = input.nextLine();
			if (armazem.existeProduto(nome)) {
				armazem.remove(armazem.acharProduto(nome));
				if(armazem.existeProduto(nome))System.out.println("\nFalha ao excluir\n");
				else System.out.println("\nProduto " + nome + " excluído com sucesso");
			}else
				System.out.println("\nNão existe este produto no armazem\n");
					
		}else {
			System.out.println("\nNão existe produtos neste armazem\n");
		}
	}//removerProdutoArmazem
	private static void inserirProdutoArmazem(Armazem armazem) {
		int opcao = 1000;
		Scanner input = new Scanner(System.in);
		System.out.println(menuNacionalEstrangeiro());
		System.out.println("opcao:");
		 input = new Scanner(System.in);
		 opcao = input.nextInt();
		 if (opcao == 1 || opcao == 2)
			inserirProduto(armazem, opcao);
		 else
			 System.out.println("Opção Inválida");
	}//inserirProdutoArmazem
	
	private static void inserirProduto(Armazem armazem, int opcao){
		String nome = "";
		int quantidade = 0;
		double preco = 0.0 ;
		double custoEntrega = 0.0;
		Scanner input = new Scanner(System.in);
		System.out.print("Digite o nome do produto: ");
		nome = input.nextLine();	
		if(armazem.existeProduto(nome)) {
			System.out.println("O produto já existe");
		}else {
			System.out.print("Digite o preço do produto: ");
			preco = Double.parseDouble(input.next());
			
			System.out.print("Digite a quantidade do produto: ");
			quantidade = input.nextInt();
			
			if(opcao == 2)
			{
				System.out.print("Digite o custo de entrega do produto: ");
				custoEntrega = Double.parseDouble(input.next());
				ProdutoEstrangeiro pe = new ProdutoEstrangeiro(nome, preco, quantidade, custoEntrega);
				armazem.add(pe);
			}else{
				ProdutoNacional pn = new ProdutoNacional(nome, preco, quantidade);
				armazem.add(pn);
			}
			
			if(armazem.existeProduto(nome)) {
				System.out.println("\nProduto " + nome + " adicionado com sucesso\n");
			}else {
				System.err.println("Erro ao adicionar");
			}
		}
	}//inserirProdutoEstrangeiro
	
	private static String menu() {
		return "\t\tArmazem\n" +
			   "1 - Inserir um Produto no Armazem\n" +
			   "2 - Remover um Produto do Armazem\n"+
			   "3 - Listar Produtos do Armazem\n" +
			   "4 - Comprar um Produto do Armazem\n" +
			   "5 - Remover um Produto das compras\n"+
			   "6 - Listar Compra\n" +
			   "7 - Fechar Compra\n" +
			   "0 - Sair\n" +
			   "opção: ";
	}//menu
	
	private static String menuNacionalEstrangeiro() {
		return "\t\t  \n" +
				   "1 - Produto Nacional\n" +
				   "2 - Produto Estrangeiro"; 
	}//menuNacionalEstrangeiro
	
}//Main()