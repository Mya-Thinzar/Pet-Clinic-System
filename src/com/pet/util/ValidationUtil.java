package com.pet.util;

public class ValidationUtil {
	public static String checkLoginUser(String ...values){
		String error=new String();
			String strId=values[0];
			String strPassword=values[1];
			if(strId==null || strId.isEmpty())
				error+="Id is required<br>";
			if(strPassword==null || strPassword.isEmpty())
				error+="Password is required<br>";
		return error;
	}
////	public static boolean checkLoginMember(String ...values){
////			String error=new String();
////			String strEmail=values[0];
////			String strName=values[1];
////			String strPassword=values[2];
////			if(strEmail.equals()){
////				
////			}
//		else return false;
//	}

}

