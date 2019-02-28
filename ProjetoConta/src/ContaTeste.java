import java.util.Scanner;

public class ContaTeste {
	Conta cc = new Conta();
	
	public static void main(String[] args) {
		ContaTeste ct = new ContaTeste();
		int op = 0;
		Scanner in = new Scanner(System.in);
		do {
			
			System.out.println("1..Cadastrar");
			System.out.println("2..Depositar");
			System.out.println("3..Sacar");
			System.out.println("4..Consultar");
			System.out.println("9..Sair");
			op = Integer.parseInt(in.nextLine());
			
			switch (op) {
			case 1:
				ct.execCadastrar();
				break;
			case 2:
				ct.execDepositar();
				break;
			case 3:
				ct.execSacar();
				break;
			case 4:
				ct.execConsultar();
				break;
			case 9:
				System.out.println("\nFim\n");
				break;
			default:
				System.out.println("\nOpcao Inválida\n");
				break;
			}
			
		}while(op!=9);
	}//main
	
	public void execCadastrar() {
		Scanner in = new Scanner(System.in);
		System.out.println("Digite o nome do cliente");
		cc.setNomeCliente(in.nextLine());
		
		System.out.println("Digite o nome da Agencia");
		cc.setAgencia(in.nextLine());
		
		System.out.println("Digite o numero da conta");
		cc.setConta(in.nextLine());
		System.out.println("Cliente cadastrado com sucesso");
	}
	
	public void execConsultar() {
		System.out.println(cc.toString());
	}
	
	public void execDepositar() {
		Scanner in = new Scanner(System.in);
		System.out.println("Digite o valor do depósito: ");
		cc.depositar(Double.parseDouble(in.nextLine()));
		System.out.println("Deposito efetuado com sucesso");
	}
	
	public void execSacar() {
		Scanner in = new Scanner(System.in);
		System.out.println("Digite o valor do saque: ");
		if(cc.sacar(Double.parseDouble(in.nextLine())) == 1) {
			System.out.println("Saque efetuado com sucesso");
		}else {
			System.out.println("Saque não efetuado");
		}
			
	}
}
