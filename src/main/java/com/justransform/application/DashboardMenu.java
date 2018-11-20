package com.justransform.application;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.ui.Panel;
import org.vaadin.addons.collapsiblepanel.CollapsiblePanel;
public class DashboardMenu extends UI {

	public DashboardMenu() {
		HorizontalLayout layout= new HorizontalLayout();
		layout.setSizeUndefined();
		
		VerticalLayout verticalLayoutMenu = new VerticalLayout();
		
		Label transactionLabel = new Label();
		transactionLabel.setText("Transactions");
		
		verticalLayoutMenu.add(transactionLabel);
		layout.add(verticalLayoutMenu);
		add(layout);
		
	}
}
