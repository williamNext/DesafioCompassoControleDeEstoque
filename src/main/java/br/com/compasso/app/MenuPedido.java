package br.com.compasso.app;

import java.io.IOException;
import java.util.Scanner;

import br.com.compasso.model.Cliente;
import br.com.compasso.model.Pedido;
import br.com.compasso.model.Produto;
import br.com.compasso.services.AtualizaEstoqueProduto;
import br.com.compasso.services.ListaEstoque;
import br.com.compasso.services.PreparaPedido;
import br.com.compasso.services.cadastros.CadastroPedido;
import br.com.compasso.services.cadastros.CadastroProduto;

public class MenuPedido {
	private PreparaPedido preparaPedido = new PreparaPedido();
	private ListaEstoque listaestoque = new ListaEstoque();
	private Cliente cliente;
	private AtualizaEstoqueProduto estoque = new AtualizaEstoqueProduto();
	private CadastroProduto cadastroProduto = new CadastroProduto();
	private CadastroPedido cadastraPedido = new CadastroPedido();

	public void startMenu(Scanner scan) {
		
		if(ChecaBancoDeDados()) {
			int condition = -1;
			while (true) {
				try {
	
					System.out.println("\nDigite 0 para voltar ao menu pricipal ou 1 pra continuar comprando");
					condition = Integer.parseInt(scan.nextLine());
				} catch (Exception e) {
					condition = -1;
				}
	
				// se zero guarda o pedido e volta para o menu
				if (condition == 0) {
					break;
				} else if (condition == 1) {
					try {
	
						System.out.println("Digite cpf do cliente");
						String cpf = (scan.nextLine());
						this.cliente = this.preparaPedido.findClientePorCpf(cpf);
	
						this.listaestoque.listaProdutosEstoque();
	
						System.out.println("digite codigo do produto desejado");
	
						int codigoproduto = Integer.parseInt(scan.nextLine());
	
						Produto produto = this.preparaPedido.findProdutoPorCodigo(codigoproduto);
	
						System.out.println("dgite quantidade do produto: ");
						int quantidade = Integer.parseInt(scan.nextLine());
						checaQuantidadeProduto(produto, quantidade);
						cadastraPedido.cadastra(new Pedido(this.cliente, produto.getValor() * quantidade));
	
					} catch (Exception e) {
						System.out.println("Erro na realização do pedido: " + e.getMessage());
					}
				} else {
					System.out.println("Opção inválida");
				}
	
			}
	 }else {
		 System.out.println("Erro na leitura do banco de dados, verifique se ha clientes e produtos cadastrados");
	 }
		
	}

	private void checaQuantidadeProduto(Produto produto, int quantidade) throws IOException {
		if (produto.getQuantidadeEstoque() >= quantidade) {
			estoque.deleteProduto(produto);
			produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);
			cadastroProduto.cadastra(produto);
		} else {
			throw new RuntimeException("não ha quantidade solicitada deste produto");
		}
	}

	private boolean ChecaBancoDeDados() {
		try {
			this.preparaPedido.carregaDados();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

}
