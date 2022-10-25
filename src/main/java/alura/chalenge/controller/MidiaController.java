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
public class MidiaController {
	
	@Autowired
	private MidiaService midiaService;
	
	@RequestMapping("/videos")
	public List<Midia> list(){
		return midiaService.getVideos();
	}
	
	@GetMapping("/videos/{id}")
	public ResponseEntity<Midia> findVideoById(@PathVariable(value="id") Long id){	
		return midiaService.getVideoById(id);
	}
	
	@PostMapping("/videos")
	public void create(@RequestBody Midia midia){	
		midiaService.createVideo(midia);
	}

	@PutMapping("/videos/update")
	public String update(@RequestBody Midia midia) {
		// Atender uma requisição capaz de atualizar um ou mais campos de um vídeo.
		// Retornar um Json com informações do filme atualizado.
		return null;
	}

	@DeleteMapping("/videos/{id}")
	public String deleteVideoById(@PathVariable(value="id") Long id){	
		return midiaService.deleteVideoById(id);
	}
}
