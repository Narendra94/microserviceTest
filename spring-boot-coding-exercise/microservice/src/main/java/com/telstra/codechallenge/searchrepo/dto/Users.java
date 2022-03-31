package com.telstra.codechallenge.searchrepo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Users {

	@JsonProperty(value="html_url")
	String htmlUrl;
	@JsonProperty(value="watchers_count")
	long watchersCount;
	String language;
	String description;
	String name;
	
	public String getHtmlUrl() {
		return htmlUrl;
	}
	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}
	public long getWatchers_count() {
		return watchersCount;
	}
	public void setWatchers_count(long watchers_count) {
		this.watchersCount = watchers_count;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	   
	
}
