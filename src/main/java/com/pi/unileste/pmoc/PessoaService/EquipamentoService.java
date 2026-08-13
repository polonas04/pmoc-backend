package com.pi.unileste.pmoc.PessoaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.unileste.pmoc.Models.Cliente;
import com.pi.unileste.pmoc.Models.Equipamento;
import com.pi.unileste.pmoc.Repositories.ClienteRepository;
import com.pi.unileste.pmoc.Repositories.EquipamentoRepository;

import DTOs.EquipamentoDTO;

@Service
public class EquipamentoService {

	@Autowired
	private EquipamentoRepository eRep;
	@Autowired
	private ClienteRepository cRep;
	
	public List<Equipamento> listar_equipamentos(){
		return eRep.findAll();
	}

	public List<Equipamento> listar_equipamento_pelo_cliente(String matricula) {
		return eRep.findAll();
	}

	public Equipamento criar_equipamento(EquipamentoDTO e) {
		
		Cliente c = cRep.findById(e.getMatricula()).orElseThrow(
				() -> new RuntimeException("Cliente não existe"));
		
		Equipamento eNovo = new Equipamento();
		
		eNovo.setMarca(e.getMarca());
		eNovo.setMatricula_cliente(c);
		eNovo.setModelo(e.getModelo());
		eNovo.setTipo(e.getTipo());
		
		eRep.save(eNovo);
		
		return eNovo;
	}
	
}
