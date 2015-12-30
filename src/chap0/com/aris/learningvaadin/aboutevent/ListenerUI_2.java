package chap0.com.aris.learningvaadin.aboutevent;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ListenerUI_2 extends UI {
	private static final long serialVersionUID = 7729524520539994468L;
	
	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
	}

}
