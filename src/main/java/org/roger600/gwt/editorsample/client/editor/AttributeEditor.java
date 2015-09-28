package org.roger600.gwt.editorsample.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.*;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import org.roger600.gwt.editorsample.client.Logger;

import java.util.List;

public class AttributeEditor<T> implements IsWidget, org.roger600.gwt.editorsample.shared.editors.AttributeEditor<T> {

    interface View<T> extends IsWidget, HasValue<T>, HasEditorErrors<T> {
        void init(AttributeEditor<T> presenter);
    }
    
    View<T> view;
    
    public AttributeEditor() {
        view = GWT.create(StringAttributeEditorView.class);
        view.init(this);
        view.addValueChangeHandler(new ValueChangeHandler<T>() {
            @Override
            public void onValueChange(ValueChangeEvent<T> event) {
                T value = event.getValue();
                Logger.log("DataSetDefAttributeEditor#View.addValueChangeHandler - value=" + value);
            }
        });
    }

    @Override
    public Widget asWidget() {
        return view.asWidget();
    }


    @Override
    public void showErrors(List<EditorError> errors) {
        Logger.log("DataSetDefAttributeEditor#showErrors", errors);
        view.showErrors(errors);
    }

    @Override
    public void setValue(T value) {
        Logger.log("DataSetDefAttributeEditor#setValue=" + value);
        view.setValue(value);
    }

    @Override
    public T getValue() {
        return view.getValue();
    }

}
