package com.pi.unileste.pmoc.PessoaService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pi.unileste.pmoc.Models.Funcionario;
import com.pi.unileste.pmoc.Models.Os;
import com.pi.unileste.pmoc.Repositories.FuncionarioRepository;
import com.pi.unileste.pmoc.Repositories.OsRepository;

import DTOs.ViewOsDTO;

@Service
public class OsService {

	@Autowired
	private OsRepository OsRepository;
	@Autowired
	private FuncionarioRepository fRep;

	public List<Os> listar_Os() {
		return OsRepository.findAll();
	}

	public Os listar_Os_Por_Id(Integer id) {
		
		Optional<Os> os = OsRepository.findById(id);
		
		if(os.isPresent()) {
			return os.get();
		}
		
		throw new NullPointerException("OS não encontrada");
	}

	public Os save(Os os) {
		
		return OsRepository.save(os);
		
	}

	public void deletarOs(Integer id) {
		
		OsRepository.deleteById(id);
		
	}

	public Os alterarOs(Integer id, Os osNova) {
		
		Os osExiste = OsRepository.findById(id)
				.orElseThrow(() -> 
					new NullPointerException("Os não Existe!"));
		
		osExiste.setDescricao(osNova.getDescricao());
		osExiste.setEstado(osNova.getEstado());
		osExiste.setData_conclusao(osNova.getData_conclusao());
		osExiste.setData_atendimento(osNova.getData_atendimento());
		osExiste.setDescricao(osNova.getDescricao());
		
		return OsRepository.save(osExiste);
	}

	public ViewOsDTO iniciarOs(Integer idOs, String matriculaF) {
		
		Os os = OsRepository.findById(idOs).orElseThrow(
				() -> new RuntimeException("Os não encontrada!"));
		
		Funcionario f = fRep.findById(matriculaF).orElseThrow(
				() -> new RuntimeException("Funcionario não encontrada!"));
		
		os.setData_atendimento(LocalDate.now());
		os.setEstado(1);
		os.setFuncionario(f);
		
		OsRepository.save(os);
		
		ViewOsDTO OsDTO = new ViewOsDTO();
		
		OsDTO.setId(os.getId());
		OsDTO.setCliente(os.getCliente());
		OsDTO.setData_atendimento(os.getData_atendimento());
		OsDTO.setData_conclusao(os.getData_conclusao());
		OsDTO.setEquipamento(os.getEquipamento());
		OsDTO.setEstado(os.getEstado());
		OsDTO.setDescricao(os.getDescricao());
		OsDTO.setFuncionario(os.getFuncionario());
		
		return OsDTO;
	}

	public ViewOsDTO encerrarOs(Integer idOs) {
		
		Os os = OsRepository.findById(idOs).orElseThrow(
				() -> new RuntimeException("Os não encontrada!"));
		
		os.setData_conclusao(LocalDate.now());
		os.setEstado(2);
		
		OsRepository.save(os);
		
		ViewOsDTO OsDTO = new ViewOsDTO();
		
		OsDTO.setId(os.getId());
		OsDTO.setCliente(os.getCliente());
		OsDTO.setData_atendimento(os.getData_atendimento());
		OsDTO.setData_conclusao(os.getData_conclusao());
		OsDTO.setEquipamento(os.getEquipamento());
		OsDTO.setEstado(os.getEstado());
		OsDTO.setDescricao(os.getDescricao());
		OsDTO.setFuncionario(os.getFuncionario());
		
		return OsDTO;
	}
	
}
