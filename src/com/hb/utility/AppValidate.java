package com.hb.utility;

import java.util.Collection;

public class AppValidate {
	public static boolean isEmpty(String s)
	{
//        return ((s == null) || (s.trim().length() == 0));
		return ((s == null) || (s.trim().isEmpty()));
	}

	public static boolean isEmpty(CharSequence cs)
	{
//        return ((s == null) || (s.trim().length() == 0));
		return ((cs == null) || (cs.toString().trim().isEmpty()));
	}

	public static boolean isEmpty(Collection c)
	{
		return ((c == null) || (c.isEmpty()));
	}

	public static boolean isEmpty(Object[] array)
	{
		return ((array == null) || (array.length == 0));
	}

	public static boolean isNotEmpty(String s)
	{
		return ((s != null) && (s.trim().length() > 0));
	}

	public static boolean isNotEmpty(Object[] a)
	{
		return ((a != null) && (!(a.length == 0)));
	}

	public static boolean isNotEmpty(Collection c)
	{
		return ((c != null) && (!c.isEmpty()));
	}


}
