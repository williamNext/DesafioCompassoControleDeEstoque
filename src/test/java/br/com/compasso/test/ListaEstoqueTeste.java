package br.com.compasso.test;



import org.junit.jupiter.api.Test;

import br.com.compasso.services.ListaEstoque;

class ListaEstoqueTeste {

	@Test
	void test() {
		ListaEstoque estoque= new ListaEstoque();
		estoque.listaProdutosEstoque();
	}

}
