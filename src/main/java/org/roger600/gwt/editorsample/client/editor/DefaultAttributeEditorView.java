package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;

import java.util.List;

public class DefaultAttributeEditorView<T> extends ValueBoxEditorDecorator<T> implements DefaultAttributeEditor.View<T> {

    @Override
    public void showErrors(List<EditorError> errors) {
        super.showErrors(errors);
    }
}
