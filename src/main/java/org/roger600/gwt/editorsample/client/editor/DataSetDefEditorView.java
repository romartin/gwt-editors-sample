package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class DataSetDefEditorView extends Composite implements DataSetDefEditorPresenter.View {

    interface Binder extends UiBinder<Widget, DataSetDefEditorView> {
        Binder BINDER = GWT.create(Binder.class);
    }

    @UiField
    @Path("UUID")
    ValueBoxEditorDecorator<String> uuid;

    @UiField
    @Path("name")
    ValueBoxEditorDecorator<String> name;
    
    @UiConstructor
    public DataSetDefEditorView() {
        initWidget(Binder.BINDER.createAndBindUi(this));
    }
    
    
}
