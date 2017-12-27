package de.hhu.stups.propra.orm.uni.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.hhu.stups.propra.orm.uni.model.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {
	List<Professor> findProfessorByNameLike(String name);

}
