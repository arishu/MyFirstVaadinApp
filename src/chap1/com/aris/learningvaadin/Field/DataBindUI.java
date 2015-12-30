package chap1.com.aris.learningvaadin.Field;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class DataBindUI extends UI {
	private static final long serialVersionUID = -1002254002034163585L;

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		
		ObjectProperty<String> property = new ObjectProperty<>("Hello"); 
		Label viewer = new Label();
		viewer.setPropertyDataSource(property);

		layout.addComponent(viewer);
		
		
		final Label show = new Label();
		ObjectProperty<String> name = new ObjectProperty<>("");
		final TextField editor = new TextField("Email");
		editor.setPropertyDataSource(name);
		editor.addValidator(new EmailValidator("must be an email"));
		editor.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 7893331614310942960L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				// TODO Auto-generated method stub
				if (editor.isValid()) {
					layout.addComponent(show);
				} else {
					Notification.show("must be an email");
					editor.focus();
				}
			}
		});
		show.setPropertyDataSource(editor);
		layout.addComponent(editor);
		
	}

}
