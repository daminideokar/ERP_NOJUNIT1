/**
 * BTI - BAAN for Technology And Trade IntL. 
 * Copyright © 2017 BTI. 
 * 
 * All rights reserved.
 * 
 * THIS PRODUCT CONTAINS CONFIDENTIAL INFORMATION  OF BTI. 
 * USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED WITHOUT THE 
 * PRIOR EXPRESS WRITTEN PERMISSION OF BTI.
 */
package com.bti.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Name of Project: BTI 
 * Description:Test class 
 * Created on:OCTOBER 26,2017
 * Modified on:
 * 
 * @author goodtech
 */
public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat outPutFormat = new SimpleDateFormat("HH:mm");
		try {
			Date date1 = formatter.parse("00:43:00");
			System.out.println(outPutFormat.format(date1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*String translatedText = Translate.DEFAULT.execute("Text", 
				Language.ENGLISH, Language.ARABIC);*/
		
	}
}
