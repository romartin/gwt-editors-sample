package org.roger600.gwt.editorsample.shared.editors;

import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.ValueAwareEditor;
import org.roger600.gwt.editorsample.shared.model.DataColumnDef;

public interface DataColumnDefEditor extends ValueAwareEditor<DataColumnDef>, HasEditorErrors<DataColumnDef> {
    
    AttributeEditor<String> id();
    
}
