package chap1.com.aris.learningvaadin.Select;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class SelectTest2UI extends UI {
	private static final long serialVersionUID = 6555443685325176992L;

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		// 添加几个数据
		final ComboBox cb = new ComboBox("选择国家");
		
		cb.addItem("America");
		cb.addItem("UK");
		cb.addItem("China");
		
		layout.addComponent(cb);
	
		
		// 添加大批的数据: 使用addItems(Collection<?> c)方法
		final ComboBox cb2 = new ComboBox("选择国家");
		java.util.List<String> countryList = new java.util.ArrayList<>(utils.countryArray.length);
		for (String item: utils.countryArray) {
			countryList.add(item);
		}
		cb2.addItems(countryList);
	
		layout.addComponent(cb2);
		
		// 使用addItem()获取一个Item id,然后改变这个id的显示名称
		final ComboBox cb3 = new ComboBox("选择星期");
		Object item1Id = cb3.addItem();
		cb3.setItemCaption(item1Id, "MON");
		Object item2Id = cb3.addItem();
		cb3.setItemCaption(item2Id, "TUS");
		Object item3Id = cb3.addItem();
		cb3.setItemCaption(item3Id, "WED");
		Object item4Id = cb3.addItem();
		cb3.setItemCaption(item4Id, "THU");
		Object item5Id = cb3.addItem();
		cb3.setItemCaption(item5Id, "FRI");
		Object item6Id = cb3.addItem();
		cb3.setItemCaption(item6Id, "SAT");
		Object item7Id = cb3.addItem();
		cb3.setItemCaption(item7Id, "SUN");
		
		layout.addComponent(cb3);
	}

}
