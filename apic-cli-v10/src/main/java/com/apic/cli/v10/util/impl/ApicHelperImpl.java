/**
 * 
 */
package com.apic.cli.v10.util.impl;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apic.cli.v10.bo.Context;
import com.apic.cli.v10.common.Constants;
import com.apic.cli.v10.util.ApicHelper;
import com.apic.cli.v10.util.Utility;

/**
 * 
 */
@Component
public class ApicHelperImpl implements ApicHelper {

	private static Logger LOG = LoggerFactory.getLogger(ApicHelperImpl.class);

	@Autowired
	private Utility utility;
	
	@Override
	public String getServerName(Context context) throws Exception {
		LOG.info(Constants.LOG_PATTERN_LINE_EMPTY);
		LOG.info("APIC CLI Path: " + context.getBasePath());
		LOG.info(Constants.LOG_PATTERN_LINE_EMPTY);

		utility.extractCommandOutput(utility.executeCommand(new List[] {Arrays.asList(context.getCommandPrefix(), "--accept-license")}));
		utility.extractCommandOutput(utility.executeCommand(new List[] {Arrays.asList(context.getCommandPrefix(), "client-creds:clear")}));
		String server = utility.extractCommandOutput(utility.executeCommand(new List[] {Arrays.asList(context.getCommandPrefix(), "client-creds:set", context.getBasePath() + "credentials.json")}))[0];
		server = "p" + server.split(":")[0];
		return server;
	}

	@Override
	public void doSsoLoginInApiC(Context context) throws Exception {
		utility.extractCommandOutput(utility.executeCommand(new List[] {Arrays.asList(context.getCommandPrefix(), "login", "-s", context.getApicCloudManager(), "--sso", "--context", "provider", "--apiKey", context.getApiKey())}));		
	}

}
