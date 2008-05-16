package edu.chc.helpdesk.requests;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author mgspross
 * 
 *  @deprecated Switching to direct JDBC calls via utils.DropDownListService
 *
 */

@Deprecated
@Entity
@Table(schema="HelpDeskApp",name="DROPDOWNVALUE")
@DiscriminatorValue("ISSUE")
public class IssueDropDownValue extends DropDownValue {
	/* This class is a placeholder.
	 * It is declared so that the rest of the
	 * code can refer to Issue drop-down values
	 * in an object-oriented manner and use
	 * ploymorphic queries.
	 * Like all drop-downs, it only uses
	 * the inherited ID and displayValue columns
	 * and has no "extra" functionality.
	 */
}
