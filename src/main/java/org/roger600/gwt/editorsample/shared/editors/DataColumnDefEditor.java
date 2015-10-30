package org.roger600.gwt.editorsample.shared.editors;

import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.ValueAwareEditor;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import org.roger600.gwt.editorsample.shared.model.DataColumnDef;

public interface DataColumnDefEditor extends HasEditorErrors<DataColumnDef> {
    
    ValueBoxEditorDecorator<String> id();
    
}
