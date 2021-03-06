/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 *
 */
package org.apache.carbondata.processing.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.apache.carbondata.core.metadata.schema.table.column.CarbonDimension;
import org.apache.carbondata.core.mutate.SegmentUpdateDetails;
import org.apache.carbondata.core.statusmanager.LoadMetadataDetails;
import org.apache.carbondata.core.statusmanager.SegmentUpdateStatusManager;

public class CarbonLoadModel implements Serializable {
  /**
   *
   */
  private static final long serialVersionUID = 6580168429197697465L;

  private String databaseName;

  private String tableName;

  private String factFilePath;

  private String dimFolderPath;

  private String colDictFilePath;

  private String partitionId;

  private CarbonDataLoadSchema carbonDataLoadSchema;

  private String[] aggTables;

  private String aggTableName;

  private boolean aggLoadRequest;

  private String storePath;

  private boolean isRetentionRequest;

  private List<String> factFilesToProcess;
  private String csvHeader;
  private String[] csvHeaderColumns;
  private String csvDelimiter;
  private String complexDelimiterLevel1;
  private String complexDelimiterLevel2;

  private boolean isDirectLoad;
  private List<LoadMetadataDetails> loadMetadataDetails;
  private transient List<SegmentUpdateDetails> segmentUpdateDetails;
  private transient SegmentUpdateStatusManager segmentUpdateStatusManager;

  private String blocksID;

  /**
   * Map from carbon dimension to pre defined dict file path
   */
  private HashMap<CarbonDimension, String> predefDictMap;

  /**
   * task id, each spark task has a unique id
   */
  private String taskNo;
  /**
   * new load start time
   */
  private String factTimeStamp;
  /**
   * load Id
   */
  private String segmentId;

  private String allDictPath;

  /**
   * escape Char
   */
  private String escapeChar;

  /**
   * quote Char
   */
  private String quoteChar;

  /**
   * comment Char
   */
  private String commentChar;

  private String dateFormat;

  private String defaultTimestampFormat;

  private String defaultDateFormat;

  /**
   * defines the string that should be treated as null while loadind data
   */
  private String serializationNullFormat;

  /**
   * defines the string to specify whether the bad record logger should be enabled or not
   */
  private String badRecordsLoggerEnable;

  /**
   * defines the option to specify the bad record logger action
   */
  private String badRecordsAction;

  /**
   * Max number of columns that needs to be parsed by univocity parser
   */
  private String maxColumns;

  /**
   * the key of RDD Iterator in RDD iterator Map
   */
  private String rddIteratorKey;

  private String carbondataFileName = "";

  public String getCarbondataFileName() {
    return carbondataFileName;
  }

  public void setCarbondataFileName(String carbondataFileName) {
    this.carbondataFileName = carbondataFileName;
  }

  /**
   * Use one pass to generate dictionary
   */
  private boolean useOnePass;

  /**
   * dictionary server host
   */
  private String dictionaryServerHost;

  /**
   * dictionary sever port
   */
  private int dictionaryServerPort;

  /**
   * Pre fetch data from csv reader
   */
  private boolean preFetch;

  /**
   * get escape char
   *
   * @return
   */
  public String getEscapeChar() {
    return escapeChar;
  }

  /**
   * set escape char
   *
   * @param escapeChar
   */
  public void setEscapeChar(String escapeChar) {
    this.escapeChar = escapeChar;
  }

  /**
   * get blocck id
   *
   * @return
   */
  public String getBlocksID() {
    return blocksID;
  }

  /**
   * set block id for carbon load model
   *
   * @param blocksID
   */
  public void setBlocksID(String blocksID) {
    this.blocksID = blocksID;
  }

  public String getCsvDelimiter() {
    return csvDelimiter;
  }

  public void setCsvDelimiter(String csvDelimiter) {
    this.csvDelimiter = csvDelimiter;
  }

  public String getComplexDelimiterLevel1() {
    return complexDelimiterLevel1;
  }

  public void setComplexDelimiterLevel1(String complexDelimiterLevel1) {
    this.complexDelimiterLevel1 = complexDelimiterLevel1;
  }

  public String getComplexDelimiterLevel2() {
    return complexDelimiterLevel2;
  }

  public void setComplexDelimiterLevel2(String complexDelimiterLevel2) {
    this.complexDelimiterLevel2 = complexDelimiterLevel2;
  }

  public boolean isDirectLoad() {
    return isDirectLoad;
  }

  public void setDirectLoad(boolean isDirectLoad) {
    this.isDirectLoad = isDirectLoad;
  }

