package com.sab.training.rcp.demo.texteditor;

public class MyTextEditor extends org.eclipse.ui.editors.text.TextEditor {

	public MyTextEditor() {
		super();
		setSourceViewerConfiguration(new MySourceViewerConfiguration());
	}

}
