package org.roger600.gwt.editorsample.client.editor.attribute;

import com.google.gwt.editor.client.EditorError;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.roger600.gwt.editorsample.client.editor.DefaultAttributeEditor;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class DefaultAttributeEditorTest {

    @Mock DefaultAttributeEditor.View view;
    private DefaultAttributeEditor presenter;
    
    @Before
    public void setup() {
        presenter = new DefaultAttributeEditor(view);
    }

    @Test
    public void testShowErrors() throws Exception {
        presenter.showErrors(new ArrayList<EditorError>());
    }
    
    
}
