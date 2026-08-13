package com.pi.unileste.pmoc.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.unileste.pmoc.Models.Cliente;
import com.pi.unileste.pmoc.Models.Os;
import com.pi.unileste.pmoc.PessoaService.ClienteService;
import com.pi.unileste.pmoc.PessoaService.OsService;

import DTOs.ViewOsDTO;

@RestController
@RequestMapping("/api/Os")
public class OsController {
	
	@Autowired
	private OsService OsService;
	@Autowired
	private ClienteService cService;
	
	//Listar Todas as Ordens Abertas e Em andamento
	@GetMapping
	public ResponseEntity<List<Os>> listar_Ordem_De_Servico(){
		
		List<Os> listaOrdens = OsService.listar_Os();
		
		listaOrdens = listaOrdens.stream()
				.filter(os -> os.getEstado() < 2).toList();
		
		return ResponseEntity.ok().body(listaOrdens);
	}
	
	//Lista Ordens de Serviço do Cliente
	@GetMapping("/dashboard/{matricula}")
	public ResponseEntity<List<Os>> listar_Os_Por_Cliente(@PathVariable String matricula){
		
		Cliente c = cService.listarClienteApenasMatricula(matricula);
		
		List<Os> lista = OsService.listar_Os();
		
		lista = lista.stream().filter(
				os -> os.getCliente().getMatricula().equals(c.getMatricula()) && os.getEstado() < 2).toList();
		
		return ResponseEntity.ok().body(lista);
	}
	
	//Lista Os pelo Id da Os
	@GetMapping("/{id}")
	public ResponseEntity<Os> listar_Os_Por_Id(@PathVariable Integer id){
		Os os = OsService.listar_Os_Por_Id(id);
		
		return ResponseEntity.ok().body(os);
	}
	
	//Cria a Os
	@PostMapping("/criar")
	public ResponseEntity<Os> criarOs(@RequestBody Os os){
		
		Os osSalva = OsService.save(os);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(osSalva);
	}
	
	/*@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Os> deletarOs(@PathVariable Integer id){
		
		OsService.deletarOs(id);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();	
		
	}*/
	
	@PutMapping("/alterar/{id}")
	public ResponseEntity<Os> alterarOs(@RequestBody Os os, @PathVariable Integer id){
		
		Os OsAtualizada = OsService.alterarOs(id, os);
		
		return ResponseEntity.ok().body(OsAtualizada);
		
	}
	
	//Inicia a Os (Funcionario)
	@PutMapping("/iniciarOs/{idOs}/{matriculaF}")
	public ResponseEntity<ViewOsDTO> iniciarOs(@PathVariable Integer idOs, @PathVariable String matriculaF){
		
		ViewOsDTO OsAtualizada = OsService.iniciarOs(idOs, matriculaF);
		
		return ResponseEntity.ok().body(OsAtualizada);
		
	}
	
	//Encerra a Os (Funcionario)
	@PutMapping("/encerrarOs/{idOs}")
	public ResponseEntity<ViewOsDTO> encerrarOs(@PathVariable Integer idOs){
		ViewOsDTO osEncerrada = OsService.encerrarOs(idOs);
		
		return ResponseEntity.ok().body(osEncerrada);
	}
}
