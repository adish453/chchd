<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CHC Help Desk Greeting</title>

<script type="text/javascript">
function checkForm1()
{
	if (document.form7.problem.selectedIndex == 0)
	   {
	   	alert("you must select a problem");
	   	return false;
	   }
	else if (document.form6.UrgentYes.checked == false && document.form6.UrgentNo.checked == false)
		{
			alert("you must select urgent or not urgent");
			return false;
		}
	else if (checkPhoneNumber(document.form5.PhoneNumber.value) == false)
		{
			alert("you must enter a valid phone number");
			return false;
		}	
}

function checkPhoneNumber(PhoneNumber)
{
	re = /^(\(\d{3}\)\s*)?\d{3}[\s-]?\d{4}$/
	return re.test(PhoneNumber);
}
</script>

</head>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>  
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<body bgcolor = "maroon" text = "gray">
<f:view>
	<h:dataTable border="0">
		<h:column id="column1">
			<tr id = "row0">
				<h:graphicImage src = "C:\Documents and Settings\Owner\My Documents\My Pictures\samuraiReggie.bmp"></h:graphicImage>
				<b>
				<h:outputText value =" Welcome to CHC Help Desk!"></h:outputText>
				</b>
				<br>
				<br>
				<h:outputText value ="Please Enter all required information marked with a *"></h:outputText>
			</tr>
			<br>
		    <tr id = "row1">
				<h:form id = "form1">
				<h>
				* First Name :
				</h>
					<h:inputText id = "FirstName"> </h:inputText>
				</h:form>
			</tr>
			<tr id = "row2">
				<h:form id = "form2"> 
					<h>
					* Last Name :
					</h>
					<h:inputText id = "LastName"> </h:inputText>
				</h:form>
			</tr>
			<tr id = "row3">
				<h:form id = "form3">
				<h>
				Location(* for residents) : 
				</h>
					<h:selectOneMenu style="width: 105px" id = "location" value = ""> 
						<f:selectItem id="FzHall" itemLabel="Fitz Hall" itemValue="1" />
						<f:selectItem id="StJoes" itemLabel="Saint Joseph's Hall" itemValue="2" />
						<f:selectItem id="Fr" itemLabel="Fournier" itemValue="3" />
						<f:selectItem id="Font" itemLabel="Fontbonne" itemValue="4" />
						<f:selectItem id="Library" itemLabel="Library" itemValue="5" />
						
					 </h:selectOneMenu>
				</h:form>
			</tr>
			<tr id = "row4">
				<h:form id = "form4">
				<h> * Email </h>
					<h:inputText id = "Email"> </h:inputText>
				<h> eg; (yourname@Chc.edu) </h>
				</h:form>
			</tr>
			<tr id = "row5">
					<h:form id = "form5" onsubmit = "return checkForm1()">
					<h> * Phone Number </h>
						<h:inputText id = "PhoneNumber"> </h:inputText>
					<h> eg; ((xxx) xxx-xxxx)</h>	
					</h:form>
			</tr>
			<tr id = "row6">
				<h:form id = "form6" onsubmit = "return checkForm1()">
					<p>
					* What is your problem (choose one)
					</p>
						<h:selectOneMenu id="problem" value="">
							<f:selectItem id="email" itemLabel="Email" itemValue="1" />
							<f:selectItem id="MSOffice" itemLabel="Microsoft Office" itemValue="2" />
							<f:selectItem id="Internet" itemLabel="Internet" itemValue="3" />
							<f:selectItem id="Other" itemLabel="Other (Please Specify)" itemValue="4" />
						</h:selectOneMenu>
							
				</h:form>
			</tr> 
			<tr id = "row7">
				<h:form id = "form7" onsubmit = "return checkForm1()">
					<h> * Is your Problem Urgent? (choose one) </h>
					<br>
						<h> Yes </h>
						<h:selectBooleanCheckbox id = "UrgentYes"></h:selectBooleanCheckbox>
						<h> No </h>
					<h:selectBooleanCheckbox id = "UrgentNo"></h:selectBooleanCheckbox>
				</h:form>
			</tr>
			<tr id = "row8">
					<h:form id = "form8"> 
					<h> Comments(100 characters or less) </h>
					<br>
						<h:inputTextarea style="height: 119px; width: 275px"> </h:inputTextarea>
					</h:form>
			</tr>
			<tr id = "row9">
				<h:form id = "form9">
					<h:commandButton value = "Submit" action = "success">
					</h:commandButton>
					<h:commandButton value = "Cancel" action = "reset">
					</h:commandButton>
				</h:form>
			</tr>
		</h:column>
	</h:dataTable>
</f:view>
</body>
</html>

