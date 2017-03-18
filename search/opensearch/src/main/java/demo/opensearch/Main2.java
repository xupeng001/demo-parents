package demo.opensearch;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import com.aliyun.opensearch.CloudsearchClient;
import com.aliyun.opensearch.CloudsearchDoc;
import com.aliyun.opensearch.object.KeyTypeEnum;

public class Main2 {
	public static void main(String[] args) {
		String accesskey = "Eqamk9ejdBn2Sn2v";
		String secret = "URCuv07jxcmdEZRZ4803xkoVOEDiek";
		String appName = "demo";
		Map<String, Object> opts = new HashMap<String, Object>();
		String host = "http://opensearch-cn-beijing.aliyuncs.com";
		// 这里的host需要根据访问应用详情页中提供的的API入口来确定
		CloudsearchClient client = null;
		try {
			client = new CloudsearchClient(accesskey, secret, host, opts, KeyTypeEnum.ALIYUN);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		CloudsearchDoc doc = new CloudsearchDoc(appName, client);
		String table_name = "demo";
		String json="[{\"fields\":{\"id\":\"0\",\"name\":\"广大中小企业都有各种结构化的数据需要进行检索，目前一般采用数据库本身提供的搜索功能或者利用open source的搜索软件搭建，这样的做法不但会消耗网站本身的资源，性能也会很容易成为问题，而且相关性通常也不够好。我们的产品的目的是要利用阿里云先进的云计算和搜索技术向广大中小企业提供低成本，高质量，高性能，可定制的数据搜索解决方案。本项目和云搜索的通用解决方案目标略有不同，主要区别为本项目主要针对用户的结构化数据进行搜索，云搜索的通用解决方案则主要是针对网页型数据位处理对象。\",\"description\":\"广大中小企业都有各种结构化的数据需要进行检索，目前一般采用数据库本身提供的搜索功能或者利用open source的搜索软件搭建，这样的做法不但会消耗网站本身的资源，性能也会很容易成为问题，而且相关性通常也不够好。我们的产品的目的是要利用阿里云先进的云计算和搜索技术向广大中小企业提供低成本，高质量，高性能，可定制的数据搜索解决方案。本项目和云搜索的通用解决方案目标略有不同，主要区别为本项目主要针对用户的结构化数据进行搜索，云搜索的通用解决方案则主要是针对网页型数据位处理对象。\",\"url\":\"广大中小企业都有各种结构化的数据需要进行检索，目前一般采用数据库本身提供的搜索功能或者利用open source的搜索软件搭建，这样的做法不但会消耗网站本身的资源，性能也会很容易成为问题，而且相关性通常也不够好。我们的产品的目的是要利用阿里云先进的云计算和搜索技术向广大中小企业提供低成本，高质量，高性能，可定制的数据搜索解决方案。本项目和云搜索的通用解决方案目标略有不同，主要区别为本项目主要针对用户的结构化数据进行搜索，云搜索的通用解决方案则主要是针对网页型数据位处理对象。\"},\"cmd\":\"ADD\"}]";
		try {
			System.out.println(doc.push(json, table_name));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
