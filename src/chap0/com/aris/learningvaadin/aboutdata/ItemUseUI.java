package chap0.com.aris.learningvaadin.aboutdata;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ItemUseUI extends UI {
	private static final long serialVersionUID = -333654316391447424L;

	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		PropertysetItem item = new PropertysetItem();
		item.addItemProperty("Name", new ObjectProperty<String>("Aris"));
		item.addItemProperty("Age", new ObjectProperty<Integer>(30));
		
		FieldGroup fg = new FieldGroup();
		fg.setItemDataSource(item);
		
		// 构建Field，并绑定数据
		TextField name = (TextField) fg.buildAndBind("Name");
		TextField age = (TextField) fg.buildAndBind("Age");
		
		
		layout.addComponents(name, age);
		
	}

}
