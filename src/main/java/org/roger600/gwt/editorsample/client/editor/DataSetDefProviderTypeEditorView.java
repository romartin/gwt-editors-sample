package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class DataSetDefProviderTypeEditorView extends Composite implements DataSetDefProviderTypeEditor.View {

    interface Binder extends UiBinder<Widget, DataSetDefProviderTypeEditorView> {
        Binder BINDER = GWT.create(Binder.class);
    }
    
    @UiField
    CheckBox beanCheckBox;

    @UiField
    CheckBox sqlCheckBox;

    @UiField
    CheckBox csvCheckBox;

    @UiField
    CheckBox elasticCheckBox;

    @UiField
    HTML errorLabel;
    
    private DataSetDefProviderTypeEditor presenter;
    
    @UiConstructor
    public DataSetDefProviderTypeEditorView() {
        initWidget(Binder.BINDER.createAndBindUi(this));
    }

    @Override
    public void init(DataSetDefProviderTypeEditor presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setIsBeanType() {
        enableType(beanCheckBox);
    }

    @Override
    public void setIsCSVType() {
        enableType(csvCheckBox);
    }

    @Override
    public void setIsSQLType() {
        enableType(sqlCheckBox);
    }

    @Override
    public void setIsElasticSearchType() {
        enableType(elasticCheckBox);
    }

    @Override
    public boolean isBeanType() {
        return beanCheckBox.getValue();
    }

    @Override
    public boolean isCSVType() {
        return csvCheckBox.getValue();
    }

    @Override
    public boolean isSQLType() {
        return sqlCheckBox.getValue();
    }

    @Override
    public boolean isElasticSearchType() {
        return elasticCheckBox.getValue();
    }

    @Override
    public void showError(String message) {
        errorLabel.setText(message);
        errorLabel.setVisible(true);
    }

    private void enableType(CheckBox type) {
        clear();
        type.setValue(true);
    }
    
    public void clearError() {
        errorLabel.setText("");
        errorLabel.setVisible(false);
    }
    
    private void clear() {
        beanCheckBox.setValue(false);
        sqlCheckBox.setValue(false);
        csvCheckBox.setValue(false);
        elasticCheckBox.setValue(false);
        clearError();
    }
}
