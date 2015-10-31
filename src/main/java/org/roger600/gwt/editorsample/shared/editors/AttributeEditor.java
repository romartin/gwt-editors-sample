package org.roger600.gwt.editorsample.shared.editors;

import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.editor.client.LeafValueEditor;

public interface AttributeEditor<T> extends LeafValueEditor<T>, HasEditorErrors<T> {
    
}
