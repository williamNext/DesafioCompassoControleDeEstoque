package br.com.compasso.services;

import br.com.caelum.stella.validation.CPFValidator;

public class ValidaCPF implements ValidarDocumento{

	public void validarDocumento(String cpf) throws IllegalStateException{
		CPFValidator validador = new CPFValidator();
		validador.assertValid(cpf);			
	}

}
