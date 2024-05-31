/**
 * 
 */
package com.apic.cli.v10.util;

import com.apic.cli.v10.bo.Context;

/**
 * 
 */
public interface ApicHelper {
	
	public String getServerName(Context context) throws Exception;
	
	public void doSsoLoginInApiC(Context context) throws Exception;
	
	public void verifyPostLoginInfo(Context context) throws Exception;
	
	public String[] getOrgInfo(Context context) throws Exception;
}
