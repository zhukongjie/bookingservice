package com.alibaba.uglymonkey.constant.shard;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by jack on 2018/3/21.
 */
@XmlType(name = "AckCodeType")
@XmlEnum
public enum AckCodeType {

    /**
     * (out) Request processing succeeded
     */
    @XmlEnumValue("Success")
    Success(0, "Success"),

    /**
     * (out) Request processing failed
     */
    @XmlEnumValue("Failure")
    Failure(1, "Failure"),

    /**
     * (out) Request processing completed with warning information being included in the response message
     */
    @XmlEnumValue("Warning")
    Warning(2, "Warning"),

    /**
     * (out) Request processing completed with warning information being included in the response message
     */
    @XmlEnumValue("PartialFailure")
    PartialFailure(3, "PartialFailure");

    private final int intValue;
    private final String value;

    AckCodeType(int intValue, String value) {
        this.intValue = intValue;
        this.value = value;
    }

    /**
     * Get the integer value of this enum value, as defined in the Baiji IDL.
     */
    public int getValue() {
        return intValue;
    }

    @JsonValue
    public String value() {
        return value;
    }

    /**
     * Get the integer value of this enum value, as defined in the Baiji IDL.
     */
    public static AckCodeType findByValue(int value) {
        switch (value) {
            case 0:
                return Success;
            case 1:
                return Failure;
            case 2:
                return Warning;
            case 3:
                return PartialFailure;
            default:
                return null;
        }
    }

    @JsonCreator
    public static AckCodeType fromValue(String v) {
        for (AckCodeType c: AckCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}