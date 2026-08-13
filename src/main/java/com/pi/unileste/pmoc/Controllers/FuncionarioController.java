package com.pi.unileste.pmoc.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.unileste.pmoc.Models.Funcionario;
import com.pi.unileste.pmoc.PessoaService.FuncionarioService;

import DTOs.FuncionarioDTO;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
@RequestMapping("api/funcionario")
public class FuncionarioController {
	
	
	@Autowired
	private FuncionarioService fService;
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> listarFuncionarios(){
		
		List<Funcionario> lista = fService.listarFuncionarios();
		
		List<Funcionario> listaNova = lista.stream()
				.filter(nome -> nome.getAtivo() == 1).toList();
				
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(listaNova);
	}
	
	//Login de Funcionario
	@GetMapping("/{matricula}/{senha}")
	public ResponseEntity<Funcionario> buscarFuncPorId(@PathVariable String matricula, @PathVariable String senha){
		Funcionario f = fService.buscarFuncPorId(matricula, senha);
		
		if(f == null) {
			throw new RuntimeException("Credenciais incorretas!");
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(f);
	}
	
	@GetMapping("/{matricula}")
	public ResponseEntity<Funcionario> buscarFuncPorId(@PathVariable String matricula){
		Funcionario f = fService.buscarFuncPorMatricula(matricula);
		
		if(f == null) {
			throw new RuntimeException("Credenciais incorretas!");
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(f);
	}

	//Cadastra Funcionario
	@PostMapping
	public ResponseEntity<Funcionario> criarFuncionario(@RequestBody FuncionarioDTO fDTO) {
		
		Funcionario f = fService.criarFuncionario(fDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(f);
		
	}
	
	/*@PutMapping("/{matricula}")
	public ResponseEntity<Funcionario> alterarFuncionario(@RequestBody FuncionarioDTO fDTO, @PathVariable String matricula){
		
		Funcionario f = fService.alterarFuncionario(fDTO, matricula);
		
		return ResponseEntity.ok().body(f);
		
	}*/
}
