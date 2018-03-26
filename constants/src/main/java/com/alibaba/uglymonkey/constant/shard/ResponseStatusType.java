package com.alibaba.uglymonkey.constant.shard;

import com.alibaba.uglymonkey.constant.shard.exception.LogicException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by jack on 2018/3/21.
 */
public class ResponseStatusType {

    /**
     * This value represents the date and time when a Baiji service processed the request.
     * The value of this element is set by framework automatically, value set by service implementation will be overwritten.
     */
    @XmlElement(name = "Timestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    @JsonProperty("Timestamp")
    public Calendar timestamp;


    /**
     * Indicates whether the call was successfully processed by Baiji.
     */
    @XmlElement(name = "Ack", required = true)
    @JsonProperty("Ack")
    public AckCodeType ack;


    /**
     * A list of framework, validation or service-level errors or warnings (if any)
     * that were raised when a Baiji service processed the request.
     * Only returned if there were warnings or errors.
     */
    @XmlElement(name = "Errors")
    @JsonProperty("Errors")
    public List<ErrorDataType> errors;


    /**
     * This refers to the particular software build that Baiji service used
     * when processing the request and generating the response.
     * This includes the version number plus additional information.
     */
    @XmlElement(name = "Build")
    @JsonProperty("Build")
    public String build;


    /**
     * The version of service used to process the request.
     */
    @XmlElement(name = "Version")
    @JsonProperty("Version")
    public String version;


    /**
     * Reserved for future extension.
     */
    @XmlElement(name = "Extension")
    @JsonProperty("Extension")
    public List<ExtensionType> extension;

    /**
     * This value represents the date and time when a Baiji service processed the request.
     * The value of this element is set by framework automatically, value set by service implementation will be overwritten.
     */
    public Calendar getTimestamp() {
        return timestamp;
    }

    /**
     * This value represents the date and time when a Baiji service processed the request.
     * The value of this element is set by framework automatically, value set by service implementation will be overwritten.
     */
    public void setTimestamp(final Calendar timestamp) {
        this.timestamp = timestamp;
    }


    /**
     * Indicates whether the call was successfully processed by Baiji.
     */
    public AckCodeType getAck() {
        return ack;
    }

    /**
     * Indicates whether the call was successfully processed by Baiji.
     */
    public void setAck(final AckCodeType ack) {
        this.ack = ack;
    }


    /**
     * A list of framework, validation or service-level errors or warnings (if any)
     * that were raised when a Baiji service processed the request.
     * Only returned if there were warnings or errors.
     */
    public List<ErrorDataType> getErrors() {
        if (errors == null) {
            errors = new ArrayList<ErrorDataType>();
        }
        return errors;
    }

    /**
     * A list of framework, validation or service-level errors or warnings (if any)
     * that were raised when a Baiji service processed the request.
     * Only returned if there were warnings or errors.
     */
    public void setErrors(final List<ErrorDataType> errors) {
        this.errors = errors;
    }


    /**
     * This refers to the particular software build that Baiji service used
     * when processing the request and generating the response.
     * This includes the version number plus additional information.
     */
    public String getBuild() {
        return build;
    }

    /**
     * This refers to the particular software build that Baiji service used
     * when processing the request and generating the response.
     * This includes the version number plus additional information.
     */
    public void setBuild(final String build) {
        this.build = build;
    }


    /**
     * The version of service used to process the request.
     */
    public String getVersion() {
        return version;
    }

    /**
     * The version of service used to process the request.
     */
    public void setVersion(final String version) {
        this.version = version;
    }


    /**
     * Reserved for future extension.
     */
    public List<ExtensionType> getExtension() {
        if (extension == null) {
            extension = new ArrayList<ExtensionType>();
        }
        return extension;
    }

    /**
     * Reserved for future extension.
     */
    public void setExtension(final List<ExtensionType> extension) {
        this.extension = extension;
    }

    // Used by DatumWriter. Applications should not call.
    public Object get(int fieldPos) throws LogicException {
        switch (fieldPos) {
            case 0: return this.timestamp;
            case 1: return this.ack;
            case 2: return this.errors;
            case 3: return this.build;
            case 4: return this.version;
            case 5: return this.extension;
            default: throw new LogicException("Bad index " + fieldPos + " in get()");
        }
    }

    // Used by DatumReader. Applications should not call.
    @SuppressWarnings(value="unchecked")
    public void put(int fieldPos, Object fieldValue) throws LogicException {
        switch (fieldPos) {
            case 0: this.timestamp = (Calendar)fieldValue; break;
            case 1: this.ack = (AckCodeType)fieldValue; break;
            case 2: this.errors = (List<ErrorDataType>)fieldValue; break;
            case 3: this.build = (String)fieldValue; break;
            case 4: this.version = (String)fieldValue; break;
            case 5: this.extension = (List<ExtensionType>)fieldValue; break;
            default: throw new LogicException("Bad index " + fieldPos + " in put()");
        }
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        final ResponseStatusType other = (ResponseStatusType)obj;
        return
                Objects.equal(this.timestamp, other.timestamp) &&
                        Objects.equal(this.ack, other.ack) &&
                        Objects.equal(this.errors, other.errors) &&
                        Objects.equal(this.build, other.build) &&
                        Objects.equal(this.version, other.version) &&
                        Objects.equal(this.extension, other.extension);
    }

    @Override
    public int hashCode() {
        int result = 1;

        result = 31 * result + (this.timestamp == null ? 0 : this.timestamp.hashCode());
        result = 31 * result + (this.ack == null ? 0 : this.ack.hashCode());
        result = 31 * result + (this.errors == null ? 0 : this.errors.hashCode());
        result = 31 * result + (this.build == null ? 0 : this.build.hashCode());
        result = 31 * result + (this.version == null ? 0 : this.version.hashCode());
        result = 31 * result + (this.extension == null ? 0 : this.extension.hashCode());

        return result;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("timestamp", timestamp)
                .add("ack", ack)
                .add("errors", errors)
                .add("build", build)
                .add("version", version)
                .add("extension", extension)
                .toString();
    }
}
