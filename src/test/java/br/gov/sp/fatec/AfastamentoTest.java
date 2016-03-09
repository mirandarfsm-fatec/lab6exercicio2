package br.gov.sp.fatec;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.sp.fatec.factory.AfastamentoFactory;
import br.gov.sp.fatec.factory.UsuarioFactory;
import br.gov.sp.fatec.model.Afastamento;
import br.gov.sp.fatec.model.Usuario;
import br.gov.sp.fatec.repository.AfastamentoRepository;
import br.gov.sp.fatec.repository.UsuarioRepository;
import br.gov.sp.fatec.service.AfastamentoService;

public class AfastamentoTest {

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private AfastamentoRepository afastamentoRepo;
	
	@Autowired
	private AfastamentoService afastamentoService;
	private ApplicationContext context;

	@Before
	public void setUp() {
		this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
		usuarioRepo = (UsuarioRepository) context.getBean("usuarioRepository");
		afastamentoRepo = (AfastamentoRepository) context.getBean("afastamentoRepository");
		
	}

	@Test
	public void salvarAfastamento(){
		Usuario usuario = UsuarioFactory.criarUsuario(null, "teste", "teste", "teste", "teste@fatec.com");
		usuarioRepo.save(usuario);
		Date dataInicio = new Date();
		Date dataFim= new Date(2016,03,10);
		Afastamento afastamento = AfastamentoFactory.criarAfastamento(null, "Férias", dataInicio, dataFim, "", usuario);
		afastamentoRepo.save(afastamento);
	}
	
	@Test
	public void testIsAfastado(){
		Usuario usuario = UsuarioFactory.criarUsuario(null, "teste", "teste", "teste", "teste@fatec.com");
		usuarioRepo.save(usuario);
		Date dataInicio = new Date();
		Date dataFim= new Date(2016,03,10);
		Afastamento afastamento = AfastamentoFactory.criarAfastamento(null, "Férias", dataInicio, dataFim, "", usuario);
		afastamentoRepo.save(afastamento);
		Date date = new Date(2016,03,9);
		System.out.println(afastamentoService.isAfastado(date, usuario));
	}

	public UsuarioRepository getUsuarioRepo() {
		return usuarioRepo;
	}

	public void setUsuarioRepo(UsuarioRepository usuarioRepo) {
		this.usuarioRepo = usuarioRepo;
	}

	public AfastamentoRepository getAfastamentoRepo() {
		return afastamentoRepo;
	}

	public void setAfastamentoRepo(AfastamentoRepository afastamentoRepo) {
		this.afastamentoRepo = afastamentoRepo;
	}

	public AfastamentoService getAfastamentoService() {
		return afastamentoService;
	}

	public void setAfastamentoService(AfastamentoService afastamentoService) {
		this.afastamentoService = afastamentoService;
	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}
	
	
}