  public String getAllDictPath() {
    return allDictPath;
  }

  public void setAllDictPath(String allDictPath) {
    this.allDictPath = allDictPath;
  }

  public List<String> getFactFilesToProcess() {
    return factFilesToProcess;
  }

  public String getCsvHeader() {
    return csvHeader;
  }

  public void setCsvHeader(String csvHeader) {
    this.csvHeader = csvHeader;
  }

  public String[] getCsvHeaderColumns() {
    return csvHeaderColumns;
  }

  public void setCsvHeaderColumns(String[] csvHeaderColumns) {
    this.csvHeaderColumns = csvHeaderColumns;
  }

  public void initPredefDictMap() {
    predefDictMap = new HashMap<>();
  }

  public String getPredefDictFilePath(CarbonDimension dimension) {
    return predefDictMap.get(dimension);
  }

  public void setPredefDictMap(CarbonDimension dimension, String predefDictFilePath) {
    this.predefDictMap.put(dimension, predefDictFilePath);
  }

  /**
   * @return carbon dataload schema
   */
  public CarbonDataLoadSchema getCarbonDataLoadSchema() {
    return carbonDataLoadSchema;
  }

  /**
   * @param carbonDataLoadSchema
   */
  public void setCarbonDataLoadSchema(CarbonDataLoadSchema carbonDataLoadSchema) {
    this.carbonDataLoadSchema = carbonDataLoadSchema;
  }

  /**
   * @return the databaseName
   */
  public String getDatabaseName() {
    return databaseName;
  }

  /**
   * @param databaseName the databaseName to set
   */
  public void setDatabaseName(String databaseName) {
    this.databaseName = databaseName;
  }

  /**
   * @return the tableName
   */
  public String getTableName() {
    return tableName;
  }

  /**
   * @param tableName the tableName to set
   */
  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  /**
   * @return the factFilePath
   */
  public String getFactFilePath() {
    return factFilePath;
  }

  /**
   * @param factFilePath the factFilePath to set
   */
  public void setFactFilePath(String factFilePath) {
    this.factFilePath = factFilePath;
  }

  /**
   * @return external column dictionary file path
   */
  public String getColDictFilePath() {
    return colDictFilePath;
  }

  /**
   * set external column dictionary file path
   *
   * @param colDictFilePath
   */
  public void setColDictFilePath(String colDictFilePath) {
    this.colDictFilePath = colDictFilePath;
  }

  /**
   * get copy with parition
   *
   * @param uniqueId
   * @return
   */
  public CarbonLoadModel getCopyWithPartition(String uniqueId) {
    CarbonLoadModel copy = new CarbonLoadModel();
    copy.tableName = tableName;
    copy.factFilePath = factFilePath + '/' + uniqueId;
    copy.databaseName = databaseName;
    copy.partitionId = uniqueId;
    copy.aggTables = aggTables;
    copy.aggTableName = aggTableName;
    copy.aggLoadRequest = aggLoadRequest;
    copy.loadMetadataDetails = loadMetadataDetails;
    copy.isRetentionRequest = isRetentionRequest;
    copy.complexDelimiterLevel1 = complexDelimiterLevel1;
    copy.complexDelimiterLevel2 = complexDelimiterLevel2;
    copy.carbonDataLoadSchema = carbonDataLoadSchema;
    copy.blocksID = blocksID;
    copy.taskNo = taskNo;
    copy.factTimeStamp = factTimeStamp;
    copy.segmentId = segmentId;
    copy.serializationNullFormat = serializationNullFormat;
    copy.badRecordsLoggerEnable = badRecordsLoggerEnable;
    copy.badRecordsAction = badRecordsAction;
    copy.escapeChar = escapeChar;
    copy.quoteChar = quoteChar;
    copy.commentChar = commentChar;
    copy.dateFormat = dateFormat;
    copy.defaultTimestampFormat = defaultTimestampFormat;
    copy.maxColumns = maxColumns;
    copy.storePath = storePath;
    copy.useOnePass = useOnePass;
    copy.dictionaryServerHost = dictionaryServerHost;
    copy.dictionaryServerPort = dictionaryServerPort;
    copy.preFetch = preFetch;
    return copy;
  }

