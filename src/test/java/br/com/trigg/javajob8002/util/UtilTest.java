package br.com.trigg.javajob8002.util;

import br.com.trigg.javajob8002.model.Candidato;
import br.com.trigg.javajob8002.model.Entity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.LinkedList;

import static org.springframework.test.util.AssertionErrors.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
@Slf4j
class UtilTest {
  @Value("classpath:candidatos.json")
  private Resource candidatos;

  @Test
  void bubble() {
    try {
      if (candidatos.exists()) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(dateFormat);
        Entity entity = mapper.readValue(candidatos.getFile(), Entity.class);
        assertNotNull("Entity null", entity);
        assertTrue("Entity empty", entity.getCandidatos().size() > 0);
        LinkedList<Candidato> bubble = Util.bubble(entity.getCandidatos());
        assertTrue("Bubble null and empty", bubble.size() == entity.getCandidatos().size());
        System.out.println(Arrays.toString(bubble.toArray()));
      }
    } catch (IOException e) {
      log.info("Erro ao testar bubble sort");
    }
  }
}
