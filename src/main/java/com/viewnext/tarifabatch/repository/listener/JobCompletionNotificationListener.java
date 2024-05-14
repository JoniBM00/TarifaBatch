package com.viewnext.tarifabatch.repository.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

	private final JdbcTemplate jdbcTemplate;

	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Cuando acaba el {@link Job} muestra un mensaje sobre si lo ha completado o no
	 */
	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("Fichero creado");
		} else {
			log.info("El fichero no se pudo crear");
		}
	}

	@Override
	public void beforeJob(JobExecution jobExecution) {
		log.info(jobExecution.getStatus().toString());
	}

}
