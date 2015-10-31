package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import org.roger600.gwt.editorsample.client.Logger;
import org.roger600.gwt.editorsample.shared.editors.AttributeEditor;
import org.roger600.gwt.editorsample.shared.model.DataColumnDef;

import java.util.List;

public class DataColumnDefEditor implements IsWidget, org.roger600.gwt.editorsample.shared.editors.DataColumnDefEditor {

    interface View extends IsWidget {
        void init(DataColumnDefEditor presenter, DefaultAttributeEditor.View attrEditorView);
    }
    
    public View view;
    private EditorDelegate<DataColumnDef> delegate;
    private DataColumnDef column;
    private DefaultAttributeEditor idEditor;
    
    public DataColumnDefEditor() {
        super();
        final TextBox idBox = new TextBox();
        final ValueBoxEditor<String> idBoxEditor = ValueBoxEditor.of(idBox);
        idEditor = new DefaultAttributeEditor();
        view = GWT.create(DataColumnDefEditorView.class);
        view.init(this, idEditor.view);
    }

    @Override
    public Widget asWidget() {
        return view.asWidget();
    }

    @Override
    public AttributeEditor<String> id() {
        return idEditor;
    }
    
    @Override
    public void showErrors(List<EditorError> errors) {
        Logger.log("DataColumnDefEditor#showErrors", errors);
    }

    /*@Override
    public void flush() {
        Logger.log("DataColumnDefEditor#flush");
    }

    @Override
    public void onPropertyChange(String... paths) {
        Logger.log("DataColumnDefEditor#onPropertyChange");
    }

    @Override
    public void setValue(DataColumnDef value) {
        Logger.log("DataColumnDefEditor#setValue=" + ( value != null ? value.getId() : "") );
        this.column = value;
    }

    @Override
    public void setDelegate(EditorDelegate<DataColumnDef> delegate) {
        this.delegate = delegate;
    }*/

}
