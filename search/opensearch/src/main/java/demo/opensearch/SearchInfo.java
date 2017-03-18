package demo.opensearch;

import java.io.Serializable;

public class SearchInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String identifier;
	private String title;
	private String author;
	private String subject;
	private String keywords;
	private int creation_date;
	private int modified_date;
	private String content;
	private String format; 	
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setCreation_date(int creation_date) {
		this.creation_date = creation_date;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public void setModified_date(int modified_date) {
		this.modified_date = modified_date;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public String getContent() {
		return content;
	}
	public int getCreation_date() {
		return creation_date;
	}
	public String getFormat() {
		return format;
	}
	public String getIdentifier() {
		return identifier;
	}
	public String getKeywords() {
		return keywords;
	}
	public int getModified_date() {
		return modified_date;
	}
	public String getSubject() {
		return subject;
	}
	public String getTitle() {
		return title;
	}
}
