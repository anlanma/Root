package com.tl.test.ssh;

import org.apache.commons.exec.*;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by tanglin on 16/4/18.
 * commons.exec vs RuntimeProcess —— 是对RuntimeProcess的良好封装，提供超时等功能
 * commons.exec vs jsch —— jsch是ssh到远程服务器，commons.exec则是在本地执行
 */
public class ExecuteTest {

    @Test
    public void testExecutor(){
//        String command = "sh /Users/tanglin/softwares/apache-tomcat-7.0.67/bin/startup.sh";
        String command = "sh /Users/tanglin/softwares/apache-tomcat-7.0.67/bin/shutdown.sh";
//        String command = "sh /Users/tanglin/Downloads/hdfs-checker-1.3/bin/startup.sh";
        CommandLine cmdLine = CommandLine.parse(command);

        //使用ExecuteResultHandler进行异步处理
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

        ExecuteWatchdog watchdog = new ExecuteWatchdog(1000);
        Executor executor = new DefaultExecutor();
//        executor.setExitValue(1);
        executor.setWatchdog(watchdog);
        try {
            executor.execute(cmdLine, resultHandler);
            // some time later the result handler callback was invoked so we
            // can safely request the exit value
            resultHandler.waitFor();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    /**
     * 执行有返回结果的命令
     */
    @Test
    public void testTail() {
        //构建命令
        CommandLine cmdLine = new CommandLine("tail");
        cmdLine.addArgument("-f");
        cmdLine.addArgument("${file}");
        HashMap map = new HashMap();
        map.put("file", new File("/app/agent-manager/logs/manager.log"));
        cmdLine.setSubstitutionMap(map);

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ByteArrayOutputStream errorStream = new ByteArrayOutputStream();

            //进行执行体

            DefaultExecutor exec= new DefaultExecutor();
            exec.setExitValues(null);

            //利用监视狗来设置超时
            ExecuteWatchdog watchdog = new ExecuteWatchdog(10000);
            exec.setWatchdog(watchdog);

            PumpStreamHandler streamHandler = new PumpStreamHandler(
                    outputStream,errorStream);

            exec.setStreamHandler(streamHandler);
            exec.execute(cmdLine);//执行

            String out =outputStream.toString("utf-8");
            String error =errorStream.toString("utf-8");

            System.out.println(out);

            System.err.println(error);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
