package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.*;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import org.roger600.gwt.editorsample.client.Logger;
import org.roger600.gwt.editorsample.shared.editors.*;
import org.roger600.gwt.editorsample.shared.editors.DataSetDefProviderTypeEditor;
import org.roger600.gwt.editorsample.shared.model.DataSetDef;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

public class DataSetDefEditor implements IsWidget, org.roger600.gwt.editorsample.shared.editors.DataSetDefEditor {

    interface View extends IsWidget {
        void init(DataSetDefEditor presenter);
        ValueBoxEditorDecorator<String> UUID();
        ValueBoxEditorDecorator<String> name();
        org.roger600.gwt.editorsample.client.editor.DataSetDefProviderTypeEditor provider();
    }
    
    View view;
    private EditorDelegate<DataSetDef> delegate;
    private DataSetDef dataSetDef;
    
    
    public DataSetDefEditor() {
        view = GWT.create(DataSetDefEditorView.class);
        view.init(this);
    }

    @Override
    public Widget asWidget() {
        return view.asWidget();
    }

    @Override
    public void showErrors(List<EditorError> errors) {
        Logger.log("DataSetDefEditor#showErrors", errors);
    }

    @Override
    public void flush() {
        GWT.log("DataSetDefEditor#flush");
    }

    @Override
    public void onPropertyChange(String... paths) {
        GWT.log("DataSetDefEditor#onPropertyChange");
    }

    @Override
    public void setValue(DataSetDef value) {
        GWT.log("DataSetDefEditor#setValue");
        this.dataSetDef = value;
    }

    @Override
    public ValueBoxEditorDecorator<String> UUID() {
        return view.UUID();
    }

    @Override
    public ValueBoxEditorDecorator<String> name() {
        return view.name();
    }

    @Override
    public DataSetDefProviderTypeEditor provider() {
        return view.provider();
    }

    @Override
    public void setDelegate(EditorDelegate<DataSetDef> delegate) {
        GWT.log("DataSetDefEditor#setDelegate");
        this.delegate = delegate;
    }

    

}
