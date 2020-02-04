package br.com.compasso.test;


import java.io.IOException;

import org.junit.jupiter.api.Test;

import br.com.compasso.services.ListaEstoque;

class ListaEstoqueTeste {

	@Test
	void test() {
		ListaEstoque estoque= new ListaEstoque();
		try {
			estoque.listaProdutosEstoque();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
