package chap1.com.aris.learningvaadin.Field;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class FieldTestUI extends UI {
	private static final long serialVersionUID = 8676835385709209685L;

	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		final TextField tf1 = new TextField("Name"); 
		final TextField tf2 = new TextField("Age");
		
		tf1.setRequired(true);
		tf1.setRequiredError("必填项");
		
		tf2.setRequired(true);
		tf2.setRequiredError("必填项");
		
		final Button submit = new Button("提交");
		
		submit.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 4986830420213950065L;

			@Override
			public void buttonClick(ClickEvent event) {
				if(tf1.isEmpty() && !tf2.isEmpty()) {
					Notification.show("不能为空");
					tf1.focus();
				}
				
				if(!tf1.isEmpty() && tf2.isEmpty()) {
					Notification.show("不能为空");
					tf2.focus();
				}
				
				if (tf1.isEmpty() && tf2.isEmpty()) {
					Notification.show("不能为空");
					tf1.focus();
				}
			}
		});
		
		layout.addComponents(tf1, tf2, submit);
	}

}
