package com.alibaba.spring.utils.logger;

/**
 * Created by jack on 2018/3/18.
 */
public class LoggerManager {


    /**
     * //
     // Source code recreated from a .class file by IntelliJ IDEA
     // (powered by Fernflower decompiler)
     //

     package com.ctrip.framework.clogging.agent.log;

     import com.ctrip.framework.clogging.agent.log.ILog;
     import com.ctrip.framework.clogging.agent.log.impl.CLoggingLogger;
     import java.util.concurrent.ConcurrentHashMap;
     import org.apache.commons.lang.StringUtils;

     public class LogManager {
     private static ConcurrentHashMap<String, ILog> _loggers = new ConcurrentHashMap();

     private LogManager() {
     }

     public static ILog getLogger(Class<?> type) {
     return type == null?getLogger("defaultLogger"):getLogger(type.getName());
     }

     public static ILog getLogger(String name) {
     String loggerName = name;
     if(StringUtils.isBlank(name)) {
     loggerName = "defaultLogger";
     }

     Object logger = (ILog)_loggers.get(loggerName);
     if(logger == null) {
     CLoggingLogger newLogger = new CLoggingLogger(loggerName);
     logger = (ILog)_loggers.putIfAbsent(loggerName, newLogger);
     if(logger == null) {
     logger = newLogger;
     }
     }

     return (ILog)logger;
     }
     }

     */
}
