package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import org.roger600.gwt.editorsample.client.Logger;
import org.roger600.gwt.editorsample.shared.editor.DataSetDefEditor;
import org.roger600.gwt.editorsample.shared.model.DataSetDef;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class DataSetDefEditorWorkflow {

    interface Driver extends SimpleBeanEditorDriver<DataSetDef, DataSetDefEditorView> {}

    Driver driver = GWT.create(Driver.class);
    private DataSetDefEditorPresenter presenter;

    public DataSetDefEditorWorkflow(DataSetDefEditorPresenter presenter) {
        this.presenter = presenter;
    }

    void edit() {
        final DataSetDef def = presenter.getDataSetDef();
        Logger.log("DataSetDefEditorWorkflow#edit - Starting edit for def:", def);
        // Initialize the driver with the top-level editor
        driver.initialize((DataSetDefEditorView) presenter.asWidget());
        // Copy the data in the object into the UI
        driver.edit(def);
    }

    void save() {
        GWT.log("DataSetDefEditorWorkflow#save - Driver flush...");
        DataSetDef edited = driver.flush();
        Logger.log("DataSetDefEditorWorkflow#save - Flushed:", edited);
        Set<ConstraintViolation<DataSetDef>> violations = validate(edited);
        final Set<?> test = violations;
        driver.setConstraintViolations((Iterable<ConstraintViolation<?>>) test);
        if (driver.hasErrors()) {
            // A sub-editor reported errors
            GWT.log("DataSetDefEditorWorkflow#save - Has errors!");
            presenter.onHasErrors();
        }
        GWT.log("DataSetDefEditorWorkflow#save - Saved!");
        presenter.onSave(edited);
    }

    Set<ConstraintViolation<DataSetDef>> validate(final DataSetDef def) {
        GWT.log("DataSetDefEditorWorkflow#validate - Validating...");
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<DataSetDef>> violations = validator.validate(def);
        return violations;
    }
}
