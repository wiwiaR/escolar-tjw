package br.edu.ifce.MeuPrimeiroSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifce.MeuPrimeiroSpring.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
