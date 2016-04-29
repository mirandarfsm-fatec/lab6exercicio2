package br.gov.sp.fatec;

import java.util.Date;

import org.junit.Assert;
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

import br.gov.sp.fatec.factory.AfastamentoFactory;
import br.gov.sp.fatec.factory.UsuarioFactory;
import br.gov.sp.fatec.model.Afastamento;
import br.gov.sp.fatec.model.Usuario;
import br.gov.sp.fatec.repository.AfastamentoRepository;
import br.gov.sp.fatec.repository.UsuarioRepository;
import br.gov.sp.fatec.service.AfastamentoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@Rollback
@Transactional
public class AfastamentoTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Autowired
	private AfastamentoRepository afastamentoRepo;

	@Autowired
	private AfastamentoService afastamentoService;

	@Test
	public void salvarAfastamento() {
		Usuario usuario = UsuarioFactory.criarUsuario(null, "teste", "teste",
				"teste", "teste@fatec.com");
		usuarioRepo.save(usuario);
		Date dataInicio = new Date();
		Date dataFim = new Date(2016, 03, 10);
		Afastamento afastamento = AfastamentoFactory.criarAfastamento(null,
				"Férias", dataInicio, dataFim, "", usuario);
		afastamento = afastamentoRepo.save(afastamento);
		Assert.assertEquals(afastamento.getUsuario().getId(), usuario.getId());
		Assert.assertEquals("Férias", afastamento.getMotivo());
	}

	@Test
	public void testIsAfastado() {
		Usuario usuario = UsuarioFactory.criarUsuario(null, "teste", "teste",
				"teste", "teste@fatec.com");
		usuarioRepo.save(usuario);
		Date dataInicio = new Date();
		Date dataFim = new Date();
		dataFim.setDate(dataInicio.getDate() + 3);
		Afastamento afastamento = AfastamentoFactory.criarAfastamento(null,
				"Férias", dataInicio, dataFim, "", usuario);
		afastamentoRepo.save(afastamento);
		Date date = new Date();
		date.setDate(dataFim.getDate() - 1);
		Assert.assertTrue(afastamentoService.isAfastado(date, usuario));
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

}
