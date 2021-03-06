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
    DataSetDefBasicAttributesEditor.View basicAttributesEditorView;

    @UiField(provided = true)
    DataSetDefProviderTypeEditor.View provider;

    @UiField(provided = true)
    DataSetDefColumnsEditor.View columns;

    DataSetDefEditor presenter;

    @Override
    public void init(DataSetDefEditor presenter, DataSetDefBasicAttributesEditor.View basicAttributesEditorView,
                     DataSetDefProviderTypeEditor.View providerTypeEditor, DataSetDefColumnsEditor.View columnsEditor) {
        this.presenter = presenter;
        this.basicAttributesEditorView = basicAttributesEditorView;
        provider = providerTypeEditor;
        columns = columnsEditor;
        initWidget(Binder.BINDER.createAndBindUi(this));
    }
    
    
}
