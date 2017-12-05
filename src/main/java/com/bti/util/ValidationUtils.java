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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.springframework.validation.Errors;

/**
 * Description: Find IP Address Utility for BTI 
 * Name of Project: BTI
 * Created on:OCTOBER 26,2017 
 * Modified on: 
 * @author goodtech
 * Version: 
 */
public class ValidationUtils {

	public static Boolean isStringNull(String toCheck) {
		if (toCheck != null && toCheck.trim().length() > 0)
			return false;
		else
			return true;
	}

	public static Boolean isNumberNull(Number n) {
		if (n != null)
			return false;
		else
			return true;
	}

	public static Boolean isNumberNullAndZero(Long id) {
		if (id != null && id > 0)
			return false;
		else
			return true;
	}

	public static Boolean isDateNull(Date date) {

		if (date != null)
			return false;
		else
			return true;
	}

	public static boolean isListNull(Collection<?> list) {
		if (list == null || list.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static Boolean isDateafterCurrent(Date date, String format) {

		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date Current = null;
		boolean result = false;
		try {
			Current = dateFormat.parse(dateFormat.format(new Date()));
			if (Current.after(date))
				result = true;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	/*public static void addError(Errors errors, String paramName, String messageCode) {
		errors.rejectValue(paramName, paramName, BundleUtils.message(messageCode));
	}*/
	
	public static boolean isArrayEmpty(Object[] array){
		boolean result=false;
		if(array==null||array.length<=0){
			result=true;
		}
		return result;
	}

}
