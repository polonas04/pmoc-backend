package DTOs;

import java.time.LocalDate;

import com.pi.unileste.pmoc.Models.Cliente;
import com.pi.unileste.pmoc.Models.Equipamento;
import com.pi.unileste.pmoc.Models.Funcionario;

public class ViewOsDTO {

	private Integer id;
	private String descricao;
	private Cliente cliente;
	private Equipamento equipamento;
	private Funcionario funcionario;
	private Integer estado;
	private LocalDate data_atendimento;
	private LocalDate data_conclusao;
	
	public ViewOsDTO() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public LocalDate getData_atendimento() {
		return data_atendimento;
	}

	public void setData_atendimento(LocalDate data_atendimento) {
		this.data_atendimento = data_atendimento;
	}

	public LocalDate getData_conclusao() {
		return data_conclusao;
	}

	public void setData_conclusao(LocalDate data_conclusao) {
		this.data_conclusao = data_conclusao;
	}
	
	
}
