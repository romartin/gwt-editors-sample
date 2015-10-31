package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.roger600.gwt.editorsample.client.editor.attribute.StringAttributeEditor;

public class DataSetDefEditorView extends Composite implements DataSetDefEditor.View {

    interface Binder extends UiBinder<Widget, DataSetDefEditorView> {
        Binder BINDER = GWT.create(Binder.class);
    }

    @UiField(provided = true)
    StringAttributeEditor.View uuid;

    @UiField(provided = true)
    StringAttributeEditor.View name;

    @UiField(provided = true)
    DataSetDefProviderTypeEditor.View provider;

    @UiField(provided = true)
    DataSetDefColumnsEditor.View columns;

    DataSetDefEditor presenter;

    @Override
    public void init(DataSetDefEditor presenter, StringAttributeEditor.View uuidEditor, StringAttributeEditor.View nameEditor,
                     DataSetDefProviderTypeEditor.View providerTypeEditor, DataSetDefColumnsEditor.View columnsEditor) {
        this.presenter = presenter;
        uuid = uuidEditor;
        name = nameEditor;
        provider = providerTypeEditor;
        columns = columnsEditor;
        initWidget(Binder.BINDER.createAndBindUi(this));
    }
    
    
}
