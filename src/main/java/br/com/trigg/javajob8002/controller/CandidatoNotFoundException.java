package br.com.trigg.javajob8002.controller;

public class CandidatoNotFoundException extends RuntimeException {
  public CandidatoNotFoundException(String s) {
    super("Candidato não encontrado " + s);
  }
}
