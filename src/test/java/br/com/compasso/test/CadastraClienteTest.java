package br.com.compasso.test;

import br.com.compasso.DAO.ClienteDAO;
import br.com.compasso.model.Cliente;
import br.com.compasso.services.cadastros.CadastroCliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class CadastraClienteTest {
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("avalido", "02702873022");
		Cliente cliente2 = new Cliente("bvalido", "02658075065");
		Cliente cliente6 = new Cliente("bvalido", "02658075065");
		Cliente cliente3 = new Cliente("cvalido", "05365741030");
		Cliente cliente4 = new Cliente("cpfvalido", "03607254060");
		Cliente cliente5 = new Cliente("cpf invalido", "0265");
		
		CadastroCliente cadastraCli = new CadastroCliente();
		ClienteDAO clienteDAO = new ClienteDAO();
		
		try {
			cadastraCli.cadastra(cliente);
			cadastraCli.cadastra(cliente2);
			cadastraCli.cadastra(cliente3);
			cadastraCli.cadastra(cliente4);
			cadastraCli.cadastra(cliente5);
			cadastraCli.cadastra(cliente6);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Set<Cliente> cadastros = clienteDAO.desserealizaXML(); 
			List<Cliente> clientes = new ArrayList<Cliente>(cadastros);
			clientes.sort(Comparator.comparing(Cliente::getNome));
			clientes.forEach(System.out::println);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

}
