package br.com.compasso.app;

import java.util.Scanner;

import br.com.compasso.model.Cliente;
import br.com.compasso.services.cadastros.CadastroCliente;

public class MenuCadastraCliente {
	private CadastroCliente cadastraCli = new CadastroCliente();
	
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
				 System.out.println("Digite nome Do cliente");
				 String nome  = scan.nextLine();
				 System.out.println("Digite cpf do cliente");
				 String cpf  = scan.nextLine();
				 cadastraCli.cadastra(new Cliente(nome,cpf));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}else {
				System.out.println("opção inválida");
			}
			
		}
	}
	
}
