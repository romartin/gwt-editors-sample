package org.roger600.gwt.editorsample.client.core;

import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import org.roger600.gwt.editorsample.client.Logger;
import org.roger600.gwt.editorsample.client.editor.DataSetDefEditor;
import org.roger600.gwt.editorsample.shared.model.DataSetDef;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class DataSetDefEditorWorkflow implements IsWidget, IsEditor<org.roger600.gwt.editorsample.shared.editors.DataSetDefEditor> {

    interface Driver extends SimpleBeanEditorDriver<DataSetDef, org.roger600.gwt.editorsample.shared.editors.DataSetDefEditor> {}
    
    Driver driver;
    DataSetDefEditor editor;

    public DataSetDefEditorWorkflow(DataSetDefEditor editor, Driver driver) {
        this.editor = editor;
        this.driver = driver;
    }

    public void edit(final DataSetDef def) {
        driver.initialize(editor);
        driver.edit(def);
    }

    public DataSetDef saveAndValidate(Class... classes) {
        Logger.log("DataSetDefEditorWorkflow#save - Saving...");
        DataSetDef edited = driver.flush();
        validateAndSetViolations(edited, classes);
        if (driver.hasErrors()) {
            // A sub-editor reported errors
            Logger.log("DataSetDefEditorWorkflow#save - Has errors!");
        }
        Logger.log("DataSetDefEditorWorkflow#save - Saved!", edited);
        return edited;
    }

    public Set<ConstraintViolation<DataSetDef>> validate(final DataSetDef def, Class... classes) {
        Logger.log("DataSetDefEditorWorkflow#validate - Validating...");
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<DataSetDef>> violations;
        if (classes != null) {
            violations = validator.validate(def, classes);
        } else {
            violations = validator.validate(def);
        }
        Logger.log("DataSetDefEditorWorkflow#validate - Validated", violations );
        return violations;
    }

    private void validateAndSetViolations(DataSetDef edited, Class... classes) {
        Set<ConstraintViolation<DataSetDef>> violations = validate(edited, classes);
        final Set<?> test = violations;
        driver.setConstraintViolations((Iterable<ConstraintViolation<?>>) test);
    }

    @Override
    public org.roger600.gwt.editorsample.shared.editors.DataSetDefEditor asEditor() {
        return editor;
    }

    @Override
    public Widget asWidget() {
        return editor.asWidget();
    }
    
}
