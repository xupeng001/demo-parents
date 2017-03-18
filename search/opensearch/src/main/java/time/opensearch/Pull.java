package time.opensearch;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.aliyun.opensearch.CloudsearchClient;
import com.aliyun.opensearch.CloudsearchSearch;
import com.aliyun.opensearch.object.KeyTypeEnum;

import opensearch.Constans;
import opensearch.QueryParam;

public class Pull {

	public static void main(String[] args) throws Exception {
		String accesskey = "Eqamk9ejdBn2Sn2v";
		String secret = "URCuv07jxcmdEZRZ4803xkoVOEDiek";
		String appName = "compare_time";
		Map<String, Object> opts = new HashMap<String, Object>();
		String host = "http://opensearch-cn-beijing.aliyuncs.com";
		// 这里的host需要根据访问应用详情页中提供的的API入口来确定
		CloudsearchClient client = null;
		try {
			client = new CloudsearchClient(accesskey, secret, host, opts, KeyTypeEnum.ALIYUN);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		CloudsearchSearch cloudsearchSearch = new CloudsearchSearch(client);
		cloudsearchSearch.addIndex(appName);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 100; i++) {
			sb.append("contain(").append("default ,").append(" \"key\" )").append(" AND ");
		}

		cloudsearchSearch.addFilter(sb.toString());
		cloudsearchSearch.setQueryString("default:'e'");
		cloudsearchSearch.addFilter("gmt_create>1");
		cloudsearchSearch.setFormat("json");
		String result = cloudsearchSearch.search();
		System.out.println(result);
	}
}
