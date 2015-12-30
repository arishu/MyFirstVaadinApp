package chap1.com.aris.learningvaadin.Select;

import java.io.Serializable;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ItemCaptionModeUI extends UI {
	private static final long serialVersionUID = 2542925998088282953L;

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		layout.addComponent(new Label("———————————————————————————ItemCaptionMode.EXPLICIT_DEFAULTS_ID模式———————————————————————————"));
		
		// 默认模式：ItemCaptionMode.EXPLICIT_DEFAULTS_ID,
		// 这种模式下, 如果每个Item有caption,就使用它的caption, 没有的话，就使用它的ID作为caption
		final ComboBox select1 = new ComboBox("Moons of Mars"); 
		select1.setItemCaptionMode(ItemCaptionMode.EXPLICIT_DEFAULTS_ID);
		
		// 将Item的Id作为这个Item的显示标题
		select1.addItem(new Integer(1));
		
		// 修改Item的显示标题
		select1.addItem(2);
		select1.setItemCaption(2, "Deimos");
		
		layout.addComponent(select1);
		
		layout.addComponent(new Label("———————————————————————————ItemCaptionMode.ID模式———————————————————————————"));
		
		// ItemCaptionMode.ID模式
		final ComboBox select2 = new ComboBox("Inner Planets");
		select2.setItemCaptionMode(ItemCaptionMode.ID);
		
		String[] planets = {"Mercury", "Venus", "Earth", "Mars"};
		for (int i = 0; i < planets.length; i++){
			select2.addItem(new PlanetId(planets[i]));
		}

		layout.addComponent(select2);
		
		
		layout.addComponent(new Label("———————————————————————————ItemCaptionMode.PROPERTY模式———————————————————————————"));
		
		// ItemCaptionMode.PROPERTY模式, 可以按照需要显示
		BeanItemContainer<Planet> container = new BeanItemContainer<Planet>(Planet.class);
		container.addItem(new Planet(1, "Mercury"));
		container.addItem(new Planet(2, "Venus"));
		container.addItem(new Planet(3, "Earth"));
		container.addItem(new Planet(4, "Mars"));
		
		final ComboBox select3 = new ComboBox("Planets", container);
		
		select3.setItemCaptionMode(ItemCaptionMode.PROPERTY);
		select3.setItemCaptionPropertyId("id");
		
		layout.addComponent(select3);
	}

	class PlanetId extends Object implements Serializable {
		private static final long serialVersionUID = -6557914040680560836L;
		String planetName;
		
		PlanetId(String name) {
			this.planetName = name;
		}
		
		@Override
		public String toString() {
			return "The Planet " + this.planetName;
		}
	}
	
	public class Planet implements Serializable {
		private static final long serialVersionUID = 5408134408348853350L;
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
