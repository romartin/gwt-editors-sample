package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import org.roger600.gwt.editorsample.shared.model.DataSetProviderType;

import java.util.List;

public class DataSetDefProviderTypeEditorView extends Composite implements DataSetDefProviderTypeEditorPresenter.View {

    interface Binder extends UiBinder<Widget, DataSetDefProviderTypeEditorView> {
        Binder BINDER = GWT.create(Binder.class);
    }
    
    @UiField
    @Ignore
    CheckBox staticCheckBox;

    @UiField
    @Ignore
    CheckBox beanCheckBox;

    @UiField
    @Ignore
    CheckBox sqlCheckBox;

    @UiField
    @Ignore
    CheckBox csvCheckBox;

    @UiField
    @Ignore
    CheckBox elasticCheckBox;

    @UiField
    @Ignore
    HTML errorLabel;
    
    @UiConstructor
    public DataSetDefProviderTypeEditorView() {
        initWidget(Binder.BINDER.createAndBindUi(this));
    }

    @Override
    public DataSetProviderType getValue() {
        return null;
    }

    @Override
    public void setValue(DataSetProviderType value) {

    }

    @Override
    public void setValue(DataSetProviderType value, boolean fireEvents) {

    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<DataSetProviderType> handler) {
        return null;
    }

    @Override
    public void showErrors(List<EditorError> errors) {

    }
}
