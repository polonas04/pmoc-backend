package com.pi.unileste.pmoc.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.unileste.pmoc.Models.Pessoa;
import com.pi.unileste.pmoc.PessoaService.PessoaService;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
@RequestMapping("api/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> listar_Pessoas(){
		List<Pessoa> pessoas = pessoaService.listar_pessoas();

		return ResponseEntity.ok().body(pessoas);
	}
	
	@GetMapping("/{id}/{nome}")
	public String escrever_nome_pessoa(@PathVariable("id") Integer id, @PathVariable("nome") String nome) {
		return pessoaService.escrever_nome_pessoa(id, nome);
	}
	
	@GetMapping("/listar_pessoa_by_cpf/{cpf}")
	public ResponseEntity<Pessoa> listar_pessoa_by_cpf(@PathVariable String cpf){
		
		Pessoa p = pessoaService.listar_pessoa_by_cpf(cpf);
		
		return p == null ? ResponseEntity.badRequest().build() 
				: ResponseEntity.ok().body(p);
	}
	
}
