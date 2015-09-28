package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueBoxBase;
import com.google.gwt.user.client.ui.Widget;
import org.roger600.gwt.editorsample.client.Logger;
import org.roger600.gwt.editorsample.shared.editors.AttributeEditor;

import java.util.List;

public class StringAttributeEditor implements IsWidget, IsEditor<org.roger600.gwt.editorsample.shared.editors.AttributeEditor<String>> {

    
    public static class ValueBoxAttributeEditor extends ValueBoxEditorDecorator<String> implements org.roger600.gwt.editorsample.shared.editors.AttributeEditor<String> {

        @UiConstructor
        public ValueBoxAttributeEditor() {
        }

        public ValueBoxAttributeEditor(ValueBoxBase<String> widget, ValueBoxEditor<String> editor) {
            super(widget, editor);
        }

        @Override
        public void setValue(String value) {
            super.asEditor().setValue(value);
        }

        @Override
        public String getValue() {
            return super.asEditor().getValue();
        }
    }

    ValueBoxAttributeEditor stringEditor;

    public StringAttributeEditor() {
        stringEditor = GWT.create(ValueBoxAttributeEditor.class);
        stringEditor.setValueBox(new TextBox());
    }

    @Override
    public Widget asWidget() {
        return stringEditor.asWidget();
    }


    @Override
    public AttributeEditor<String> asEditor() {
        return stringEditor;
    }
}
