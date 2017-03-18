package opensearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.aliyun.opensearch.CloudsearchClient;
import com.aliyun.opensearch.CloudsearchDoc;
import com.aliyun.opensearch.object.KeyTypeEnum;

public class PushDoc {
	public static  <T> String pushDocMessage(List<DocumentItem<T>> dataList) throws Exception{
		Map<String, Object> opts = null;
		CloudsearchClient client=new CloudsearchClient(Constans.key,Constans. secret,Constans. host, opts, KeyTypeEnum.ALIYUN);
		CloudsearchDoc doc=new CloudsearchDoc(Constans.index_name, client);
		String json =DocProductUtils.getIndexDataJson(dataList);
		String result=doc.push(json, Constans.table_message);
		return result;
	}
	public static  <T> String pushDocOrigin(List<DocumentItem<T>> dataList) throws Exception{
		Map<String, Object> opts = null;
		CloudsearchClient client=new CloudsearchClient(Constans.key,Constans. secret,Constans. host, opts, KeyTypeEnum.ALIYUN);
		CloudsearchDoc doc=new CloudsearchDoc(Constans.index_name, client);
		String json =DocProductUtils.getIndexDataJson(dataList);
		String result=doc.push(json, Constans.table_origin);
		return result;
	}
	public static  <T> String pushDocContext(List<DocumentItem<T>> dataList) throws Exception{
		Map<String, Object> opts = null;
		CloudsearchClient client=new CloudsearchClient(Constans.key,Constans. secret,Constans. host, opts, KeyTypeEnum.ALIYUN);
		CloudsearchDoc doc=new CloudsearchDoc(Constans.index_name, client);
		String json =DocProductUtils.getIndexDataJson(dataList);
		String result=doc.push(json, Constans.table_context);
		return result;
	}
	public static void main(String[] args) {
		//message
//		PushMessageParams params=new PushMessageParams();
//		params.setdesription("desription");
//		params.setId(1);
//		params.setOrigin(1);
////		params.setTitle("测试用例title");
//		params.setUrl("测试用例url");
//		List<DocumentItem<PushMessageParams>> dataList=new ArrayList<DocumentItem<PushMessageParams>>();
//		DocumentItem<PushMessageParams> item=new DocumentItem<PushMessageParams>();
//		item.setIndexDO(params);
//		item.setCmd("ADD");
//		dataList.add(item);
//		String result=null;
//		try {
//			result=pushDocMessage(dataList);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println(result);
		//origin
		String result=null;
		List<DocumentItem<PushOriginParams>> originparamsdataList=new ArrayList<DocumentItem<PushOriginParams>>();
		DocumentItem<PushOriginParams> originparamsitem=new DocumentItem<PushOriginParams>();
		PushOriginParams originparams=new PushOriginParams();
		Long id=System.currentTimeMillis();
		originparams.setId(id.intValue());
		originparams.setOrigin_code("测试用例origin_code1");
		originparams.setOrigin_name("测试用例origin_name1");
		originparamsitem.setIndexDO(originparams);
		originparamsitem.setCmd("ADD");
		originparamsdataList.add(originparamsitem);
		try {
			result=pushDocOrigin(originparamsdataList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		
//		//context
//		PushContextParams contextParams=new PushContextParams();
//		contextParams.setContext("测试用例context");
//		contextParams.setMessage_id(1);
//		List<DocumentItem<PushContextParams>> contextdataList=new ArrayList<DocumentItem<PushContextParams>>();
//		DocumentItem<PushContextParams> contextitem=new DocumentItem<PushContextParams>();
//		contextitem.setIndexDO(contextParams);
//		contextitem.setCmd("ADD");
//		contextdataList.add(contextitem);
//		try {
//			result=pushDocContext(contextdataList);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println(result);
	}
}
