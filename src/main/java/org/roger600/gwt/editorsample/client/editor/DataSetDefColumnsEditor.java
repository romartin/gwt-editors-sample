package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.CompositeEditor;
import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.adapters.EditorSource;
import com.google.gwt.editor.client.adapters.ListEditor;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import org.roger600.gwt.editorsample.client.Logger;
import org.roger600.gwt.editorsample.shared.model.DataColumnDef;

import java.util.List;

public class DataSetDefColumnsEditor implements IsWidget, org.roger600.gwt.editorsample.shared.editors.DataSetDefColumnsEditor {

    interface View extends IsWidget {
        void init(DataSetDefColumnsEditor presenter);
        void insert(Widget editorWidget);
        void clear();
    }
    
    private View view;
    private ListEditor<DataColumnDef, org.roger600.gwt.editorsample.shared.editors.DataColumnDefEditor> listEditor;
    private List<DataColumnDef> columns;
    
    public DataSetDefColumnsEditor() {
        super();
        view = GWT.create(DataSetDefColumnsEditorView.class);
        view.init(this);
        listEditor = ListEditor.of(new DataColumnDefEditorSource());
    }

    public class DataColumnDefEditorSource extends EditorSource<org.roger600.gwt.editorsample.shared.editors.DataColumnDefEditor> {
        @Override
        public org.roger600.gwt.editorsample.shared.editors.DataColumnDefEditor create(int index) {
            DataColumnDefEditor columnDefEditor = new DataColumnDefEditor();
            view.insert(columnDefEditor.asWidget());
            return columnDefEditor;
        }
    };
    
    @Override
    public org.roger600.gwt.editorsample.shared.editors.DataColumnDefEditor createEditorForTraversal() {
        return listEditor.createEditorForTraversal();
    }

    @Override
    public String getPathElement(org.roger600.gwt.editorsample.shared.editors.DataColumnDefEditor subEditor) {
        return listEditor.getPathElement(subEditor);
    }

    @Override
    public void setEditorChain(EditorChain<DataColumnDef, org.roger600.gwt.editorsample.shared.editors.DataColumnDefEditor> chain) {
        listEditor.setEditorChain(chain);
    }


    @Override
    public void flush() {
        listEditor.flush();
    }

    @Override
    public void onPropertyChange(String... paths) {
        listEditor.onPropertyChange(paths);
    }

    @Override
    public void setValue(List<DataColumnDef> value) {
        Logger.log("DataSetDefColumnsEditor#setValue");
        this.columns = value;
        view.clear();
        listEditor.setValue(value);
    }

    @Override
    public void setDelegate(EditorDelegate<List<DataColumnDef>> delegate) {
        listEditor.setDelegate(delegate);
    }
    
    @Override
    public void showErrors(List<EditorError> errors) {
        Logger.log("DataSetDefColumnsEditor#showErrors", errors);
    }

    @Override
    public Widget asWidget() {
        return view.asWidget();
    }
}
