package org.roger600.gwt.editorsample.client;

import com.google.gwt.core.client.GWT;
import org.roger600.gwt.editorsample.shared.model.DataSetDef;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class Logger {

    public static void log(final String message, final DataSetDef dataSetDef) {
        GWT.log(message);
        log(dataSetDef);

    }

    public static void log(final String message, final Set<ConstraintViolation<DataSetDef>> violations) {
        GWT.log(message);
        if (violations != null) {
            for (ConstraintViolation<DataSetDef> violation : violations) {
                final String _message = violation.getMessage();
                GWT.log("Validation Error -> " + _message);
            }
        } else {
            GWT.log("No violations.");
        }
    }
    
    public static void log(final DataSetDef dataSetDef) {
        GWT.log("Data Set Def");
        GWT.log("***********************************");
        GWT.log("UUID=" + dataSetDef.getUUID());
        GWT.log("Name=" + dataSetDef.getName());

    }
    
}
