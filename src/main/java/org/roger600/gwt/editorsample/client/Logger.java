package org.roger600.gwt.editorsample.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.EditorError;
import org.roger600.gwt.editorsample.shared.model.DataSetDef;
import org.roger600.gwt.editorsample.shared.model.DataSetProviderType;

import javax.validation.ConstraintViolation;
import java.util.List;
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

    public static void log(final String message, List<EditorError> errors) {
        GWT.log(message);
        if (errors != null) {
            for (EditorError editorError : errors) {
                final String _message = editorError.getMessage();
                GWT.log("Editor Error for "  + editorError.getPath() + " -> " + _message);
            }
        } else {
            GWT.log("No errors.");
        }
    }
    
    public static void log(final DataSetDef dataSetDef) {
        GWT.log("Data Set Def");
        GWT.log("***********************************");
        GWT.log("UUID=" + dataSetDef.getUUID());
        GWT.log("Name=" + dataSetDef.getName());
        final DataSetProviderType type = dataSetDef.getProvider();
        GWT.log("Type=" + (type != null ? type.name() : "null") );

    }
    
}
