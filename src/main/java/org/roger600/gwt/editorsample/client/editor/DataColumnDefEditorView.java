package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class DataColumnDefEditorView extends Composite implements DataColumnDefEditor.View {

    interface Binder extends UiBinder<Widget, DataColumnDefEditorView> {
        Binder BINDER = GWT.create(Binder.class);
    }

    @UiField(provided = true)
    ValueBoxEditorDecorator<String> id;
    
    private DataColumnDefEditor presenter;
    
    public DataColumnDefEditorView() {
        
    }

    @Override
    public void init(DataColumnDefEditor presenter, ValueBoxEditorDecorator<String> idEditor) {
        this.presenter = presenter;
        this.id = idEditor;
        initWidget(Binder.BINDER.createAndBindUi(this));
    }

}
