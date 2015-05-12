    /*
     * Licensed to the Apache Software Foundation (ASF) under one or more
     * contributor license agreements.  See the NOTICE file distributed with
     * this work for additional information regarding copyright ownership.
     * The ASF licenses this file to You under the Apache License, Version 2.0
     * (the "License"); you may not use this file except in compliance with
     * the License.  You may obtain a copy of the License at
     *
     *     http://www.apache.org/licenses/LICENSE-2.0
     *
     * Unless required by applicable law or agreed to in writing, software
     * distributed under the License is distributed on an "AS IS" BASIS,
     * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     * See the License for the specific language governing permissions and
     * limitations under the License.
     */
/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.airavata.gfac.states;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all") public class GfacExperimentStatus implements org.apache.thrift.TBase<GfacExperimentStatus, GfacExperimentStatus._Fields>, java.io.Serializable, Cloneable, Comparable<GfacExperimentStatus> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("GfacExperimentStatus");

  private static final org.apache.thrift.protocol.TField GFAC_EXPERIMENT_STATE_FIELD_DESC = new org.apache.thrift.protocol.TField("gfacExperimentState", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField TIME_OF_STATE_CHANGE_FIELD_DESC = new org.apache.thrift.protocol.TField("timeOfStateChange", org.apache.thrift.protocol.TType.I64, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new GfacExperimentStatusStandardSchemeFactory());
    schemes.put(TupleScheme.class, new GfacExperimentStatusTupleSchemeFactory());
  }

  /**
   * 
   * @see GfacExperimentState
   */
  public GfacExperimentState gfacExperimentState; // required
  public long timeOfStateChange; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  @SuppressWarnings("all") public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see GfacExperimentState
     */
    GFAC_EXPERIMENT_STATE((short)1, "gfacExperimentState"),
    TIME_OF_STATE_CHANGE((short)2, "timeOfStateChange");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // GFAC_EXPERIMENT_STATE
          return GFAC_EXPERIMENT_STATE;
        case 2: // TIME_OF_STATE_CHANGE
          return TIME_OF_STATE_CHANGE;
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
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __TIMEOFSTATECHANGE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.TIME_OF_STATE_CHANGE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.GFAC_EXPERIMENT_STATE, new org.apache.thrift.meta_data.FieldMetaData("gfacExperimentState", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, GfacExperimentState.class)));
    tmpMap.put(_Fields.TIME_OF_STATE_CHANGE, new org.apache.thrift.meta_data.FieldMetaData("timeOfStateChange", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(GfacExperimentStatus.class, metaDataMap);
  }

  public GfacExperimentStatus() {
  }

  public GfacExperimentStatus(
    GfacExperimentState gfacExperimentState)
  {
    this();
    this.gfacExperimentState = gfacExperimentState;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public GfacExperimentStatus(GfacExperimentStatus other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetGfacExperimentState()) {
      this.gfacExperimentState = other.gfacExperimentState;
    }
    this.timeOfStateChange = other.timeOfStateChange;
  }

  public GfacExperimentStatus deepCopy() {
    return new GfacExperimentStatus(this);
  }

  @Override
  public void clear() {
    this.gfacExperimentState = null;
    setTimeOfStateChangeIsSet(false);
    this.timeOfStateChange = 0;
  }

  /**
   * 
   * @see GfacExperimentState
   */
  public GfacExperimentState getGfacExperimentState() {
    return this.gfacExperimentState;
  }

  /**
   * 
   * @see GfacExperimentState
   */
  public GfacExperimentStatus setGfacExperimentState(GfacExperimentState gfacExperimentState) {
    this.gfacExperimentState = gfacExperimentState;
    return this;
  }

  public void unsetGfacExperimentState() {
    this.gfacExperimentState = null;
  }

  /** Returns true if field gfacExperimentState is set (has been assigned a value) and false otherwise */
  public boolean isSetGfacExperimentState() {
    return this.gfacExperimentState != null;
  }

  public void setGfacExperimentStateIsSet(boolean value) {
    if (!value) {
      this.gfacExperimentState = null;
    }
  }

  public long getTimeOfStateChange() {
    return this.timeOfStateChange;
  }

  public GfacExperimentStatus setTimeOfStateChange(long timeOfStateChange) {
    this.timeOfStateChange = timeOfStateChange;
    setTimeOfStateChangeIsSet(true);
    return this;
  }

  public void unsetTimeOfStateChange() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TIMEOFSTATECHANGE_ISSET_ID);
  }

  /** Returns true if field timeOfStateChange is set (has been assigned a value) and false otherwise */
  public boolean isSetTimeOfStateChange() {
    return EncodingUtils.testBit(__isset_bitfield, __TIMEOFSTATECHANGE_ISSET_ID);
  }

  public void setTimeOfStateChangeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TIMEOFSTATECHANGE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case GFAC_EXPERIMENT_STATE:
      if (value == null) {
        unsetGfacExperimentState();
      } else {
        setGfacExperimentState((GfacExperimentState)value);
      }
      break;

    case TIME_OF_STATE_CHANGE:
      if (value == null) {
        unsetTimeOfStateChange();
      } else {
        setTimeOfStateChange((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case GFAC_EXPERIMENT_STATE:
      return getGfacExperimentState();

    case TIME_OF_STATE_CHANGE:
      return Long.valueOf(getTimeOfStateChange());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case GFAC_EXPERIMENT_STATE:
      return isSetGfacExperimentState();
    case TIME_OF_STATE_CHANGE:
      return isSetTimeOfStateChange();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof GfacExperimentStatus)
      return this.equals((GfacExperimentStatus)that);
    return false;
  }

  public boolean equals(GfacExperimentStatus that) {
    if (that == null)
      return false;

    boolean this_present_gfacExperimentState = true && this.isSetGfacExperimentState();
    boolean that_present_gfacExperimentState = true && that.isSetGfacExperimentState();
    if (this_present_gfacExperimentState || that_present_gfacExperimentState) {
      if (!(this_present_gfacExperimentState && that_present_gfacExperimentState))
        return false;
      if (!this.gfacExperimentState.equals(that.gfacExperimentState))
        return false;
    }

    boolean this_present_timeOfStateChange = true && this.isSetTimeOfStateChange();
    boolean that_present_timeOfStateChange = true && that.isSetTimeOfStateChange();
    if (this_present_timeOfStateChange || that_present_timeOfStateChange) {
      if (!(this_present_timeOfStateChange && that_present_timeOfStateChange))
        return false;
      if (this.timeOfStateChange != that.timeOfStateChange)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(GfacExperimentStatus other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetGfacExperimentState()).compareTo(other.isSetGfacExperimentState());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGfacExperimentState()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.gfacExperimentState, other.gfacExperimentState);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTimeOfStateChange()).compareTo(other.isSetTimeOfStateChange());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTimeOfStateChange()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.timeOfStateChange, other.timeOfStateChange);
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
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("GfacExperimentStatus(");
    boolean first = true;

    sb.append("gfacExperimentState:");
    if (this.gfacExperimentState == null) {
      sb.append("null");
    } else {
      sb.append(this.gfacExperimentState);
    }
    first = false;
    if (isSetTimeOfStateChange()) {
      if (!first) sb.append(", ");
      sb.append("timeOfStateChange:");
      sb.append(this.timeOfStateChange);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (gfacExperimentState == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'gfacExperimentState' was not present! Struct: " + toString());
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

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class GfacExperimentStatusStandardSchemeFactory implements SchemeFactory {
    public GfacExperimentStatusStandardScheme getScheme() {
      return new GfacExperimentStatusStandardScheme();
    }
  }

  private static class GfacExperimentStatusStandardScheme extends StandardScheme<GfacExperimentStatus> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, GfacExperimentStatus struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // GFAC_EXPERIMENT_STATE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.gfacExperimentState = GfacExperimentState.findByValue(iprot.readI32());
              struct.setGfacExperimentStateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TIME_OF_STATE_CHANGE
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.timeOfStateChange = iprot.readI64();
              struct.setTimeOfStateChangeIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, GfacExperimentStatus struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.gfacExperimentState != null) {
        oprot.writeFieldBegin(GFAC_EXPERIMENT_STATE_FIELD_DESC);
        oprot.writeI32(struct.gfacExperimentState.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.isSetTimeOfStateChange()) {
        oprot.writeFieldBegin(TIME_OF_STATE_CHANGE_FIELD_DESC);
        oprot.writeI64(struct.timeOfStateChange);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class GfacExperimentStatusTupleSchemeFactory implements SchemeFactory {
    public GfacExperimentStatusTupleScheme getScheme() {
      return new GfacExperimentStatusTupleScheme();
    }
  }

  private static class GfacExperimentStatusTupleScheme extends TupleScheme<GfacExperimentStatus> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, GfacExperimentStatus struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.gfacExperimentState.getValue());
      BitSet optionals = new BitSet();
      if (struct.isSetTimeOfStateChange()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetTimeOfStateChange()) {
        oprot.writeI64(struct.timeOfStateChange);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, GfacExperimentStatus struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.gfacExperimentState = GfacExperimentState.findByValue(iprot.readI32());
      struct.setGfacExperimentStateIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.timeOfStateChange = iprot.readI64();
        struct.setTimeOfStateChangeIsSet(true);
      }
    }
  }

}

