package com.example.ddl.config;

import java.util.Date;

import org.springframework.batch.core.job.parameters.JobParameters;
import org.springframework.batch.core.job.parameters.JobParametersBuilder;
import org.springframework.batch.core.job.parameters.JobParametersIncrementer;

public class Incrementor implements JobParametersIncrementer{

    @Override
    public JobParameters getNext(JobParameters parameters) {
        return new JobParametersBuilder(parameters)
            .addDate("currentDate", new Date())
            .toJobParameters();

}
}


