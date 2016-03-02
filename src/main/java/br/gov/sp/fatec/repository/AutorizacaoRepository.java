package br.gov.sp.fatec.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.model.Autorizacao;

@Repository("autorizacaoRepository")
public interface AutorizacaoRepository extends CrudRepository<Autorizacao, Long> {

}
