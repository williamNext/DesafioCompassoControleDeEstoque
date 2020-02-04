package br.com.compasso.model;

public class Compra {
	private Produto produto;
	private int quantidade;
	private double valorTotalcompra;

	
	public Compra(Produto produto, int quantidade, double valorTotalcompra) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.valorTotalcompra = valorTotalcompra;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public double getValorTotalcompra() {
		return valorTotalcompra;
	}


	public void setValorTotalcompra(double valorTotalcompra) {
		this.valorTotalcompra = valorTotalcompra;
	}
	
	
	
	
}
