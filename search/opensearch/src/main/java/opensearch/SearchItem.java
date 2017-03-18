package opensearch;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * 类SearchItem.java的实现描述：搜索域基类
 * 
 */
public class SearchItem {

    protected Map<String, String> params = new HashMap<String, String>();

    /**
     * @return the params
     */
    public Map<String, String> getParams() {
        return params;
    }

    /**
     * 当前页数
     * 
     * @param pageNo
     */
    public void addPageNo(int pageNo) {
        params.put("page", String.valueOf(pageNo));
    }

    /**
     * 每页条数
     * 
     * @param pageSize
     */
    public void addPageSize(int pageSize) {
        params.put("page_size", String.valueOf(pageSize));
    }

    /**
     * 高级搜索关键字
     * 
     * @param cqValue
     */
    public void addCq(String cqValue) {
        addCq(cqValue, null);
    }

    public void addCq(String cqValue, String connecter) {
        if (StringUtils.isEmpty(connecter)) {
            connecter = " AND ";
        }
        String cqStr = params.get("cq");
        if (StringUtils.isEmpty(cqStr)) {
            params.put("cq", cqValue);
        } else {
            params.put("cq", cqStr + " " + connecter + " " + cqValue);
        }
    }

    public String getQueryString() {
        return params.get("cq");
    }

    /**
     * 搜索关键字
     * 
     * @param qValue
     */
    public void addQ(String qValue) {
        addQ(qValue, null);
    }

    /**
     * @param qValue 例如：defalut:keyword
     * @param connecter
     */
    public void addQ(String qValue, String connecter) {
        if (StringUtils.isEmpty(connecter)) {
            connecter = " AND ";
        }
        String qStr = params.get("q");
        if (StringUtils.isEmpty(qStr)) {
            params.put("q", qValue);
        } else {
            params.put("q", qStr + connecter + qValue);
        }
    }

    /**
     * 过滤条件
     * 
     * @param filterValue
     */
    public void addFilter(String filterValue) {
        addFilter(filterValue, null);
    }

    public void addFilter(String filterValue, String connecter) {
        if (StringUtils.isEmpty(connecter)) {
            connecter = " AND ";
        }
        String filterStr = params.get("filter");
        if (StringUtils.isEmpty(filterStr)) {
            params.put("filter", filterValue);
        } else {
            params.put("filter", filterStr + connecter + filterValue);
        }
    }

    /**
     * 按字段或者文档RANK升序(+)或降序(-)排序
     * 
     * @param sortValue
     */
    public void addSort(String sortValue) {
        String sortStr = params.get("sort");
        if (StringUtils.isEmpty(sortStr)) {
            params.put("sort", sortValue);
        } else {
            params.put("sort", sortStr + ";" + sortValue);
        }
    }

    /**
     * 指定要返回的字段，默认全部fields都返回
     * 
     * @param fetchFieldsValue
     */
    public void addFetchFields(String fetchFieldsValue) {
        String fetchFieldsStr = params.get("fetch_fields");
        if (StringUtils.isEmpty(fetchFieldsStr)) {
            params.put("fetch_fields", fetchFieldsValue);
        } else {
            params.put("fetch_fields", fetchFieldsStr + ";" + fetchFieldsValue);
        }
    }

    /**
     * 分类汇总表达式
     * facetValue一般为facet_key:company_id,facet_fun:sum(id)#max(id)#min(id)
     * 表示将同时获取company_id中id之和，最大值及最小值
     * 
     * @param facetValue
     */
    public void addFacet(String facetValue) {
        params.put("facet", facetValue);
    }

    /**
     * 用cq的时候，您必须将关键词用raw_query传值之后，才会进入topquery统计
     * 例如：cq=title:"阿里云"&raw_query="阿里云"
     * 
     * @param rawQueryValue
     */
    public void addRawQuery(String rawQueryValue) {
        params.put("raw_query", rawQueryValue);
    }
}
