package com.wangjie.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class shijianGJ {
	public static int getAgeByBirthday(Date birthday) {
		int age = 0;
		try {
			Calendar now = Calendar.getInstance();
			now.setTime(new Date());//当前时间
			
			Calendar birth = Calendar.getInstance();
			birth.setTime(birthday);
			
			if(birth.after(now)) {
				//如果传入的时间在当前时间的后面则返回0
				age=0;
			}else {
				age = now.get(Calendar.YEAR)-birth.get(Calendar.YEAR);
				if(now.get(Calendar.DAY_OF_YEAR)>birth.get(Calendar.DAY_OF_YEAR)) {
					age +=1;
				}
			}
			return age;
		} catch (Exception e) {
			return 0;
		}
		
	}
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date birthday = format.parse("1997-06-12 15:26:20");
		int age = getAgeByBirthday(birthday);
		System.out.println(age);
	}
}
