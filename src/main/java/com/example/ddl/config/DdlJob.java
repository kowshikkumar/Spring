package com.example.ddl.config;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;	
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.batch.infrastructure.repeat.RepeatStatus;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.core.job.parameters.JobParametersValidator;
import org.springframework.batch.core.job.parameters.RunIdIncrementer;
import org.springframework.batch.core.job.parameters.DefaultJobParametersValidator;
import  com.example.ddl.config.Incrementor;

@Configuration
public class DdlJob {


	@Bean 
	public JobParametersValidator Validator(){
		DefaultJobParametersValidator validator = new DefaultJobParametersValidator();
		validator.setRequiredKeys(new String[] {"fileName"});
		validator.setOptionalKeys(new String[] {"name"});

		return validator;



	}
    @Bean
	public Job auptcjob(JobRepository jobRepository,Step step1){
		return new JobBuilder("auptcjob",jobRepository)
		.start(step1)
		
		
		
		.build();
	}

	@Bean 
	public Step step1(JobRepository jobRepository){
		return new StepBuilder("step1",jobRepository)
		.tasklet(hellotasklet())
		.build();
	}
	@Bean
	public Tasklet hellotasklet(){
		return (contribution,chunkContext)->{
			String name = (String) chunkContext.getStepContext().getJobParameters().get("name");
			System.out.println("Hello " + name);
			return RepeatStatus.FINISHED;
		};
	}
}
