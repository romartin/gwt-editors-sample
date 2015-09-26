package org.roger600.gwt.editorsample.client;

import com.google.gwt.core.client.GWT;
import org.roger600.gwt.editorsample.shared.model.DataSetDef;

public class Logger {

    public static void log(final String message, final DataSetDef dataSetDef) {
        GWT.log(message);
        log(dataSetDef);

    }
    
    public static void log(final DataSetDef dataSetDef) {
        GWT.log("Data Set Def");
        GWT.log("***********************************");
        GWT.log("UUID=" + dataSetDef.getUUID());
        GWT.log("Name=" + dataSetDef.getName());

    }
    
}
