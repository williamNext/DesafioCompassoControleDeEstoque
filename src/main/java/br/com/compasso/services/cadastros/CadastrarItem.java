package br.com.compasso.services.cadastros;

import java.io.IOException;

public interface CadastrarItem<T> {
	void cadastra(T obj)throws IOException;
}