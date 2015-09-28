package org.roger600.gwt.editorsample.shared.editors;

import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.editor.client.ValueAwareEditor;
import org.roger600.gwt.editorsample.shared.model.DataSetDef;

public interface DataSetDefEditor extends ValueAwareEditor<DataSetDef>, HasEditorErrors<DataSetDef> {

    AttributeEditor<String> UUID();
    AttributeEditor<String> name();
    DataSetDefProviderTypeEditor provider();
    DataSetDefColumnsEditor columns();
}
