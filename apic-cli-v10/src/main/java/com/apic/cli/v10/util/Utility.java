/**
 * 
 */
package com.apic.cli.v10.util;

import java.util.List;

import com.apic.cli.v10.common.Constants;

/**
 * 
 */
public interface Utility {

	public Constants.OperatingSystems getOperatingSystem() throws Exception;
	
	public Process executeCommand(List<String>[] commands) throws Exception;
	
	public String[] extractCommandOutput(Process process) throws Exception;
}
