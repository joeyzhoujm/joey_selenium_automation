package com.joey.auto.test.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Log {
    // Initialize Log4j2 logs
    protected static final Logger logger = LoggerFactory.getLogger(Log.class.getSimpleName());

    //相对路径的配置文件加载
    /* public static void config() {
     *//*  try {
            ConfigurationSource source;

            //方法1  使用getResource()
            *//**//* String path = "/log4j2.xml";
            URL url = Log.class.getResource(path);
            System.out.println(url);
            source = new ConfigurationSource(new FileInputStream(new File(url.getPath())), url);
            Configurator.initialize(null, source);*//**//*

           //方法2 使用System.getProperty
            String config=System.getProperty("user.dir");
            System.out.println(config+"\\log4j2.xml");
            source = new ConfigurationSource(new FileInputStream(config+"\\log4j2.xml"));
            Configurator.initialize(null, source);

            //输出内容
			*//**//*2014-09-01 16:32:19,746 DEBUG [main] test.ConfigTest (ConfigTest.java:53) - debug...
			2014-09-01 16:32:19,746 INFO  [main] test.ConfigTest (ConfigTest.java:54) - info...
			2014-09-01 16:32:19,746 WARN  [main] test.ConfigTest (ConfigTest.java:55) - warn...
			2014-09-01 16:32:19,746 ERROR [main] test.ConfigTest (ConfigTest.java:56) - error...
			2014-09-01 16:32:19,746 FATAL [main] test.ConfigTest (ConfigTest.java:57) - fatal...*//**//*

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*//*

    }*/

    // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
    public static void startTestCase(String sTestCaseName) throws IOException {
        logger.debug("hello world...{}", "How are you");
        logger.info("****************************************************************************************");
        logger.info("****************************************************************************************");
        logger.info("$$$$$$$$$$$$$$$$              " + sTestCaseName + "  Start" + "       $$$$$$$$$$$$$$$$$$$");
        logger.info("****************************************************************************************");
        logger.info("****************************************************************************************");
    }

    //This is to print log for the ending of the test case
    public static void endTestCase(String sTestCaseName) {
        logger.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        logger.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        logger.info("XXXXXXXXXXXXX             " + sTestCaseName + "  End" + "             XXXXXXXXXXXXXXXXXXXX");
        logger.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        logger.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    // Need to create these methods, so that they can be called
    public static void info(String message) {
        logger.info(message);
    }

    public static void warn(String message) {

        logger.warn(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void main(String[] args) {
        try {
            startTestCase(Log.class.getSimpleName());
            endTestCase(Log.class.getSimpleName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.trace("trace Level");
        logger.trace("debug Level");
        logger.trace("info Level");
        logger.trace("warn Level");
        logger.trace("error Level");
        logger.trace("fatal Level");

        logger.error("字符串快捷拼接方式一：{}，该方式比使用加号+拼接字符串速度更快", "logger");
        logger.error("字符串拼接方式二：" + "logger");

    }

}