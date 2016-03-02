package br.gov.sp.fatec.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.model.Tarefa;

@Repository("tarefaRepository")
public interface TarefaRepository extends CrudRepository<Tarefa, Long> {

}
