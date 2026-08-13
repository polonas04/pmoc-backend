package com.pi.unileste.pmoc.PessoaService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.unileste.pmoc.Models.Funcionario;
import com.pi.unileste.pmoc.Models.Pessoa;
import com.pi.unileste.pmoc.Repositories.FuncionarioRepository;
import com.pi.unileste.pmoc.Repositories.PessoaRepository;

import DTOs.FuncionarioDTO;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository fRep;
	@Autowired
	private PessoaRepository pRep;
	
	public Funcionario criarFuncionario(FuncionarioDTO fDTO) {
		
		Pessoa p = new Pessoa();
		
		p.setCpf(fDTO.getCpf());
		p.setDataNasc(fDTO.getData_nasc());
		p.setNome(fDTO.getNome());
		p.setTelefone(fDTO.getTelefone());
		
		pRep.save(p);
		
		Funcionario f = new Funcionario();
		
		f.setMatricula(fDTO.getMatricula());
		f.setSenha(fDTO.getSenha());
		f.setPessoa(p);
		
		return fRep.save(f);
		
	}
	
	/*public void deletarFuncionario(String matricula) {
		Funcionario f = fRep.findById(matricula).orElseThrow(
				() -> new RuntimeException("Funcionario nao existe!"));
		
		pRep.deleteById(f.getPessoa().getCpf());
		fRep.deleteById(matricula);
		
	}*/

	public List<Funcionario> listarFuncionarios() {
		return fRep.findAll();
	}

	public Funcionario buscarFuncPorId(String matricula, String senha) {
		
		Funcionario f = fRep.findById(matricula).orElseThrow(
				() -> new RuntimeException("Funcionario não existe!"));
		
		if(f.getSenha().equals(senha)) {
			return f;
		}
		
		return null;
	}

	public Funcionario buscarFuncPorMatricula(String matricula) {
		
		Funcionario f = fRep.findById(matricula).orElseThrow(
				() -> new RuntimeException("Funcionario não existe!"));
		
		return f;
	}
	
}
