package com.systemsinmotion.petrescue.config;

import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.systemsinmotion.petresque.scheduler.Scheduler;

@Configuration("petFinderJob")
public class PetFinderConfiguration {

	@Autowired
	@Qualifier("jobRepository")
	private JobRepository jobRepository;

	@Bean
	public Scheduler getSchedule() {
		return new Scheduler();
	}

	@Bean
	public SimpleJobLauncher jobLauncher() {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(jobRepository);
		return jobLauncher;
	}
}
