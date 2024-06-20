package roupa;

import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Declarando as variavéis
		int opc;

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

			opc = sc.nextInt();

			if (opc == 6) {
				System.out.println("\nVocê imagina, e nós vestimos você!");
				sobre();
				sc.close();
				System.exit(0);
			}

			switch (opc) {
			case 1:
				System.out.println("Novo Pedido\n\n");

				break;
			case 2:
				System.out.println("Listar Pedidos\n\n");

				break;
			case 3:
				System.out.println("Buscar Pedido - por número\n\n");

				break;
			case 4:
				System.out.println("Editar Pedido\n\n");

				break;
			case 5:
				System.out.println("Cancelar pedido\n\n");

				break;
			default:
				System.out.println("\nOpção Inválida!\n");
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
}