package chap1.com.aris.learningvaadin.Select;

import java.io.Serializable;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class AddNewItemUI extends UI {
	private static final long serialVersionUID = -160794655947511663L;

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		layout.addComponent(new Label("—————————————————————————————添加新项目—————————————————————————————————"));
		final ComboBox cb = new ComboBox("请选择姓名或添加姓名");
		cb.addItem("xiaoming");
		cb.addItem("xiaohuang");
		cb.addItem("xiaoqiang");
		
		// 设置有允许添加新项目,并打开立即模式
		cb.setNewItemsAllowed(true);
		cb.setImmediate(true);
		
		layout.addComponent(cb);

		layout.addComponent(new Label("—————————————————————————————处理新添加的项目—————————————————————————————————"));
		
		final BeanItemContainer<Planet> container = new BeanItemContainer<Planet>(Planet.class); 
		container.addItem(new Planet(1, "Mercury"));
		container.addItem(new Planet(2, "Venus"));
		container.addItem(new Planet(3, "Earth"));
		container.addItem(new Planet(4, "Mars"));
		
		final ComboBox cb2 = new ComboBox("Select or Add a Planet", container);
		cb2.setNullSelectionAllowed(false);
		cb2.setItemCaptionPropertyId("name");
		
		cb2.setNewItemsAllowed(true);
		cb2.setImmediate(true);
		
		cb2.setNewItemHandler(new AbstractSelect.NewItemHandler() {
			private static final long serialVersionUID = 6378207307799121156L;
			@Override
			public void addNewItem(String newItemCaption) {
				Planet newPlanet = new Planet(0, newItemCaption);
				container.addBean(newPlanet);
				cb2.select(newPlanet);
				
				Notification.show("Added New planet called " + newItemCaption);
			}
		});
		
		layout.addComponent(cb2);
	}

	
	public class Planet implements Serializable {
		private static final long serialVersionUID = -5181776796907121108L;
		private int id;
		private String name;
		
		public Planet(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
}
