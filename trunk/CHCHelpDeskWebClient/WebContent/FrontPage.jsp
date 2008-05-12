<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CHC Help Desk Greeting</title>
<link rel="stylesheet" type="text/css" href="main.css">
<script type="text/javascript">

function mask_phone(input, e) {

	MAX_PHONE_LEN=14;

	//get the key code and ASCII char for the key being pressed
	key = (e.keyCode) ? e.keyCode : e.which;
	keyChar = String.fromCharCode(key);

	//allow backspace,tab, and delete
	if(key==8 || key==9 || key==46) {
		return true;
	}
	else {

		var phone = input.value;

		//ignore non-digit characters
		if(!/\d/.test(keyChar))
			return false;

		//ignore key if field is full
		if(phone.length==MAX_PHONE_LEN)
			return false;

		if(phone.length==0) phone = "(" + phone;
		if(phone.length==4) phone = phone + ") ";
		if(phone.length==9) phone = phone + "-";
		input.value = phone+keyChar;

		return false;
	}
}

function allowReset()  
{
		 return window.confirm("Do you really want to clear the data?");
}

function checkForm1()
{
	if(document.form1["form1:FirstName"].value =="" || document.form1["form1:LastName"].value == "")
	{
		window.alert("You must enter your first and last name.");
		return false;
	}
	
	else if(document.form1["form1:location"].selectIndex == -1)
	{
		window.alert("You must select a location.");
		return false;
	}
	
	else if(checkEmail(document.form1["form1:Email"].value) == false)
	{
		window.alert("You must enter a valid email.");
		return false;
	}
	
	else if (document.form1["form1:problem"].selectedIndex == -1)
	   {
	   	window.alert("you must select a problem");
	   	return false;
	   }
	
	else if (document.form1["form1:Room"].value == "")
		{
			window.alert("you must enter a room number");
			return false;
		}
	
	else if (checkPhoneNumber(document.form1["form1:PhoneNumber"].value) == false)
		{
			window.alert("you must enter a valid phone number");
			return false;
		}	
	else
	{ 
  		return window.confirm("Do you really want to submit the data?");
	}
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
}


</script>

</head>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>  
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<body>
<f:view>
	<h:form id="form1">
		<div style="background-color:maroon; font-color:white; padding:5px">
		<h:outputText value ="Chestnut Hill College" style="font-family:Arial;font-size:12pt; color:white"></h:outputText>
		<br />
		<h:outputText value ="HelpDesk" style="font-family:Arial;font-size:22pt; font-weight:bold; color:white"></h:outputText>
		</div>
		<div style="border-bottom: 1pt solid gray; height:5px; background-color: #e0e0e0"></div>
		<br />
		<div style="margin:10px">
		<h:outputText value ="Help Request Form" style="font-size:18pt"></h:outputText>
		<br />
		<h:message style="border:1px solid #00000; background-color: #ffff80" for="comments" />
		<br />
		<h:outputText style="font-size:12pt;" value="What do I do?"></h:outputText>
		<br /><br />
		<h:outputText styleClass="help" value="Fill out the information below and click Submit to send a request for service to the HelpDesk."></h:outputText>
		<br /><br />
		<table cellspacing="10px">
			<tr>
				<td align="right">First name:</td>
				<td><h:inputText id="FirstName" value="#{frontPageBean.firstName}"> </h:inputText></td>
			</tr>
			<tr>
				<td align="right">Last name:</td>
				<td><h:inputText id="LastName" value="#{frontPageBean.lastName}"></h:inputText></td>
			</tr>
			<tr>
				<td align="right">Building:</td>
				<td>			
				<h:selectOneMenu style="width: auto" id="location" value="#{frontPageBean.location}">
					<f:selectItems value="#{frontPageBean.locationSelectItems}" />
				</h:selectOneMenu>
				</td>
			</tr>		
			<tr>
				<td align="right">Room number:</td>
				<td><h:inputText id="Room" value="#{frontPageBean.roomNo}"> </h:inputText></td>
			</tr>		
			<tr>
				<td align="right">Your e-mail:<br /><span class="help">(i.e. jdoe@chc.edu)</span></td>
				<td><h:inputText id = "Email" value="#{frontPageBean.email}"> </h:inputText></td>
			</tr>	
			<tr>
				<td align="right">Phone number:</td>
				<td><h:inputText id = "PhoneNumber" value="#{frontPageBean.phoneNumber}" onkeypress="return mask_phone(this,event)"> </h:inputText></td>
			</tr>
			<tr>
				<td align="right">Problem:</td>
				<td>
				<h:selectOneMenu id="problem" value="#{frontPageBean.problem}">
					<f:selectItems value="#{frontPageBean.issueSelectItems}"/>
				</h:selectOneMenu>	
				</td>
			</tr>
			<tr>
				<td align="right" valign="top">Additional Comments:<br /><span class="help">(100 characters max)</span></td>
				<td>
				<h:inputTextarea style="width: 400px;height: 200px" id= "comments" value="#{frontPageBean.comments}">
					<f:validateLength maximum="100"/>
				</h:inputTextarea>					
				</td>
			</tr>
		</table>
		<br /><br />
		<h:commandButton id="submit" value="Submit" onclick="return checkForm1()" action="#{frontPageBean.submit}"/>
		<h:commandButton id="reset" value="Reset" onclick = "return allowReset()"action="#{frontPageBean.reset}"/>
		</div>
		</h:form>	
</f:view>
</body>
</html>

