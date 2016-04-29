package br.gov.sp.fatec.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "AFASTAMENTO")
@Data
public class Afastamento {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column( name = "ID")
	private Long id;
	
	@Column( name = "MOTIVO")
	private String motivo;
	
	@Column( name = "DT_INICIO")
	private Date dataInicio;
	
	@Column( name = "DT_FIM")
	private Date dataFim;
	
	@Column( name = "OBSERVACAO")
	private String observacao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USUARIO", referencedColumnName = "ID")
	private Usuario usuario;
	
}
