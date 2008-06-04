package edu.chc.helpdesk;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import edu.chc.helpdesk.email.MessageTest;
import edu.chc.helpdesk.requests.EJBHelpRequestServiceTest;
import edu.chc.helpdesk.utils.DropDownListServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({MessageTest.class,
    EJBHelpRequestServiceTest.class,
    DropDownListServiceTest.class})
public class AllTests {
    
}
