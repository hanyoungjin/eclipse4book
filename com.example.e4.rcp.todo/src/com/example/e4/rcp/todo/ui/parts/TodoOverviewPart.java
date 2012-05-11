package com.example.e4.rcp.todo.ui.parts;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import com.example.e4.rcp.todo.model.ITodoModel;

public class TodoOverviewPart {
	
	private static int i = 0;

	@PostConstruct
	public void createControls(Composite parent,
			final EPartService partService, final ESelectionService selectionService) {
		Button button = new Button(parent, SWT.PUSH);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String s = "Works? " + i++;
				System.out.println("Setting selection " + s);
				selectionService.setSelection(s);
				MPart part = partService
						.findPart("com.example.e4.rcp.ui.parts.tododetail");
				part.setVisible(true);
				partService.showPart(part, PartState.ACTIVATE);
			}
		});

	}
	
	@Inject 
	void setModel(@Optional ITodoModel model){
		System.out.println("setter called");
		if (model==null) {
			System.out.println("is null");
		}
	}
	

	@PreDestroy
	public void dispose() {

	}

}