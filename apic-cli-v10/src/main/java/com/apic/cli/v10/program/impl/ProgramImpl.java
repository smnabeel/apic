/**
 * 
 */
package com.apic.cli.v10.program.impl;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apic.cli.v10.common.Constants;
import com.apic.cli.v10.common.Constants.OperatingSystems;
import com.apic.cli.v10.program.Program;
import com.apic.cli.v10.util.Utility;

/**
 * 
 */
@Component
public class ProgramImpl implements Program {

	private static Logger LOG = LoggerFactory.getLogger(ProgramImpl.class);
	
	@Autowired
	private Utility utility;
		
	@Override
	public void execute(String... args) throws Exception {		
		LOG.info("Determining OS...");
		OperatingSystems os = utility.getOperatingSystem();
		LOG.info(os.name() + " ... operating system detected and is compatible with this program");
		if (OperatingSystems.WINDOWS.equals(os)) {
			executeForWindows(args);
		} else if (OperatingSystems.LINUX.equals(os)) {
			executeForLinux(args);
		}
	}

	@Override
	public void executeForWindows(String... args) throws Exception {
		String basePath = args[1] + File.separator;
		LOG.info(Constants.LOG_PATTERN_LINE_EMPTY);
		LOG.info("APIC CLI Path: " + basePath);
		LOG.info(Constants.LOG_PATTERN_LINE_EMPTY);
		
		String baseCommand = basePath + Constants.PROPERTY_PROGRAM_NAME_APIC;
		List<String>[] commands = new List[]{
			Arrays.asList(baseCommand, "--accept-license")
			,Arrays.asList(baseCommand, "client-creds:clear")
			,Arrays.asList(baseCommand, "client-creds:set", basePath + "credentials.json")
		};
		
		for (List<String> command : commands) {
			LOG.info("Executing command... " + command.stream().map(Object::toString).collect(Collectors.joining(" ")));
			Process process = new ProcessBuilder(command).start();
			process.getOutputStream().close();
			utility.extractOutput(process);
		}
	}

	@Override
	public void executeForLinux(String... args) throws Exception {
	}
}
