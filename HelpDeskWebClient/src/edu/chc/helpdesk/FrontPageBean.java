package edu.chc.helpdesk;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.model.SelectItem;

import edu.chc.helpdesk.requests.DropDownValue;
import edu.chc.helpdesk.requests.HelpDeskApplicationException;
import edu.chc.helpdesk.requests.HelpRequest;
import edu.chc.helpdesk.requests.HelpRequestService;

public class FrontPageBean {

    public String getComments() {
        return comments;
    }

    public String getEmail() {
        return email;
    }

    public String getfirstName() {
        return firstName;
    }

    public List getIssueSelectItems() {
        if (issueSelectItems == null) {
            issueSelectItems = getSelectItemsForList(requestService.getIssueDropDownList());
        }
        return issueSelectItems;
    }

    public String getLastName() {
        return lastName;
    }

    public int getLocation() {
        return location;
    }

    public List getLocationSelectItems() {
        if (locationSelectItems == null) {
            locationSelectItems = getSelectItemsForList(requestService.getLocationDropDownList());
        }
        return locationSelectItems;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getProblem() {
        return problem;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public String reset() {
        return "reset";
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setIssueSelectItems(List issueSelectItems) {
        this.issueSelectItems = issueSelectItems;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void setLocationSelectItems(List locationSelectItems) {
        this.locationSelectItems = locationSelectItems;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setProblem(int problem) {
        this.problem = problem;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String submit() {
        HelpRequest request = new HelpRequest();
        request.setFirstName(firstName);
        request.setLastName(lastName);
        request.setEmailAddress(email);
        request.setPhoneNumber(phoneNumber);
        request.setLocationId(location);
        request.setIssueId(problem);
        request.setRoomNumber(roomNo);
        request.setComments(comments);

        try {
            requestService.submit(request);
            return "success";
        } catch (HelpDeskApplicationException hae) {
            return "fail";
        }
    }

    private List getSelectItemsForList(List<? extends DropDownValue> valueList) {

        List selectItems = new ArrayList();

        for (DropDownValue value : valueList) {
            selectItems.add(new SelectItem(value.getID(), value.getDisplayValue()));
        }

        return selectItems;
    }

    @EJB
    public HelpRequestService requestService;

    String firstName;

    String lastName;

    String email;

    String phoneNumber;

    String roomNo;

    String comments;

    int problem;

    int location;

    List locationSelectItems;

    List issueSelectItems;
}
