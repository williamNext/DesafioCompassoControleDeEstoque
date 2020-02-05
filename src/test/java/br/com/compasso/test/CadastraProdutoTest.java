package br.com.compasso.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;


import br.com.compasso.DAO.ProdutoDAO;
import br.com.compasso.model.Produto;
import br.com.compasso.services.cadastros.CadastroProduto;

class CadastraProdutoTest {

	public static void main(String[] args) {
		try {
			testegeral();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void testegeral() throws IOException {
		
		ProdutoDAO produtoDao = new ProdutoDAO();
		CadastroProduto cadastraProd = new CadastroProduto();
//		Produto produto = new Produto(1, 25, "tripa", "produto alimenticio");
//		Produto produto1 = new Produto(2, 25, "feija0", "produto alimenticio");
		Produto produto2 = new Produto(6, 25, "erroz", "produto alimenticio",25);
		Produto produto3 = new Produto(7, 25, "brroz", "produto alimenticio",25);
		Produto produto4 = new Produto(8, 25, "zrroz", "produto alimenticio",25);
		Produto produto5 = new Produto(9, 25, "erroz", "produto alimenticio",25);
		Produto produto6 = new Produto(10, 25, "brroz", "produto alimenticio",25);
		Produto produto7 = new Produto(11, 25, "zrroz", "produto alimenticio",25);

		try {
//			cadastraProd.cadastra(produto);
//			cadastraProd.cadastra(produto1);
			cadastraProd.cadastra(produto2);
			cadastraProd.cadastra(produto3);
			cadastraProd.cadastra(produto4);
			cadastraProd.cadastra(produto5);
			cadastraProd.cadastra(produto6);
			cadastraProd.cadastra(produto7);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			Set<Produto> cadastros = produtoDao.desserealizaXML();
			List<Produto> clientes = new ArrayList<Produto>(cadastros);
			clientes.sort(Comparator.comparing(Produto::getNome));
			clientes.forEach(System.out::println);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
