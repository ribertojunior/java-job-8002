package br.com.trigg.javajob8002;

import br.com.trigg.javajob8002.model.Candidato;
import br.com.trigg.javajob8002.model.Entity;
import br.com.trigg.javajob8002.repository.CandidatoRepository;
import br.com.trigg.javajob8002.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
@Slf4j
public class JavaJob8002Application {
	@Value("classpath:candidatos.json")
	private Resource candidatos;

	public static void main(String[] args) {
		SpringApplication.run(JavaJob8002Application.class, args);
	}

	@Bean
	/*
	  A ordenação foi feita como pedido, mas não há necessidade de tal,
	  já que estamos usando um banco de dados e podemos ordenar utilizando o método do repositório (findByOrderByDataNascimentoAsc).
	  Por esse motivo mantive a ordenação comentada.
	 */
	public CommandLineRunner run(CandidatoRepository repository) {
    return args -> {
      if (candidatos.exists()) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(dateFormat);
        Entity entity = mapper.readValue(candidatos.getFile(), Entity.class);
        // LinkedList<Candidato> bubble = Util.bubble(entity.getCandidatos());
        repository.saveAll(entity.getCandidatos());
      }
    };
	}

}
