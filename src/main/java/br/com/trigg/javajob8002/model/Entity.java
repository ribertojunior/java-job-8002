package br.com.trigg.javajob8002.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Entity {
  private String recrutador;
  private Date dtAberturaVaga;
  private List<Candidato> candidatos;
}
