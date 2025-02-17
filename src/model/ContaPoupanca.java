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
		System.out.println("Saque n�o permitido na poupan�a." + " Use a op��o resgate para conta corrente\n");
	}

	// Exibir dados da conta
	@Override
	public void exibirDados() {
		System.out.println("Conta Poupan�a " + this.getTipoConta());
		System.out.println("N�mero da conta - " + this.getNumero());
		System.out.println("Titular da conta - " + this.getTitular());
		System.out.println("Saldo da conta - " + this.getSaldo());
	}

	// Resgatar da poupan�a
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

	// Jurus da aplica��o 10%
	@Override
	public void jurusAplica��o() {
		this.setSaldo(saldo + ((saldo * 10) / 100));

	}

	

	@Override
	public void mostrarSaldo() {
		System.out.println(" Saldo em conta pupan�a de " + this.getSaldo());
		
	}

}
