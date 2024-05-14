package com.viewnext.tarifabatch.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Clase para guardar datos de la tabla Tarifas
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarifa {

	private Long id;
	private String nombre;
	private double precio;

}