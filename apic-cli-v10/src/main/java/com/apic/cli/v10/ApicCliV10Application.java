package com.apic.cli.v10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apic.cli.v10.common.Constants;
import com.apic.cli.v10.program.Program;

@SpringBootApplication(
	scanBasePackages = {"com.apic.cli.v10"}
)
public class ApicCliV10Application implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(ApicCliV10Application.class);

	@Autowired
	private Program program;
	
	public static void main(String[] args) {
		SpringApplication.run(ApicCliV10Application.class, args);
	}

	@Override
	public void run(String... args) {
		LOG.info(Constants.LOG_PATTERN_LINE_SEPERATOR);
		LOG.info("PROGRAM-APIC-CLI: Starting...");
		try {
			program.execute(args);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		LOG.info(Constants.LOG_PATTERN_LINE_SEPERATOR);
		LOG.info("PROGRAM-APIC-CLI: Ended");		
	}
}
