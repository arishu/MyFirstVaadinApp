package chap1.com.aris.learningvaadin.Select;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class MultiSelectUI extends UI {
	private static final long serialVersionUID = -6082371977010015908L;

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		final ListSelect select = new ListSelect();
		select.addItems("Mercury", "Venus", "Earth", "Mars", "Jupiter",
				"Saturn", "Uranus", "Neptune");

		select.setMultiSelect(true);

		select.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = -7019719197525919446L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				layout.addComponent(new Label("Selected: "
						+ event.getProperty().getValue().toString()));
			}
		});

		select.setImmediate(true);

		layout.addComponent(select);
	}

}
