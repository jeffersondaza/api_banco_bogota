package co.edu.usbbog.bdd.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import co.edu.usbbog.bdd.model.Ciudad;

@Repository
public interface CiudadRepository extends CrudRepository<Ciudad, Long>{
	
	
}
