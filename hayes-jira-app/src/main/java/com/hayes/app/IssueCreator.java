package com.hayes.app;

import com.atlassian.util.concurrent.Promise;
import com.atlassian.jira.rest.client.api.AuthenticationHandler;
import com.atlassian.jira.rest.client.api.IssueRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.BasicIssue;
import com.atlassian.jira.rest.client.api.domain.IssueType;
import com.atlassian.jira.rest.client.api.domain.input.IssueInput;
import com.atlassian.jira.rest.client.api.domain.input.IssueInputBuilder;
import com.atlassian.jira.rest.client.auth.BasicHttpAuthenticationHandler;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import java.net.URI;

public class IssueCreator
{
	URI jiraUri;
	AsynchronousJiraRestClientFactory factory;
	AuthenticationHandler authenticator;
	JiraRestClient restClient;
	IssueRestClient issueClient;
	Issue issue;
	
	public IssueCreator(String jiraServerUri, String username, String password, Issue issuePreferences) throws Exception
	{
		jiraUri = URI.create(jiraServerUri);
        authenticator = new BasicHttpAuthenticationHandler(username, password);
        this.issue = issuePreferences;
		setupClient();
	}
	
	public void create() throws Exception
	{
        try
        {
        	IssueInputBuilder iib = new IssueInputBuilder();
        	iib.setProjectKey(issue.getProjectKey());
        	iib.setSummary(issue.getSummary());
        	iib.setIssueType(getIssueType(issue.getIssueType(), restClient));
        	iib.setDescription(issue.getDescription());
        	iib.setPriorityId(issue.getPriorityId());
        	iib.setAssigneeName(issue.getAssigneeName());
        	iib.setReporterName(issue.getReporterName());
        	iib.setDueDate(issue.getDueDate());
        	
        	IssueInput issue = iib.build();
        	BasicIssue issueObj = issueClient.createIssue(issue).claim();
        	
        	System.out.println("Issue " + issueObj.getKey() + " created successfully.");
        }
        finally
        {
        	restClient.close();
        }
	}
	
	private void setupClient()
	{
        factory = new AsynchronousJiraRestClientFactory();
        restClient = factory.create(jiraUri, authenticator);
        issueClient = restClient.getIssueClient();
	}
	
	 private IssueType getIssueType(long issueTypeId, JiraRestClient client)
	    {
	    	Promise<Iterable<IssueType>> promise = client.getMetadataClient().getIssueTypes();
	    	
	    	Iterable<IssueType> issueTypes = promise.claim();
	    	for(IssueType type : issueTypes)
	    	{
	    		if(type.getId() == issueTypeId)
	    		{
	    			return type;
	    		}
	    	}
	    	
	    	return null;	// Type not found, use default Type.
	    }
}
