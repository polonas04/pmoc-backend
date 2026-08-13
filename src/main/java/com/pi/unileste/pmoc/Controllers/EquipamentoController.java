package com.pi.unileste.pmoc.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.unileste.pmoc.Models.Equipamento;
import com.pi.unileste.pmoc.PessoaService.ClienteService;
import com.pi.unileste.pmoc.PessoaService.EquipamentoService;

import DTOs.EquipamentoDTO;

@RestController
@RequestMapping("/api/equipamento")
public class EquipamentoController {
	
	@Autowired
	private EquipamentoService eService;
	@Autowired
	private ClienteService cService;
	
	@GetMapping
	public ResponseEntity<List<Equipamento>> listar_equipamentos(){
		
		List<Equipamento> lista = eService.listar_equipamentos();
		
		return ResponseEntity.ok().body(lista);
	}
	
	//Lista Equipamento do Cliente
	@GetMapping("/{matricula}")
	public ResponseEntity<List<Equipamento>> listar_equipamento_pelo_cliente(@PathVariable String matricula) {
		
		List<Equipamento> lista = eService.listar_equipamento_pelo_cliente(matricula);
		
		lista = lista.stream().filter(e -> e.getCliente().getMatricula().equals(matricula)).toList();
		
		return ResponseEntity.ok().body(lista);
	}
	
	//Cadastrar Equipamento do Cliente
	@PostMapping
	public ResponseEntity<EquipamentoDTO> criar_equipamento(@RequestBody EquipamentoDTO e){
		
		Equipamento eNovo = eService.criar_equipamento(e);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(e);
	}
	
}