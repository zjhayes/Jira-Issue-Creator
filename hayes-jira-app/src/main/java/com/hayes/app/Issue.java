package com.hayes.app;

import org.joda.time.DateTime;

public class Issue
{
	private String projectKey;
	private String summary;
	private long issueType;
	private String description;
	private long priorityId;
	private String assigneeName;
	private String reporterName;
	private DateTime dueDate;
	
	// Getters and Setters
	public String getProjectKey()
	{
		return projectKey;
	}
	public void setProjectKey(String projectKey)
	{
		this.projectKey = projectKey;
	}
	public String getSummary()
	{
		return summary;
	}
	public void setSummary(String summary)
	{
		this.summary = summary;
	}
	public long getIssueType()
	{
		return issueType;
	}
	public void setIssueType(long issueType)
	{
		this.issueType = issueType;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public long getPriorityId()
	{
		return priorityId;
	}
	public void setPriorityId(long priorityId)
	{
		this.priorityId = priorityId;
	}
	public String getAssigneeName()
	{
		return assigneeName;
	}
	public void setAssigneeName(String assigneeName)
	{
		this.assigneeName = assigneeName;
	}
	public String getReporterName()
	{
		return reporterName;
	}
	public void setReporterName(String reporterName)
	{
		this.reporterName = reporterName;
	}
	public DateTime getDueDate()
	{
		return dueDate;
	}
	public void setDueDate(DateTime dueDate)
	{
		this.dueDate = dueDate;
	}
	

}
