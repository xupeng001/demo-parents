package opensearch;

import java.io.Serializable;

public class PushContextParams implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4803048438647258734L;
	private int message_id;
	private String context;
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public int getMessage_id() {
		return message_id;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getContext() {
		return context;
	}
}
