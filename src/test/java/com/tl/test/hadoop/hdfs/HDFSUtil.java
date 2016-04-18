package com.tl.test.hadoop.hdfs;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.*;

/**
 * Created by tanglin on 16/3/7.
 */
public class HDFSUtil {
    private static final Logger logger = LoggerFactory.getLogger(HDFSUtil.class);

    private Set<Path> sucParentPath = new HashSet<Path>();

    private static final String URI = "hdfs://10.0.53.81:9000";
    private static String startTime = "/2016/03/24/00/";
    private static String endTime = "/2016/03/24/23/";
    private static String prefixPath = "/tl";

    private static FileSystem fs;
    private static String[] formats = {"/yyyy/MM/dd/HH/", "/yyyy/MM/dd/HH/mm/", "/yyyy/MM/dd/"};//String -> long
    private static FastDateFormat fastDateFormat;//long -> String
    private static long ONE_MINUTE = 60 * 1000;
    private static long ONE_HOUR = 60 * 60 * 1000;
    private static long ONE_DAY = 60 * 60 * 1000 * 24;
    private static long timeUnit;
    private static int calenderTimeUnit;

    private static String timeType = "H";//1:小时粒度，2:分钟粒度
    private static String DAY = "D";
    private static String HOUR = "H";
    private static String MINUTE = "M";
    private static String sucFileName = "/_SUCCESS";


    @BeforeClass
    public static void init() {
        try {
            fs = FileSystem.get(new URI(URI), new Configuration());
            logger.info("FileSystem create successfully.");
        } catch (IOException e) {
            logger.error("FileSystem create fail.", e);
        } catch (URISyntaxException e) {
            logger.error("Uri error", e);
        }
        if (StringUtils.equals(timeType, HOUR)) {
            timeUnit = ONE_HOUR;
            calenderTimeUnit = Calendar.HOUR_OF_DAY;
            fastDateFormat = FastDateFormat.getInstance(formats[0]);
        } else if (StringUtils.equals(timeType, MINUTE)) {
            timeUnit = ONE_MINUTE;
            calenderTimeUnit = Calendar.MINUTE;
            fastDateFormat = FastDateFormat.getInstance(formats[1]);
        } else if (StringUtils.equals(timeType, DAY)) {
            timeUnit = ONE_DAY;
            calenderTimeUnit = Calendar.DAY_OF_MONTH;
            fastDateFormat = FastDateFormat.getInstance(formats[2]);
        } else {
            logger.error("Param timeType error,timeType:" + timeType);
        }
    }

    @Test
    public void recover() {
        String pathToRecover = "";
        boolean result = false;
        try {
            result = ((DistributedFileSystem) fs).recoverLease(new Path(pathToRecover));
            System.out.println("result:" + result);
        } catch (Exception e) {
            logger.error("Recover file error, path:" + pathToRecover, e);
        }
    }

    @Test
    public void batchCreateDir() {
        //String -> long
        long start = 0;
        long end = 0;
        try {
            start = DateUtils.parseDate(startTime, formats).getTime();
            end = DateUtils.parseDate(endTime, formats).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //计算目录的个数，即check文件的个数
        long count = (end - start) / timeUnit;
        logger.info("Count:" + count);

        Path path = null;
        //检查每个路径下是否存在check文件
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(start);
        for (int i = 0; i < count; i++) {
            cal.add(calenderTimeUnit, 1);
            String dataPath = fastDateFormat.format(cal.getTimeInMillis());
            path = new Path(prefixPath + dataPath);
            try {
                if (!fs.exists(path)) {
                    fs.mkdirs(path);
                    logger.info("Path:" + path + " created.");
                }
            } catch (IOException e) {
                logger.error("Create path:" + path + " fail.", e);
            }
        }

    }

    @Test
    public void testCreateDir() {
        try {
            Path path = new Path("/tl/2016/03/24");
            fs.mkdirs(path);
            logger.info("Path:" + path + " created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete() {
        String[] pathsToDelete = new String[]{"/swan"};
        try {
            for (String path : pathsToDelete) {
                boolean result = fs.delete(new Path(path), true);
                Assert.assertEquals(true, result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void rename() {
        String srcPath = "/tl/newBinlog5";
        String destPath = "/tl/recoverPath";
        try {
            boolean result = fs.rename(new Path(srcPath), new Path(destPath));
            Assert.assertEquals(true, result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //自己实现的递归遍历
    public void findSucParentPath(FileSystem fs, FileStatus fileStatus) {
        try {
            Path path = fileStatus.getPath();
            if (!fileStatus.isDirectory()) {
                Path sucParent = path.getParent();
                if (!sucParentPath.contains(sucParent)) {
                    sucParentPath.add(sucParent);
                    System.out.println("Add path:" + sucParent);
                    String sucFilePath = sucParent.toString() + "/" + sucFileName;
                    if (!fs.exists(new Path(sucFilePath))) {
                        System.out.println(sucFilePath + " not exist.");
                    } else {
                        System.out.println(sucFilePath + " exist.");
                    }
                }
            } else {

                FileStatus[] stats = fs.listStatus(path);
                for (FileStatus s : stats) {
                    findSucParentPath(fs, s);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFileMatch() {
        try {
            //列出匹配路径下的所有文件或路径
            //如需列出叶子节点文件则层级必须给出到文件层
            FileStatus[] status = fs.globStatus(new Path("/tl/*/*/24/*/*"));
            for (FileStatus s : status) {
                System.out.println(s.getPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListFile() {
        try {
            //listFiles,true可以列出叶子节点文件
            RemoteIterator<LocatedFileStatus> statuses = fs.listFiles(new Path("/tl"), true);//不支持/tl/*
            while (statuses.hasNext()) {
                System.out.println(statuses.next().getPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDepth() {
        try {
            String root = "/logAdded/binlog2hdfs_test_yhg/blazer/passenger_tickets/2016-03-06/22/53";
            Path rootPath = new Path(root);
            FileStatus[] statuses = fs.listStatus(rootPath);
            for (FileStatus status : statuses) {
                System.out.println("Path:" + status.getPath());
                System.out.println("Depth:" + status.getPath().depth());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
