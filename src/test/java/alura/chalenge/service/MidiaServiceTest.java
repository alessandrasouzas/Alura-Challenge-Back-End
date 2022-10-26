package alura.chalenge.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import alura.chalenge.model.Midia;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class MidiaServiceTest {
	
	@Autowired
	private MidiaService service;
	
	@Order(1)
	@Test	
	public void buscarTodosTest() {
		
		ResponseEntity<List<Midia>> midias = service.buscarTodos();
		Integer expected = midias.getBody().size();
		
		assertEquals(expected, 2);
		assertEquals(midias.getStatusCode(), HttpStatus.OK);		
	}
	
	
	@Order(2)
	@Test
	public void buscarPeloIdTest() {
		
		ResponseEntity<Midia> midias = service.buscarPeloId(1L);	
		assertEquals(midias.getStatusCode(), HttpStatus.OK);
	}
			
	@Order(3)
	@Test
	public void atualizarVideoTest() {
		Midia midia = new Midia();
		midia.setId(2L);
		midia.setTitle("Teste");
		midia.setDescription("teste de criacao");
		midia.setUrl("/you.be/teste");
		
		ResponseEntity<Midia> midias = service.atualizarVideo(midia);	
		assertEquals(midias.getStatusCode(), HttpStatus.OK);
	}
	
	@Order(4)
	@Test
	public void criarVideoTest() {
		Midia midia = new Midia();
		
		midia.setId(3L);
		midia.setTitle("Teste");
		midia.setDescription("teste de criacao");
		midia.setUrl("/you.be/teste");
				
		ResponseEntity<String> midias = service.criarVideo(midia);
		assertEquals(midias.getStatusCode(), HttpStatus.CREATED);
	}
	
	@Order(5)
	@Test
	public void deletarVideoPeloIdTest() {
		ResponseEntity<Midia> midias = service.deletarVideoPeloId(3L);	
		assertEquals(midias.getStatusCode(), HttpStatus.OK);
	}

}
