package chap1.com.aris.learningvaadin.Field;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class ValueBufferedUI extends UI {
	private static final long serialVersionUID = -47104117585045032L;

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		final PropertysetItem item = new PropertysetItem();
		item.addItemProperty("name", new ObjectProperty<String>("Q"));
		item.addItemProperty("age", new ObjectProperty<Integer>(42));
		
		// provide a container for fields
		Panel panel = new Panel("Buffered form");
		final FormLayout form = new FormLayout();
		panel.setContent(form);
		
		// create a FieldGroup and use it to create fields
		final FieldGroup binder = new FieldGroup(item);
		form.addComponent(binder.buildAndBind("Name", "name"));
		form.addComponent(binder.buildAndBind("Age", "age"));
		
		binder.setBuffered(true); // enable buffering(默认是true)
		
		form.addComponent(new Button("OK", new Button.ClickListener() {
			private static final long serialVersionUID = -6470069420506407977L;

			@Override
			public void buttonClick(ClickEvent event) {
				try {
					binder.commit();
					Notification.show("Thanks");
				} catch (CommitException e) {
					Notification.show("You Failed");
				}
			}
		}));
		
		form.addComponent(new Button("Discard", new Button.ClickListener() {
			private static final long serialVersionUID = 539047432072942109L;

			@Override
			public void buttonClick(ClickEvent event) {
				binder.discard();
				Notification.show("Discarded");
			}
		}));
		
		layout.addComponent(panel);
	}

}
