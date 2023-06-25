package br.edu.ifce.MeuPrimeiroSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifce.MeuPrimeiroSpring.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long>{

}
