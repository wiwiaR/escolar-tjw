package br.edu.ifce.MeuPrimeiroSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifce.MeuPrimeiroSpring.model.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long>{

}
