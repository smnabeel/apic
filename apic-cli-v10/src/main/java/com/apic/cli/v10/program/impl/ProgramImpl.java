/**
 * 
 */
package com.apic.cli.v10.program.impl;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apic.cli.v10.bo.Context;
import com.apic.cli.v10.common.Constants.OperatingSystems;
import com.apic.cli.v10.program.Program;
import com.apic.cli.v10.util.ApicHelper;
import com.apic.cli.v10.util.Utility;

/**
 * 
 */
@Component
public class ProgramImpl implements Program {

	private static Logger LOG = LoggerFactory.getLogger(ProgramImpl.class);
	
	@Autowired
	private Utility utility;
	
	@Autowired
	private ApicHelper apicHelper;
	
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
		Context context = new Context();
		context.setBasePath(args[1] + File.separator);
		context.setApiKey(args[2]);
		context.setApicCloudManager(apicHelper.getServerName(context));
		
		LOG.info("API Connect Cloud Manager URL: " + context.getApicCloudManager());
		
		apicHelper.doSsoLoginInApiC(context);
	}

	@Override
	public void executeForLinux(String... args) throws Exception {
	}
}
