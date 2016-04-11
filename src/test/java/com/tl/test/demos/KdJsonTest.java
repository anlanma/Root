package com.tl.test.demos;

import com.kuaidadi.framework.util.JsonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tanglin on 2016/1/5.
 */
public class KdJsonTest {
    public void testJson(){
        Map<String,Object> agentInfo = new HashMap<String, Object>();

        Map<String,Object> config = new HashMap<String, Object>();

        Map<String,Object> consumer = new HashMap<String, Object>();
        List<Object> list = new ArrayList<Object>();
        Map<String,Object> consumerConf = new HashMap<String, Object>();
        consumerConf.put("String", "String");
        consumerConf.put("int", 1);
        consumerConf.put("long", 2L);
        list.add(consumerConf);
        list.add(consumerConf);
        consumer.put("list",list);

        Map<String,Object> producer = new HashMap<String, Object>();
        producer.put("String","String");
        producer.put("int",1);
        producer.put("long",2L);

        config.put("consumer", consumer);
        config.put("producer",producer);
        config.put("timeout",1000);

        agentInfo.put("name", "agentA");
        agentInfo.put("config", config);
        System.out.println("agentInfo " + JsonUtil.toJson(agentInfo));

        String consumerListStr = "{\"consumerList\":[{\"int\":1,\"String\":\"String\",\"long\":2},{\"int\":1,\"String\":\"String\",\"long\":2}]}";
        Map<String,Object> o = JsonUtil.toObject(consumerListStr,Map.class);
        Object res = o.get("consumerList");
        System.out.println();
    }

}
