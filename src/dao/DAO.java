package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

public class DAO {
	// Lista
	static List<ContaCorrente> ContaCorrentes = new ArrayList<>();
	static List<ContaPoupanca> Contapoupancas = new ArrayList<>();

	// Criar conta
	public static void criarConta() {
		try {
			Scanner scanner = new Scanner(System.in);

			System.out.println("Informe o nome do titular: ");
			String titular = scanner.next();
			System.out.println("\n");

			ContaCorrente cc = new ContaCorrente(titular);
			ContaPoupanca cp = new ContaPoupanca(titular);
			
			DAO.ContaCorrentes.add(cc);
			DAO.Contapoupancas.add(cp);

			DAO.acessandoContaTotal(titular);
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		

		
	}

	// Acessando conta total - tem um erro
	public static void acessandoContaTotal(String titular) {
		try {
			for (ContaCorrente contaCorrente : ContaCorrentes) {
				if (contaCorrente.getTitular().equalsIgnoreCase(titular)) {
					contaCorrente.exibirDados();
				}else {
					System.out.println("Conta corrente não encontrada");
					
				}
			}

			System.out.println();
			for (ContaPoupanca contaPoupanca : Contapoupancas) {
				if (contaPoupanca.getTitular().equalsIgnoreCase(titular)) {
					contaPoupanca.exibirDados();
				}else {
					System.out.println("Conta poupança não encontrado");
				}
				System.out.println("\n");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	// Acessando conta corrente numero da conta - vou percorrer a conta
	public static void acessarContaCCNumero(String numero) {
		try {
			for (ContaCorrente contaCorrente : ContaCorrentes) {
				if (contaCorrente.getNumero().equals(numero)) {
					contaCorrente.exibirDados();
				}else {
					System.out.println("Cliente não encontrado");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	// Acessando conta corrente nome do titular da conta - vou percorrer a conta
	public static void acessarContaCCNome(String titular) {
		try {
			for (ContaCorrente contaCorrente : ContaCorrentes) {
				if (contaCorrente.getTitular().equalsIgnoreCase(titular)) {
					contaCorrente.exibirDados();
				}else {
					System.out.println("Cliente não encontrado");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

	// Acessando conta poupança numero da conta - vou percorrer a conta
	public static void acessarContaCPNumero(String numero) {
		
		try {
			for (ContaPoupanca contaPoupanca : Contapoupancas) {
				if (contaPoupanca.getNumero().equals(numero)) {
					contaPoupanca.exibirDados();
				}else {
					System.out.println("Cliente não encontrado");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	// Acessando conta poupança nome do titular da conta - vou percorrer a conta
	public static void acessarContaCPNome(String titular) {
		try {
			for (ContaPoupanca contaPoupanca : Contapoupancas) {
				if (contaPoupanca.getTitular().equalsIgnoreCase(titular)) {
					contaPoupanca.exibirDados();
				}else {
					System.out.println("Cliente não encontrado");
				}
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		

	}

	// Depositando na conta-----------------
	public static void deposita(String nome, double valor) {
		try {
			for (ContaCorrente contaCorrente : ContaCorrentes) {
				if (contaCorrente.getTitular().equalsIgnoreCase(nome)) {
					contaCorrente.depositar(valor);
				}else {
					System.out.println("Cliente não encontrado");
				}
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
	}

	// Sacando da conta
	public static void sacar(String nome, double valor) {
		try {
			for (ContaCorrente contaCorrente : ContaCorrentes) {
				if (contaCorrente.getTitular().equalsIgnoreCase(nome)) {
					contaCorrente.sacar(valor);
				}
				else {
					System.out.println("Cliente não encontrado");
				}
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	// transferirDeConta entre conta correntes
	public static void transferirDeConta(String origemConta, String destinoConta, double valor) {
		ContaCorrente contaOrigem = null;
		ContaCorrente contaDestino = null;

		try {
			// Encontrando as contas na lista
			for (ContaCorrente conta : ContaCorrentes) {

				// encontrando conta de origem
				if (conta.getTitular().equalsIgnoreCase(origemConta)) {
					contaOrigem = conta;
				}

				// encontrando conta de destino
				if (conta.getTitular().equalsIgnoreCase(destinoConta)) {
					contaDestino = conta;
				}
			}
			
			// Verificando se ambas as contas existem
			if (contaOrigem == null) {
				System.out.println("Conta de origem não encontrada!");
				return;
			}
			if (contaDestino == null) {
				System.out.println("Conta de destino não encontrada!");
				return;
			}

			// Verificando saldo suficiente
			if (contaOrigem.getSaldo() < valor) {
				System.out.println("Saldo insuficiente para a transferência!");
				return;
			}

			// Realizando a transferência
			contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
			contaDestino.setSaldo(contaDestino.getSaldo() + valor);

			System.out.println("Transferência de " + valor + " realizada com sucesso de " + origemConta + " para "
					+ destinoConta + "!");

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

		
		
		
	}

	public static void aplicarPoupanca(String origemConta, double valor) {
		try {
			ContaCorrente contaOrigemCC = null;
			ContaPoupanca contaDestinoCP = null;

			for (ContaCorrente contaCorrente : ContaCorrentes) {
				if (contaCorrente.getTitular().equalsIgnoreCase(origemConta)
						&& contaCorrente.getTipoConta().equalsIgnoreCase("CC")) {
					contaOrigemCC = contaCorrente;
				}
			}

			for (ContaPoupanca contaPoupanca : Contapoupancas) {
				if (contaPoupanca.getTitular().equalsIgnoreCase(origemConta)
						&& contaPoupanca.getTipoConta().equalsIgnoreCase("CP")) {
					contaDestinoCP = contaPoupanca;
				}
			}

			// Verificando se ambas as contas existem
			if (contaOrigemCC == null) {
				System.out.println("Conta de origem não encontrada!");
				return;
			}
			
			if (contaDestinoCP == null) {
				System.out.println("Conta de destino não encontrada!");
				return;
			}
			
			// Verificando saldo suficiente
			if (contaOrigemCC.getSaldo() < valor) {
				System.out.println("Saldo insuficiente para a transferência!");
				return;
			}
			
			contaOrigemCC.setSaldo(contaOrigemCC.getSaldo() - valor);
			contaDestinoCP.setSaldo(contaDestinoCP.getSaldo() + valor);
			
			System.out.println("Transferência de " + valor + " realizada com sucesso da conta corrente de " + contaOrigemCC.getTitular() + " para conta poupança!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public static void resgatarPoupanca(String origemConta, double valor) {
		try {
			ContaCorrente contaOrigemCC = null;
			ContaPoupanca contaDestinoCP = null;

			for (ContaCorrente contaCorrente : ContaCorrentes) {
				if (contaCorrente.getTitular().equalsIgnoreCase(origemConta)
						&& contaCorrente.getTipoConta().equalsIgnoreCase("CC")) {
					contaOrigemCC = contaCorrente;
				}
			}

			for (ContaPoupanca contaPoupanca : Contapoupancas) {
				if (contaPoupanca.getTitular().equalsIgnoreCase(origemConta)
						&& contaPoupanca.getTipoConta().equalsIgnoreCase("CP")) {
					contaDestinoCP = contaPoupanca;
				}
			}

			// Verificando se ambas as contas existem
			if (contaOrigemCC == null) {
				System.out.println("Conta de origem não encontrada!");
				return;
			}
			
			if (contaDestinoCP == null) {
				System.out.println("Conta de destino não encontrada!");
				return;
			}
			
			// Verificando saldo suficiente
			if (contaDestinoCP.getSaldo() < valor) {
				System.out.println("Saldo insuficiente para a transferência!");
				return;
			}
			
			contaOrigemCC.setSaldo(contaOrigemCC.getSaldo() + valor);
			contaDestinoCP.setSaldo(contaDestinoCP.getSaldo() - valor);
			
			System.out.println("Transferência de " + valor + " realizada com sucesso da conta poupança de " + contaDestinoCP.getTitular() + " para conta corrente!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
