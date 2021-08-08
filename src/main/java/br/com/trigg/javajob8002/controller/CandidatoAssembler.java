package br.com.trigg.javajob8002.controller;

import br.com.trigg.javajob8002.model.Candidato;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CandidatoAssembler
    implements RepresentationModelAssembler<Candidato, EntityModel<Candidato>> {

  @Override
  public EntityModel<Candidato> toModel(Candidato entity) {
    return EntityModel.of(
        entity,
        linkTo(methodOn(CandidatoController.class).one(entity.getId())).withSelfRel(),
        linkTo(methodOn(CandidatoController.class).all()).withRel("candidatos"));
  }
}
