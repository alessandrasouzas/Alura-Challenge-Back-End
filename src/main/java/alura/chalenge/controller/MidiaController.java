package alura.chalenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alura.chalenge.model.Midia;
import alura.chalenge.service.MidiaService;

@RestController
public class MidiaController {
	
	@Autowired
	private MidiaService midiaService;
	
	@RequestMapping("/videos")
	public List<Midia> listVideos(){
		return midiaService.getVideos();
	}
	
	@GetMapping("/videos/{id}")
	public ResponseEntity<Midia> findVideoById(@PathVariable(value="id") Long id){	
		return midiaService.getVideoById(id);
	}
	
	@PostMapping("/videos/create")
	public void createVideo(Midia midia){	
		midiaService.createVideo(midia);
	}

	
}
