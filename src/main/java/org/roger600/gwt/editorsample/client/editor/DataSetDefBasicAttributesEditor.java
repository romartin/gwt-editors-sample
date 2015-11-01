package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import org.roger600.gwt.editorsample.client.Logger;
import org.roger600.gwt.editorsample.shared.editors.AttributeEditor;
import org.roger600.gwt.editorsample.shared.model.DataSetDef;

import java.util.List;

public class DataSetDefBasicAttributesEditor implements IsWidget, org.roger600.gwt.editorsample.shared.editors.DataSetDefBasicAttributesEditor {

    interface View extends IsWidget {
        
        void init(DataSetDefBasicAttributesEditor presenter, DefaultAttributeEditor.View uuidEditor, DefaultAttributeEditor.View nameEditor);
    }
    
    View view;
    private EditorDelegate<DataSetDef> delegate;
    private DataSetDef dataSetDef;

    private DefaultAttributeEditor<String> uuidEditor;
    private DefaultAttributeEditor<String> nameEditor;
    
    public DataSetDefBasicAttributesEditor() {
        uuidEditor = new DefaultAttributeEditor<String>();
        nameEditor = new DefaultAttributeEditor<String>();
        view = new DataSetDefBasicAttributesEditorView();
        view.init(this, uuidEditor.view, nameEditor.view);
    }

    @Override
    public Widget asWidget() {
        return view.asWidget();
    }

    @Override
    public void showErrors(List<EditorError> errors) {
        Logger.log("DataSetDefBasicAttributesEditor#showErrors", errors);
    }

    @Override
    public void flush() {
        Logger.log("DataSetDefBasicAttributesEditor#flush");
    }

    @Override
    public void onPropertyChange(String... paths) {
        Logger.log("DataSetDefBasicAttributesEditor#onPropertyChange");
    }

    @Override
    public void setValue(DataSetDef value) {
        Logger.log("DataSetDefBasicAttributesEditor#setValue");
        this.dataSetDef = value;
    }

    @Override
    public void setDelegate(EditorDelegate<DataSetDef> delegate) {
        Logger.log("DataSetDefBasicAttributesEditor#setDelegate");
        this.delegate = delegate;
    }

    @Override
    public AttributeEditor<String> UUID() {
        return uuidEditor;
    }

    @Override
    public AttributeEditor<String> name() {
        return nameEditor;
    }

    
}
