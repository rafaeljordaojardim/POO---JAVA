
public class Conta {
	private String conta;
	private String agencia;
	private double saldo;
	private String nomeCliente;
	
	
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	
	public int sacar(double valor) {
		if(valor <= this.getSaldo()) {
			this.setSaldo(this.getSaldo() - valor);
			return 1;
		}
		return 0;
	}
	
	public void depositar(double valor) {
		this.setSaldo(this.getSaldo() + valor);
	}
	
	
	@Override
	public String toString() {
		return "Conta [conta=" + conta + ", agencia=" + agencia + ", saldo=" + saldo + ", nomeCliente=" + nomeCliente
				+ "]";
	}
	
	
}
