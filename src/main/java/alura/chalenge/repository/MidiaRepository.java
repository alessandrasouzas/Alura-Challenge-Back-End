package alura.chalenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import alura.chalenge.model.Midia;

@Repository
public interface MidiaRepository extends JpaRepository<Midia, Long> {

	@Query("SELECT MAX(m.id) FROM Midia m")
	public Long findMaxId();

}
