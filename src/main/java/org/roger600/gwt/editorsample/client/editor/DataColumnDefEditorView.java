package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.roger600.gwt.editorsample.client.editor.attribute.StringAttributeEditor;

public class DataColumnDefEditorView extends Composite implements DataColumnDefEditor.View {

    interface Binder extends UiBinder<Widget, DataColumnDefEditorView> {
        Binder BINDER = GWT.create(Binder.class);
    }

    @UiField(provided = true)
    StringAttributeEditor.View id;
    
    private DataColumnDefEditor presenter;
    
    @Override
    public void init(DataColumnDefEditor presenter, StringAttributeEditor.View attrEditorView) {
        this.presenter = presenter;
        this.id = attrEditorView;
        initWidget(Binder.BINDER.createAndBindUi(this));
    }

}
