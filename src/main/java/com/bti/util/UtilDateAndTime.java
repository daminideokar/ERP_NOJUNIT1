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
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Description: date time utility
 * Name of Project: BTI
 * Created on: OCTOBER 26,2017
 * Modified on: 
 * @author 	goodtech
 * Version: 
 */
public class UtilDateAndTime {

	private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	/**
	 * Method will return date in UTC format
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public Date localToUTC() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date gmt = new Date(sdf.format(date));
		return gmt;
	}
	
	/**
	 * Method will convert UTC date to local date
	 * @param date
	 * @return
	 */
	public Date utcToLocalDate(Date date) {
		String timeZone = Calendar.getInstance().getTimeZone().getID();
		Date local = new Date(date.getTime() + TimeZone.getTimeZone(timeZone).getOffset(date.getTime()));
		return local;
	}

	/**
	 * @param dateInString
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDate(String dateInString) throws ParseException {
		Date date = new Date();

		date = formatter.parse(dateInString);

		return date;
	}

	/**
	 * @param date
	 * @return
	 */
	public static Date ddmmyyyyStringToDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date date1 = formatter.parse(date);
			return date1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * @param date
	 * @return
	 */
	public static String dateToStringddmmyyyy(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			String formatDate = formatter.format(date);
			return formatDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param date
	 * @return
	 */
	public static Date ddmmyyyyStringTimeToDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("hh:mm aa");
		try {
			Date date1 = formatter.parse(date);
			return date1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param date
	 * @return
	 */
	public static String dateToStringhhmmaa(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("hh:mm aa");
		try {
			String formatDate = formatter.format(date);
			return formatDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param time
	 * @return
	 */
	public static Time getTimeFromStringFrom12Formats(String time) {
		SimpleDateFormat formatter = new SimpleDateFormat("hh:mm aa");
		try {
			Date date1 = formatter.parse(time);
			return new java.sql.Time(date1.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Time getTimeFromStringFrom24Formats(String time) {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		try {
			Date date1 = formatter.parse(time);
			return new java.sql.Time(date1.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static String convertTimeToString12Formats(Date time) {
		SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
		SimpleDateFormat outPutFormat = new SimpleDateFormat("hh:mm aa");
		try {
			Date date1 = formatter.parse(""+time);
			return outPutFormat.format(date1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String convertTimeToString24Formats(Date time) {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat outPutFormat = new SimpleDateFormat("HH:mm");
		try {
			Date date1 = formatter.parse(""+time);
			return outPutFormat.format(date1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param date
	 * @return
	 */
	public static String convertDateDDMMYYYYFormatToDBFormat(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1 = formatter.parse(date);
			return dbFormat.format(date1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}