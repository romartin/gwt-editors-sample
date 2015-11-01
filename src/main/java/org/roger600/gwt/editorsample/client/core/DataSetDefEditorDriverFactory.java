package org.roger600.gwt.editorsample.client.core;

import com.google.gwt.core.shared.GWT;

public class DataSetDefEditorDriverFactory {
    
    public static DataSetDefEditorWorkflow.Driver newDataSetDefEditorDriver() {
        return GWT.create(DataSetDefEditorWorkflow.Driver.class);
    }
}
