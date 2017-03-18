package opensearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class DocProductUtils {

	 final static Log logger = LogFactory.getLog(DocProductUtils.class);

	    public static String strFliter(String instr) {
	        String[] filter = { "<em>", "</em>" };
	        String todo = instr;
	        for (String fstr : filter) {
	            while (todo.indexOf(fstr) > 0) {
	                int pos = todo.indexOf(fstr);
	                if (pos >= 0) {
	                    int len = fstr.length();
	                    todo = todo.substring(0, pos) + todo.substring(pos + len, todo.length());
	                }
	            }
	        }
	        return todo;
	    }

	    /**
	     * 查询数据转换成json格式
	     * 
	     * @param <T>
	     * @param opt 操作类型
	     * @param datalist 数据
	     * @return String json格式
	     */
	    public static <T> String getIndexDataJson(String opt, List<T> datalist) {
	        JSONArray arr = new JSONArray();
	        for (T t : datalist) {
	            JSONObject root = new JSONObject();
	            root.element("cmd", opt);
	            JSONObject data = JSONObject.fromObject(t);
	            root.element("fields", data);
	            arr.add(root);
	        }
	        return arr.toString();
	    }

	    public static <T> String getIndexDataJson(List<DocumentItem<T>> dataList) {
	        JSONArray arr = new JSONArray();
	        for (DocumentItem documentItem : dataList) {
	            JSONObject root = new JSONObject();
	            root.element("cmd", documentItem.getCmd());
	            JSONObject data = JSONObject.fromObject(documentItem.getIndexDO());
	            root.element("fields", data);
	            arr.add(root);
	        }

	        return arr.toString();
	    }

	    public static void beanCopyProperties(Object dest, Object orig) {
	        try {
	            BeanUtils.copyProperties(dest, orig);
	        } catch (IllegalAccessException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            logger.error("error message", e);
	        } catch (InvocationTargetException e) {
	            e.printStackTrace();
	            // TODO Auto-generated catch block
	            logger.error("error message", e);
	        }
	    }

	    /*
	     * 判断字符串是否为数字
	     * @param num
	     * @return
	     */
	    public static boolean isNumeric(String num) {
	        num = org.apache.commons.lang.StringUtils.trim(num);
	        Pattern pattern = Pattern.compile("[0-9]*");
	        return pattern.matcher(num).matches();
	    }

	    //test===============================begin=============================================================
	    private static String testPath = "d:\\file\\";

	    public static String loadFileContent(String filename) {
	        File file = new File(testPath + filename);
	        BufferedReader reader = null;
	        StringBuilder stringBuilder = new StringBuilder();
	        try {

	            reader = new BufferedReader(new FileReader(file));
	            String tempString = null;
	            while ((tempString = reader.readLine()) != null) {
	                stringBuilder.append(tempString);
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                }
	            }
	        }
	        return stringBuilder.toString();
	    }

	    /**
	     * 过滤条件
	     * 
	     * @param filterValue
	     */
	    public static Map<String, String> addFilter(String filterValue, Map<String, String> params) {
	        return addFilter(filterValue, null, params);
	    }

	    public static Map<String, String> addFilter(String filterValue, String connecter, Map<String, String> params) {
	        if (StringUtils.isEmpty(connecter)) {
	            connecter = " AND ";
	        }
	        String filterStr = params.get("filter");
	        if (StringUtils.isEmpty(filterStr)) {
	            params.put("filter", filterValue);
	        } else {
	            params.put("filter", filterStr + connecter + filterValue);
	        }
	        return params;
	    }

	    /**
	     * 高级搜索关键字
	     * 
	     * @param cqValue 例如 ：userName:强良
	     */
	    public static Map<String, String> addCq(String cqValue, Map<String, String> params) {
	        return addCq(cqValue, null, params);
	    }

	    public static Map<String, String> addCq(String cqValue, String connecter, Map<String, String> params) {
	        if (StringUtils.isEmpty(connecter)) {
	            connecter = " AND ";
	        }
	        String cqStr = params.get("cq");
	        if (StringUtils.isEmpty(cqStr)) {
	            params.put("cq", cqValue);
	        } else {
	            params.put("cq", cqStr + connecter + cqValue);
	        }
	        return params;
	    }

	    public static void main(String[] args) {

	        Map<String, String> params = new HashMap<String, String>();
	        addCq("id:':2013-01-06-19-57-19-367047-ba7dfe4c-8c16-4842-9eb7-0956841d6046-0'", params);
	        addCq("name:':William.jiang'", params);
	        System.out.println(params);

	    }
}
