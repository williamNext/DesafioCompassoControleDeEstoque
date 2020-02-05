package br.com.compasso.app;

import java.util.Scanner;

import br.com.compasso.services.ListaEstoque;


public class Menu {

	public static void main(String[] args) {
		MenuPedido menuPedido;
		MenuCadastraProduto menuProduto;
		MenuCadastraCliente menuCliente;
		Scanner scan = new Scanner(System.in);
		ListaEstoque listaEstoque;

		int condition = -1;
		while (condition != 5) {
			
			printaMenu();
			try {
				condition = Integer.parseInt(scan.nextLine());
			} catch (Exception e) {
				System.out.println("opção Inválida");
			}
			
			switch (condition) {
			case 1:
				listaEstoque = new ListaEstoque();
				listaEstoque.listaProdutosEstoque();
				break;
			case 2:
				menuPedido = new MenuPedido();
				menuPedido.startMenu(scan);
				break;
			case 3:
				menuProduto = new MenuCadastraProduto();
				menuProduto.startMenu(scan);
				break;
			case 4:
				menuCliente = new MenuCadastraCliente();
				menuCliente.startMenu(scan);
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("opção inválida");
				break;
			}

		}
		scan.close();
	}
	

	static void printaMenu() {
		System.out.println("\n## Escolha uma das opções abaixo ## \n" + "1 - Verifica Estoque\n"
				+ "2 - Fazer pedido\n" + "3 - Cadastrar produto\n"+ "4 - Cadastrar Cliente\n"+ "5 - Sair");

		System.out.println("---------------------------------\n");
		System.out.print("Digite aqui sua opção: ");
	}
}
