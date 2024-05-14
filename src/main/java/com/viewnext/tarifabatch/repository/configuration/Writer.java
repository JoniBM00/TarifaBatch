package com.viewnext.tarifabatch.repository.configuration;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.PathResource;
import org.springframework.stereotype.Component;

import com.viewnext.tarifabatch.business.model.Tarifa;

@Component
public class Writer {

	/**
	 * Instancio un {@link BeanWrapperFieldExtractor} para transformar a csv las
	 * tarifas Le pongo los atributos y verifico que esten puestos Instancio un
	 * {@link DelimitedLineAggregator} para añadirle los ; para poder crear el csv
	 * 
	 * @return El FlatFileItemWriter de Tarifa
	 */
	@Bean
	FlatFileItemWriter<Tarifa> itemWriter() {
		BeanWrapperFieldExtractor<Tarifa> fieldExtractor = new BeanWrapperFieldExtractor<>();
		fieldExtractor.setNames(new String[] { "id", "nombre", "precio" });
		fieldExtractor.afterPropertiesSet();

		DelimitedLineAggregator<Tarifa> lineAggregator = new DelimitedLineAggregator<>();
		lineAggregator.setDelimiter(";");
		lineAggregator.setFieldExtractor(fieldExtractor);

		return new FlatFileItemWriterBuilder<Tarifa>().name("tarifas.csv").resource(new PathResource("tarifas.csv"))
				.lineAggregator(lineAggregator).build();
	}

}
