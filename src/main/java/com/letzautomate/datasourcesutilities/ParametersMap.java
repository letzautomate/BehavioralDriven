package com.letzautomate.datasourcesutilities;

import java.util.HashMap;

public class ParametersMap {
	
	public HashMap<String, String> getParamsMap(String params) {
		
		HashMap<String, String> keyValueMap = new HashMap<String, String>();
		String[] paramsArray = params.split("\\|");
		for(String param: paramsArray){
			String[] keyValuePairArray = param.split("=");
			keyValueMap.put(keyValuePairArray[0], keyValuePairArray[1]);
		}
		return keyValueMap;
	}

}
