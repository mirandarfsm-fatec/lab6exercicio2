package br.gov.sp.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TAREFA")
@Data
public class Tarefa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column( name = "ID")
	private Long id;
	
	@Column( name = "TITULO")
	private String titulo;
	
	@Column( name = "DESCRICAO")
	private String descricao;
	
	@Column( name = "STATUS")
	private TarefaStatus status;
	
	@ManyToOne
	private Usuario donoTarefa;
	
	@ManyToOne
	private Usuario responsavel;
	
}
