package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class DataSetDefBasicAttributesEditorView extends Composite implements DataSetDefBasicAttributesEditor.View {

    interface Binder extends UiBinder<Widget, DataSetDefBasicAttributesEditorView> {
        Binder BINDER = GWT.create(Binder.class);
    }

    @UiField(provided = true)
    DefaultAttributeEditor.View uuid;

    @UiField(provided = true)
    DefaultAttributeEditor.View name;


    DataSetDefBasicAttributesEditor presenter;

    @Override
    public void init(DataSetDefBasicAttributesEditor presenter, DefaultAttributeEditor.View uuidEditor, DefaultAttributeEditor.View nameEditor) {
        this.presenter = presenter;
        uuid = uuidEditor;
        name = nameEditor;
        initWidget(Binder.BINDER.createAndBindUi(this));
    }
    
}
