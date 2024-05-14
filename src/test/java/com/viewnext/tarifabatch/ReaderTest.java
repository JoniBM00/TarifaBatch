package com.viewnext.tarifabatch;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.viewnext.tarifabatch.business.model.Tarifa;

@SpringBootTest
class ReaderTest {

	@Autowired
	JdbcCursorItemReader<Tarifa> jdbcCursorItemReader;

	/**
	 * Test del JdbcCursorItemReader Lee un fichero y comprueba que este leyendo el
	 * total de objectos que hay en el fichero
	 * 
	 * @throws Exception
	 */
	@Test
	void JdbcCursorItemReaderTest() throws Exception {

		List<Tarifa> lTarifa = new ArrayList<>();
		jdbcCursorItemReader.open(new ExecutionContext());

		while (true) {

			Tarifa tarifa = jdbcCursorItemReader.read();
			if (tarifa == null) {
				break;
			}
			lTarifa.add(tarifa);
		}
		jdbcCursorItemReader.close();

		assertThat(lTarifa).hasSize(5);

	}

}
