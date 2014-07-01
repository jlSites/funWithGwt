package com.jlsites.how2gwt.gwtwithdb.client;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.jlsites.how2gwt.gwtwithdb.shared.action.AddUserAction;
import com.jlsites.how2gwt.gwtwithdb.shared.action.AddUserResult;
import com.jlsites.how2gwt.gwtwithdb.shared.action.CanDispatchAction;
import com.jlsites.how2gwt.gwtwithdb.shared.action.CanDispatchResult;
import com.jlsites.how2gwt.gwtwithdb.shared.domain.HappyUser;

public class MainView extends Composite {

  private static MainViewBinder uiBinder = GWT.create(MainViewBinder.class);

  interface MainViewBinder extends UiBinder<Widget, MainView> {
  }

  @UiField
  Label labAllUsers;

  @UiField
  Button btnAddUser;

  @UiField
  TextBox textUser;

  @Inject
  InforDialog inforDlg;

  @Inject
  DispatchAsync dispatchAsync;

  public MainView() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @UiHandler("btnDispatchMe")
  void dispatchMe(ClickEvent e) {
    dispatchAsync.execute(new CanDispatchAction(), new AsyncCallback<CanDispatchResult>() {
      @Override
      public void onFailure(Throwable caught) {
        labAllUsers.setText("");

        inforDlg.setText("Dispatch");
        inforDlg.setMessage("Failed to dispatch! The detail message is " + caught.getMessage());
        inforDlg.center();
      }

      @Override
      public void onSuccess(CanDispatchResult result) {
        // popup
        inforDlg.setText("Dispatch");
        inforDlg.setMessage("How are you from Server!");
        inforDlg.center();
      }
    });
  }

  @UiHandler("btnAddUser")
  void addUser(ClickEvent e) {
    AddUserAction action = new AddUserAction();
    action.setUserName(textUser.getText());
    action.setPic(textUser.getText().getBytes());

    dispatchAsync.execute(action, new AsyncCallback<AddUserResult>() {
      @Override
      public void onFailure(Throwable caught) {
        // popup
        inforDlg.setText("Add");
        inforDlg.setMessage("Failed to add the user! The detail message is " + caught.getMessage());
        inforDlg.center();
      }

      @Override
      public void onSuccess(AddUserResult result) {
        // show all users
        StringBuffer sb = new StringBuffer();
        for (HappyUser hUser : result.getAllUsers()) {
          sb.append(hUser.getUserName());
          sb.append(";");
        }
        labAllUsers.setText(sb.toString());

        // popup
        inforDlg.setText("Add");
        inforDlg.setMessage("The user has been successfully added!");
        inforDlg.center();
      }
    });
  }
}
