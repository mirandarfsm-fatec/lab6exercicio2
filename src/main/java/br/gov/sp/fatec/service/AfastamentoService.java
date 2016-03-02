package br.gov.sp.fatec.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.Usuario;
import br.gov.sp.fatec.repository.AfastamentoRepository;

@Service("afastamentoService")
public class AfastamentoService {
	
	@Autowired
	private AfastamentoRepository afastamentoRepo;
	
	public boolean isAfastado(Date date, Usuario usuario){
		return afastamentoRepo.isAfastado(date, usuario);
	}

	public AfastamentoRepository getAfastamentoRepo() {
		return afastamentoRepo;
	}

	public void setAfastamentoRepo(AfastamentoRepository afastamentoRepo) {
		this.afastamentoRepo = afastamentoRepo;
	};
	
}
