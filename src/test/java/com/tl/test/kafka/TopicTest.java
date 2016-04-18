package com.tl.test.kafka;

import kafka.admin.AdminUtils;
import kafka.utils.ZKStringSerializer$;
import org.I0Itec.zkclient.ZkClient;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by tanglin on 16/4/11.
 */
public class TopicTest {
    private static String zkAddr;
    private static ZkClient zkClient;

    @BeforeClass
    public void init(){
        zkClient = new ZkClient(zkAddr,10000,1000, ZKStringSerializer$.MODULE$);

    }

    @Test
    public void delete(){
        String topicToDelete = "";
        AdminUtils.deleteTopic(zkClient,topicToDelete);
    }


}
