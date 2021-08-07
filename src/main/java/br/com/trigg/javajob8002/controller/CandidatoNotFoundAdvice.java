package br.com.trigg.javajob8002.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CandidatoNotFoundAdvice {
  @ResponseBody
  @ExceptionHandler(CandidatoNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String candidatoHandler(CandidatoNotFoundException e) {
    return e.getMessage();
  }
}
