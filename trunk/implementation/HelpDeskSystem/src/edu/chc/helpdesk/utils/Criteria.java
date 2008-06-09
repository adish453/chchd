package edu.chc.helpdesk.utils;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/** 
 * This class can be used to dynamically construct and execute simple EQL queries at run-time.
 * 
 * The API is loosely-based on Hibernate's Criteria API.
 * <p>
 * It is recommended that developers use the <code>edu.chc.helpdesk.utils.Expression</code>
 * class to construct criteria filters that can then be passed to the <code>add</code> method of this class.
 * The <code>Expression</code> class can construct common filter strings such as "A=B" or "A>B", and
 * will automatically delimit the right-hand side of the expression according to its data type.
 *
 * @author Mike Spross
 * @see edu.chc.helpdesk.utils.Expression
 * 
 */

public class Criteria {
	
	final private String TBL_ALIAS = "obj";
	
	private Class clazz;
	private List<String> conditions;
	private String select;
	
	private EntityManager em;
	
	/**
	 * Constructs a new <code>Criteria</code> object that can query for objects of type <code>clazz</code>
	 * using the persistence context provided by the supplied <code>EntityManager</code>
	 *
	 * @param clazz the class of objects this <code>Criteria</code> instance will query for
	 * @param em the <code>EntityManager</code> that this instance will use to perform database queries
	 */

	public Criteria (Class clazz, EntityManager em) {

		if(clazz == null)
			throw new NullPointerException("clazz parameter cannot be null.");
		if(em == null)
			throw new NullPointerException("em parameter cannot be null.");
		
		this.clazz = clazz;
		this.em = em;
		
		select = "SELECT " + TBL_ALIAS + " FROM " + getClassNameAndAlias();
		conditions = new ArrayList<String>();
	}
	
	/**
	 * Adds a new condition to this <code>Criteria</code> instance that will
	 * be used along with any previously added conditions 
	 * to filter what is returned by the <code>list<code> method.
	 * @param condition the condition to add
	 */
	
	public void add(String condition) {
		condition = TBL_ALIAS+"."+condition.trim();
		String tmpCond = (conditions.size()==0) ? (condition) : (" AND " + condition);
		conditions.add(tmpCond);
	}
	
	/**
	 * Returns the EQL query that will be executed if <code>list</code> is called.
	 * @return the query string that <code>list</code> will execute
	 */
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
	
	/**
	 * Returns a <code>List</code> of objects matching all the conditions added
	 * via the <code>add</code> method. The query searches for objects of the <code>Class</code>
	 * that was passed to the constructor when this <code>Criteria</code> instance
	 * was created. The execution of the query is delegated to the <code>EntityManager</code>
	 * associated with this <code>Criteria</code> instance.
	 * 
	 * @return a set of objects matching the conditions of this <code>Criteria</code> instance
	 */
	public List list() {
		// execute the query and return the results
		Query q = em.createQuery(getQueryString());
		return q.getResultList();
	}
	
	private String getClassNameAndAlias() {
		 return clazz.getSimpleName()+ " " + TBL_ALIAS;
	}
	
}

