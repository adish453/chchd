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
			<h:graphicImage id="image" alt="griff logo" url="http://i225.photobucket.com/albums/dd83/w_goldfish/Picture1.png"></h:graphicImage><b>
			<br>
			<h:outputText value ="Welcome to CHC Help Desk!" style="font-size:14pt"></h:outputText></b>
				<br><br>
				
		
		<h:message style="border:1px solid #00000; background-color: #ffff80" for="comments" />
		
		<h:panelGrid border="0" columns="1" frame="none">
		<h:outputText styleClass="help" value="Please fill in the following information."></h:outputText>
		<h:panelGrid border="0" columns="2" frame="none">
			<h:outputText value="First Name:"></h:outputText>
			<h:inputText id="FirstName" value="#{frontPageBean.firstName}"> </h:inputText>
			<h:outputText value="Last Name:"></h:outputText>
			<h:inputText id="LastName" value="#{frontPageBean.lastName}">
			</h:inputText><h:outputText value="Building:"></h:outputText>
			<h:selectOneMenu style="width: auto" id="location" value="#{frontPageBean.location}">
						<f:selectItems value="#{frontPageBean.locationSelectItems}" />
					</h:selectOneMenu><h:outputText value="Room Number:"></h:outputText><h:inputText id="Room" value="#{frontPageBean.roomNo}"> </h:inputText>
			<h:outputText value="Your e-mail address:"></h:outputText>
			<h:inputText id = "Email" value="#{frontPageBean.email}"> </h:inputText>
			<h:outputText value="Phone number:"></h:outputText>
			<h:inputText id = "PhoneNumber" value="#{frontPageBean.phoneNumber}" onkeypress="return mask_phone(this,event)"> </h:inputText>
			<h:outputText value="I am having a problem with: "></h:outputText>
			<h:selectOneMenu id="problem" value="#{frontPageBean.problem}">
				<f:selectItems value="#{frontPageBean.issueSelectItems}"/>
			</h:selectOneMenu>		
		</h:panelGrid>
		<h:panelGrid border="0" columns="1" frame="none" style="width: 381px">
			<h:outputText value="Additional comments:"></h:outputText>
			<h:inputTextarea style="width: 348px;height: 107px" id= "comments" value="#{frontPageBean.comments}">
					<f:validateLength maximum="100"/>
			</h:inputTextarea>	
		</h:panelGrid>
		</h:panelGrid>
		
		<h:commandButton id="submit" value="Submit" onclick="return checkForm1()" action="#{frontPageBean.submit}"/>
		<h:commandButton id="reset" value="Reset" onclick = "return allowReset()"action="#{frontPageBean.reset}"/>

		</h:form>	
</f:view>
</body>
</html>

