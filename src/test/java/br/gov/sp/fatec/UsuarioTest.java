package br.gov.sp.fatec;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.factory.UsuarioFactory;
import br.gov.sp.fatec.model.Usuario;
import br.gov.sp.fatec.repository.UsuarioRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@Rollback
@Transactional
public class UsuarioTest extends AbstractTransactionalJUnit4SpringContextTests{

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Test
	public void salvarUsuario() {
		Usuario usuario = UsuarioFactory.criarUsuario(null, "Paulo", "senha",
				"pauloppc@gmail.com", "pauloppc");
		usuarioRepo.save(usuario);
		assertNotNull(usuario.getId());
		assertNotNull(usuarioRepo.findByNome("Paulo").getNome());
	}

	@Test
	public void atualizarUsuario() {
		Usuario usuario = UsuarioFactory.criarUsuario(null, "Maria", "123",
				"mariamae@gmail.com", "mariamae");
		usuarioRepo.save(usuario);
		usuario = usuarioRepo.findByNome("Maria");
		usuario.setSenha("teste");
		usuarioRepo.save(usuario);
		assertEquals("teste", usuarioRepo.findByNome("Maria").getSenha());
	}

	@Test
	public void deletarUsuario() {
		Usuario usuario = UsuarioFactory.criarUsuario(null, "Carlos", "tatata",
				"carloscap@gmail.com", "carloscap");
		usuarioRepo.save(usuario);
		usuarioRepo.delete(usuario);
		assertNull(usuarioRepo.findByNome("Carlos"));
	}

}
