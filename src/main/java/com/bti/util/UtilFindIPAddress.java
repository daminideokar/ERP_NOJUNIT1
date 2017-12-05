/**
 * BTI - BAAN for Technology And Trade IntL. 
 * Copyright @ 2017 BTI. 
 * 
 * All rights reserved.
 * 
 * THIS PRODUCT CONTAINS CONFIDENTIAL INFORMATION  OF BTI. 
 * USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED WITHOUT THE 
 * PRIOR EXPRESS WRITTEN PERMISSION OF BTI.
 */
package com.bti.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: Find IP Address Utility for BTI 
 * Name of Project: BTI
 * Created on:OCTOBER 26,2017 
 * Modified on: 
 * @author goodtech
 * Version: 
 */
public class UtilFindIPAddress {

	private static final String[] IP_HEADER_CANDIDATES = { "X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP",
			"HTTP_X_FORWARDED_FOR", "HTTP_X_FORWARDED", "HTTP_X_CLUSTER_CLIENT_IP", "HTTP_CLIENT_IP",
			"HTTP_FORWARDED_FOR", "HTTP_FORWARDED", "HTTP_VIA", "REMOTE_ADDR" };
	
	/**
	 * it returns the IP address of requesting user
	 * @param request
	 * @return
	 */
	public static String getUserIp(HttpServletRequest request) {
		for (String header : IP_HEADER_CANDIDATES) {
			String ip = request.getHeader(header);
			if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
				return ip;
			}
		}
		return request.getRemoteAddr();
	}

	/**
	 * checks if ipAddress lies in between startIp and endIp
	 * @param ipAddress
	 * @param startIp
	 * @param endIp
	 * @return
	 * @throws UnknownHostException
	 */
	public static boolean checkIfIpExistInRange(String ipAddress, String startIp, String endIp)
			throws UnknownHostException {
		if (null != startIp && null != endIp) {
			if (startIp.length() > 0 && endIp.length() > 0) {
				long ipLo = convertIpToLong(InetAddress.getByName(startIp));
				long ipHi = convertIpToLong(InetAddress.getByName(endIp));
				long ipToTest = convertIpToLong(InetAddress.getByName(ipAddress));
				if (ipToTest >= ipLo && ipToTest <= ipHi) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * convert ip to long value
	 * @param ip
	 * @return
	 */
	public static long convertIpToLong(InetAddress ip) {
		byte[] octets = ip.getAddress();
		long result = 0;
		for (byte octet : octets) {
			result <<= 8;
			result |= octet & 0xff;
		}
		return result;
	}
}
