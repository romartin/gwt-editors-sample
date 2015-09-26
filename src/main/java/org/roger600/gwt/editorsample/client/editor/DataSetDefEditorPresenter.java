package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import org.roger600.gwt.editorsample.client.Logger;
import org.roger600.gwt.editorsample.shared.editor.DataSetDefEditor;
import org.roger600.gwt.editorsample.shared.model.DataSetDef;

public class DataSetDefEditorPresenter implements IsWidget, IsEditor<DataSetDefEditor> {
    
    interface View extends IsWidget, DataSetDefEditor {
        
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
    
    public void save() {
        GWT.log("DataSetDefEditorPresenter#save - Saving...");
        workflow.save();
    }
    
    void onHasErrors() {
        GWT.log("DataSetDefEditorPresenter#onHasErrors - Has errors!");
        Logger.log(dataSetDef);
    }
    
    void onSave(final DataSetDef saved) {
        this.dataSetDef = saved;
        GWT.log("DataSetDefEditorPresenter#onSave - Saved!");
        Logger.log(dataSetDef);
    }
    
}
