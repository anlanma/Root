package com.tl.demos.java.network;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by tanglin on 2016/1/16.
 */
public class KafkaBrokerConnTest {
    private static Logger logger = Logger.getLogger("connTestLogger");

    public static void main(String[] args) {
        String host = "10.0.53.79";
        int port = 9092;
        connect(host,port);
    }
    public static void connect(String host,int port){
        Socket socket = null;
        Long befor = System.currentTimeMillis();
        try {
            //建立连接
            socket = new Socket(host,port);

            logger.info("Connect "+host+":"+port+" successfully,time used:"+ (System.currentTimeMillis() - befor) + " ms");
        } catch (IOException e) {
            logger.error("Connect "+host+":"+port+" fail,time used:"+ (System.currentTimeMillis() - befor)  + " ms");
            e.printStackTrace();
        }finally {
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
