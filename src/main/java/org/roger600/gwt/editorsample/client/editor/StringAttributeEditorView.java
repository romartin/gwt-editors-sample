package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import java.util.List;

public class StringAttributeEditorView extends Composite implements AttributeEditor.View<String> {

    interface Binder extends UiBinder<Widget, StringAttributeEditorView> {
        Binder BINDER = GWT.create(Binder.class);
    }

    @UiField
    ValueBoxEditorDecorator<String> field;
    
    @UiField
    TextBox fieldBox;
    
    private AttributeEditor presenter;
    
    public StringAttributeEditorView() {
        initWidget(Binder.BINDER.createAndBindUi(this));
    }

    @Override
    public void init(AttributeEditor presenter) {
        this.presenter = presenter;
    }

    @Override
    public String getValue() {
        return field.asEditor().getValue();
    }

    @Override
    public void setValue(String value) {
        setValue(value, false);
    }

    @Override
    public void setValue(String value, boolean fireEvents) {
        String oldValue = getValue();
        field.asEditor().setValue(value);
        if (fireEvents) {
            ValueChangeEvent.fireIfNotEqual(this, oldValue, value);
        }
        
    }

    @Override
    public void showErrors(List<EditorError> errors) {
        field.showErrors(errors);
    }
    
    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
        return fieldBox.addValueChangeHandler(handler);
    }
}
