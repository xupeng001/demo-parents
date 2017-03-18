package opensearch;

import java.io.Serializable;

public class SearchParams implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7922607352800850447L;
	private int id;
	private String title;
	private String description;
	private String url;
	private int  origin;
	private String context;
	private String origin_code;
	private String origin_name;
	
	 /**
     * 从第几条开始取
     */
    private Integer           start;
    /**
     * 取几条
     */
    private Integer           PageSize;
    /**
     * 排序字段。
     */
    private String            orderField;
    /**
     * 排序顺序
     */
    private String            orderSort;
    
    
    public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
    public String getOrderField() {
		return orderField;
	}
    public void setOrderSort(String orderSort) {
		this.orderSort = orderSort;
	}
    public String getOrderSort() {
		return orderSort;
	}
    public void setPageSize(Integer pageSize) {
		PageSize = pageSize;
	}
    public Integer getPageSize() {
		return PageSize;
	}
    public void setStart(Integer start) {
		this.start = start;
	}
    public Integer getStart() {
		return start;
	}
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
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
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
