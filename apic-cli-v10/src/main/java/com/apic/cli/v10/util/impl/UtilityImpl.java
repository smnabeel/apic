/**
 * 
 */
package com.apic.cli.v10.util.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.apic.cli.v10.common.Constants;
import com.apic.cli.v10.common.Constants.OperatingSystems;
import com.apic.cli.v10.util.Utility;

/**
 * 
 */
@Component
public class UtilityImpl implements Utility {

	private static Logger LOG = LoggerFactory.getLogger(UtilityImpl.class);
	
	@Override
	public OperatingSystems getOperatingSystem() throws Exception {
		String os = System.getProperty(Constants.PROPERTY_SYSTEM_OS_NAME);
		if (os.toLowerCase().contains(Constants.OS_NAME_WIN)) {
			return OperatingSystems.WINDOWS;
		} else if (os.toLowerCase().contains(Constants.OS_NAME_LIN)) {
			return OperatingSystems.LINUX;
		} else if (os.toLowerCase().contains(Constants.OS_NAME_MAC)) {
			return OperatingSystems.MAC;
		} else {
			throw new Exception("Operating System [" + os + "] not supported!");
		}
	}

	@Override
	public Process executeCommand(List<String>[] commands) throws Exception {
		Process process = null;
		for (List<String> command : commands) {
			String cmd = command.stream().map(Object::toString).collect(Collectors.joining(" "));
			LOG.info("Executing command... " + cmd);
			process = new ProcessBuilder(command).start();
			process.getOutputStream().close();
		}
		return process;
	}
	
	@Override
	public String[] extractCommandOutput(Process process) throws Exception {
		String[] output = null;
		String line;
		LOG.info("Command Standard Output:");
		LOG.info("------------------------");
		BufferedReader stdout = new BufferedReader(new InputStreamReader(process.getInputStream()));
		while ((line = stdout.readLine()) != null) {
			LOG.info(line);
			output = new String[] {line};
		}
		stdout.close();	
		LOG.info(Constants.LOG_PATTERN_LINE_EMPTY);

		BufferedReader stderr = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		Boolean onlyOnce = true;
		while ((line = stderr.readLine()) != null) {
			if (onlyOnce) {
				LOG.info(Constants.LOG_PATTERN_LINE_EMPTY);
				LOG.info("Command Standard Error:");
				LOG.info("-----------------------");
				onlyOnce = false;
			}
			LOG.info(line);
		}
		stderr.close();
		return output;
	}
}
