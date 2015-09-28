package org.roger600.gwt.editorsample.shared.editors;

import com.google.gwt.editor.client.CompositeEditor;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.editor.client.ValueAwareEditor;
import com.google.gwt.editor.client.adapters.EditorSource;
import com.google.gwt.editor.client.adapters.ListEditor;
import org.roger600.gwt.editorsample.shared.model.DataColumnDef;

import java.util.List;

public interface DataSetDefColumnsEditor extends CompositeEditor<List<DataColumnDef>, DataColumnDef, DataColumnDefEditor>, HasEditorErrors<List<DataColumnDef>> {
    
}
