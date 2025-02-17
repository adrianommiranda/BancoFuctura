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
			|BANCO MIRANDA - FEITO PARA VOCÊ  - MENU PRINCIPAL|
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
			9. Transferência entre CC
			10.Aplicando na Poupança
			11.Resgatando da Poupança
			0. Sair
			""";

	// Menu criar contas
	static String menuTitulo = """
			----------------------------------
			|BANCO MIRANDA - FEITO PARA VOCÊ |
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
				System.out.println("------------Pesquise CP peno número da conta--------------\n");
				System.out.println("Informe o numero da contar");
				String numero = scanner.next();
				DAO.acessarContaCPNumero(numero);
				System.out.println("\n------------------------------------------------------------\n\n");
				exibirMenuPrincipal();
			}

			if (resp == 6) {
				System.out.println("\n\n\n " + menuTitulo);
				System.out.println("------------Pesquise CC pelo número da conta--------------\n");
				System.out.println("Informe o numero da contar");
				String numero = scanner.next();
				DAO.acessarContaCCNumero(numero);
				System.out.println("\n------------------------------------------------------------\n\n");
				exibirMenuPrincipal();
			}

			/*
			 * opção 7 - 8 - 9 iguais
			 * 
			 * Se o valor digitado não for inteiro, fica no loop até que seja inteiro
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
						System.out.println("Entrada inválida! Digite apenas números inteiros.");
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
						System.out.println("Entrada inválida! Digite apenas números inteiros.");
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
						System.out.println("Entrada inválida! Digite apenas números inteiros.");
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
				System.out.println("------------ APLICAR NA POUPANÇA --------------\n");
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
						System.out.println("Entrada inválida! Digite apenas números inteiros.");
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
				System.out.println("------------ RESGATANDO DA POUPANÇA --------------\n");
				System.out.println("Informe o nome do titular da conta da poupança:");
				String origem = scanner.next();

				double valor;

				while (true) {
					try {
						System.out.println("Informe o valor a ser transferido:");
						double valore = scanner.nextDouble();
						valor = valore;
						break;
					} catch (RuntimeException e) {
						System.out.println("Entrada inválida! Digite apenas números inteiros.");
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
			 * Solicita nova entrada do usuário, protegendo contra entradas inválidas O
			 * scanner int vai ler apenas inteiro Se ele digitar qualquer caracter diferente
			 * de inteiro vai gerer exceção se a entrada for válisa sair do loop e segue o
			 * código - breack
			 * 
			 */
			while (true) {
				try {
					System.out.println("Informe a sua opção! Menu:");
					resp = scanner.nextInt();
					break; // Sai do loop se a entrada for válida
				} catch (Exception e) {
					System.out.println("Entrada inválida! Digite apenas números inteiros.");
					scanner.nextLine(); // Limpa o buffer do scanner para evitar loop infinito
				}
			}

			// Validar a opção
			if (resp < 0 || resp > 11) {
				System.out.println("Opção inválida! Escolha entre 0 - 11 ");
			}

		}

	}
}
