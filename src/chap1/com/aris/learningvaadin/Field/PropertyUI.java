package chap1.com.aris.learningvaadin.Field;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class PropertyUI extends UI {
	private static final long serialVersionUID = -37751408202175011L;

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		final TextField tf1 = new TextField("Name");
		tf1.setValue("James");
		tf1.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 8665776693942741089L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				Notification.show("Your Name is: " + event.getProperty().getValue());
			}
		});
		
		final TextField tf2 = new TextField("Age");
		tf2.setValue("23");
		tf2.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = -7945802588957952032L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				Integer age = Integer.parseInt(tf2.getValue().toString());
				Notification.show("Your Age is: " + age);
			}
		});
		
		layout.addComponents(tf1, tf2);
	}

}
