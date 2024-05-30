/**
 * 
 */
package com.apic.cli.v10.program;

/**
 * 
 */
public interface Program {

	public void execute(String... args) throws Exception;
	
	public void executeForWindows(String... args) throws Exception;

	public void executeForLinux(String... args) throws Exception;
}
