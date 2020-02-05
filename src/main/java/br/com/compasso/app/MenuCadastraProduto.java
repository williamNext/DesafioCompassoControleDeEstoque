package br.com.compasso.app;

import java.util.Scanner;

import br.com.compasso.model.Produto;
import br.com.compasso.services.cadastros.CadastroProduto;

public class MenuCadastraProduto {
	private CadastroProduto cadastroProduto = new CadastroProduto();
	
	public void startMenu(Scanner scan) {
		int condition=-1;
		
		while (true) {
			try {
				System.out.println("\nDigite 0 para voltar ao menu pricipal ou 1 pra continuar Cadastrando");
				condition = Integer.parseInt(scan.nextLine());
			} catch (Exception e) {
				condition =-1;
			}
			
			if (condition == 0) {
				break;
			}else if(condition == 1) {
				try {
					System.out.println("Digite código do produto (numero inteiro)");
					int codigo= Integer.parseInt(scan.nextLine());
					System.out.println("Digite nome do produto");
					String nome = scan.nextLine();
					System.out.println("Digite quantidade");
					int quantidade = Integer.parseInt(scan.nextLine());
					System.out.println("Digite Descrição do produto");
					String descricao= scan.nextLine();
					System.out.println("Digite valor do produto (utilize pontos em valores com centavos)");
					double valor= Double.parseDouble(scan.nextLine());
					cadastroProduto.cadastra(new Produto(codigo, valor, nome, descricao, quantidade));
					
				} catch (Exception e) {
					System.out.println("erro no cadastro: "+e.getMessage());
				}
			}else {
				System.out.println("opção inválida");
			}
			
		}
	}
}
