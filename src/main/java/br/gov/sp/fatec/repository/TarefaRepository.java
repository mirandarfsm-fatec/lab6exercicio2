package br.gov.sp.fatec.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Tarefa;

public interface TarefaRepository extends CrudRepository<Tarefa, Long> {

}
