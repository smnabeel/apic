/**
 * 
 */
package com.apic.cli.v10.common;

/**
 * 
 */
public class Constants {
	
	public static final String PROPERTY_SYSTEM_OS_NAME = "os.name"; 	
	public static final String PROPERTY_WIN_CMD_PROGRAM = "C:\\Windows\\System32\\WindowsPowerShell\\v1.0\\powershell.exe ";
	public static final String PROPERTY_PROGRAM_NAME_APIC = "apic"; 
	
	public static final String LOG_PATTERN_LINE_SEPERATOR = "/********************/////********************/";
	public static final String LOG_PATTERN_LINE_EMPTY = "";
	
	public static final String OS_NAME_WIN = "win"; 
	public static final String OS_NAME_LIN = "linux"; 
	public static final String OS_NAME_MAC = "mac"; 

	public enum OperatingSystems {
		WINDOWS,
		LINUX,
		MAC;
	}
}
