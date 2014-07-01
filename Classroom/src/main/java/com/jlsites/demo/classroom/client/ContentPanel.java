package com.jlsites.demo.classroom.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTMLPanel;

public class ContentPanel extends Composite {

  private static ContentPanelUiBinder uiBinder = GWT.create(ContentPanelUiBinder.class);

  interface ContentPanelUiBinder extends UiBinder<DockPanel, ContentPanel> {
  }

  @UiField
  MenuPanel menuPanel;
  @UiField
  HTMLPanel contentArea;

  public ContentPanel() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @Override
  protected void onLoad() {
    super.onLoad();

    bind();

    // show home by default?
    contentArea.clear();
    contentArea.add(new Home());
  }

  private void bind() {
    MenuHandler menuHandler = new MenuHandler();
    menuPanel.homeAnchor.addClickHandler(menuHandler);
    menuPanel.homeworkAnchor.addClickHandler(menuHandler);
    menuPanel.assessmentsAnchor.addClickHandler(menuHandler);
  }

  class MenuHandler implements ClickHandler {

    @Override
    public void onClick(ClickEvent event) {
      if (event.getSource() == menuPanel.homeAnchor) {
        contentArea.clear();
        contentArea.add(new Home());
      } else if (event.getSource() == menuPanel.homeworkAnchor) {
        contentArea.clear();
        contentArea.add(new HomeworkAssignments());
      } else if (event.getSource() == menuPanel.assessmentsAnchor) {
        contentArea.clear();
        contentArea.add(new Assessments());
      }
    }

  }

}
