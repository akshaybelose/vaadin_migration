package com.justransform.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.justransform.model.MenuItems;
import com.vaadin.addon.charts.themes.ValoDarkTheme;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.Column;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.grid.ItemClickEvent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.theme.material.Material;
import com.vaadin.ui.themes.ValoTheme;

@Route("test")
public class TransactionTreeGrid extends VerticalLayout{

	public TransactionTreeGrid() {}

	public Grid getGrid() {

		
		 TreeGrid<MenuItems> grid = new TreeGrid<>(MenuItems.class);
	        grid.setHierarchyColumn("menuItems");
	     
	        MenuItems jtPortal = new MenuItems("JTPortal");
	        MenuItems transactions = new MenuItems("Transactions");
	        MenuItems dashboard = new MenuItems("Dashboard");
	        MenuItems archiveTransaction = new MenuItems("ArchiveTransaction");
	        
	        grid.getTreeData().addItem(null, jtPortal);
	        grid.getTreeData().addItem(jtPortal, transactions);
	        grid.getTreeData().addItem(jtPortal, dashboard);
	        grid.getTreeData().addItem(jtPortal, archiveTransaction);
	        
	        
	        MenuItems jtCommunity = new MenuItems("JT Community");
	        MenuItems jtNetwork = new MenuItems("JT Network");
	        MenuItems connection = new MenuItems("Connection");
	        MenuItems businessProcess = new MenuItems("Business Process");
	        
	        grid.getTreeData().addItem(null, jtCommunity);
	        grid.getTreeData().addItem(jtCommunity, jtNetwork);
	        grid.getTreeData().addItem(jtCommunity, connection);
	        grid.getTreeData().addItem(jtCommunity, businessProcess);
	        
	        
	        MenuItems jtMapAndTestSuit = new MenuItems("JT Map & Test Suit");
	        MenuItems jtMapper = new MenuItems("JT Mapper");
	        MenuItems jtSpecification = new MenuItems("JT Specification");
	        MenuItems b2bTestManager = new MenuItems("B2B Test Manager");
	        
	        grid.getTreeData().addItem(null, jtMapAndTestSuit);
	        grid.getTreeData().addItem(jtMapAndTestSuit, jtMapper);
	        grid.getTreeData().addItem(jtMapAndTestSuit, jtSpecification);
	        grid.getTreeData().addItem(jtMapAndTestSuit, b2bTestManager);
	        
	        MenuItems jtOBManagement = new MenuItems("JT OB Management");
	        MenuItems jtInbox = new MenuItems("JT Inbox");
	        MenuItems program = new MenuItems("Program");
	        MenuItems tastManager = new MenuItems("Task Manager");
	        MenuItems calender = new MenuItems("Calender");
	        
	        grid.getTreeData().addItem(null, jtOBManagement);
	        grid.getTreeData().addItem(jtOBManagement, jtInbox);
	        grid.getTreeData().addItem(jtOBManagement, program);
	        grid.getTreeData().addItem(jtOBManagement, tastManager);
	        grid.getTreeData().addItem(jtOBManagement, calender);
	        
	        MenuItems jtContentManagement = new MenuItems("JT Content Management");
	        MenuItems jtLibrary = new MenuItems("JT Library");
	        MenuItems jtSpreadSheet = new MenuItems("JT SpreadSheet");
	        MenuItems jtDocument = new MenuItems("JT Document");
	        MenuItems jtDocumentScanner = new MenuItems("JT Document Scanner");
	        MenuItems globalVariables = new MenuItems("Global Variables");
	        MenuItems jtLookUpTable = new MenuItems("JT Look Up Table");
	        
	        grid.getTreeData().addItem(null, jtContentManagement);
	        grid.getTreeData().addItem(jtContentManagement, jtLibrary);
	        grid.getTreeData().addItem(jtContentManagement, jtSpreadSheet);
	        grid.getTreeData().addItem(jtContentManagement, jtDocument);
	        grid.getTreeData().addItem(jtContentManagement, jtDocumentScanner);
	        grid.getTreeData().addItem(jtContentManagement, globalVariables);
	        grid.getTreeData().addItem(jtContentManagement, jtLookUpTable);
	        
	        MenuItems jtUserManagement = new MenuItems("JT User Management");
	        MenuItems adminPortal = new MenuItems("Admin Portal");
	        MenuItems issueTracker = new MenuItems("Issue Tracker");
	        
	        grid.getTreeData().addItem(null, jtUserManagement);
	        grid.getTreeData().addItem(jtUserManagement, adminPortal);
	        grid.getTreeData().addItem(jtUserManagement, issueTracker);
	        grid.setThemeName(Material.DARK);
	        grid.setSelectionMode(SelectionMode.NONE);
	        
	        grid.addItemClickListener(new ComponentEventListener<ItemClickEvent<MenuItems>>(){
					@Override
					public void onComponentEvent(ItemClickEvent<MenuItems> event) {
						
						if(event.getItem().getMenuItems().equals("Transactions")) {
							
							
							String emailId = (String) getUI().get().getCurrent().getSession().getAttribute("emailId");
							System.out.println(emailId);
							Notification.show("Transactions was clicked "+emailId);
							}
						}
					}
	        		);
	        
	        return grid;
	
	}
}
