package com.hayes.app;

import org.joda.time.DateTime;

/**
 * Zachary Hayes
 * Mumo project
 */
public class App 
{
    public static void main(String[] args ) throws Exception
    {
        System.out.println( "Running..." );
   	
        IssueCreator issueCreator = new IssueCreator("http://localhost:8080","zjhayes", "Toast2018", setupPreferences());
        issueCreator.create();
        
        System.out.println("Finished.");
    }
    
    private static Issue setupPreferences()
    {
        Issue issuePreferences = new Issue();
        issuePreferences.setProjectKey("TEST");
        issuePreferences.setSummary("Issue Create Test 1");
        issuePreferences.setIssueType(10001);
        issuePreferences.setDescription("First test creating issue via Java.");
        issuePreferences.setPriorityId(3L);
        issuePreferences.setAssigneeName("zjhayes");
        issuePreferences.setReporterName("zjhayes");
        issuePreferences.setDueDate(new DateTime(2018, 11, 2, 12, 00));
        
        return issuePreferences;
    }
}
