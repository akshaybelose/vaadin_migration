package com.justransform.jtapp.ui.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.CssLayout;

public abstract class AbstractView extends CssLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AbstractView() {
		setSizeFull();
		addStyleName("jt-content");
	}

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {

	}
}
