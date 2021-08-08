package br.com.trigg.javajob8002.controller;

import br.com.trigg.javajob8002.model.Candidato;
import br.com.trigg.javajob8002.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CandidatoController {

  @Autowired private CandidatoRepository candidatoRepository;
  @Autowired private CandidatoAssembler candidatoAssembler;

  @GetMapping("/candidatos")
  CollectionModel<EntityModel<Candidato>> all() {
    List<EntityModel<Candidato>> candidatos =
        candidatoRepository.findByOrderByDataNascimentoAsc().stream()
            .map(candidatoAssembler::toModel)
            .collect(Collectors.toList());
    return CollectionModel.of(
        candidatos, linkTo(methodOn(CandidatoController.class).all()).withSelfRel());
  }

  @GetMapping("/candidatos/{id}")
  EntityModel<Candidato> one(@PathVariable String id) {
    Candidato candidato =
        candidatoRepository.findById(id).orElseThrow(() -> new CandidatoNotFoundException(id));
    return candidatoAssembler.toModel(candidato);
  }
}
