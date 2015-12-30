package chap0.com.aris.learningvaadin.aboutdata;

import com.vaadin.data.util.IndexedContainer;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ContainerUseUI extends UI {
	private static final long serialVersionUID = 252322297786784042L;

	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		
		IndexedContainer ic = new IndexedContainer();

		ic.addContainerProperty("First Name", String.class, null);
		ic.addContainerProperty("Last Name", String.class, null);
		
		PropertysetItem item1 = new PropertysetItem();
		item1.addItemProperty("First Name", new ObjectProperty<String>("FirstName1"));
		item1.addItemProperty("Last Name", new ObjectProperty<String>("LastName1"));
		
		PropertysetItem item2 = new PropertysetItem();
		item2.addItemProperty("First Name", new ObjectProperty<String>("FirstName2"));
		item2.addItemProperty("Last Name", new ObjectProperty<String>("LastName2"));
		
		PropertysetItem item3 = new PropertysetItem();
		item3.addItemProperty("First Name", new ObjectProperty<String>("FirstName3"));
		item3.addItemProperty("Last Name", new ObjectProperty<String>("LastName3"));
		
		ic.addItem(item1);
		ic.addItem(item2);
		ic.addItem(item3);
		
		Table nameList = new Table();
		nameList.setContainerDataSource(ic);
		
		layout.addComponent(nameList);
	}

}
