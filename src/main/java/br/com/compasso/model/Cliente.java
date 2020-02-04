package br.com.compasso.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Cliente {
	@JacksonXmlProperty(localName = "nome")
	private String nome;
	@JacksonXmlProperty(localName = "cpf")
	private String Cpf;

	public Cliente() {
	}
	
	public Cliente(String nome, String cpf) {
		this.nome = nome;
		Cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Cpf == null) ? 0 : Cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (Cpf == null) {
			if (other.Cpf != null)
				return false;
		} else if (!Cpf.equals(other.Cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Cliente nome: %s cpf: %s", this.nome, this.Cpf);
	}

}
