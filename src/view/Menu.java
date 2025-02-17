package view;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

import dao.DAO;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

public class Menu {

	static String menuPrincipal = """
			---------------------------------------------------
			|BANCO MIRANDA - FEITO PARA VOC�  - MENU PRINCIPAL|
			---------------------------------------------------

			MENU PRINCIPAL

			1. Criar Conta
			2. Pesquise pelo nome do titular CP
			3. Pesquise pelo nome do titular CC
			4. Pesquisa todas as contas pelo nome do titular
			5. Pesquise pelo numero da conta CP
			6. Pesquise pelo numero da conta CC
			7. Depositar na conta CC
			8. Sacar da conta CC
			9. Transfer�ncia entre CC
			10.Aplicando na Poupan�a
			11.Resgatando da Poupan�a
			0. Sair
			""";

	// Menu criar contas
	static String menuTitulo = """
			----------------------------------
			|BANCO MIRANDA - FEITO PARA VOC� |
			---------------------------------
			""";

	// Chamada menu principal
	public static void exibirMenuPrincipal() {
		System.out.println(menuPrincipal);

	}

	public static void iniciar() {

		Scanner scanner = new Scanner(System.in);
		int resp = 100;

		exibirMenuPrincipal();

		while (resp != 0) {

			if (resp == 1) {

				System.out.println("\n\n\n " + menuTitulo);
				DAO.criarConta();
				exibirMenuPrincipal();
			}

			if (resp == 2) {
				System.out.println("\n\n\n " + menuTitulo);
				System.out.println("------------Pesquise pelo nome do titular CP--------------\n");
				System.out.println("Informe o nome do titular");
				String nome = scanner.next();
				DAO.acessarContaCPNome(nome);
				System.out.println("\n\n------------------------------------------------------------\n\n\n\n");
				exibirMenuPrincipal();
			}

			if (resp == 3) {
				System.out.println("\n\n\n " + menuTitulo);
				System.out.println("------------Pesquise pelo nome do titular CC--------------\n");
				System.out.println("Informe o nome do titular");
				String nome = scanner.next();
				DAO.acessarContaCCNome(nome);
				System.out.println("\n------------------------------------------------------------\n\n");
				exibirMenuPrincipal();

			}

			if (resp == 4) {
				System.out.println("\n\n\n " + menuTitulo);
				System.out.println("------------Pesquise todas as contas pelo nome do titular--------------\n");
				System.out.println("Informe o nome do titular");
				String nome = scanner.next();
				DAO.acessandoContaTotal(nome);
				System.out.println("\n------------------------------------------------------------\n\n");
				exibirMenuPrincipal();

			}

			if (resp == 5) {
				System.out.println("\n\n\n " + menuTitulo);
				System.out.println("------------Pesquise CP peno n�mero da conta--------------\n");
				System.out.println("Informe o numero da contar");
				String numero = scanner.next();
				DAO.acessarContaCPNumero(numero);
				System.out.println("\n------------------------------------------------------------\n\n");
				exibirMenuPrincipal();
			}

			if (resp == 6) {
				System.out.println("\n\n\n " + menuTitulo);
				System.out.println("------------Pesquise CC pelo n�mero da conta--------------\n");
				System.out.println("Informe o numero da contar");
				String numero = scanner.next();
				DAO.acessarContaCCNumero(numero);
				System.out.println("\n------------------------------------------------------------\n\n");
				exibirMenuPrincipal();
			}

			/*
			 * op��o 7 - 8 - 9 iguais
			 * 
			 * Se o valor digitado n�o for inteiro, fica no loop at� que seja inteiro
			 * 
			 */

			if (resp == 7) {
				System.out.println("\n\n\n " + menuTitulo);
				System.out.println("------------ Depositar na conta corrente - nome do titular --------------\n");
				System.out.println("Informe o nome do titular");
				String nome = scanner.next();
				System.out.println("\n");

				double valor;
				while (true) {
					try {
						System.out.println("Informe o valor a ser depositado");
						double valore = scanner.nextDouble();
						valor = valore;
						break;
					} catch (Exception e) {
						System.out.println("Entrada inv�lida! Digite apenas n�meros inteiros.");
						scanner.nextLine(); // Limpa o buffer do scanner para evitar loop infinito
					} finally {
						scanner.nextLine(); // Limpa o buffer do scanner para evitar loop infinito
					}
				}

				DAO.deposita(nome, valor);
				System.out.println("\n------------------------------------------------------------\n\n");
				exibirMenuPrincipal();
			}

			if (resp == 8) {
				System.out.println("\n\n\n " + menuTitulo);
				System.out.println("------------ Sacar da conta corrente - nome do titular --------------\n");
				System.out.println("Informe o nome do titular");
				String nome = scanner.next();
				System.out.println("\n");

				double valor;
				while (true) {
					try {
						System.out.println("Informe o valor a ser sacado");
						double valore = scanner.nextDouble();
						valor = valore;
						break;
					} catch (Exception e) {
						System.out.println("Entrada inv�lida! Digite apenas n�meros inteiros.");
					} finally {
						scanner.nextLine(); // Limpa o buffer do scanner para evitar loop infinito
					}
				}

				DAO.sacar(nome, valor);
				System.out.println("\n------------------------------------------------------------\n\n");
				exibirMenuPrincipal();
			}

			/*
			 * Tive que colar o scanner.nextLine(); // Limpa o buffer do scanner para evitar
			 * loop infinito
			 * 
			 * Se der erro fica infinito/*
			 */
			if (resp == 9) {
				System.out.println("\n\n\n " + menuTitulo);
				System.out.println("------------ Transferir entre contas correntes --------------\n");
				System.out.println("Informe o nome do titular da conta de origem:");
				String origem = scanner.next();

				System.out.println("Informe o nome do titular da conta de destino:");
				String destino = scanner.next();

				double valor;

				while (true) {
					try {
						System.out.println("Informe o valor a ser transferido:");
						double valore = scanner.nextDouble();
						valor = valore;
						break;
					} catch (Exception e) {
						System.out.println("Entrada inv�lida! Digite apenas n�meros inteiros.");
						scanner.nextLine(); // Limpa o buffer do scanner para evitar loop infinito
					} finally {
						scanner.nextLine(); // Limpa o buffer do scanner para evitar loop infinito
					}
				}

				DAO.transferirDeConta(origem, destino, valor);
				System.out.println("\n------------------------------------------------------------\n\n");
				exibirMenuPrincipal();
			}

			if (resp == 10) {
				System.out.println("\n\n\n " + menuTitulo);
				System.out.println("------------ APLICAR NA POUPAN�A --------------\n");
				System.out.println("Informe o nome do titular da conta de origem:");
				String origem = scanner.next();

				double valor;

				while (true) {
					try {
						System.out.println("Informe o valor a ser transferido:");
						double valore = scanner.nextDouble();
						valor = valore;
						break;
					} catch (Exception e) {
						System.out.println("Entrada inv�lida! Digite apenas n�meros inteiros.");
						scanner.nextLine(); // Limpa o buffer do scanner para evitar loop infinito
					} finally {
						scanner.nextLine(); // Limpa o buffer do scanner para evitar loop infinito
					}
				}

//				System.out.println("Informe o valor a ser transferido:");
//				double valor = scanner.nextDouble();

				DAO.aplicarPoupanca(origem, valor);
				System.out.println("\n------------------------------------------------------------\n\n");
				exibirMenuPrincipal();
			}

			if (resp == 11) {
				System.out.println("\n\n\n " + menuTitulo);
				System.out.println("------------ RESGATANDO DA POUPAN�A --------------\n");
				System.out.println("Informe o nome do titular da conta da poupan�a:");
				String origem = scanner.next();

				double valor;

				while (true) {
					try {
						System.out.println("Informe o valor a ser transferido:");
						double valore = scanner.nextDouble();
						valor = valore;
						break;
					} catch (RuntimeException e) {
						System.out.println("Entrada inv�lida! Digite apenas n�meros inteiros.");
						scanner.nextLine(); // Limpa o buffer do scanner para evitar loop infinito
					} finally {
						scanner.nextLine(); // Limpa o buffer do scanner para evitar loop infinito
					}
				}

				DAO.resgatarPoupanca(origem, valor);
				System.out.println("\n------------------------------------------------------------\n\n");
				exibirMenuPrincipal();
			}

			/*
			 * Solicita nova entrada do usu�rio, protegendo contra entradas inv�lidas O
			 * scanner int vai ler apenas inteiro Se ele digitar qualquer caracter diferente
			 * de inteiro vai gerer exce��o se a entrada for v�lisa sair do loop e segue o
			 * c�digo - breack
			 * 
			 */
			while (true) {
				try {
					System.out.println("Informe a sua op��o! Menu:");
					resp = scanner.nextInt();
					break; // Sai do loop se a entrada for v�lida
				} catch (Exception e) {
					System.out.println("Entrada inv�lida! Digite apenas n�meros inteiros.");
					scanner.nextLine(); // Limpa o buffer do scanner para evitar loop infinito
				}
			}

			// Validar a op��o
			if (resp < 0 || resp > 11) {
				System.out.println("Op��o inv�lida! Escolha entre 0 - 11 ");
			}

		}

	}
}
