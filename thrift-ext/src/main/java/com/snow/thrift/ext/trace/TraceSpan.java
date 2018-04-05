/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.snow.thrift.ext.trace;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-04-05")
public class TraceSpan implements org.apache.thrift.TBase<TraceSpan, TraceSpan._Fields>, java.io.Serializable, Cloneable, Comparable<TraceSpan> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Trace");

  private static final org.apache.thrift.protocol.TField TRACE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("traceID", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField CALL_INFO_FIELD_DESC = new org.apache.thrift.protocol.TField("callInfo", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TraceStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TraceTupleSchemeFactory();

  public java.lang.String traceID; // required
  public java.lang.String callInfo; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TRACE_ID((short)1, "traceID"),
    CALL_INFO((short)2, "callInfo");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TRACE_ID
          return TRACE_ID;
        case 2: // CALL_INFO
          return CALL_INFO;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TRACE_ID, new org.apache.thrift.meta_data.FieldMetaData("traceID", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CALL_INFO, new org.apache.thrift.meta_data.FieldMetaData("callInfo", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TraceSpan.class, metaDataMap);
  }

  public TraceSpan() {
  }

  public TraceSpan(
    java.lang.String traceID,
    java.lang.String callInfo)
  {
    this();
    this.traceID = traceID;
    this.callInfo = callInfo;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TraceSpan(TraceSpan other) {
    if (other.isSetTraceID()) {
      this.traceID = other.traceID;
    }
    if (other.isSetCallInfo()) {
      this.callInfo = other.callInfo;
    }
  }

  public TraceSpan deepCopy() {
    return new TraceSpan(this);
  }

  @Override
  public void clear() {
    this.traceID = null;
    this.callInfo = null;
  }

  public java.lang.String getTraceID() {
    return this.traceID;
  }

  public TraceSpan setTraceID(java.lang.String traceID) {
    this.traceID = traceID;
    return this;
  }

  public void unsetTraceID() {
    this.traceID = null;
  }

  /** Returns true if field traceID is set (has been assigned a value) and false otherwise */
  public boolean isSetTraceID() {
    return this.traceID != null;
  }

  public void setTraceIDIsSet(boolean value) {
    if (!value) {
      this.traceID = null;
    }
  }

  public java.lang.String getCallInfo() {
    return this.callInfo;
  }

  public TraceSpan setCallInfo(java.lang.String callInfo) {
    this.callInfo = callInfo;
    return this;
  }

  public void unsetCallInfo() {
    this.callInfo = null;
  }

  /** Returns true if field callInfo is set (has been assigned a value) and false otherwise */
  public boolean isSetCallInfo() {
    return this.callInfo != null;
  }

  public void setCallInfoIsSet(boolean value) {
    if (!value) {
      this.callInfo = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case TRACE_ID:
      if (value == null) {
        unsetTraceID();
      } else {
        setTraceID((java.lang.String)value);
      }
      break;

    case CALL_INFO:
      if (value == null) {
        unsetCallInfo();
      } else {
        setCallInfo((java.lang.String)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case TRACE_ID:
      return getTraceID();

    case CALL_INFO:
      return getCallInfo();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case TRACE_ID:
      return isSetTraceID();
    case CALL_INFO:
      return isSetCallInfo();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof TraceSpan)
      return this.equals((TraceSpan)that);
    return false;
  }

  public boolean equals(TraceSpan that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_traceID = true && this.isSetTraceID();
    boolean that_present_traceID = true && that.isSetTraceID();
    if (this_present_traceID || that_present_traceID) {
      if (!(this_present_traceID && that_present_traceID))
        return false;
      if (!this.traceID.equals(that.traceID))
        return false;
    }

    boolean this_present_callInfo = true && this.isSetCallInfo();
    boolean that_present_callInfo = true && that.isSetCallInfo();
    if (this_present_callInfo || that_present_callInfo) {
      if (!(this_present_callInfo && that_present_callInfo))
        return false;
      if (!this.callInfo.equals(that.callInfo))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetTraceID()) ? 131071 : 524287);
    if (isSetTraceID())
      hashCode = hashCode * 8191 + traceID.hashCode();

    hashCode = hashCode * 8191 + ((isSetCallInfo()) ? 131071 : 524287);
    if (isSetCallInfo())
      hashCode = hashCode * 8191 + callInfo.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TraceSpan other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetTraceID()).compareTo(other.isSetTraceID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTraceID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.traceID, other.traceID);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetCallInfo()).compareTo(other.isSetCallInfo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCallInfo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.callInfo, other.callInfo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("Trace(");
    boolean first = true;

    sb.append("traceID:");
    if (this.traceID == null) {
      sb.append("null");
    } else {
      sb.append(this.traceID);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("callInfo:");
    if (this.callInfo == null) {
      sb.append("null");
    } else {
      sb.append(this.callInfo);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (traceID == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'traceID' was not present! Struct: " + toString());
    }
    if (callInfo == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'callInfo' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TraceStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TraceStandardScheme getScheme() {
      return new TraceStandardScheme();
    }
  }

  private static class TraceStandardScheme extends org.apache.thrift.scheme.StandardScheme<TraceSpan> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TraceSpan struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TRACE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.traceID = iprot.readString();
              struct.setTraceIDIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CALL_INFO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.callInfo = iprot.readString();
              struct.setCallInfoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TraceSpan struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.traceID != null) {
        oprot.writeFieldBegin(TRACE_ID_FIELD_DESC);
        oprot.writeString(struct.traceID);
        oprot.writeFieldEnd();
      }
      if (struct.callInfo != null) {
        oprot.writeFieldBegin(CALL_INFO_FIELD_DESC);
        oprot.writeString(struct.callInfo);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TraceTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TraceTupleScheme getScheme() {
      return new TraceTupleScheme();
    }
  }

  private static class TraceTupleScheme extends org.apache.thrift.scheme.TupleScheme<TraceSpan> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TraceSpan struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeString(struct.traceID);
      oprot.writeString(struct.callInfo);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TraceSpan struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.traceID = iprot.readString();
      struct.setTraceIDIsSet(true);
      struct.callInfo = iprot.readString();
      struct.setCallInfoIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

