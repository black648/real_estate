package com.real_estate.global.result;

import lombok.Getter;

import java.util.List;

@Getter
public class ResultSet {

    public static ResultAPI resultData(Object object) {
        ResultAPI resultAPI = new ResultAPI();
        resultAPI.setObject(ResultType.resultData(object));

        return resultAPI;
    }

    public static ResultAPI resultList(List<?> list) {
        return resultList(list, null);
    }

    public static ResultAPI resultList(List<?> list, Long listCount) {
        ResultAPI resultApi = new ResultAPI();
        resultApi.setObject(ResultType.resultList(list, listCount));

        return resultApi;
    }
}