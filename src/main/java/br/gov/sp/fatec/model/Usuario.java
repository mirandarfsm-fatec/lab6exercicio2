package br.gov.sp.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
	private Long id;
	
	@Column(name = "NOME", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "LOGIN", unique=true, length = 25, nullable = false)
	private String login;
	
	@Column(name = "SENHA", length = 50, nullable = false)
	private String senha;
	
	@Column(name = "EMAIL", unique=true, length = 50, nullable = false)
	private String email;
}
