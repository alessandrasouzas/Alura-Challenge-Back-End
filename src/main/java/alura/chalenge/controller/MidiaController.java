package alura.chalenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alura.chalenge.model.Midia;
import alura.chalenge.service.MidiaService;

@RestController	
@RequestMapping("/videos")
public class MidiaController {
	
	@Autowired
	private MidiaService midiaService;
	
	@GetMapping()
	public ResponseEntity<List<Midia>> buscarTodos(){
		return midiaService.buscarTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Midia> buscarPeloId(@PathVariable(value="id") Long id){	
		return midiaService.buscarPeloId(id);
	}
	
	@PostMapping()
	public ResponseEntity<String> criarVideo(@RequestBody Midia midia){	
		return midiaService.criarVideo(midia);
	}

	@PutMapping()
	public ResponseEntity<Midia> atualizarVideo(@RequestBody Midia midia) {
		return midiaService.atualizarVideo(midia);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Midia> deletarVideoPeloId(@PathVariable(value="id") Long id){	
		return midiaService.deletarVideoPeloId(id);
	}
}
