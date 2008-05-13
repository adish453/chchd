package edu.chc.helpdesk.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author mspross
 *
 * A simple utility class for building expressions that can be used
 * to build SQL WHERE clauses
 */
public class Expression {
	
	public static String equalTo(String field, Object value) {
		return relation(field,"=",value);
	}
	
	public static String notEqualTo(String field, Object value) {
		return relation(field,"<>",value);
	}
	
	public static String like(String field, Object value) {
		String s = value.toString();
		s=s.replace("*", "%");
		return relation(field,"LIKE",s);
	}
	
	public static String greaterThan(String field, Object value) {
		return relation(field,">",value);
	}
	
	public static String lessThan(String field, Object value) {
		return relation(field,"<",value);
	}
	
	public static String greaterThanOrEqual(String field, Object value) {
		return relation(field,">=",value);
	}
	
	public static String lessThanOrEqual(String field, Object value) {
		return relation(field,"<=",value);
	}
	
	protected static String relation(String field, String operator, Object value) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(field);
		sb.append(" ");
		sb.append(operator);
		sb.append(" ");
		
		sb.append(getDelimiter(value));
		sb.append(format(value));
		sb.append(getDelimiter(value));
		
		return sb.toString();
		
	}
	
	protected static String getDelimiter(Object value) {
		if(value instanceof String || value instanceof Date)
			return "'";
		else
			return "";
	}
	
	protected static String format(Object value) {
		
		if(value instanceof Date) {
			SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy hh:mm");
			return formatter.format(value);
		}
		else
			return value.toString();
	}
}
