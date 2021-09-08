package com.pet.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	private static String TIME="hh-mm-ss";
	private static SimpleDateFormat SDFF=new SimpleDateFormat(TIME);
	public static String convertS2T(String str){
		try{
			Date d=SDFF.parse(str);
			
			return SDFF.format(d);
		}catch(ParseException e){e.printStackTrace();}
		return null;
	}
	
	private static String PATTERN="dd-MM-yyyy";
	private static SimpleDateFormat SDF=new SimpleDateFormat(PATTERN);
	public static Date convertS2D(String str){
		try{
			Date d=SDF.parse(str);
			return d;
		}catch(ParseException e){}
		return null;
	}
	public static String convertD2S(Date d){
		return SDF.format(d);
	}

	private static String PATTERN1="yyyy-MM-dd";
	private static SimpleDateFormat SDF1=new SimpleDateFormat(PATTERN1);
	public static Date convertStoD(String str){
		try{
			Date d=SDF1.parse(str);
			return d;
		}catch(ParseException e){}
		return null;
	}
	
	//dateutil
	public static String dateFormat(String strDate){
	DateFormat iFormat=new SimpleDateFormat("yyyy-MM-dd");
	DateFormat oFormat=new SimpleDateFormat("dd-MM-yyyy");
	try {
		Date date=iFormat.parse(strDate);
		String oString=oFormat.format(date);
		System.out.println("FORMAT DATE : "+oString);
		return oString;
	} catch (ParseException e) {}
	return null;
	}
}
