package com.chngenesis.nebula.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONObject;
import org.json.XML;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class JsonUtils {

	private static Gson gson = null;
	static {
		if (gson == null) {
			gson = new Gson();
		}
	}

	private JsonUtils() {
	}

	/**
	 * 将object对象转成json字符串
	 * 
	 * @param object
	 * @return
	 */
	public static String GsonString(Object object) {
		String gsonString = null;
		if (gson != null) {
			gsonString = gson.toJson(object);
		}
		return gsonString;
	}

	/**
	 * 将json转换为对象
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Object fromJson(String json, @SuppressWarnings("rawtypes") Class clazz) {
		return gson.fromJson(json, clazz);
	}

	/**
	 * json to xml
	 * 
	 * @param json
	 * @return
	 */
	public static String json2xml(String json) {
		JSONObject jsonObj = new JSONObject(json);
		return "<xml>" + XML.toString(jsonObj) + "</xml>";
	}

	/**
	 * xml to json
	 * 
	 * @param xml
	 * @return
	 */
	public static String xml2json(String xml) {
		JSONObject xmlJSONObj = XML.toJSONObject(xml.replace("<xml>", "").replace("</xml>", ""));
		return xmlJSONObj.toString();
	}

	/**
	 * 获取JsonObject
	 * 
	 * @param json
	 * @return
	 */
	public static JsonObject parseJson(String json) {
		JsonParser parser = new JsonParser();
		JsonObject jsonObj = parser.parse(json).getAsJsonObject();
		return jsonObj;
	}

	/**
	 * 依据json字符串返回Map对象
	 * 
	 * @param json
	 * @return
	 */
	public static Map<String, Object> toMap(String json) {
		return new Gson().fromJson(json, new TypeToken<HashMap<String, Object>>() {
		}.getType());
		// return JsonUtils.toMap(JsonUtils.parseJson(json));
	}

	/**
	 * 将JSONObjec对象转换成Map-List集合
	 * 
	 * @param json
	 * @return
	 */
	public static Map<String, Object> toMap(JsonObject json) {
		Map<String, Object> map = new HashMap<String, Object>();
		Set<Entry<String, JsonElement>> entrySet = json.entrySet();
		for (Iterator<Entry<String, JsonElement>> iter = entrySet.iterator(); iter.hasNext();) {
			Entry<String, JsonElement> entry = iter.next();
			String key = entry.getKey();
			Object value = entry.getValue();
			if (value instanceof JsonArray)
				map.put((String) key, toList((JsonArray) value));
			else if (value instanceof JsonObject)
				map.put((String) key, toMap((JsonObject) value));
			else
				map.put((String) key, value);
		}
		return map;
	}

	/**
	 * 将JSONArray对象转换成List集合
	 * 
	 * @param json
	 * @return
	 */
	public static List<Object> toList(JsonArray json) {
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < json.size(); i++) {
			Object value = json.get(i);
			if (value instanceof JsonArray) {
				list.add(toList((JsonArray) value));
			} else if (value instanceof JsonObject) {
				list.add(toMap((JsonObject) value));
			} else {
				list.add(value);
			}
		}
		return list;
	}

	/**
	 * @author I321533
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> jsonToList(String json, Class<T[]> clazz) {
		T[] array = gson.fromJson(json, clazz);
		return Arrays.asList(array);
	}

	/**
	 * @author I321533
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T[] jsonToArry(String json, Class<T[]> clazz) {
		Gson gson = new Gson();
		T[] array = gson.fromJson(json, clazz);
		return array;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		map.put("k1", "v1");
		map.put("k2", "v2");
		List<String> a = new ArrayList<>();
		a.add("1");
		a.add("2");
		a.add("3");
		map.put("list", a);
		String gsonString = GsonString(map);
		System.out.println(gsonString);
		Map<String, Object> jsonMap = toMap(gsonString);
		System.out.println(((List<String>) jsonMap.get("list")).get(0));
	}
}
