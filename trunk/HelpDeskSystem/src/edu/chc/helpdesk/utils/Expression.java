package edu.chc.helpdesk.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author mspross
 *
 * A simple utility class for constructing expressions which can be used
 * to generate criteria clauses in SQL queries.
 */
public class Expression {
	
	public static String equalTo(String field, Object value) {
		return makeRelation(field,"=",value);
	}
	
	public static String notEqualTo(String field, Object value) {
		return makeRelation(field,"<>",value);
	}
	
	public static String like(String field, Object value) {
		String s = value.toString();
		s=s.replace("*", "%");
		return makeRelation(field,"LIKE",s);
	}
	
	public static String greaterThan(String field, Object value) {
		return makeRelation(field,">",value);
	}
	
	public static String lessThan(String field, Object value) {
		return makeRelation(field,"<",value);
	}
	
	public static String greaterThanOrEqual(String field, Object value) {
		return makeRelation(field,">=",value);
	}
	
	public static String lessThanOrEqual(String field, Object value) {
		return makeRelation(field,"<=",value);
	}
	
	protected static String makeRelation(String field, String operator, Object value) {
		
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
	
	/**
	 * @param value the value to delimit
	 * @return the value passed in, properly delimited for use in a SQL query
	 * */
	protected static String getDelimiter(Object value) {
		
		//Decide how to delimit 'value' based on its type.
		//Strings and dates need to be delimited with single-quotes in SQL.
		//Other fields don't need a delimiter
		
		if(value instanceof String || value instanceof Date)
			return "'";
		else
			return "";
	}
	
	/**
	 * 
	 * @param value the value to format
	 * @return a formatted version of 'value'
	 * 
	 * This method formats a value so that it will be
	 * valid in a SQL query. This function makes sure
	 * special characters are escaped properly in strings
	 * and ensures that all values of the same object type
	 * are formatted in a similar manner for consistency
	 * in generated expressions.
	 */
	protected static String format(Object value) {
		
		if(value instanceof String) {
			// escape single quotes in strings
			String s = value.toString();
			return s.replace("'", "''");
		}
		else if(value instanceof Date) {
			SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy hh:mm");
			return formatter.format(value);
		}
		else
			return value.toString();
	}
}
