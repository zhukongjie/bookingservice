package com.alibaba.spring.utils.logger;

import java.util.Map;

/**
 * Created by jack on 2018/3/17.
 */
public interface ILogger {
    void info(String msg);

    void info(Exception ex);

    void info(String title, String content);

    void info(String title, String content, Map<String, String> tags);

    void info(String title, Exception ex);

    void info(String title, Exception ex,Map<String,String> tags);

    void splitInfo(String title, String content, Map<String, String> tags);

    void warn(String msg);

    void warn(Exception ex);

    void warn(String title, String content);

    void warn(String title, String content, Map<String, String> tags);

    void warn(String title, Exception ex);

    void warn(String title, Exception ex,Map<String,String> tags);

    void error(String msg);

    void error(Exception ex);

    void error(String title, String content);

    void error(String title, String content, Map<String, String> tags);

    void error(String title, Exception ex);

    void error(String title, Exception ex,Map<String,String> tags);

    void debug(String msg);

    void debug(Exception ex);

    void debug(String title, String content);

    void debug(String title, String content, Map<String, String> tags);

    void debug(String title, Exception ex);

    void debug(String title, Exception ex,Map<String,String> tags);
}
