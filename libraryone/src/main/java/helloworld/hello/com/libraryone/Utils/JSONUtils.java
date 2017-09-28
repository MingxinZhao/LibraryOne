package helloworld.hello.com.libraryone.Utils;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 
 * JSON 工具类
 **
 */
public class JSONUtils {
	
	/**
	 * 把JSON对象转换为bean对象
	 * <p>
	 * 注意:对象类型现在处理的都是String类型，如果有其他类型还需要处理
	 * 
	 * @param clazz
	 * @param jsonObject
	 * @return
	 */
	public static <T> T jsonObjectToBean(Class<T> clazz, JSONObject jsonObject) {
		T entity = null;
		try {
			entity = clazz.newInstance();
			for (Field field : clazz.getDeclaredFields()) {
				String fieldName = field.getName();
				if (Modifier.isStatic(field.getModifiers())) {
					continue;
				}
				if (TextUtils.isEmpty(fieldName)) {
					continue;
				}
				if ("serialVersionUID".equals(fieldName)) {
					continue;
				}
				if ("this".indexOf(fieldName) != -1) {
					continue;
				}
				field.setAccessible(true);
				Class<?> fieldType = field.getType();
				if ((Integer.TYPE == fieldType) || (Integer.class == fieldType)) {
					// Integer value=getJSONString(jsonObject,
					// fieldName)==""?0:Integer.valueOf(getJSONString(jsonObject,
					// fieldName));
					Integer value;
					if (getJSONString(jsonObject, fieldName).equalsIgnoreCase(
							"")) {
						value = 0;
					} else {
						value = Integer.valueOf(getJSONString(jsonObject,
								fieldName));
					}
					field.set(entity, value);
				} else if ((Long.TYPE == fieldType)
						|| (Long.class == fieldType)) {
					String valuestr = getJSONString(jsonObject, fieldName);
					Long value;
					if (valuestr.equalsIgnoreCase("")) {
						value = 0L;
					} else {
						value = Long.valueOf(getJSONString(jsonObject,
								fieldName));
					}
					// Long value=getJSONString(jsonObject,
					// fieldName)==""?0L:Long.valueOf(getJSONString(jsonObject,
					// fieldName));
					field.set(entity, value);
				} else if ((JSONObject.class == fieldType)) {
					field.set(entity, getJSONObject(jsonObject, fieldName));
				} else if ((JSONArray.class == fieldType)) {
					field.set(entity, getJSONArray(jsonObject, fieldName));
				} else {
					String value = getJSONString(jsonObject, fieldName);
					field.set(entity, value);
				}
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return entity;
	}
	public static <T> T jsonObjectToBean(Class<T> clazz, String json) {
		T entity = null;
		try {
			JSONObject jsonObject = new JSONObject(json);
			entity = clazz.newInstance();
			for (Field field : clazz.getDeclaredFields()) {
				String fieldName = field.getName();
				if (Modifier.isStatic(field.getModifiers())) {
					continue;
				}
				if (TextUtils.isEmpty(fieldName)) {
					continue;
				}
				if ("serialVersionUID".equals(fieldName)) {
					continue;
				}
				if ("this".indexOf(fieldName) != -1) {
					continue;
				}
				field.setAccessible(true);
				Class<?> fieldType = field.getType();
				if ((Integer.TYPE == fieldType) || (Integer.class == fieldType)) {
					// Integer value=getJSONString(jsonObject,
					// fieldName)==""?0:Integer.valueOf(getJSONString(jsonObject,
					// fieldName));
					Integer value;
					if (getJSONString(jsonObject, fieldName).equalsIgnoreCase(
							"")) {
						value = 0;
					} else {
						value = Integer.valueOf(getJSONString(jsonObject,
								fieldName));
					}
					field.set(entity, value);
				} else if ((Long.TYPE == fieldType)
						|| (Long.class == fieldType)) {
					String valuestr = getJSONString(jsonObject, fieldName);
					Long value;
					if (valuestr.equalsIgnoreCase("")) {
						value = 0L;
					} else {
						value = Long.valueOf(getJSONString(jsonObject,
								fieldName));
					}
					// Long value=getJSONString(jsonObject,
					// fieldName)==""?0L:Long.valueOf(getJSONString(jsonObject,
					// fieldName));
					field.set(entity, value);
				} else if ((JSONObject.class == fieldType)) {
					field.set(entity, getJSONObject(jsonObject, fieldName));
				} else if ((JSONArray.class == fieldType)) {
					field.set(entity, getJSONArray(jsonObject, fieldName));
				} else {
					String value = getJSONString(jsonObject, fieldName);
					field.set(entity, value);
				}
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return entity;
	}
	public static <T> T jsonObjectToBean(Class<T> clazz, JSONObject json,String nodeName) {
		T entity = null;
		try {
			JSONObject jsonObject = json.getJSONObject(nodeName);
			entity = clazz.newInstance();
			for (Field field : clazz.getDeclaredFields()) {
				String fieldName = field.getName();
				if (Modifier.isStatic(field.getModifiers())) {
					continue;
				}
				if (TextUtils.isEmpty(fieldName)) {
					continue;
				}
				if ("serialVersionUID".equals(fieldName)) {
					continue;
				}
				if ("this".indexOf(fieldName) != -1) {
					continue;
				}
				field.setAccessible(true);
				Class<?> fieldType = field.getType();
				if ((Integer.TYPE == fieldType) || (Integer.class == fieldType)) {
					// Integer value=getJSONString(jsonObject,
					// fieldName)==""?0:Integer.valueOf(getJSONString(jsonObject,
					// fieldName));
					Integer value;
					if (getJSONString(jsonObject, fieldName).equalsIgnoreCase(
							"")) {
						value = 0;
					} else {
						value = Integer.valueOf(getJSONString(jsonObject,
								fieldName));
					}
					field.set(entity, value);
				} else if ((Long.TYPE == fieldType)
						|| (Long.class == fieldType)) {
					String valuestr = getJSONString(jsonObject, fieldName);
					Long value;
					if (valuestr.equalsIgnoreCase("")) {
						value = 0L;
					} else {
						value = Long.valueOf(getJSONString(jsonObject,
								fieldName));
					}
					// Long value=getJSONString(jsonObject,
					// fieldName)==""?0L:Long.valueOf(getJSONString(jsonObject,
					// fieldName));
					field.set(entity, value);
				} else if ((JSONObject.class == fieldType)) {
					field.set(entity, getJSONObject(jsonObject, fieldName));
				} else if ((JSONArray.class == fieldType)) {
					field.set(entity, getJSONArray(jsonObject, fieldName));
				} else {
					String value = getJSONString(jsonObject, fieldName);
					field.set(entity, value);
				}
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return entity;
	}
	/**
	 * json节点转换为jsonObject
	 * 
	 * @param jsonObject
	 * @param nodeName
	 * @return
	 */
	private static JSONObject getJSONObject(JSONObject jsonObject,
                                            String nodeName) {
		if (jsonObject.isNull(nodeName)) {
			return null;
		} else {
			try {
				return jsonObject.getJSONObject(nodeName);
			} catch (JSONException e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	/**
	 * json节点转换为jsonArray
	 * 
	 * @param jsonObject
	 * @param nodeName
	 * @return
	 */
	private static JSONArray getJSONArray(JSONObject jsonObject, String nodeName) {
		if (jsonObject.isNull(nodeName)) {
			return null;
		} else {
			try {
				return jsonObject.getJSONArray(nodeName);
			} catch (JSONException e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	/**
	 * 获取JOSN对象对应节点字符串
	 * 
	 * @param jsonObject
	 * @param nodeName
	 * @return
	 */
	public static String getJSONString(JSONObject jsonObject, String nodeName) {
		if (jsonObject.isNull(nodeName)) {
			return "";
		} else {
			try {
				return jsonObject.getString(nodeName);
			} catch (JSONException e) {
				e.printStackTrace();
				return "";
			}
		}
	}

	/**
	 * 将JsonArray转换成ArrayList
	 * 
	 * @param array
	 * @return
	 */
	public static ArrayList<String> parseToArrayList(JSONArray array) {
		if (array == null) {
			return null;
		}

		int len = array.length();
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < len; i++) {
			list.add(array.optString(i));
		}

		return list;
	}

	/**
	 * jsonArray 字符串转换为 ArrayList
	 * 
	 * @param jsonString
	 * @return
	 */
	public static ArrayList<String> jsonArrayStringToStringArray(
			String jsonString) {
		if (!TextUtils.isEmpty(jsonString)) {
			try {
				JSONArray array = new JSONArray(jsonString);
				return parseToArrayList(array);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new ArrayList<String>();
	}

	/**
	 * jsonarray 转换为list bean
	 * 
	 * @param clazz
	 * @param jsonArray
	 * @return
	 */
	public static <T> List<T> jsonArrayToListBean(Class<T> clazz, JSONArray jsonArray) {
		List<T> list = new ArrayList<T>();
		for (int index = 0; index < jsonArray.length(); index++) {
			try {
				T t = jsonObjectToBean(clazz, jsonArray.getJSONObject(index));
				list.add(t);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * 将json 数组转换为Map 对象
	 * 
	 * @return
	 */
	public static Map<String, Object> getMap(JSONObject jsonObject) {
		try {
			// jsonObject = new JSONObject(jsonString);
			// @SuppressWarnings("unchecked")
			Iterator<String> keyIter = jsonObject.keys();
			String key;
			Object value;
			Map<String, Object> valueMap = new HashMap<String, Object>();
			while (keyIter.hasNext()) {
				key = (String) keyIter.next();
				value = jsonObject.get(key);
				valueMap.put(key, value);
			}
			return valueMap;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> List<Map<String, T>> parseJSON2List(JSONArray jsonArray) {
		// JSONArray jsonArr = JSONArray.fromObject(jsonStr);
		List<Map<String, T>> list = new ArrayList<Map<String, T>>();
		for (int index = 0; index < jsonArray.length(); index++) {
			try {
				JSONObject jsonObject = jsonArray.getJSONObject(index);
				Map<String, T> map = (Map<String, T>) getMap(jsonObject);
				list.add(map);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return list;
	}


	/**
	 * jsonarray 转换为list bean
	 * 
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> jsonArrayToListBean(Class<T> clazz,
                                                  String jsonString) {
		List<T> list = new ArrayList<T>();
		JSONArray jsonArray;
		try {
			jsonArray = new JSONArray(jsonString);
			for (int index = 0; index < jsonArray.length(); index++) {
				try {
					T t = jsonObjectToBean(clazz,
							jsonArray.getJSONObject(index));
					list.add(t);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		return list;
	}

}
