package br.com.compasso.app;

import java.io.IOException;
import java.util.Scanner;

import br.com.compasso.model.Pedido;
import br.com.compasso.services.ListaEstoque;


public class Menu {

	public static void main(String[] args) {
		MenuPedido menuPedido;
		Scanner scan = new Scanner(System.in);
		ListaEstoque listaEstoque = new ListaEstoque();

		int condition = -1;
		while (condition != 5) {
			printaMenu();
			condition = Integer.parseInt(scan.nextLine());
			switch (condition) {
			case 1:
				//verifica estoque
				try {
					listaEstoque.listaProdutosEstoque();
				} catch (IOException e) {
					System.out.println("estoque vazio");
				}
				break;
			case 2:
				menuPedido = new MenuPedido(scan);
				break;
			case 3:
				//cadastra produto
				System.out.println("i");
				break;
			case 4:
				//cadastra cliente
				System.out.println("i");
				break;
			default:
				System.out.println("opção inválida");
				break;
			}

		}
		scan.close();
	}
	

	static void printaMenu() {
		System.out.println("\n## Escolha uma das opções abaixo ## \n" + "1 - Verifica Estoque\n"
				+ "2 - Fazer pedido\n" + "3 - Cadastrar produto\n"+ "4 - Cadastrar Cleinte\n"+ "5 - Sair");

		System.out.println("---------------------------------\n");
		System.out.print("Digite aqui sua opção: ");
	}
}
