package br.gov.sp.fatec;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.sp.fatec.model.Autorizacao;
import br.gov.sp.fatec.model.Usuario;
import br.gov.sp.fatec.repository.UsuarioRepository;

public class UsuarioTest {

	@Autowired
	UsuarioRepository usuarioRepo;
	ApplicationContext context;

	@Before
	public void setUp() {
		this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
		usuarioRepo = (UsuarioRepository) context.getBean("usuarioRepository");
	}

	@Test
	public void salvarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome("Paulo");
		usuario.setSenha("senha");
		usuario.setEmail("pauloppc@gmail.com");
		usuario.setLogin("pauloppc");
		usuarioRepo.save(usuario);
		assertNotNull(usuario.getId());
		assertNotNull(usuarioRepo.findByNome("Paulo").getNome());
	}

	@Test
	public void atualizarUsuario(){
		Usuario usuario = new Usuario();
		usuario.setNome("Maria");
		usuario.setSenha("123");
		usuario.setEmail("mariamae@gmail.com");
		usuario.setLogin("mariamae");
		usuarioRepo.save(usuario);
		usuario = usuarioRepo.findByNome("Maria");
		usuario.setSenha("teste");
		usuarioRepo.save(usuario);
		assertEquals("teste", usuarioRepo.findByNome("Maria").getSenha());
	}
	
	@Test
	public void deletarUsuario(){
		Usuario usuario = new Usuario();
		usuario.setNome("Carlos");
		usuario.setSenha("tatata");
		usuario.setEmail("carloscap@gmail.com");
		usuario.setLogin("carloscap");
		usuarioRepo.save(usuario);
		usuarioRepo.delete(usuario);
		assertNull(usuarioRepo.findByNome("Carlos"));
		
		
	}
	
	
	
}
