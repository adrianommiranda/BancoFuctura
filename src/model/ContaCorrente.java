package model;

import iInterface.tarifaCC;

public class ContaCorrente extends Conta implements tarifaCC {

	public ContaCorrente(String titular) {
		super(titular);
		this.setTipoConta("CC");
	}

	// Sacar
	public void sacar(double valor) {
		if (this.getSaldo() < valor - 3) {
			throw new RuntimeException("Saldo insufuciente!");
			//System.out.println("Saldo insufuciente!");
		} else {
			System.out.println("Saque efetuado com sucesso!");
			this.setSaldo(getSaldo() - valor);
			this.cobrarTaxaSaqueIOF();
		}
	}

	// Depositar-------------------   RuntimeException
	@Override
	public void depositar(double valor) {
		if (valor <= 0) {
			throw new RuntimeException("Valor insufuciente!");//Vai quebrar a rotina, infora exceção e volta para o menu, fiferente da try/catch
			//System.out.println("Valor insufuciente!");
		} else {
			System.out.println("Depósito efetuado com sucesso!");
			this.setSaldo(getSaldo() + valor);
		}
	}

	// Exibir dados de conta
	@Override
	public void exibirDados() {
		System.out.println("Conta corrente  " + this.getTipoConta());
		System.out.println("Titular da conta - " + this.getTitular());
		System.out.println("Número da conta - " + this.getNumero());
		System.out.println("Saldo da conta - " + this.getSaldo());
	}

	// tranferir de conta                                         --- throws Exception
	public void tranferirConta(Conta destinatario, double valor) throws Exception {
		if (this.saldo < valor)  {
			throw new Exception("Valor incorreto! Digite o valor válido!");
			//System.err.println("Saldo insuficiente!");
		} else {
			System.out.println("Transfêcia para " + destinatario.getTitular() + " efetuado com sucesso!");
			this.setSaldo(saldo - valor);
			destinatario.saldo = destinatario.saldo + valor;
		}

	}

	// Aplicar na poupança
	public void aplicar(ContaPoupanca destinatario, double valor) {
		if (this.saldo < valor) {
			throw new RuntimeException ("Saldo insuficiente");
		} else {
			destinatario.setSaldo(destinatario.getSaldo() + valor);
			this.setSaldo(saldo - valor);
		}
	}

	//Mostrar saldo
	@Override
	public void mostrarSaldo() {
		System.out.println(" Saldo em conta corrente de " + this.getSaldo());
	}

	// iterface IOF
	@Override
	public void cobrarTaxaSaqueIOF() {
		double iof = 3.0;
		this.setSaldo(getSaldo() - iof);
	}

	// interface mensalidade
	@Override
	public void mensalidadeCC() {
		double mensalidade = 10;
		this.setSaldo(getSaldo() - mensalidade);

	}

}
