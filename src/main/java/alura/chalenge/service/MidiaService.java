package alura.chalenge.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import alura.chalenge.model.Midia;
import alura.chalenge.repository.MidiaRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MidiaService {

	@Autowired
	private MidiaRepository midiaRepository;
	
	private AtomicLong nextId;

	public ResponseEntity<List<Midia>> buscarTodos() {

		log.info("Buscando todos os videos.");
		
		List<Midia> midias = midiaRepository.findAll();
		if(!midias.isEmpty()) {
			log.info("Total: {}.", midias.size());
			return new ResponseEntity<List<Midia>>(midias, HttpStatus.OK);	
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
	}

	public ResponseEntity<Midia> buscarPeloId(Long id) {
	
		log.info("Buscando video pelo id: {}.", id);
		Optional<Midia> midia = midiaRepository.findById(id);

		if (midia.isPresent()) {
			log.info("Encontrado o video: {}.", midia.get());
			return new ResponseEntity<Midia>(midia.get(), HttpStatus.OK);
		}
		
		log.info("Video não encontrado!");
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
	}

	public ResponseEntity<String> criarVideo(Midia midia) {

		if (midia != null) {
			
			nextId = findNextId();
			midia.setId(nextId.longValue());
			midiaRepository.save(midia);
			log.info("Video salvo com sucesso.");
			return new ResponseEntity<String>(HttpStatus.CREATED);			
		}
			log.info("Não foi possivel salvar.");
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);		
	}


	public ResponseEntity<Midia> atualizarVideo(Midia midia) {

		log.info("Buscando video para atualizar - id: {}.", midia.getId());
		Optional<Midia> result = midiaRepository.findById(midia.getId());

		if (result.isPresent()) {

			log.info("Encontrado o video para atualizar.");
			result.get().setTitle(midia.getTitle());
			result.get().setDescription(midia.getDescription());
			result.get().setUrl(midia.getUrl());
			log.info("Informações atualizadas!");

			midiaRepository.save(result.get());
			log.info("Video atualizado com sucesso.");

			return new ResponseEntity<Midia>(result.get(), HttpStatus.OK);
		}

		log.info("Video não encontrado.");
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	public ResponseEntity<Midia> deletarVideoPeloId(Long id) {
		
		log.info("Buscando video para deletar - id: {}.", id);
		Optional<Midia> midia = midiaRepository.findById(id);
		
		if (midia.isPresent()) {
			log.info("Video encontrado, iniciando o delete");
			midiaRepository.deleteById(id);
			log.info("Video deletado com sucesso!");
			
			return new ResponseEntity<Midia>(midia.get(), HttpStatus.OK);
		}
		
		log.info("Video não encontrado, não foi possivel deletar");
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	private AtomicLong findNextId() {
		Long id = midiaRepository.findMaxId();
		
		if(id == null) {
			id = 0L;			
		}		
		
		Long nextId = new AtomicLong(id).incrementAndGet();
		
		return new AtomicLong(nextId);
	}
}
