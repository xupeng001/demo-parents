package demo.opensearch;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import com.aliyun.opensearch.CloudsearchClient;
import com.aliyun.opensearch.CloudsearchDoc;
import com.aliyun.opensearch.object.KeyTypeEnum;

public class Main3 {
	public static void main(String[] args) {
		String accesskey = "Eqamk9ejdBn2Sn2v";
		String secret = "URCuv07jxcmdEZRZ4803xkoVOEDiek";
		String appName = "serach_info";
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
		String table_name = "main";
		String json="[{\"fields\":{\"id\":\"0\",\"name\":\"广大中小同，对象。\",\"description\":\"广大中小企业页型数据位处理对象。\",\"url\":\"广大中小企业型数据位处理对象。\",\"vip\":\"123456789\"},\"cmd\":\"ADD\"}]";
		try {
			System.out.println(doc.push(json, table_name));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
