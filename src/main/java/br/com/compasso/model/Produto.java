package br.com.compasso.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Produto {
	@JacksonXmlProperty(localName = "codigo")
	private int codigo;
	
	@JacksonXmlProperty(localName = "valor")
	private double valor;
	
	@JacksonXmlProperty(localName = "nome")
	private String nome;
	
	@JacksonXmlProperty(localName = "descricao")
	private String descricao;
	
	@JacksonXmlProperty(localName = "qauntidadeEstoque")
	private int quantidadeEstoque;
	


	public Produto() {}
	
	

	public Produto(int codigo, double valor, String nome, String descricao, int quantidadeEstoque) {
		this.codigo = codigo;
		this.valor = valor;
		this.nome = nome;
		this.descricao = descricao;
		this.quantidadeEstoque = quantidadeEstoque;
	}



	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}



	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public int getCodigo() {
		return codigo;
	}

	public void setCódigo(int codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		Produto other = (Produto) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return"Código: "+this.codigo+ " Nome do Produto: "+this.nome+" quantidade em estoque: "+this.quantidadeEstoque
				+" Descrição:"+this.descricao+" preço: "+this.valor;
	}
	
}
