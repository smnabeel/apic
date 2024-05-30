/**
 * 
 */
package com.apic.cli.v10.util;

import com.apic.cli.v10.common.Constants;

/**
 * 
 */
public interface Utility {

	public Constants.OperatingSystems getOperatingSystem() throws Exception;
	
	public void extractOutput(Process process) throws Exception;
}
