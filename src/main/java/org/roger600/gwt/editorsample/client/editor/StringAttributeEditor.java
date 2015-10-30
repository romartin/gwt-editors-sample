package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.HasEditorDelegate;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import org.roger600.gwt.editorsample.client.Logger;

import java.util.LinkedList;
import java.util.List;

public class StringAttributeEditor implements IsWidget, org.roger600.gwt.editorsample.shared.editors.AttributeEditor<String>, HasEditorDelegate<String> {

    ValueBoxEditorDecorator<String> stringEditor;
    private EditorDelegate<String> delegate;
    
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
        Logger.log("StringAttributeEditor#showErrors", errors);
        List<EditorError> subEditorErrors = new LinkedList<>();
        for (EditorError error : errors) {
            if (error.getEditor().equals(this)) {
                GWT.log("SAE: " + error.getPath() + " /" + error.getMessage());
                delegate.recordError(error.getMessage(), error.getValue(), error.getUserData());
            }
        }
        stringEditor.showErrors(errors);
    }

    @Override
    public void setValue(String value) {
        Logger.log("StringAttributeEditor#setValue" + value);
        stringEditor.asEditor().setValue(value);
    }

    @Override
    public String getValue() {
        return stringEditor.asEditor().getValue();
    }

    @Override
    public void setDelegate(EditorDelegate<String> delegate) {
        this.delegate = delegate;
    }
}
