package chap1.com.aris.learningvaadin.Select;

import java.io.Serializable;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("myfirstvaadinapp")
public class AddSelectIconUI extends UI {
	private static final long serialVersionUID = -1573650170730726729L;

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		final ComboBox cb1 = new ComboBox("设置Icon");
		cb1.addItem("home");
		// 通过setItemIcon(Object itemId, Resource icon)方法为Item添加图片
		cb1.setItemIcon("home", new ThemeResource("img/home-act.png"));

		layout.addComponent(cb1);
		
		
		// 通过setItemIconPropertyId(Object propertyId)给Item设置Icon
		final ComboBox cb2 = new ComboBox("设置Icon2");
		final BeanItemContainer<Planet> container = new BeanItemContainer<AddSelectIconUI.Planet>(Planet.class);
		container.addItem(new Planet(1, "user", FontAwesome.USER));
		container.addItem(new Planet(2, "home", FontAwesome.HOME));
		container.addItem(new Planet(3, "music", FontAwesome.MUSIC));
		
		cb2.setContainerDataSource(container);
		cb2.setItemCaptionMode(ItemCaptionMode.PROPERTY);
		cb2.setItemCaptionPropertyId("name");
		
		cb2.setItemIconPropertyId("icon");
		
		layout.addComponent(cb2);
	}

	public class Planet implements Serializable {
		private static final long serialVersionUID = 5408134408348853350L;
		private int id;
		private String name;
		private FontAwesome icon;
		
		public Planet(int id, String name, FontAwesome icon) {
			this.id = id;
			this.name = name;
			this.icon = icon;
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

		public FontAwesome getIcon() {
			return icon;
		}

		public void setIcon(FontAwesome icon) {
			this.icon = icon;
		}
	
		
	}
	
	
}
