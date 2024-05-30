/**
 * 
 */
package com.apic.cli.v10.util.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
	public void extractOutput(Process process) throws Exception {
		String line;
		LOG.info("Command Standard Output:");
		LOG.info("------------------------");
		BufferedReader stdout = new BufferedReader(new InputStreamReader(process.getInputStream()));
		while ((line = stdout.readLine()) != null) {
			LOG.info(line);
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
	}
}
