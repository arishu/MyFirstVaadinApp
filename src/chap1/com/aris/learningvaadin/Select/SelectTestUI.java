package chap1.com.aris.learningvaadin.Select;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class SelectTestUI extends UI {
	private static final long serialVersionUID = -8999135301022555399L;

	@SuppressWarnings("unchecked")
	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		IndexedContainer container = new IndexedContainer();
		
		// 添加两列
		container.addContainerProperty("col1", String.class, null);
		container.addContainerProperty("col2", Integer.class, null);
		
		container.addItem("row1"); // 添加一行
		
		// 取得第一行，然后给这行的每一列赋值
		Item item1  = container.getItem("row1");
		Property<String> prop1_1 = item1.getItemProperty("col1");
		prop1_1.setValue("xiaohu");
		Property<Integer> prop1_2 = item1.getItemProperty("col2");
		prop1_2.setValue(23);
		
		// 创建一个table，并将数据绑定到这个table
		final Table tb = new Table("表格");
		tb.setContainerDataSource(container);
		
		layout.addComponent(tb);
		
		
	}

}
