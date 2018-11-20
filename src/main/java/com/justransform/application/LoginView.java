package com.justransform.application;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.justransform.model.User;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.material.Material;


@HtmlImport("frontend://bower_components/vaadin-lumo-styles/color.html")
@HtmlImport("frontend://bower_components/vaadin-lumo-styles/typography.html")
@HtmlImport("frontend://bower_components/vaadin-lumo-styles/sizing.html")
@HtmlImport("frontend://bower_components/vaadin-lumo-styles/spacing.html")
@HtmlImport("frontend://bower_components/vaadin-lumo-styles/style.html")
@HtmlImport("frontend://bower_components/vaadin-lumo-styles/icons.html")
@Route("login")
@StyleSheet("styles.css")
@Theme(value = Material.class, variant = Material.DARK)
public class LoginView extends VerticalLayout {

    /**
     * @param bean
     */
    public LoginView() {
    	
    	HorizontalLayout parentLayout = new HorizontalLayout();
    	//parentLayout.getElement().getStyle().set("background-color", "#ccd8e5");
    	
    	setSizeFull();
    	HorizontalLayout headerLayout = new HorizontalLayout();
    	headerLayout.setSizeUndefined();
    	headerLayout.setWidth("100%");
    	headerLayout.setHeight("7%");
    	headerLayout.getElement().getStyle().set("background-color","#004362")
    	.set("color","#ffffff");
    	
    	Label logo = new Label("justransform");
    	logo.getElement().getStyle().set("font-size","16px").set("font-weight", "bold");
    	
    	HorizontalLayout logolayout = new HorizontalLayout();
    	Image image = new Image();
    	image.setSrc("https://demo.justransform.com/VAADIN/themes/jt-theme/images/logo.png");
    	logolayout.add(image);
    	
    	headerLayout.add(logolayout);
    	headerLayout.add(logo);
    	headerLayout.setAlignItems(getDefaultHorizontalComponentAlignment().START);
    	
    	HorizontalLayout horizontalLayout = new HorizontalLayout();
    	horizontalLayout.setSizeUndefined();
    	horizontalLayout.setSpacing(true);
    	horizontalLayout.getElement().getStyle().set("background","#F3F7F6")
    	.set("color", "#474747").set("border-radius", "4px").set("border", "1px solid #d5d5d5");
    	
    	VerticalLayout fields = new VerticalLayout();
		fields.setSpacing(true);
		fields.setSizeUndefined();
		fields.getStyle().get("fields");
		
    	
		Label loginLable = new Label("Login");
		loginLable.setText("Login");
		loginLable.setSizeUndefined();
		loginLable.getElement().getStyle().set("color", "#484A49").set("font-weight", "bold");
		
		
		Label UserNameLable = new Label("UserName");
		UserNameLable.setText("UserName");
		UserNameLable.setSizeUndefined();
		UserNameLable.getElement().getStyle().set("color", "#484A49");
		
    	TextField userName = new TextField();
    	userName.getElement().getStyle().set("color", "#484A49");
    	userName.focus();
    	
    	Label passwordLable = new Label("Password");
    	passwordLable.setText("Password");
    	passwordLable.setSizeUndefined();
    	passwordLable.getElement().getStyle().set("color", "#484A49");
    	
    	PasswordField passwordField = new PasswordField();
    	passwordField.getElement().getStyle().set("color", "#484A49");
    	passwordField.focus();
    	
    	Button button = new Button("SignIn");
    	button.getElement().getStyle().set("color","white").set("background", "#4169e1");
    	button.setWidth("60%");
    
    	
    	button.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> args) {
				Response response=null;
				System.out.println("hello "+userName.getValue());
				String url = "http://localhost:8080/api/getUser?username="+userName.getValue()+"&password="+passwordField.getValue();
				Client client = ClientBuilder.newBuilder().build();
				WebTarget target = client.target(url);
				response = target.request(MediaType.APPLICATION_JSON).get();
				User user = response.readEntity(User.class);
				
				int status = response.getStatus();
				
				if(status!=200)
				{
					Notification.show("Invalid Username or Password", 1000, Position.MIDDLE);
					
				}else {
					Notification.show("Valid Username or Password", 5, Position.MIDDLE);
					getUI().get().getSession().setAttribute("emailId", user.getEmailId());
					getUI().ifPresent(ui -> ui.navigate("dashboard"));
				}
				
				
			}
		});
    	
        fields.add(loginLable,UserNameLable,userName,passwordLable,passwordField,button);
        fields.setVisible(true);
        horizontalLayout.add(fields);
        parentLayout.add(horizontalLayout);
        add(headerLayout);
        add(parentLayout);
        parentLayout.setAlignItems(getHorizontalComponentAlignment(horizontalLayout).CENTER);
        setHorizontalComponentAlignment(Alignment.CENTER, parentLayout);
    }
    
    
   
}
