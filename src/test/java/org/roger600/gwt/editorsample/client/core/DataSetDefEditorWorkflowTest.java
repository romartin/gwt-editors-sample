package org.roger600.gwt.editorsample.client.core;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.roger600.gwt.editorsample.client.editor.DataSetDefEditor;
import org.roger600.gwt.editorsample.shared.model.DataSetDef;

@RunWith(MockitoJUnitRunner.class)
public class DataSetDefEditorWorkflowTest {

    @Mock
    DataSetDefEditorWorkflow.Driver driver;
    @Mock
    DataSetDefEditor editor;
    
    private DataSetDefEditorWorkflow presenter;

    @Before
    public void setup() {
        presenter = new DataSetDefEditorWorkflow(editor, driver);
    }

    @Test
    public void testEdit() throws Exception {
        final DataSetDef dataSetDef = new DataSetDef();
        presenter.edit(dataSetDef);
    }
    
}
