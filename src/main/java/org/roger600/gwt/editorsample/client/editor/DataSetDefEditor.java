package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import org.roger600.gwt.editorsample.client.Logger;
import org.roger600.gwt.editorsample.shared.editors.AttributeEditor;
import org.roger600.gwt.editorsample.shared.model.DataSetDef;

import java.util.List;

public class DataSetDefEditor implements IsWidget, org.roger600.gwt.editorsample.shared.editors.DataSetDefEditor {

    interface View extends IsWidget {
        
        void init(DataSetDefEditor presenter, DataSetDefBasicAttributesEditor.View basicAttributesEditorView,
                  DataSetDefProviderTypeEditor.View providerTypeEditor, DataSetDefColumnsEditor.View columnsEditor);
    }
    
    View view;
    DataSetDefBasicAttributesEditor basicAttributesEditor;
    private EditorDelegate<DataSetDef> delegate;
    private DataSetDef dataSetDef;

    private DefaultAttributeEditor<String> uuidEditor;
    private DefaultAttributeEditor<String> nameEditor;
    private DataSetDefProviderTypeEditor providerTypeEditor;
    private DataSetDefColumnsEditor columnsEditor;
    
    public DataSetDefEditor() {
        basicAttributesEditor = new DataSetDefBasicAttributesEditor();
        providerTypeEditor = new DataSetDefProviderTypeEditor();
        columnsEditor = new DataSetDefColumnsEditor();
        view = new DataSetDefEditorView();
        view.init(this, basicAttributesEditor.view, providerTypeEditor.view, columnsEditor.view);
    }

    @Override
    public Widget asWidget() {
        return view.asWidget();
    }

    @Override
    public void showErrors(List<EditorError> errors) {
        Logger.log("DataSetDefEditor#showErrors", errors);
    }

    @Override
    public void flush() {
        Logger.log("DataSetDefEditor#flush");
    }

    @Override
    public void onPropertyChange(String... paths) {
        Logger.log("DataSetDefEditor#onPropertyChange");
    }

    @Override
    public void setValue(DataSetDef value) {
        Logger.log("DataSetDefEditor#setValue");
        this.dataSetDef = value;
    }

    @Override
    public void setDelegate(EditorDelegate<DataSetDef> delegate) {
        Logger.log("DataSetDefEditor#setDelegate");
        this.delegate = delegate;
    }

    @Override
    public org.roger600.gwt.editorsample.shared.editors.DataSetDefBasicAttributesEditor basicAttributesEditor() {
        return basicAttributesEditor;
    }

    @Override
    public org.roger600.gwt.editorsample.shared.editors.DataSetDefProviderTypeEditor provider() {
        return providerTypeEditor;
    }

    @Override
    public org.roger600.gwt.editorsample.shared.editors.DataSetDefColumnsEditor columns() {
        return columnsEditor;
    }

}
