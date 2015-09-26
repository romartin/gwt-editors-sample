package org.roger600.gwt.editorsample.client;

import org.roger600.gwt.editorsample.client.editor.DataSetDefEditorPresenter;
import org.roger600.gwt.editorsample.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.roger600.gwt.editorsample.shared.model.DataSetDef;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class EditorsSample implements EntryPoint {

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

  private final Messages messages = GWT.create(Messages.class);

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    final DataSetDef def = new DataSetDef();
    def.setUUID("uuid1");
    def.setName("name1");
    
    final DataSetDefEditorPresenter presenter = new DataSetDefEditorPresenter();
    
    final VerticalPanel mainPanel = new VerticalPanel();
    final Button editButton = new Button("Edit");
    editButton.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        presenter.edit(def);
      }
    });

    mainPanel.add(presenter);
    mainPanel.add(editButton);
    RootPanel.get().add(mainPanel);
  }
  
}
