package roupa;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import roupa.controller.RoupaController;
import roupa.model.Bermuda;
import roupa.model.Camisa;

public class Menu {
	public static void main(String[] args) {
		// import do scanner
		Scanner sc = new Scanner(System.in);

		RoupaController roupas = new RoupaController();

		// Declarando as variavéis
		int opc;
		String modelo;
		String tamanhoC;
		int tamanhoB;
		int codigo, tipo, genero;
		char subG;

		// criando objetos para testes - Segunda Etapa
		Camisa florida = new Camisa("Florida", 1, 'M', 1, "GG");
		florida.visualizar();
		Bermuda tectell = new Bermuda("Tectell", 2, 'M', 2, 55);
		tectell.visualizar();

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                    C&A DO PARAGUAI                  ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Novo Pedido                          ");
			System.out.println("            2 - Listar Pedidos                       ");
			System.out.println("            3 - Buscar Pedido                        ");
			System.out.println("            4 - Editar Pedido                        ");
			System.out.println("            5 - Cancelar pedido                      ");
			System.out.println("            6 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			// opc = sc.nextInt();

			// Utilizando exceptions para caso o valor não seja inteiro
			try {
				opc = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				sc.nextLine();
				opc = 0;
			}

			if (opc == 6) {
				System.out.println("\nVocê imagina, e nós vestimos você!");
				sobre();
				sc.close();
				System.exit(0);
			}

			switch (opc) {
			case 1:
				System.out.println("Novo Pedido\n\n");
				do {
					System.out.println("Digite o Tipo da Roupa (1 - Camisa | 2 - Bermuda): ");
					tipo = sc.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o Modelo da Roupa: ");
				sc.skip("\\R?");
				modelo = sc.nextLine();

				System.out.println("Digite o Genero da Roupa (1 - 'M' Masculino | 2 - 'F' Feminino): ");
				genero = sc.nextInt();

				if (genero == 1) {
					subG = 'M';
				} else {
					subG = 'F';
				}

				// Camisa florida = new Camisa("Florida", 1, 'M', "GG");
				switch (tipo) {
					case 1 -> {
						System.out.println("Digite o tamanho da Camisa (PP - P - M - G - GG - XG - XXG - XXXG): ");
						sc.skip("\\R?");
						tamanhoC = sc.nextLine();
	
						roupas.cadastrar(new Camisa(modelo, roupas.gerarCodigo(), subG, tipo, tamanhoC));
					}
					case 2 -> {
						System.out.println("Digite o tamanho da Bermuda (Em número): ");
						tamanhoB = sc.nextInt();
	
						roupas.cadastrar(new Bermuda(modelo, roupas.gerarCodigo(), subG, tipo, tamanhoB));
					}
				}

				keyPress();
				break;
			case 2:
				System.out.println("Listar Pedidos\n\n");

				roupas.listarTodas();

				keyPress();
				break;
			case 3:
				System.out.println("Buscar Pedido - por número\n\n");

				System.out.println("Digite o número do pedido: ");
				codigo = sc.nextInt();

				roupas.procurarPorNumero(codigo);

				keyPress();
				break;
			case 4:
				System.out.println("Editar Pedido\n\n");

				System.out.println("Digite o número do pedido: ");
				codigo = sc.nextInt();

				var buscaConta = roupas.buscaNaCollection(codigo);

				if (buscaConta != null) {
					tipo = buscaConta.getTipo();

					System.out.println("Digite o Modelo da Roupa: ");
					sc.skip("\\R?");
					modelo = sc.nextLine();

					System.out.println("Digite o Genero da Roupa (1 - 'M' Masculino | 2 - 'F' Feminino): ");
					genero = sc.nextInt();

					if (genero == 1) {
						subG = 'M';
					} else {
						subG = 'F';
					}

					// Camisa florida = new Camisa("Florida", 1, 'M', "GG");
					switch (tipo) {
						case 1 -> {
							System.out.println("Digite o tamanho da Camisa (PP - P - M - G - GG - XG - XXG - XXXG): ");
							tamanhoC = sc.nextLine();
	
							roupas.atualizar(new Camisa(modelo, codigo, subG, tipo, tamanhoC));
						}
						case 2 -> {
							System.out.println("Digite o tamanho da Bermuda (Em número): ");
							tamanhoB = sc.nextInt();
	
							roupas.atualizar(new Bermuda(modelo, codigo, subG, tipo, tamanhoB));
						}
						default -> {
							System.out.println("Tipo de conta inválido!");
						}
					}
				} else {
					System.out.println("A Conta não foi encontrada!");
				}

				keyPress();
				break;
			case 5:
				System.out.println("Cancelar pedido\n\n");
				
				System.out.println("Digite o número da conta: ");
				codigo = sc.nextInt();

				roupas.deletar(codigo);
				
				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida!\n");

				keyPress();
				break;
			}
		}

	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Wallacy Gabriel Menezes Santos");
		System.out.println("github.com/PhysisOfWally/Comercio-Eletronico-Projeto");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {
		try {
			System.out.println("\n\nPressione Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}