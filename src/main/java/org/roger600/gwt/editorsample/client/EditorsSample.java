package org.roger600.gwt.editorsample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.roger600.gwt.editorsample.client.editor.DataSetDefEditorPresenter;
import org.roger600.gwt.editorsample.shared.model.DataSetDef;
import org.roger600.gwt.editorsample.shared.model.DataSetProviderType;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class EditorsSample implements EntryPoint {

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

  private final Messages messages = GWT.create(Messages.class);

  private DataSetDef def;
  
  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    initDef();
    
    final DataSetDefEditorPresenter presenter = new DataSetDefEditorPresenter();
    
    final VerticalPanel mainPanel = new VerticalPanel();
    final Button editButton = new Button("Edit");
    final Button saveButton = new Button("Save");
    final Button validateButton = new Button("Validate");
    editButton.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        presenter.edit(def);
      }
    });
    saveButton.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        presenter.save();
        EditorsSample.this.def = presenter.getDataSetDef();
      }
    });
    validateButton.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        presenter.validate(def);
      }
    });
    mainPanel.add(presenter);
    mainPanel.add(editButton);
    mainPanel.add(saveButton);
    mainPanel.add(validateButton);
    RootPanel.get().add(mainPanel);
  }
  
  private void initDef() {
    def =  new DataSetDef();
    def.setUUID("uuid1");
    def.setName("name1");
    def.setProvider(DataSetProviderType.BEAN);
  }
  
}
