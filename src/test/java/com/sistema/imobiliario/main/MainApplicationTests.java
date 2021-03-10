package com.sistema.imobiliario.main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import com.sistema.imobiliario.main.controller.*;
import com.sistema.imobiliario.main.entity.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MainApplicationTests {

	@Autowired
	ClienteController clienteController;

	private Cliente cliente;

	@BeforeEach
	void injecaoDependencias(){
		this.cliente = new Cliente();
		this.cliente.setEmail("teste@email");
		this.cliente.setNome("mateus");
		this.cliente.setTelefone(62332623);
	}

	@Test
	void retorna_sucesso_quando_salvarCliente() {

		//when
		String clienteSalvo = this.clienteController.salvarCliente(this.cliente);

		//then
		assertEquals("sucesso", clienteSalvo);
	}

	@Test
	void retorna_true_quando_clienteJaExistenteAoSalvar(){

		//when
		this.clienteController.salvarCliente(this.cliente);
		String clienteSalvo2 = this.clienteController.salvarCliente(this.cliente);

		//then
		assertEquals("Cliente já cadastrado", clienteSalvo2);
	}

	@Test
	void retorna_true_quando_clienteIsEmpty() {

		//when
		List<Cliente> clientes = this.clienteController.buscaClientes();

		//then
		assertTrue(clientes.isEmpty());
	}

	@Test
	void retorna_false_quando_clienteEmptyIsFalse() {
		
		//when
		this.clienteController.salvarCliente(this.cliente);
		List<Cliente> clientes = this.clienteController.buscaClientes();

		//then
		assertFalse(clientes.isEmpty());
	}

	@Test
	void retorna_true_quando_deletaCliente(){

		this.clienteController.salvarCliente(this.cliente);
		String clienteDeletado = this.clienteController.deletarCliente(this.cliente.getId());

		assertEquals("deletado com sucesso", clienteDeletado);
	}
}
