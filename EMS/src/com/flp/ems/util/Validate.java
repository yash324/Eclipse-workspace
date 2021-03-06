package com.flp.ems.util;
import java.util.regex.Pattern;

public class Validate {
	public static boolean checkName(String name)
	{
		if(Pattern.matches("^[a-zA-Z' ]+$", name))
			return true;
		return false;
	}
	public static boolean checkEmail(String email)
	{
		if(Pattern.matches(".+@.+", email))
			return true;
		return false;
	}
	public static boolean checkPhone(String phone)
	{
		if(Pattern.matches("[1-9][0-9]{9}", phone))
			return true;
		return false;
	}
	public static boolean checkDate(String date)
	{
		if(Pattern.matches("[0-9]{2}/[0-9]{2}/[0-9]{2}", date))
			return true;
		return false;
	}
}
