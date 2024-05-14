package com.viewnext.tarifabatch.business;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.viewnext.tarifabatch.business.model.Tarifa;

/*
 * Clase para hacer el reader de la bbdd
 */
@Component
public class Reader {

	private Reader() {
	}

	/**
	 * Hace el reader para la base de datos mysql
	 * 
	 * @param dataSource
	 * @return El JdbcCursorItemReader del Objeto Tarifa
	 */
	@Bean
	JdbcCursorItemReader<Tarifa> readerTarifa(DataSource dataSource) {
		JdbcCursorItemReader<Tarifa> reader = new JdbcCursorItemReader<>();

		reader.setDataSource(dataSource);
		reader.setSql("SELECT id, nombre, precio FROM tarifas");

		reader.setRowMapper(new RowMapper<Tarifa>() {
			@Override
			public Tarifa mapRow(ResultSet rs, int rowNum) throws SQLException {
				Tarifa tarifa = new Tarifa();
				tarifa.setId(rs.getLong("id"));
				tarifa.setNombre(rs.getString("nombre"));
				tarifa.setPrecio(rs.getDouble("precio"));
				return tarifa;
			}
		});
		return reader;
	}

}
