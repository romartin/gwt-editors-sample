package org.roger600.gwt.editorsample.client.editor.attribute;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import org.roger600.gwt.editorsample.client.Logger;
import org.roger600.gwt.editorsample.shared.editors.AttributeEditor;

import java.util.ArrayList;
import java.util.List;

public class StringAttributeEditor implements IsWidget, AttributeEditor<String> {

    public interface View extends IsWidget, IsEditor<ValueBoxEditor<String>>, HasEditorErrors<String> {
        
    }
    
    public View view;
    
    public StringAttributeEditor() {
        view = new StringAttributeEditorView();
    }

    @Override
    public Widget asWidget() {
        return view.asWidget();
    }

    @Override
    public void showErrors(List<EditorError> errors) {
        final List<EditorError> subEditorErrors = new ArrayList<>();
        if (errors != null && !errors.isEmpty()) {
            Logger.log("StringAttributeEditor#showErrors", errors);
            for (EditorError error : errors) {
                if (error.getEditor().equals(this)) {
                    final EditorError subEditorError = createSubEditorError(error);
                    subEditorErrors.add(subEditorError);
                }
            }
        }
        view.showErrors(subEditorErrors);
    }
    
    private EditorError createSubEditorError(final EditorError error) {
        return new EditorError() {
            @Override
            public String getAbsolutePath() {
                return error.getAbsolutePath();
            }

            @Override
            public Editor<?> getEditor() {
                return view.asEditor();
            }

            @Override
            public String getMessage() {
                return error.getMessage();
            }

            @Override
            public String getPath() {
                return error.getPath();
            }

            @Override
            public Object getUserData() {
                return error.getUserData();
            }

            @Override
            public Object getValue() {
                return error.getValue();
            }

            @Override
            public boolean isConsumed() {
                return false;
            }

            @Override
            public void setConsumed(boolean consumed) {

            }
        };
    }

    @Override
    public void setValue(String value) {
        view.asEditor().setValue(value);
    }

    @Override
    public String getValue() {
        return view.asEditor().getValue();
    }
}
