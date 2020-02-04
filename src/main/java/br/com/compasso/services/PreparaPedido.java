package br.com.compasso.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.compasso.DAO.ClienteDAO;
import br.com.compasso.DAO.ProdutoDAO;
import br.com.compasso.model.Cliente;
import br.com.compasso.model.Produto;
import br.com.compasso.utils.Filenames;

public class PreparaPedido {
	ClienteDAO clienteDao = new ClienteDAO();
	ProdutoDAO produtoDao = new ProdutoDAO();
	List<Cliente> clientesCadastrados = new ArrayList<Cliente>();
	List<Produto> produtoscadastrados = new ArrayList<Produto>();

	

	public void carregaDados() throws IOException{
		
			this.produtoscadastrados = new ArrayList<Produto>(this.produtoDao.desserealizaXML());
			this.clientesCadastrados = new ArrayList<Cliente>(this.clienteDao.desserealizaXML());
	}

	public Cliente findClientePorCpf(String cpf) throws IOException {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>(this.clienteDao.desserealizaXML());
		for (Cliente cliente : clientes) {
			if (cliente.getCpf().equalsIgnoreCase(cpf)) {
				return cliente;
			}
		}
		throw new RuntimeException("não ha clientes com esse cpf");
	}


	public Produto findProdutoPorCodigo(int codigoProduto) {
		if (!this.produtoscadastrados.isEmpty()) {
			for (Produto produto : produtoscadastrados) {
				if (produto.getCodigo() == codigoProduto) {
					return produto;
				}
			}
		}
		throw new RuntimeException("não ha produto com este código");
	}

}
