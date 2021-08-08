package br.com.trigg.javajob8002.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Candidato implements Comparable<Candidato> {

  @Id
  @JsonProperty("_id")
  private String id;

  private String nome;

  private String vaga;

  @Temporal(TemporalType.DATE)
  @JsonProperty("data_nascimento")
  private Date dataNascimento;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Candidato candidato = (Candidato) o;

    return Objects.equals(id, candidato.id);
  }

  @Override
  public int hashCode() {
    return 709293128;
  }

  @Override
  public int compareTo(Candidato o) {
    return Integer.compare(this.dataNascimento.compareTo(o.getDataNascimento()), 0);
  }
}
