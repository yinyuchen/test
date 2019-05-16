package com.sdut.product.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 
* @author
* @Description 时间工具
* @version V1.0
*/
public class DateUtils {

	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 根据时间转换为字符串类型
	 * @param date
	 * @return
	 */
	public static String date2String(Date date) {
		if (date != null) {
			return simpleDateFormat.format(date);
		}
		return "";
	}

	/*
	 * 将时间戳转换为时间
	 */
	public static String stampToDate(String s){
		String res;
		long lt = new Long(s+"000");
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
	}
}
