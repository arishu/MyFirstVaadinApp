package chap0.com.aris.learningvaadin.aboutevent;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class ListenerUI_1 extends UI implements Button.ClickListener {
	private static final long serialVersionUID = 899661467029535982L;
	private Button button1;
	private Button button2;
	private Window win;
	
	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		win = new Window("sub window");
		win.setVisible(false);
		addWindow(win);
		
		button1 = new Button("show window");
		button1.addClickListener(this);
		
		button2 = new Button("show message");
		button2.addClickListener(this);
		
		layout.addComponents(button1, button2);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if (event.getButton() == button1) { // 如果是按钮一的点击事件
			if (win.isVisible()) {
				win.setVisible(false);
			} else {
				win.setVisible(true);
			}
		} else if (event.getButton() == button2) { // 如果是按钮二的点击事件
			Notification.show("您点击了按钮二");
		}
	}

}
