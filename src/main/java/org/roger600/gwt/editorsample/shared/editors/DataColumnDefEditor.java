package org.roger600.gwt.editorsample.shared.editors;

import com.google.gwt.editor.client.HasEditorErrors;
import org.roger600.gwt.editorsample.shared.model.DataColumnDef;

public interface DataColumnDefEditor extends HasEditorErrors<DataColumnDef> {

    AttributeEditor<String> id();
    
}
