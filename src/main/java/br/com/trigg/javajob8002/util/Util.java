package br.com.trigg.javajob8002.util;

import br.com.trigg.javajob8002.model.Candidato;

import java.util.LinkedList;
import java.util.List;

public class Util {

  public static LinkedList<Candidato> bubble(List<Candidato> list) {
    LinkedList<Candidato> orderedList = new LinkedList<>(list);
    Candidato a, b;
    for (int i = 0; i < orderedList.size(); i++) {
      for (int j = 0; j < orderedList.size() - i - 1; j++) {
        a = orderedList.get(j);
        b = orderedList.get(j + 1);
        if (a.compareTo(b) > 0) {
          orderedList.set(j, b);
          orderedList.set(j + 1, a);
        }
      }
    }

    return orderedList;
  }
}
