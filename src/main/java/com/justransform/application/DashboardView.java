package com.justransform.application;

import java.util.ArrayList;
import java.util.List;

import com.justransform.model.TransactionVo;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.material.Material;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.themes.ValoTheme;

@Route("dashboard")
@Theme(value = Material.class, variant = Material.DARK)
public class DashboardView extends VerticalLayout {
	CustomLayout content =null;
	/**
	 * 
	 */
	
	 Grid<TransactionVo> grid = new Grid<>();
	 private @Id("textField") TextField textField;
	 private @Id("greeting") Label greeting;
	public DashboardView() {
		
		//Header Layout 
		HorizontalLayout headerLayout = new HorizontalLayout();
		headerLayout.setSizeUndefined();
    	headerLayout.setWidth("100%");
    	headerLayout.setHeight("10%");
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
    	
    	TransactionVo transaction = new TransactionVo();
    	transaction.setConnectionID("1");
    	transaction.setEmailID("a@gmail.com");
    	transaction.setTransactionId("2");
    	List<TransactionVo> transactionList = new ArrayList<>();
    	transactionList.add(transaction);
    	
    	 grid.setSizeFull();
         grid.addColumn(TransactionVo::getConnectionID).setHeader("ConnectionID");
         grid.addColumn(TransactionVo::getEmailID).setHeader("EmailId");
         grid.addColumn(TransactionVo::getTransactionId).setHeader("TransactionID");
         grid.setItems(transactionList);
         
    	//Layout for menus
        TransactionTreeGrid transactionTreeGrid = new TransactionTreeGrid();
    	VerticalLayout menubar = new VerticalLayout();
    	menubar.getElement().getStyle().set("background-color","#004362");
    	menubar.setWidth("20%");
    	menubar.setHeight("100%");
    	menubar.setAlignItems(getAlignItems().START);
    	menubar.add(transactionTreeGrid.getGrid());
    	
		VerticalLayout dashboard = new VerticalLayout();
		dashboard.getElement().getStyle().set("background-color", "#f0f8ff");
		dashboard.setWidth("80%");
		dashboard.setHeight("100%");

		HorizontalLayout parentLayout = new HorizontalLayout(menubar,dashboard);
		parentLayout.setHeight("90%");
		parentLayout.setWidth("100%");
		
		
		HorizontalLayout table = new HorizontalLayout(grid);
		table.setAlignItems(Alignment.START);
		table.setSizeFull();
		setHeight("100vh");
		
		dashboard.add(table);
    	add(headerLayout);
    	add(parentLayout);
	}
	
	
}