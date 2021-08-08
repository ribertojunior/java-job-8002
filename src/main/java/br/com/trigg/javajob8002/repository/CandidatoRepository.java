package br.com.trigg.javajob8002.repository;

import br.com.trigg.javajob8002.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidatoRepository extends JpaRepository<Candidato, String> {
  List<Candidato> findByOrderByDataNascimentoAsc();
}