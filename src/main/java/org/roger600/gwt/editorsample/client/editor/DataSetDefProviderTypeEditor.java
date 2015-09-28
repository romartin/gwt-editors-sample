package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import org.roger600.gwt.editorsample.client.Logger;
import org.roger600.gwt.editorsample.shared.model.DataSetProviderType;

import java.util.List;

public class DataSetDefProviderTypeEditor implements IsWidget, org.roger600.gwt.editorsample.shared.editors.DataSetDefProviderTypeEditor {

    interface View extends IsWidget {
        void init(DataSetDefProviderTypeEditor presenter);
        void setIsBeanType();
        void setIsCSVType();
        void setIsSQLType();
        void setIsElasticSearchType();
        boolean isBeanType();
        boolean isCSVType();
        boolean isSQLType();
        boolean isElasticSearchType();
        void showError(final String message);
    }
    
    View view;
    private DataSetProviderType value;
    
    public DataSetDefProviderTypeEditor() {
        view = GWT.create(DataSetDefProviderTypeEditorView.class);
        view.init(this);
    }

    @Override
    public Widget asWidget() {
        return view.asWidget();
    }

    @Override
    public void showErrors(List<EditorError> errors) {
        Logger.log("DataSetDefProviderTypeEditor#showErrors", errors);
        if (errors != null) {
            for (EditorError error : errors) {
                if (error.getEditor().equals(this)) {
                    view.showError("Error on provider type editor.");            
                }
            }
        }
    }

    @Override
    public void setValue(DataSetProviderType value) {
        Logger.log("DataSetDefProviderTypeEditor#setValue=" + value);
        this.value = value;
        if (DataSetProviderType.BEAN.equals(value)) {
            view.setIsBeanType();
        } else if (DataSetProviderType.CSV.equals(value)) {
            view.setIsCSVType();
        } else if (DataSetProviderType.SQL.equals(value)) {
            view.setIsSQLType();
        } else if (DataSetProviderType.ELASTICSEARCH.equals(value)) {
            view.setIsElasticSearchType();
        }
    }

    @Override
    public DataSetProviderType getValue() {
        if (view.isBeanType()) {
            return DataSetProviderType.BEAN;
        } else if (view.isCSVType()) {
            return DataSetProviderType.CSV;
        } else if (view.isSQLType()) {
            return DataSetProviderType.SQL;
        } else if (view.isElasticSearchType()) {
            return DataSetProviderType.ELASTICSEARCH;
        } 
        
        return null;
    }
    
}
