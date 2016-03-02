package br.gov.sp.fatec.factory;

import br.gov.sp.fatec.model.Usuario;

public class UsuarioFactory {

	public static Usuario criarUsuario(Long id, String nome, String login,
			String senha, String email) {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setEmail(email);
		return usuario;
	}

}
