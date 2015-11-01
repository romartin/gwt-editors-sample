package org.roger600.gwt.editorsample.shared.editors;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.editor.client.ValueAwareEditor;
import org.roger600.gwt.editorsample.shared.model.DataSetDef;

public interface DataSetDefEditor extends ValueAwareEditor<DataSetDef>, HasEditorErrors<DataSetDef> {

    @Editor.Path(".")
    DataSetDefBasicAttributesEditor basicAttributesEditor();
    DataSetDefProviderTypeEditor provider();
    DataSetDefColumnsEditor columns();
}
