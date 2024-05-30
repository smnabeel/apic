/**
 * 
 */
package com.apic.cli.v10.bo;

import com.apic.cli.v10.common.Constants;

/**
 * 
 */
public class Context {

	private String basePath;
	private String commandPrefix;
	private String apicCloudManager;
	private String apiKey;
	
	public String getBasePath() {
		return basePath;
	}
	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	public String getCommandPrefix() {
		commandPrefix = basePath + Constants.PROPERTY_PROGRAM_NAME_APIC;
		return commandPrefix;
	}
	public String getApicCloudManager() {
		return apicCloudManager;
	}
	public void setApicCloudManager(String apicCloudManager) {
		this.apicCloudManager = apicCloudManager;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
}
