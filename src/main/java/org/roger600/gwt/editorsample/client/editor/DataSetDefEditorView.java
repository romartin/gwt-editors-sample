package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.roger600.gwt.editorsample.client.Logger;
import org.roger600.gwt.editorsample.shared.model.DataSetDef;

import java.util.List;

public class DataSetDefEditorView extends Composite implements DataSetDefEditorPresenter.View {


    EditorDelegate<DataSetDef> delegate;
    private DataSetDef value;
    
    @Override
    public void flush() {
        GWT.log("DataSetDefEditorView#flush");
    }

    @Override
    public void onPropertyChange(String... paths) {
        GWT.log("DataSetDefEditorView#onPropertyChange");
        
    }

    @Override
    public void setValue(DataSetDef value) {
        GWT.log("DataSetDefEditorView#setValue");
        this.value = value;
    }

    @Override
    public void setDelegate(EditorDelegate<DataSetDef> delegate) {
        GWT.log("DataSetDefEditorView#setDelegate");
        this.delegate = delegate;
    }

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

    @Override
    public void showErrors(List<EditorError> errors) {
        Logger.log("DataSetDefEditorView#showErrors", errors);
    }
    
    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<DataSetDef> handler) {
        GWT.log("DataSetDefEditorView#addValueChangeHandler");
        return addHandler(handler, ValueChangeEvent.getType());
    }
    
}
