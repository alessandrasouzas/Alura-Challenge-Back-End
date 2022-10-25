package alura.chalenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import alura.chalenge.model.Midia;
import alura.chalenge.repository.MidiaRepository;

@Service
public class MidiaService {	
	
	@Autowired
	private MidiaRepository midiaRepository;

	public List<Midia> getVideos() {
		List<Midia> midias = midiaRepository.findAll();
		return midias;
	}

	public ResponseEntity<Midia> getVideoById(Long id) {
		Optional<Midia> midia = midiaRepository.findById(id);
		if (midia.isPresent())
			return new ResponseEntity<Midia>(midia.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.valueOf("Não encontrado"));
	}

	public void createVideo(Midia midia) {
		//	method here		
		
	}


}
