
package opensearch;
import java.io.Serializable;

public class PushParams implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4803048438647258734L;
	private int id;
	private String title;
	private String desription;
	private String url;
	private int  origin;
	private String context;
	private String origin_code;
	private String origin_name;
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
	public void setContext(String context) {
		this.context = context;
	}
	public String getContext() {
		return context;
	}
	public void setOrigin_code(String origin_code) {
		this.origin_code = origin_code;
	}
	public String getOrigin_code() {
		return origin_code;
	}
	public void setOrigin_name(String origin_name) {
		this.origin_name = origin_name;
	}
	public String getOrigin_name() {
		return origin_name;
	}
}
