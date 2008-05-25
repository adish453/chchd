<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%><%@taglib
	uri="http://java.sun.com/jsf/core" prefix="f"%><%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Browse Request Page</title>
<link rel="stylesheet" type="text/css" href="main.css">
<style type="text/css">
.evenRow {
	background-color: white;
}

.oddRow {
	background-color: #e0e0e0;
}
</style>
<script type="text/javascript">

function allowReset()  
{
		 return window.confirm("Do you really want to clear the data?");
}



</script>

</head>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<body>
<f:view>
	<h:form id="form1">
		<div style="background-color: white">
		<div style="background-color: maroon; font-color: white; padding: 5px">
		<h:outputText value="Chestnut Hill College"
			style="font-family:Arial;font-size:12pt; color:white"></h:outputText>
		<br />
		<h:outputText value="HelpDesk"
			style="font-family:Arial;font-size:22pt; font-weight:bold; color:white"></h:outputText>
		</div>
		<br />
		<div style="margin: 10px"><h:outputText
			value="Search Help Requests" style="font-size:18pt"></h:outputText> <br />
		<h:message style="border:1px solid #00000; background-color: #ffff80"
			for="comments" /> <br />
		<h:outputText style="font-size:12pt;" value="What do I do?"></h:outputText>
		<br />
		<br />
		<h:outputText styleClass="help"
			value="Fill out the information below and click Submit to search or modify a HelpDesk request"></h:outputText>
		<br />
		<br />
		<table cellspacing="10px">
			<tr>
				<td align="right">First name:</td>
				<td><h:inputText id="FirstName"
					value="#{browseRequestBean.firstName}">
				</h:inputText></td>
			</tr>
			<tr>
				<td align="right">Last name:</td>
				<td><h:inputText id="LastName"
					value="#{browseRequestBean.lastName}"></h:inputText></td>
			</tr>
			<tr>
				<td align="right">Building:</td>
				<td><h:selectOneMenu style="width: auto" id="location"
					value="#{browseRequestBean.location}">
					<f:selectItems value="#{browseRequestBean.locationSelectItems}" />
				</h:selectOneMenu></td>
			</tr>
			<tr>
				<td align="right">Room number:</td>
				<td><h:inputText id="Room" value="#{browseRequestBean.roomNo}">
				</h:inputText></td>
			</tr>
			<tr>
				<td align="right">Problem:</td>
				<td><h:selectOneMenu id="problem"
					value="#{browseRequestBean.problem}">
					<f:selectItems value="#{browseRequestBean.issueSelectItems}" />
				</h:selectOneMenu></td>
			</tr>

		</table>
		<br />
		<h:commandButton id="search" value="Search"
			action="#{browseRequestBean.search}" /> <h:commandButton id="reset"
			value="Reset" onclick="return allowReset()"
			action="#{browseRequestBean.reset}" /> <br />
		<br />
		<h:outputText style="font-size:14pt"
			value="#{browseRequestBean.resultCount} matches"></h:outputText> <br />
		<br />
		<h:dataTable style="width:100%"
			value="#{browseRequestBean.searchResults}" var="result"
			rowClasses="evenRow, oddRow">
			<h:column>
				<f:facet name="header">
					<h:outputText value="Request ID"></h:outputText>
				</f:facet>
				<h:outputText value="#{result.requestID}"></h:outputText>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Date Added"></h:outputText>
				</f:facet>
				<h:outputText value="#{result.shortDate}"></h:outputText>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Status"></h:outputText>
				</f:facet>
				<h:outputText value="#{result.status.displayValue}"></h:outputText>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Submitted By"></h:outputText>
				</f:facet>
				<h:outputText value="#{result.fullName}"></h:outputText>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Location"></h:outputText>
				</f:facet>
				<h:outputText value="#{result.location.displayValue}"></h:outputText>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Room Nbr"></h:outputText>
				</f:facet>
				<h:outputText value="#{result.roomNumber}"></h:outputText>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Problem"></h:outputText>
				</f:facet>
				<h:outputText value="#{result.issue.displayValue}"></h:outputText>
			</h:column>
		</h:dataTable></div>
		<div
			style="font-size: 10pt; color: gray; background-color: #e0e0e0; align: right">&#169;2008
		Chestnut Hill College</div>
		</div>
	</h:form>
</f:view>
</body>
</html>
