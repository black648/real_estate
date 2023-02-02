package com.real_estate.global.result;

import com.real_estate.global.constants.Constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultType {
    public static Map<String, Object> resultList(List<?> list, Long listCount) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put(Constants.RESULT_LIST, list);
        resultMap.put(Constants.RESULT_DATA, listCount);

        return resultMap;
    }

    public static Map<String, Object> resultData(Object object) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put(Constants.RESULT_DATA, object);

        return resultMap;
    }
}