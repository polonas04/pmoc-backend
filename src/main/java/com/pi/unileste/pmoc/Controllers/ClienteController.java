package com.pi.unileste.pmoc.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.unileste.pmoc.Models.Cliente;
import com.pi.unileste.pmoc.PessoaService.ClienteService;

import DTOs.ClienteDTO;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	public ClienteService cService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listarClientes(){
		List<Cliente> lista = cService.listarClientes();
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(lista);
	}
	
	//Tela de Login Cliente
	@GetMapping("/{matricula}/{senha}")
	public ResponseEntity<Cliente> listarClientePorMatricula(@PathVariable String matricula, @PathVariable String senha){
		Cliente c = cService.listarClientePorMatricula(matricula, senha);
		
		if(c == null) {
			throw new RuntimeException("Credenciais Incorretas!");
		}
		
		return ResponseEntity.ok().body(c);
	}
	
	@PutMapping("/{matricula}")
	public ResponseEntity<Cliente> alterarCliente(@PathVariable String matricula, @RequestBody Cliente c){
		
		Cliente novo = cService.alterar(matricula, c);
		
		return ResponseEntity.ok().body(novo);
		
	}
	
	//Tela de Cadastro Cliente
	@PostMapping
	public ResponseEntity<ClienteDTO> criarCliente(@RequestBody ClienteDTO c){
		
		ClienteDTO cCriado = cService.criarCliente(c);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cCriado);
	}
	
	
}
