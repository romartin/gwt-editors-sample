package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueBoxBase;
import com.google.gwt.user.client.ui.Widget;
import org.roger600.gwt.editorsample.client.Logger;

import java.util.List;

public class StringAttributeEditor implements IsWidget, org.roger600.gwt.editorsample.shared.editors.AttributeEditor<String> {

    ValueBoxEditorDecorator<String> stringEditor;
    
    public StringAttributeEditor() {
        stringEditor = GWT.create(ValueBoxEditorDecorator.class);
        stringEditor.setValueBox(new TextBox());
    }

    @Override
    public Widget asWidget() {
        return stringEditor.asWidget();
    }


    @Override
    public void showErrors(List<EditorError> errors) {
        Logger.log("DataSetDefAttributeEditor#showErrors", errors);
        stringEditor.showErrors(errors);
    }


    @Override
    public LeafValueEditor<String> asEditor() {
        return stringEditor.asEditor();
    }
}
