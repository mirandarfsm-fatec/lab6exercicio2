package br.gov.sp.fatec;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.sp.fatec.factory.UsuarioFactory;
import br.gov.sp.fatec.model.Usuario;
import br.gov.sp.fatec.repository.UsuarioRepository;

public class UsuarioTest {

	@Autowired
	private UsuarioRepository usuarioRepo;
	private ApplicationContext context;

	@Before
	public void setUp() {
		this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
		usuarioRepo = (UsuarioRepository) context.getBean("usuarioRepository");
	}

	@Test
	public void salvarUsuario() {
		Usuario usuario = UsuarioFactory.criarUsuario(null,"Paulo","senha","pauloppc@gmail.com","pauloppc");
		usuarioRepo.save(usuario);
		assertNotNull(usuario.getId());
		assertNotNull(usuarioRepo.findByNome("Paulo").getNome());
	}

	@Test
	public void atualizarUsuario(){
		Usuario usuario = UsuarioFactory.criarUsuario(null,"Maria","123","mariamae@gmail.com","mariamae");
		usuarioRepo.save(usuario);
		usuario = usuarioRepo.findByNome("Maria");
		usuario.setSenha("teste");
		usuarioRepo.save(usuario);
		assertEquals("teste", usuarioRepo.findByNome("Maria").getSenha());
	}
	
	@Test
	public void deletarUsuario(){
		Usuario usuario = UsuarioFactory.criarUsuario(null,"Carlos","tatata","carloscap@gmail.com","carloscap");
		usuarioRepo.save(usuario);
		usuarioRepo.delete(usuario);
		assertNull(usuarioRepo.findByNome("Carlos"));
	}
	
	
	
}
