package org.akka.actor;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import utils.HttpClientUtil;

import java.util.HashMap;
import java.util.Map;

public class helloActor extends UntypedActor {

    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    @Override
    public void onReceive(Object msg) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("$orderby","SiteName");
        paramMap.put("$skip","0");
        paramMap.put("$top","1000");
        paramMap.put("format","json");
        Map<String, String> headerMap = new HashMap<String, String>();
        String url = "http://opendata.epa.gov.tw/webapi/Data/REWIQA/?$orderby=SiteName&$skip=0&$top=1000&format=json";
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        String getResult = httpClientUtil.doGet(url, headerMap, paramMap);
        log.info(getResult);
//        accessAPI(url,paramMap,headerMap);

        log.info("  helloActor 運行完成 !!!!!");
    }

//    public String accessAPI(String url , Map<String, Object> paramMap , Map<String, String> headerMap) {
//        HttpClientUtil httpClientUtil = new HttpClientUtil();
//        String getResult = httpClientUtil.doGet(url, headerMap, paramMap);
//
//        return getResult;
//    }

}
