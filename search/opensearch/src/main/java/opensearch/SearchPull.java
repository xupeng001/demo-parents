package opensearch;

import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.opensearch.CloudsearchClient;
import com.aliyun.opensearch.CloudsearchSearch;
import com.aliyun.opensearch.object.KeyTypeEnum;

public class SearchPull {

	static final int DEFAULT_PAGE_SIZE = 20;
	final static String FORMAT_JSON = "json";
	static final int RETRY_TIMES = 3;

	public static String searchInfo(SearchParams params) throws Exception {
		Map<String, Object> opts = null;
		CloudsearchClient client = new CloudsearchClient(Constans.key, Constans.secret, Constans.host, opts,
				KeyTypeEnum.ALIYUN);
		CloudsearchSearch cloudsearchSearch = new CloudsearchSearch(client);
		cloudsearchSearch.addIndex(Constans.index_name);
		Map<String, String> queryParams = createSearchItem(params).getParams();
		// 指定搜索的关键词
		if (StringUtils.isNotBlank(queryParams.get(QueryParam.cq.name()))) {
			String str=queryParams.get(QueryParam.cq.name());
			cloudsearchSearch.setQueryString(str);
		}

		if (StringUtils.isNotBlank(queryParams.get(QueryParam.q.name()))) {
			String str=queryParams.get(QueryParam.q.name());
			cloudsearchSearch.setQueryString(str);
		}

		// 设定过滤条件,字段必须设定为可过滤
//		if (StringUtils.isNotBlank(queryParams.get(QueryParam.filter.name()))) {
//			cloudsearchSearch.addFilter(queryParams.get(QueryParam.filter.name()));
//		}
		cloudsearchSearch.addFilter("contain(title, \"wb199502\")");
		// 设定排序方式,字段必须设定为可过滤
		if (StringUtils.isNotBlank(queryParams.get(QueryParam.sort.name()))) {
			cloudsearchSearch.addSort(queryParams.get(QueryParam.sort.name()), "");
		}

		// 分页查询
		int page = 1;
		if (StringUtils.isNotBlank(queryParams.get(QueryParam.page.name()))) {
			page = Integer.parseInt(queryParams.get(QueryParam.page.name()));
		}
		if (page <= 0) {
			page = 1;
		}

		int pageSize = DEFAULT_PAGE_SIZE;
		if (StringUtils.isNotBlank(queryParams.get(QueryParam.page_size.name()))) {
			pageSize = Integer.parseInt(queryParams.get(QueryParam.page_size.name()));
		}
		if (pageSize <= 0) {
			pageSize = DEFAULT_PAGE_SIZE;
		}
		cloudsearchSearch.setHits(pageSize);

		int offset = (page - 1) * pageSize;
		cloudsearchSearch.setStartHit(offset);

		// 指定搜索返回的格式
		cloudsearchSearch.setFormat(FORMAT_JSON);

		String result = cloudsearchSearch.search();
		int retryTime = 0;
		if (!isSuccess(result)) {
			while (!isSuccess(result) && retryTime <= RETRY_TIMES) {
				result = cloudsearchSearch.search();
				++retryTime;
			}
		}

		if (!isSuccess(result)) {
		}
		return result;

	}

	public static boolean isSuccess(String result) {
		result = StringUtils.trimToEmpty(result);
		boolean success = false;
		try {
			JSONObject jo = null;
			if ((jo = JSON.parseObject(result)) != null) {
				success = "OK".equals(jo.get("status"));
			}
		} catch (Exception e) {
		}
		if (!success) {
		}

		return success;
	}

	private static SearchItem createSearchItem(SearchParams searchInfoParam) throws Exception {
		SearchItem searchItem = new SearchItem();
		searchItem.addPageNo(0);
		searchItem.addPageSize(20);
		Map<String, Object> searchOpportunityMap = PropertyUtils.describe(searchInfoParam);
		for (Map.Entry<String, Object> o : searchOpportunityMap.entrySet()) {
			if (null != o.getValue()) {
				if ("orderSort".equals(o.getKey())) {

				} else if ("orderField".equals(o.getKey())) {
					Object orderSortStr = "-";
					if (null != searchInfoParam.getOrderSort()) {
						orderSortStr = "asc".equals(searchInfoParam.getOrderSort().toLowerCase()) ? "+" : "-";
					}
					if (!StringUtils.isEmpty(searchInfoParam.getOrderField())) {
						searchItem.addSort(orderSortStr + searchInfoParam.getOrderField());
					} else {
						searchItem.addSort("-id");
					}
				} else if (o.getValue() instanceof String) {
					if(o.getKey().equals("origin_code")){
						searchItem.addCq("code:'" + o.getValue() + "'");
					}else{
						searchItem.addCq(o.getKey() + ":'" + o.getValue() + "'");
					}
				} else if ("pageSize".equals(o.getKey())) {
					// 分页pageSize设置
					searchItem.addPageSize(searchInfoParam.getPageSize());
				} else if ("start".equals(o.getKey())) {
					// 分页start设置
					int page = (searchInfoParam.getStart() / searchInfoParam.getPageSize()) + 1;
					searchItem.addPageNo(page);
				}
			}
		}
		System.out.println(searchItem.getQueryString());
		System.out.println(JSON.toJSONString(searchItem.getParams()));
		return searchItem;
	}

	public static void main(String[] args) throws Exception {
		SearchParams params = new SearchParams();
//		 params.setId(1);
		 params.setOrigin_code("origin_code1");
//		params.setTitle("title");
//		 params.setUrl("url");
		params.setPageSize(10);
		params.setStart(0);
//		params.set
//		params.setOrderField("origin");
//		params.setOrderSort("asc");
		String result = searchInfo(params);
		System.out.println(result);
	}
}
