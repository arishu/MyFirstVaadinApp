package chap0.com.aris.learningvaadin.aboutevent;

import com.vaadin.event.EventRouter;
import com.vaadin.ui.AbstractComponentContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Window;

public class TheButtons {
	private Button button1;
	private Button button2;
	private Window win;
	
	public TheButtons(AbstractComponentContainer container) {
		win = new Window();
		win.setVisible(false);
		container.getUI().addWindow(win);
		
		EventRouter router = new EventRouter();
		
		button1 = new Button("show window");
		button2 = new Button("show message");
		
		router.addListener(Button.ClickEvent.class, this, "theButton1Click");
		router.addListener(Button.ClickEvent.class, this, "theButton2Click");
		
		container.addComponents(button1, button2);
	}
	
	public void theButton1Click(Button.ClickEvent event){
	}
	
	public void theButton2Click(Button.ClickEvent event){
		Notification.show("您点击了按钮二");
	}
}
