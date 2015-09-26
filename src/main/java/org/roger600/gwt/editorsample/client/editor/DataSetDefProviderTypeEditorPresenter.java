package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import org.roger600.gwt.editorsample.shared.editor.DataSetDefProviderTypeEditor;
import org.roger600.gwt.editorsample.shared.model.DataSetProviderType;

public class DataSetDefProviderTypeEditorPresenter implements IsWidget, IsEditor<DataSetDefProviderTypeEditor> {
    
    interface View extends IsWidget, DataSetDefProviderTypeEditor {
        
    }
    
    View view;
    private DataSetProviderType type;
    
    public DataSetDefProviderTypeEditorPresenter() {
        view = GWT.create(DataSetDefEditorView.class);
    }

    @Override
    public DataSetDefProviderTypeEditor asEditor() {
        return view;
    }

    @Override
    public Widget asWidget() {
        return view.asWidget();
    }

    public void edit(final DataSetProviderType providerType) {
        this.type = providerType;
    }
    
}
