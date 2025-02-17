package model;

import java.util.Random;

public abstract class Conta {
	
	private String titular;
	private String numero;
	protected double saldo;
	private  String tipoConta;

	// Construtor
	public Conta(String titular) {
		this.titular = titular;
		this.numero = gerarConta();
		this.saldo = 0.0;
		//this.tipoConta = tipoConta;
		
	}

	// get e set
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String getTipoConta() {
		return tipoConta;
	}
	
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	
	// gerador de numero conta
	public String gerarConta() {
		Random r = new Random();
		int numeroConta = r.nextInt(9999) + 1;
		return String.format("%04d", numeroConta);
	}
	
	//Métodos abstratos
	public abstract void depositar(double valor);
	public abstract void mostrarSaldo();
	public abstract void exibirDados();
	

	
	
	
}
