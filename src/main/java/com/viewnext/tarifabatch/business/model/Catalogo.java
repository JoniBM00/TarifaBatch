package com.viewnext.tarifabatch.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catalogo {

	private Long id;
	private String lugar;
	private int stock;
	private int stockReal;
	private int stockVirtual;
	private Long codigo;
	private String nombre;
	private String tipo;
	private double precio;

}
