package com.viewnext.tarifabatch;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.viewnext.tarifabatch.business.model.Tarifa;

@SpringBootTest
class WriterTest {

	@Autowired
	FlatFileItemWriter<Tarifa> flatFileItemWriter;

	/**
	 * Test del FlatFileItemWriter Escribe un fichero csv y depsues mira que este
	 * creado el fichero
	 */
	@Test
	void itemWriterTest() {
		File fichero = new File("tarifas.csv");

		// Borro el fichero si es que esta creado para probar el test
		fichero.delete();

		List<Tarifa> lTarifas = new ArrayList<>();
		lTarifas.add(new Tarifa(1L, "nombre1", 1));

		flatFileItemWriter.open(new ExecutionContext());

		try {
			flatFileItemWriter.write(new Chunk<Tarifa>(new Tarifa(1l, "Nombre 1", 1000)));
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertThat(fichero).exists();

	}

}
