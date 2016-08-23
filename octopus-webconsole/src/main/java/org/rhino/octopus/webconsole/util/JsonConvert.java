package org.rhino.octopus.webconsole.util;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class JsonConvert {
	
	public static String convertObj(Object obj){
		return JSONObject.fromObject(obj).toString();
	}
	
	public static Object convertJson(String json, JsonConfig config){
		JSONObject jsonObj = JSONObject.fromObject(json);
		return JSONObject.toBean(jsonObj, config);
	}
}
