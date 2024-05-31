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
	private String username;
	private String orgId;
	private String orgInstance;
	
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOrgInstance() {
		return orgInstance;
	}
	public void setOrgInstance(String orgInstance) {
		this.orgInstance = orgInstance;
	}
}
