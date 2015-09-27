package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import org.roger600.gwt.editorsample.client.Logger;
import org.roger600.gwt.editorsample.shared.model.DataSetDef;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class DataSetDefEditorPresenter implements IsWidget, IsEditor<org.roger600.gwt.editorsample.shared.editors.DataSetDefEditor> {

    interface Driver extends SimpleBeanEditorDriver<DataSetDef, org.roger600.gwt.editorsample.shared.editors.DataSetDefEditor> {}
    Driver driver = GWT.create(Driver.class);
    DataSetDefEditor editor;

    public DataSetDefEditorPresenter() {
        editor = new DataSetDefEditor();
    }

    @Override
    public Widget asWidget() {
        return editor.asWidget();
    }

    @Override
    public org.roger600.gwt.editorsample.shared.editors.DataSetDefEditor asEditor() {
        return editor;
    }

    public void edit(final DataSetDef def) {
        driver.initialize(editor);
        driver.edit(def);
    }

    public DataSetDef save() {
        GWT.log("DataSetDefEditorPresenter#save - Saving...");
        DataSetDef edited = driver.flush();
        validateAndSetViolations(edited);
        if (driver.hasErrors()) {
            // A sub-editor reported errors
            GWT.log("DataSetDefEditorPresenter#save - Has errors!");
        }
        Logger.log("DataSetDefEditorPresenter#save - Saved!", edited);
        return edited;
    }

    public Set<ConstraintViolation<DataSetDef>> validate(final DataSetDef def) {
        GWT.log("DataSetDefEditorPresenter#validate - Validating...");
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<DataSetDef>> violations = validator.validate(def);
        Logger.log("DataSetDefEditorPresenter#validate - Validated", violations );
        return violations;
    }

    private void validateAndSetViolations(DataSetDef edited) {
        Set<ConstraintViolation<DataSetDef>> violations = validate(edited);
        final Set<?> test = violations;
        driver.setConstraintViolations((Iterable<ConstraintViolation<?>>) test);
    }
}
