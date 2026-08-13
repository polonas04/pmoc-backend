package com.pi.unileste.pmoc.PessoaService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pi.unileste.pmoc.Models.Pessoa;
import com.pi.unileste.pmoc.Repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public String escrever_nome_pessoa(Integer id, String nome) {
		return id + " " + nome	;
	}

	public Pessoa listar_pessoa_by_cpf(String cpf) {
		
		Optional<Pessoa> optionalPessoa = pessoaRepository.findById(cpf);
		
		if(optionalPessoa.isPresent()) {
			Pessoa p = optionalPessoa.get();
			return p;
		}
		
		return null;
	}

	public List<Pessoa> listar_pessoas() {
		return pessoaRepository.findAll();
	}
	
}
