package org.roger600.gwt.editorsample.shared.model;


/**
 * An enumeration of the available data set provider types.
 */
public enum DataSetProviderType {

    /**
     * For accessing statically registered data set which are created by calling directly to the data set API.
     */
    STATIC,

    /**
     * For accessing data sets generated directly from a bean class implementing the DataSetGenerator interface
     */
    BEAN,

    /**
     * For accessing data sets defined as an SQL query over an existing data source.
     */
    SQL,

    /**
     * For accessing data sets that are the result of loading all the rows of a CSV file.
     */
    CSV,

    /**
     * For accessing data sets that are the result of querying an elasticsearch server.
     */
    ELASTICSEARCH;

}
