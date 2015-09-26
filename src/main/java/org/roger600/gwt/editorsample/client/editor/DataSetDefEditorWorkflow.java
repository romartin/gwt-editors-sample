package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import org.roger600.gwt.editorsample.shared.editor.DataSetDefEditor;
import org.roger600.gwt.editorsample.shared.model.DataSetDef;

public class DataSetDefEditorWorkflow {

    interface Driver extends SimpleBeanEditorDriver<DataSetDef, DataSetDefEditor> {}

    Driver driver = GWT.create(Driver.class);
    private DataSetDefEditorPresenter presenter;

    public DataSetDefEditorWorkflow(DataSetDefEditorPresenter presenter) {
        this.presenter = presenter;
    }

    void edit() {
        // Initialize the driver with the top-level editor
        driver.initialize(presenter.asEditor());
        // Copy the data in the object into the UI
        driver.edit(presenter.getDataSetDef());
    }

    // Called by some UI action
    void save() {
        GWT.log("DataSetDefEditorWorkflow#save - Driver flush...");
        DataSetDef edited = driver.flush();
        if (driver.hasErrors()) {
            // A sub-editor reported errors
            GWT.log("DataSetDefEditorWorkflow#save - Has errors!");
            presenter.onHasErrors();
        }
        GWT.log("DataSetDefEditorWorkflow#save - Saved!");
        presenter.onSave(edited);
    }
    
}
