package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.roger600.gwt.editorsample.shared.model.DataSetDef;

import java.util.List;

public class DataSetDefEditorView extends Composite implements DataSetDefEditor.View {

    interface Binder extends UiBinder<Widget, DataSetDefEditorView> {
        Binder BINDER = GWT.create(Binder.class);
    }

    @UiField
    ValueBoxEditorDecorator<String> uuid;

    @UiField
    ValueBoxEditorDecorator<String> name;
    
    @UiField
    DataSetDefProviderTypeEditor provider;

    DataSetDefEditor presenter;
    
    @UiConstructor
    public DataSetDefEditorView() {
        initWidget(Binder.BINDER.createAndBindUi(this));
    }

    @Override
    public void init(DataSetDefEditor presenter) {
        this.presenter = presenter;
    }

    @Override
    public ValueBoxEditorDecorator<String> UUID() {
        return uuid;
    }

    @Override
    public ValueBoxEditorDecorator name() {
        return name;
    }

    @Override
    public DataSetDefProviderTypeEditor provider() {
        return provider;
    }
}
