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

    @Override
    public CompositeEditor<List<DataColumnDef>, DataColumnDef, org.roger600.gwt.editorsample.shared.editors.DataColumnDefEditor> asEditor() {
        return listEditor;
    }

    @Override
    public void setDelegate(EditorDelegate<List<DataColumnDef>> delegate) {
        listEditor.setDelegate(delegate);
    }

    interface View extends IsWidget {
        void init(DataSetDefColumnsEditor presenter);
        void insert(Widget editorWidget);
        void clear();
    }
    
    private View view;
    private ListEditor<DataColumnDef, org.roger600.gwt.editorsample.shared.editors.DataColumnDefEditor> listEditor;
    
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
    public void showErrors(List<EditorError> errors) {
        Logger.log("DataSetDefColumnsEditor#showErrors", errors);
    }

    @Override
    public Widget asWidget() {
        return view.asWidget();
    }
}
