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
	if(document.form1["form1:FirstName"].value != "" || document.form1["form1:LastName"].value != "")
	{
		window.alert("You must enter your first and last names.");
		return false;
	}
	else
		return true;
}
	/*
	if(document.form1.location.selectIndex == -1)
	{
		window.alert("You must select a location.");
		return false;
	}
	else
		return true; 
	
	if(checkEmail(document.form1.Email.value) == false)
	{
		window.alert("You must enter a valid email.");
		return false;
	}
	else
		return true;

	if (document.form1.problem.selectedIndex == -1)
	   {
	   	window.alert("you must select a problem");
	   	return false;
	   }
	else if (document.form1.UrgentYes.checked == false && document.form6.UrgentNo.checked == false)
		{
			window.alert("you must select urgent or not urgent");
			return false;
		}
	else if (checkPhoneNumber(document.form1.PhoneNumber.value) == false)
		{
			window.alert("you must enter a valid phone number");
			return false;
		}	
	/*	
}

function checkPhoneNumber(PhoneNumber)
{
	re = /^(\(\d{3}\)\s*)?\d{3}[\s-]?\d{4}$/
	return re.test(PhoneNumber);
}

function checkEmail(Email)
{
	re =/^\w[-._\w]*\w@\w[-._\w]*\w\.\w{2,8}$/
	return re.test(Email);
}*/

</script>

</head>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>  
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<body bgcolor = "maroon" text = "gray">
<f:view>
		<h:form id = "form1" onsubmit = "return checkForm1()">
				<b><h:outputText value =" Welcome to CHC Help Desk!"></h:outputText>
				<br>
				<h:outputText value ="Please Enter all required information marked with a *"></h:outputText>
			<br>
				* First Name :
					<h:inputText id = "FirstName"> </h:inputText>
			<br>
					* Last Name :
					<h:inputText id = "LastName"> </h:inputText>
			<br>
				Location(* for residents) : 
					<h:selectOneMenu style="width: 105px" id = "location" value = ""> 
						<f:selectItem id="FzHall" itemLabel="Fitz Hall" itemValue="1" />
						<f:selectItem id="StJoes" itemLabel="Saint Joseph's Hall" itemValue="2" />
						<f:selectItem id="Fr" itemLabel="Fournier" itemValue="3" />
						<f:selectItem id="Font" itemLabel="Fontbonne" itemValue="4" />
						<f:selectItem id="Library" itemLabel="Library" itemValue="5" />
						
					 </h:selectOneMenu>
			<br>
				 * Email 
					<h:inputText id = "Email"> </h:inputText>
				 eg; (yourname@chc.edu) 
			<br>
					* Phone Number 
						<h:inputText id = "PhoneNumber"> </h:inputText>
					 eg; ((xxx) xxx-xxxx)
			<br>
					* What is your problem (choose one)
					<br></br>
					<h:selectOneMenu id="problem" value="">
						<f:selectItem id="email" itemLabel="Email" itemValue="1" />
						<f:selectItem id="MSOffice" itemLabel="Microsoft Office" itemValue="2" />
						<f:selectItem id="Internet" itemLabel="Internet" itemValue="3" />
						<f:selectItem id="Other" itemLabel="Other (Please Specify)" itemValue="4" />
					</h:selectOneMenu>
			<br>
			<br>
					* Is your Problem Urgent? (choose one)
					<br>
						 Yes 
						<h:selectBooleanCheckbox id = "UrgentYes"></h:selectBooleanCheckbox>
						 No 
					<h:selectBooleanCheckbox id = "UrgentNo"></h:selectBooleanCheckbox> 
					
			<br>
			<br>
					Comments(100 characters or less)
					<br>
						<h:inputTextarea style="height: 119px; width: 275px"> </h:inputTextarea>
			<br>
					
					<h:commandButton value = "Submit" action = "success">
					</h:commandButton>
					<h:commandButton value = "Cancel" action = "reset">
					</h:commandButton>
		</h:form>	
</f:view>
</body>
</html>

