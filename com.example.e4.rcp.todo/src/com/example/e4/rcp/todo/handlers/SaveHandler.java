package com.example.e4.rcp.todo.handlers;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;

public class SaveHandler {
	@Execute
	public void execute() {
		
	}

	@CanExecute
	public boolean canExecute() {
		return true;
	}

}