  /**
   * get CarbonLoadModel with partition
   *
   * @param uniqueId
   * @param filesForPartition
   * @param header
   * @param delimiter
   * @return
   */
  public CarbonLoadModel getCopyWithPartition(String uniqueId, List<String> filesForPartition,
      String header, String delimiter) {
    CarbonLoadModel copyObj = new CarbonLoadModel();
    copyObj.tableName = tableName;
    copyObj.factFilePath = null;
    copyObj.databaseName = databaseName;
    copyObj.partitionId = uniqueId;
    copyObj.aggTables = aggTables;
    copyObj.aggTableName = aggTableName;
    copyObj.aggLoadRequest = aggLoadRequest;
    copyObj.loadMetadataDetails = loadMetadataDetails;
    copyObj.isRetentionRequest = isRetentionRequest;
    copyObj.carbonDataLoadSchema = carbonDataLoadSchema;
    copyObj.csvHeader = header;
    copyObj.csvHeaderColumns = csvHeaderColumns;
    copyObj.factFilesToProcess = filesForPartition;
    copyObj.isDirectLoad = true;
    copyObj.csvDelimiter = delimiter;
    copyObj.complexDelimiterLevel1 = complexDelimiterLevel1;
    copyObj.complexDelimiterLevel2 = complexDelimiterLevel2;
    copyObj.blocksID = blocksID;
    copyObj.taskNo = taskNo;
    copyObj.factTimeStamp = factTimeStamp;
    copyObj.segmentId = segmentId;
    copyObj.serializationNullFormat = serializationNullFormat;
    copyObj.badRecordsLoggerEnable = badRecordsLoggerEnable;
    copyObj.badRecordsAction = badRecordsAction;
    copyObj.escapeChar = escapeChar;
    copyObj.quoteChar = quoteChar;
    copyObj.commentChar = commentChar;
    copyObj.dateFormat = dateFormat;
    copyObj.defaultTimestampFormat = defaultTimestampFormat;
    copyObj.maxColumns = maxColumns;
    copyObj.storePath = storePath;
    copyObj.useOnePass = useOnePass;
    copyObj.dictionaryServerHost = dictionaryServerHost;
    copyObj.dictionaryServerPort = dictionaryServerPort;
    copyObj.preFetch = preFetch;
    return copyObj;
  }

  /**
   * @return the partitionId
   */
  public String getPartitionId() {
    return partitionId;
  }

  /**
   * @param partitionId the partitionId to set
   */
  public void setPartitionId(String partitionId) {
    this.partitionId = partitionId;
  }

  /**
   * @param aggTables the aggTables to set
   */
  public void setAggTables(String[] aggTables) {
    this.aggTables = aggTables;
  }

  /**
   * @return the aggLoadRequest
   */
  public boolean isAggLoadRequest() {
    return aggLoadRequest;
  }

  /**
   * @param aggLoadRequest the aggLoadRequest to set
   */
  public void setAggLoadRequest(boolean aggLoadRequest) {
    this.aggLoadRequest = aggLoadRequest;
  }

  /**
   * @param storePath The storePath to set.
   */
  public void setStorePath(String storePath) {
    this.storePath = storePath;
  }

  /**
   * @return Returns the aggTableName.
   */
  public String getAggTableName() {
    return aggTableName;
  }

  /**
   * @return Returns the factStoreLocation.
   */
  public String getStorePath() {
    return storePath;
  }

  /**
   * @param aggTableName The aggTableName to set.
   */
  public void setAggTableName(String aggTableName) {
    this.aggTableName = aggTableName;
  }

  /**
   * isRetentionRequest
   *
   * @return
   */
  public boolean isRetentionRequest() {
    return isRetentionRequest;
  }

  /**
   * getLoadMetadataDetails.
   *
   * @return
   */
  public List<LoadMetadataDetails> getLoadMetadataDetails() {
    return loadMetadataDetails;
  }

  /**
   * setLoadMetadataDetails.
   *
   * @param loadMetadataDetails
   */
  public void setLoadMetadataDetails(List<LoadMetadataDetails> loadMetadataDetails) {
    this.loadMetadataDetails = loadMetadataDetails;
  }

  /**
   * getSegmentUpdateDetails
   *
   * @return
   */
  public List<SegmentUpdateDetails> getSegmentUpdateDetails() {
    return segmentUpdateDetails;
  }

  /**
   * setSegmentUpdateDetails
   *
   * @param segmentUpdateDetails
   */
  public void setSegmentUpdateDetails(List<SegmentUpdateDetails> segmentUpdateDetails) {
    this.segmentUpdateDetails = segmentUpdateDetails;
  }

  /**
   * getSegmentUpdateStatusManager
   *
   * @return
   */
  public SegmentUpdateStatusManager getSegmentUpdateStatusManager() {
    return segmentUpdateStatusManager;
  }

