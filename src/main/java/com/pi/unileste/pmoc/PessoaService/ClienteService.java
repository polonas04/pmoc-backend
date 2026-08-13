package com.pi.unileste.pmoc.PessoaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pi.unileste.pmoc.Models.Cliente;
import com.pi.unileste.pmoc.Models.Endereco;
import com.pi.unileste.pmoc.Models.Pessoa;
import com.pi.unileste.pmoc.Repositories.ClienteRepository;
import com.pi.unileste.pmoc.Repositories.EnderecoRepository;
import com.pi.unileste.pmoc.Repositories.PessoaRepository;

import DTOs.ClienteDTO;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository cRep;
	@Autowired
	private PessoaRepository pRep;
	@Autowired
	private EnderecoRepository eRep;
	
	public List<Cliente> listarClientes() {
		return cRep.findAll();
	}

	public Cliente listarClientePorMatricula(String matricula, String senha) {
		Cliente c = cRep.findById(matricula).orElseThrow(
				() -> new RuntimeException("Cliente não existe!"));
		
		if(c.getSenha().equals(senha)) {
			return c;
		}
		
		return null;
	}
	
	public Cliente listarClienteApenasMatricula(String matricula) {
		Cliente c = cRep.findById(matricula).orElseThrow(
				() -> new RuntimeException("Cliente não existe!"));
		
		return c;
	}

	public Cliente alterar(String matricula, Cliente cNovo) {
		Cliente cOriginal = cRep.findById(matricula).orElseThrow(
				() -> new RuntimeException("Cliente não existe!"));
		
		cOriginal.setMatricula(cNovo.getMatricula());
		cOriginal.setSenha(cNovo.getSenha());
		
		return cNovo;
		
	}

	public ClienteDTO criarCliente(ClienteDTO c) {
		
		Cliente cNovo = new Cliente();
		cNovo.setMatricula(c.getMatricula());
		cNovo.setSenha(c.getSenha());
		
		Pessoa pNova = new Pessoa();
		
		pNova.setCpf(c.getCpf());
		pNova.setDataNasc(c.getData_nasc());
		pNova.setNome(c.getNome());
		pNova.setTelefone(c.getTelefone());
		
		cNovo.setPessoa(pNova);
		
		Endereco eNovo = new Endereco();
		
		eNovo.setCep(c.getCep());
		eNovo.setCidade(c.getCidade());
		eNovo.setEstado(c.getEstado());
		eNovo.setNumero(c.getNumero());
		eNovo.setPessoa(pNova);
		
		pRep.save(pNova);
		eRep.save(eNovo);
		cRep.save(cNovo);
		
		return c;
	}
	
	
	
}
