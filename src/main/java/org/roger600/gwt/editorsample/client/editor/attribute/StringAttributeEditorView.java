package org.roger600.gwt.editorsample.client.editor.attribute;

import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.user.client.ui.TextBox;

import java.util.List;

public class StringAttributeEditorView extends ValueBoxEditorDecorator<String> implements StringAttributeEditor.View {

    public StringAttributeEditorView() {
        super.setValueBox(new TextBox());
    }
    
    @Override
    public void showErrors(List<EditorError> errors) {
        super.showErrors(errors);
    }
}
