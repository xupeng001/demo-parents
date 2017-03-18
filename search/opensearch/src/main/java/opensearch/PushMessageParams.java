package opensearch;

import java.io.Serializable;

public class PushMessageParams implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4803048438647258734L;
	private int id;
	private String title;
	private String desription;
	private String url;
	private int  origin;
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setdesription(String desription) {
		this.desription = desription;
	}
	public String getdesription() {
		return desription;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrl() {
		return url;
	}
	public void setOrigin(int origin) {
		this.origin = origin;
	}
	public int getOrigin() {
		return origin;
	}
	
}
