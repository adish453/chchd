package edu.chc.helpdesk.requests;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @author mspross
 *
 *	Base class for drop-down lists
 *  stored in the DROPDOWNVALUE table
 *  in the DB. The data for
 *  all dropdown lists in the program
 *  is stored in the DROPDOWNVALUE table,
 *  but to make it more OO, each type
 *  of dropdown list (Location, Issue, Status)
 *  has its own entity that derives from
 *  this class, even though they all use
 *  the same table.
 */

@Entity
@Table(schema="HelpDeskDB")
@Inheritance(strategy=SINGLE_TABLE)
@DiscriminatorColumn(name="LISTNAME",discriminatorType=STRING,length=40)
@NamedQuery(name="getDropDownValuesForList", query="SELECT v FROM DropDownValue v WHERE v.listName=:listName")
public abstract class DropDownValue {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	private String listName;
	private String displayValue;
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @param id the iD to set
	 */
	public void setID(int id) {
		ID = id;
	}
	/**
	 * @return the list name
	 */
	public String getListName() {
		return listName;
	}
	/**
	 * @param list the list name to set
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}
	/**
	 * @return the displayValue
	 */
	public String getDisplayValue() {
		return displayValue;
	}
	/**
	 * @param displayValue the displayValue to set
	 */
	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}
}
