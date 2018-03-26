package com.alibaba.uglymonkey.constant.shard;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by jack on 2018/3/21.
 */
public class ErrorDataType {
    /**
     * A brief description of the condition that raised the error.
     */
    @XmlElement(name = "Message")
    @JsonProperty("Message")
    public String message;


    /**
     * A unique code that identifies the particular error condition that occurred.
     */
    @XmlElement(name = "ErrorCode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    @JsonProperty("ErrorCode")
    public String errorCode;


    /**
     * StackTrace of exception causing this error, only used in debug mode.
     */
    @XmlElement(name = "StackTrace")
    @JsonProperty("StackTrace")
    public String stackTrace;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }
}
