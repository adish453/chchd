<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%><%@taglib
	uri="http://java.sun.com/jsf/core" prefix="f"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Browse Request Page</title>
<script type="text/javascript">

function allowReset()  
{
		 return window.confirm("Do you really want to clear the data?");
}

</script>

</head>
<body bgcolor = "maroon" text = "gray">
<f:view>
	<h:form id="form1">			
			<h:graphicImage id="image" alt="griff logo" url="http://i225.photobucket.com/albums/dd83/w_goldfish/Picture1.png"></h:graphicImage><b>
			<br>
			<h:outputText value =" Welcome to CHC Help Desk Search!"></h:outputText></b>
				<br>
			<h:outputText value ="Please Enter Your Search Terms in the Fields Below"></h:outputText>
			<br>
				First Name :
					<h:inputText id = "FirstName"> </h:inputText>
			<br>
				Last Name :
					<h:inputText id = "LastName"> </h:inputText>
			<br>
				Location(building) : 
					<h:selectOneMenu style="width: 105px" id = "location"> 
						<f:selectItem id="FzHall" itemLabel="Fitz Hall" itemValue="1" />
						<f:selectItem id="StJoes" itemLabel="Saint Joseph's Hall" itemValue="2" />
						<f:selectItem id="Fr" itemLabel="Fournier" itemValue="3" />
						<f:selectItem id="Font" itemLabel="Fontbonne" itemValue="4" />
						<f:selectItem id="Library" itemLabel="Library" itemValue="5" />
						
					 </h:selectOneMenu>
			<br>
				Location(Room) :
					<h:inputText id = "Room"> </h:inputText>
				<br>
					Problem:
					
					<h:selectOneMenu id="problem">
						<f:selectItem id="email" itemLabel="Email" itemValue="1" />
						<f:selectItem id="MSOffice" itemLabel="Microsoft Office" itemValue="2" />
						<f:selectItem id="Internet" itemLabel="Internet" itemValue="3" />
						<f:selectItem id="Other" itemLabel="Other (Please Specify)" itemValue="4" />
					</h:selectOneMenu>
			<br>
			<h:commandButton id="search" value="Search" action="#{browseResultsBean.search}"> </h:commandButton>
			<h:commandButton id ="reset" value = "Reset" onclick = "return allowReset()" action = "#{browseResultsBean.reset}"> </h:commandButton>
	</h:form>	
</f:view>
</body>
</html>