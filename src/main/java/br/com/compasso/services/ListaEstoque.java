package br.com.compasso.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.com.compasso.DAO.ProdutoDAO;
import br.com.compasso.model.Produto;

public class ListaEstoque {
	
	 public void  listaProdutosEstoque()  {
		 try {
			
			 ProdutoDAO produtoDAO = new ProdutoDAO();
			 List<Produto> produtosestoque  = new ArrayList<Produto>(produtoDAO.desserealizaXML());
			 produtosestoque.sort(Comparator.comparing(Produto::getNome));
			 System.out.println("\nListas de produtos:\n");
			 for (Produto produto : produtosestoque) {
				 System.out.println("------------------------------------------------------------------------------------------------------");
				 System.out.println(produto);
				 System.out.println("------------------------------------------------------------------------------------------------------");
			 }
			 System.out.println("\n");
		} catch (Exception e) {
			System.out.println("Estoque vazio");
		}
	 }
}
