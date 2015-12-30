package chap0.com.aris.learningvaadin.aboutdata;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class PropertyUseUI extends UI {
	private static final long serialVersionUID = 2603161818744325305L;

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		
		final TextField tf = new TextField("Name");
		
		tf.setValue("The text field value");;
		tf.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = -5019137607505513996L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				String value = tf.getValue();
				Notification.show("value = " + value);
			}
		});
		
		layout.addComponent(tf);
	}

}
