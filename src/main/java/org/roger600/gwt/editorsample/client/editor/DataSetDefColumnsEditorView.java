package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class DataSetDefColumnsEditorView extends Composite implements DataSetDefColumnsEditor.View {

    interface Binder extends UiBinder<Widget, DataSetDefColumnsEditorView> {
        Binder BINDER = GWT.create(Binder.class);
    }

    @UiField
    VerticalPanel columnsPanel;
    
    private DataSetDefColumnsEditor presenter;
    
    @UiConstructor
    public DataSetDefColumnsEditorView() {
        initWidget(Binder.BINDER.createAndBindUi(this));
    }

    @Override
    public void init(DataSetDefColumnsEditor presenter) {
        this.presenter = presenter;
    }

    @Override
    public void insert(DataColumnDefEditor.View editorWidget) {
        columnsPanel.add(editorWidget.asWidget());
    }

    @Override
    public void clear() {
        columnsPanel.clear();
    }


}
