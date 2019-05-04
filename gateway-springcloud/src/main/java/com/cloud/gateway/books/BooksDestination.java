package com.cloud.gateway.books;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "books.destinations")
public class BooksDestination {

	  @NotNull
	  private String booksServiceUrl;

	  public String getBooksServiceUrl() {
	    return booksServiceUrl;
	  }

	  public void setBooksServiceUrl(String booksServiceUrl) {
	    this.booksServiceUrl = booksServiceUrl;
	  }
	
}
