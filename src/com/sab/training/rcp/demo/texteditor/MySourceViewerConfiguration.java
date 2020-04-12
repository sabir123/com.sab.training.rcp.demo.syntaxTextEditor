package com.sab.training.rcp.demo.texteditor;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class MySourceViewerConfiguration extends SourceViewerConfiguration {
	private static Color DEFAULT_TAG_COLOR = new Color(Display.getCurrent(), new RGB(0,0,0));
	MyRuleScanner scanner;
	
	public MySourceViewerConfiguration() {
		super();
	}
	
	/**
	 * Returns the presentation reconciler ready to be used with the given source viewer.
	 *
	 * @param sourceViewer the source viewer
	 * @return the presentation reconciler or <code>null</code> if presentation reconciling should not be supported
	 */
	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		System.out.println("MySourceViewerConfiguration.getPresentationReconciler()");
		PresentationReconciler reconciler= new PresentationReconciler();
		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);
		//reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
		return reconciler;
	} 
	
	protected MyRuleScanner getScanner() {
		if(scanner==null) {
			 scanner = new MyRuleScanner();
			scanner.setDefaultReturnToken(new Token(new TextAttribute(DEFAULT_TAG_COLOR)));
			
		}
		return scanner;
	}
}
