package model;

import iInterface.jurosCP;
import iInterface.tarifaCP;

public class ContaPoupanca extends Conta implements tarifaCP, jurosCP {

	// Construtor
	public ContaPoupanca(String titular) {
		super(titular);
		this.setTipoConta("CP");

	}

	// depositar
	@Override
	public void depositar(double valor) {
		System.out.println("Saque não permitido na poupança." + " Use a opção resgate para conta corrente\n");
	}

	// Exibir dados da conta
	@Override
	public void exibirDados() {
		System.out.println("Conta Poupança " + this.getTipoConta());
		System.out.println("Número da conta - " + this.getNumero());
		System.out.println("Titular da conta - " + this.getTitular());
		System.out.println("Saldo da conta - " + this.getSaldo());
	}

	// Resgatar da poupança
	public void resgatar(ContaCorrente destinatario, double valor) {
		if (this.saldo <= valor) {
			throw new RuntimeException("Saldo insuficiente");
		} else {
			destinatario.depositar(valor);
			this.setSaldo(this.getSaldo() - valor);
		}
	}

	// pagar mensalidade
	@Override
	public void mensalidadeCP() {
		double mensalidade = 5;
		this.setSaldo(getSaldo() - mensalidade);

	}

	// Jurus da aplicação 10%
	@Override
	public void jurusAplicação() {
		this.setSaldo(saldo + ((saldo * 10) / 100));

	}

	

	@Override
	public void mostrarSaldo() {
		System.out.println(" Saldo em conta pupança de " + this.getSaldo());
		
	}

}
