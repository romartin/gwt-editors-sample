package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class DataSetDefEditorView extends Composite implements DataSetDefEditor.View {

    interface Binder extends UiBinder<Widget, DataSetDefEditorView> {
        Binder BINDER = GWT.create(Binder.class);
    }

    @UiField(provided = true)
    StringAttributeEditor uuid;

    @UiField(provided = true)
    StringAttributeEditor name;

    @UiField(provided = true)
    DataSetDefProviderTypeEditor provider;

    @UiField(provided = true)
    DataSetDefColumnsEditor columns;

    DataSetDefEditor presenter;
    
    public DataSetDefEditorView() {
        
    }

    @Override
    public void init(DataSetDefEditor presenter, StringAttributeEditor uuidEditor, StringAttributeEditor nameEditor,
                     DataSetDefProviderTypeEditor providerTypeEditor, DataSetDefColumnsEditor columnsEditor) {
        this.presenter = presenter;
        uuid = uuidEditor;
        name = nameEditor;
        provider = providerTypeEditor;
        columns = columnsEditor;
        initWidget(Binder.BINDER.createAndBindUi(this));
    }

}
