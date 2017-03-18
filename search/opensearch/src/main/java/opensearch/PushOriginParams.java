package opensearch;

import java.io.Serializable;

public class PushOriginParams implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4803048438647258734L;
	private int id;
	private String origin_code;
	private String origin_name;
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
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
