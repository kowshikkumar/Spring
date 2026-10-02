package com.example.ddl.config;

import org.springframework.batch.core.job.parameters.JobParametersValidator;
import org.springframework.batch.core.job.parameters.InvalidJobParametersException;
import org.springframework.batch.core.job.parameters.JobParameters;


public class InputValidator implements JobParametersValidator {

    @Override
    public void validate(JobParameters parameters) throws InvalidJobParametersException {
        if (parameters.getString("fileName") == null) {
            throw new InvalidJobParametersException("The 'fileName' parameter is required.");
        }
    }

  

}
