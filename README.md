# lab6exercicio2

No departamento que gerencia as atividades rotineiras não-fins de uma empresa, se fez necessário um sistema que controle a alocação de recursos. 
Onde: 
- Um Usuário, que possui nome, senha, login, email, id (os três últimos sendo únicos), pode ser designado, por outro Usuário, a uma Tarefa, que por sua vez possui id, titulo, descricao, status, dono, responsável (identificada unicamente por id) a designação só pode ocorrer se o usuário responsável não estiver afastado no momento. 
- Uma Tarefa pode possuir os status aberto, em andamento e concluído.
- Um Afastamento possui id, motivo, data inicio, data fim, observação e usuario. Caso uma tarefa esteja em andamento para aquele Usuário o afastamento não pode ser criado.
