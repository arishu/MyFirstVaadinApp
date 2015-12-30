package chap1.com.aris.learningvaadin.commonfeatures;

import java.util.ResourceBundle;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class LocaleUI extends UI {
	private static final long serialVersionUID = -4199463509561376793L;
	
	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		ResourceBundle bundle = ResourceBundle.getBundle("MyResources", UI.getCurrent().getLocale());
		
		Button cacel = new Button(bundle.getString("CancelKey"));
		
		layout.addComponent(cacel);
		
	}

}
