package org.roger600.gwt.editorsample.shared.editors;

import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.editor.client.ValueAwareEditor;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import org.roger600.gwt.editorsample.shared.model.DataSetDef;

public interface DataSetDefEditor extends ValueAwareEditor<DataSetDef>, HasEditorErrors<DataSetDef> {

    ValueBoxEditorDecorator<String> UUID();
    ValueBoxEditorDecorator<String> name();
    DataSetDefProviderTypeEditor provider();
    
}
