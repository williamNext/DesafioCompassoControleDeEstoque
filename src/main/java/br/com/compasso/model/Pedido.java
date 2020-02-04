package br.com.compasso.model;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;



public class Pedido {
	@JacksonXmlProperty(localName = "cliente")
	private Cliente cliente;
	@JacksonXmlProperty(localName = "valorTotal")
	private double valorTotal;
	
	
	public Pedido() {
		
	}
	
	public Pedido(Cliente cliente, double valorTotal) {
		super();
		this.cliente = cliente;
		this.valorTotal = valorTotal;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	
}
