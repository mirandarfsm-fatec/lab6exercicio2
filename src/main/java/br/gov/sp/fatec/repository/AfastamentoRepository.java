package br.gov.sp.fatec.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.model.Afastamento;
import br.gov.sp.fatec.model.Usuario;

@Repository("afastamentoRepository")
public interface AfastamentoRepository extends
		CrudRepository<Afastamento, Long> {

	@Query("select case when (count(a.id) > 0) then true else false end "
			+ "from Afastamento a "
			+ "where a.dataInicio < ?1 and "
			+ "a.dataFim >  ?1 and a.usuario = ?2")
	public boolean isAfastado(Date date, Usuario usuario);
}
