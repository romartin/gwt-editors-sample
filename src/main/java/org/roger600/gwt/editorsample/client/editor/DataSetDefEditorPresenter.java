package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.ValueAwareEditor;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import org.roger600.gwt.editorsample.client.Logger;
import org.roger600.gwt.editorsample.shared.editor.DataSetDefEditor;
import org.roger600.gwt.editorsample.shared.model.DataSetDef;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class DataSetDefEditorPresenter implements IsWidget, IsEditor<DataSetDefEditor> {

    interface View extends IsWidget, DataSetDefEditor, HasHandlers, HasValueChangeHandlers<DataSetDef>,
            ValueAwareEditor<DataSetDef>, HasEditorErrors<DataSetDef> {
        
    }
    
    View view;
    private DataSetDef dataSetDef;
    private DataSetDefEditorWorkflow workflow;
    
    public DataSetDefEditorPresenter() {
        view = GWT.create(DataSetDefEditorView.class);
        workflow =  new DataSetDefEditorWorkflow(this);
    }

    @Override
    public DataSetDefEditor asEditor() {
        return view;
    }

    @Override
    public Widget asWidget() {
        return view.asWidget();
    }

    public DataSetDef getDataSetDef() {
        return dataSetDef;
    }

    public void edit(final DataSetDef def) {
        this.dataSetDef = def;
        workflow.edit();
    }
    
    public Set<ConstraintViolation<DataSetDef>> validate(final DataSetDef def) {
        GWT.log("DataSetDefEditorPresenter#save - Validating...");
        final Set<ConstraintViolation<DataSetDef>> violations = workflow.validate(def);
        Logger.log("DataSetDefEditorPresenter#validate - Validated", violations );
        return violations;
    }

    public void save() {
        GWT.log("DataSetDefEditorPresenter#save - Saving...");
        workflow.save();
    }
    
    void onHasErrors() {
        Logger.log("DataSetDefEditorPresenter#onHasErrors - Has errors!", dataSetDef);
    }
    
    void onSave(final DataSetDef saved) {
        this.dataSetDef = saved;
        Logger.log("DataSetDefEditorPresenter#onSave - Saved!", dataSetDef);
    }
    
}