  /**
   * setSegmentUpdateStatusManager
   *
   * @param segmentUpdateStatusManager
   */
  public void setSegmentUpdateStatusManager(SegmentUpdateStatusManager segmentUpdateStatusManager) {
    this.segmentUpdateStatusManager = segmentUpdateStatusManager;
  }

  /**
   * @return
   */
  public String getTaskNo() {
    return taskNo;
  }

  /**
   * @param taskNo
   */
  public void setTaskNo(String taskNo) {
    this.taskNo = taskNo;
  }

  /**
   * @return
   */
  public String getFactTimeStamp() {
    return factTimeStamp;
  }

  /**
   * @param factTimeStamp
   */
  public void setFactTimeStamp(long factTimeStamp) {
    this.factTimeStamp = factTimeStamp + "";
  }

  public String[] getDelimiters() {
    return new String[] { complexDelimiterLevel1, complexDelimiterLevel2 };
  }

  /**
   * @return load Id
   */
  public String getSegmentId() {
    return segmentId;
  }

  /**
   * @param segmentId
   */
  public void setSegmentId(String segmentId) {
    this.segmentId = segmentId;
  }

  /**
   * the method returns the value to be treated as null while data load
   *
   * @return
   */
  public String getSerializationNullFormat() {
    return serializationNullFormat;
  }

  /**
   * the method sets the value to be treated as null while data load
   *
   * @param serializationNullFormat
   */
  public void setSerializationNullFormat(String serializationNullFormat) {
    this.serializationNullFormat = serializationNullFormat;
  }

  /**
   * returns the string to enable bad record logger
   *
   * @return
   */
  public String getBadRecordsLoggerEnable() {
    return badRecordsLoggerEnable;
  }

  /**
   * method sets the string to specify whether to enable or dissable the badrecord logger.
   *
   * @param badRecordsLoggerEnable
   */
  public void setBadRecordsLoggerEnable(String badRecordsLoggerEnable) {
    this.badRecordsLoggerEnable = badRecordsLoggerEnable;
  }

  public String getQuoteChar() {
    return quoteChar;
  }

  public void setQuoteChar(String quoteChar) {
    this.quoteChar = quoteChar;
  }

  public String getCommentChar() {
    return commentChar;
  }

  public void setCommentChar(String commentChar) {
    this.commentChar = commentChar;
  }

  public String getDateFormat() {
    return dateFormat;
  }

  public void setDateFormat(String dateFormat) {
    this.dateFormat = dateFormat;
  }

  public String getDefaultTimestampFormat() {
    return defaultTimestampFormat;
  }

  public void setDefaultTimestampFormat(String defaultTimestampFormat) {
    this.defaultTimestampFormat = defaultTimestampFormat;
  }

  /**
   * @return
   */
  public String getMaxColumns() {
    return maxColumns;
  }

  /**
   * @param maxColumns
   */
  public void setMaxColumns(String maxColumns) {
    this.maxColumns = maxColumns;
  }

  /**
   * returns option to specify the bad record logger action
   *
   * @return
   */
  public String getBadRecordsAction() {
    return badRecordsAction;
  }

  /**
   * set option to specify the bad record logger action
   *
   * @param badRecordsAction
   */
  public void setBadRecordsAction(String badRecordsAction) {
    this.badRecordsAction = badRecordsAction;
  }

  public String getRddIteratorKey() {
    return rddIteratorKey;
  }

  public void setRddIteratorKey(String rddIteratorKey) {
    this.rddIteratorKey = rddIteratorKey;

  }

  public boolean getUseOnePass() {
    return useOnePass;
  }

  public void setUseOnePass(boolean useOnePass) {
    this.useOnePass = useOnePass;
  }

  public int getDictionaryServerPort() {
    return dictionaryServerPort;
  }

  public void setDictionaryServerPort(int dictionaryServerPort) {
    this.dictionaryServerPort = dictionaryServerPort;
  }

  public String getDictionaryServerHost() {
    return dictionaryServerHost;
  }

  public void setDictionaryServerHost(String dictionaryServerHost) {
    this.dictionaryServerHost = dictionaryServerHost;
  }

  public boolean isPreFetch() {
    return preFetch;
  }

  public void setPreFetch(boolean preFetch) {
    this.preFetch = preFetch;
  }

  public String getDefaultDateFormat() {
    return defaultDateFormat;
  }

  public void setDefaultDateFormat(String defaultDateFormat) {
    this.defaultDateFormat = defaultDateFormat;
  }
}
