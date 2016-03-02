package br.gov.sp.fatec.factory;

import java.util.Date;

import br.gov.sp.fatec.model.Afastamento;
import br.gov.sp.fatec.model.Usuario;

public class AfastamentoFactory {

	public static Afastamento criarAfastamento(Long id, String motivo, Date dataInicio, Date dataFim, String observacao, Usuario usuario){
		Afastamento afastamento = new Afastamento();
		afastamento.setId(id);
		afastamento.setMotivo(motivo);
		afastamento.setDataInicio(dataInicio);
		afastamento.setDataFim(dataFim);
		afastamento.setObservacao(observacao);
		afastamento.setUsuario(usuario);
		return afastamento;
	}
	
}
