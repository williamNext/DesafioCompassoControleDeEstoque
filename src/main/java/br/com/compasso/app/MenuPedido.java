package br.com.compasso.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.compasso.model.Cliente;
import br.com.compasso.model.Compra;
import br.com.compasso.model.Pedido;
import br.com.compasso.model.Produto;
import br.com.compasso.services.AtualizaEstoqueProduto;
import br.com.compasso.services.ListaEstoque;
import br.com.compasso.services.PreparaPedido;
import br.com.compasso.services.cadastros.CadastroPedido;
import br.com.compasso.services.cadastros.CadastroProduto;

public class MenuPedido {
	private List<Compra> compras = new ArrayList<Compra>();
	private PreparaPedido preparaPedido  = new PreparaPedido();
	private ListaEstoque listaestoque = new ListaEstoque();
	private Cliente cliente ;
	private AtualizaEstoqueProduto estoque = new AtualizaEstoqueProduto();
	private CadastroProduto cadastroProduto= new CadastroProduto();
	private CadastroPedido cadastraPedido = new CadastroPedido();
	
	public MenuPedido(Scanner scan) {
			try {
				this.preparaPedido.carregaDados();
				startMenu(scan);
			} catch (IOException e) {
				System.out.println("erro na leitura dos dados: " +e.getMessage());
			}
	     }

	public void startMenu(Scanner scan) {
		
		int condition =1;
		while (true) {
			System.out.println("Digite 0 para voltar ao menu pricipal ou 1 pra continuar comprando");
			condition = Integer.parseInt(scan.nextLine());
			
			//se zero guarda o pedido e volta para o menu
			if (condition == 0) {
					break;
			}else {
				try {
					
				   System.out.println("Digite cpf do cliente");
				   String cpf =(scan.nextLine());
				   this.cliente = this.preparaPedido.findClientePorCpf(cpf);
							
					this.listaestoque.listaProdutosEstoque();
					
					System.out.println("digite codigo do produto desejado");
					
					int  codigoproduto =Integer.parseInt(scan.nextLine());
					
					Produto produto = this.preparaPedido.findProdutoPorCodigo(codigoproduto);
					
					System.out.println("dgite quantidade do produto: ");
					int  quantidade =Integer.parseInt(scan.nextLine());
					checaQuantidadeProduto(produto, quantidade);
					cadastraPedido.cadastra(new Pedido(this.cliente,produto.getValor()*quantidade));
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			

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

}
