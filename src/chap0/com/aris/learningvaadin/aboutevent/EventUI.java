package chap0.com.aris.learningvaadin.aboutevent;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window;

public class EventUI extends UI {
	private static final long serialVersionUID = -1738825285679352845L;

	
	
	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		final Window win = new Window("Sub Window");
		win.setVisible(false);
		
		addWindow(win);
		
		Button button=new Button("Show window once"); 
		button.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = -2298512060779781306L;

			@Override
			public void buttonClick(ClickEvent event) {
				if (win.isVisible()) {
					win.setVisible(false);
				} else {
					win.setVisible(true);
				}
			}
		});
		
		layout.addComponents(button);
	}

}
