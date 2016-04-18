package com.tl.test.demos.kafka;

import kafka.admin.AdminUtils;
import kafka.utils.ZKStringSerializer$;
import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.lang.StringUtils;

import java.util.Properties;

/**
 * Created by tanglin on 16/4/11.
 */
public class TopicUtil {

    public static String createTopic(ZkClient zkClient, String zkAddr, String topic, Integer partition, Integer replica,Integer retention){
        if(StringUtils.isBlank(zkAddr) || StringUtils.isBlank(topic) || partition==null || replica == null || retention ==null){
            return "集群或topic或partition数或replica数或topic数据保留时间为空";
        }

        try{
            if (AdminUtils.topicExists(zkClient, topic)) {
                return "Topic已存在集群中";
            } else {
                long retentionMs = retention * 3600000;
                Properties topicProp = new Properties();
                topicProp.setProperty("retention.ms",String.valueOf(retentionMs));
                AdminUtils.createTopic(zkClient, topic, partition, replica, topicProp);
            }
            return "success";
        }finally {
            zkClient.close();
        }
    }

}
