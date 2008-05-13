package edu.chc.helpdesk.requests;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/** 
 * 
 * @author mspross
 *
 * This class can be used to generate and
 * execute simple dynamic EQL queries.
 */

public class Criteria {
	
	final private String TBL_ALIAS = "o";
	
	private Class clazz;
	private List<String> conditions;
	private String select;
	
	private EntityManager em;

	public Criteria (Class clazz, EntityManager em) {

		this.em = em;
		this.clazz = clazz;
		
		select = "SELECT " + TBL_ALIAS + " FROM " + getClassNameAndAlias();
		conditions = new ArrayList<String>();
	}
	
	public void add(String condition) {
		condition = TBL_ALIAS+"."+condition.trim();
		String tmpCond = (conditions.size()==0) ? (condition) : (" AND " + condition);
		conditions.add(tmpCond);
	}
	
	public String getQueryString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(select);
		
		if(conditions.size()>0) {
			sb.append(" WHERE ");
			for(String cond : conditions) {
				sb.append(cond);
			}
		}
		
		return sb.toString();
	}
	
	public List list() {
		// execute the query and return the results
		Query q = em.createQuery(getQueryString());
		return q.getResultList();
	}
	
	private String getClassNameAndAlias() {
		 return clazz.getSimpleName()+ " " + TBL_ALIAS;
	}
	
}

