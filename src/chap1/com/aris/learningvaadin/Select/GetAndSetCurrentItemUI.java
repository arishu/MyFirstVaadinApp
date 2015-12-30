package chap1.com.aris.learningvaadin.Select;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TwinColSelect;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class GetAndSetCurrentItemUI extends UI {
	private static final long serialVersionUID = 2922414770378585565L;
	private static Set<String>  valueSet = new HashSet<>(2);
	
	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		layout.addComponent(new Label("——————————————————————————通过复选按钮来选中ComboBox中的项目——————————————————————————————"));
		// 通过复选按钮来选中ComboBox中的项目
		final ComboBox select1 = new ComboBox();
		select1.setNullSelectionItemId("select"); // 给空值设置id
		select1.addItem("xiaohua");
		select1.addItem("xiaoming");
		select1.addItem("xiaoqiang");
		
		select1.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = -5625161764713169540L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				// 选中某个Item，其实选中的是Item的属性，它的值就是这个Item的ID
				Object selectedId = event.getProperty().getValue();
				Notification.show("您选择的是：" + selectedId);
			}
		});
		
		layout.addComponent(select1);
		
		final CheckBox cb1 = new CheckBox("xiaohua"); 
		cb1.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = -4789291179025294432L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				boolean selectedValue = Boolean.parseBoolean(event.getProperty().getValue().toString());
				if(selectedValue == true) {
					select1.setValue(cb1.getCaption()); // 选中下拉列表框中Item ID=复选框caption的选项
				} else {
					select1.setValue(null);
				}
			}
		});
		layout.addComponent(cb1);
		
		layout.addComponent(new Label("——————————————————————————使用Html自带的选择框——————————————————————————————"));
		
		// 使用Html自带的选择框
		final NativeSelect ns = new NativeSelect();
		ns.setWidthUndefined();
		ns.setNullSelectionItemId("select a day"); // 给空值设置id
		ns.addItem("MON");
		ns.addItem("TUE");
		ns.addItem("WED");
		
		ns.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1884780477822057002L;
			@Override
			public void valueChange(ValueChangeEvent event) {
				Notification.show("您选择的日期是：" + event.getProperty().getValue());
			}
		});
		
		layout.addComponent(ns);
		

		layout.addComponent(new Label("——————————————————————————使用列表选择框——————————————————————————————"));
		
		// 使用列表选择框
		final ListSelect ls = new ListSelect();
		ls.setMultiSelect(true);
		ls.addItems("MON", "TUE", "WED", "TUR", "FRI", "SAT", "SUN");

		ls.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1884780477822057002L;
			@Override
			public void valueChange(ValueChangeEvent event) {
				Notification.show("您选择的是: " + event.getProperty().getValue());
			}
		});
		
		layout.addComponent(ls);	
		
		layout.addComponent(new Label("————————————————————————————使用双向选择列表框————————————————————————————"));
		
		// 使用双向选择列表框
		final TwinColSelect tcs = new TwinColSelect();
		tcs.addItems("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
		
		tcs.setRows(3);
		
		tcs.setValue(new HashSet<String>(Arrays.asList("Apr", "May", "Jun")));
		
		tcs.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = -5989861584591461255L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				layout.addComponent(new Label("Selected: " + event.getProperty().getValue()));
			}
		});
		
		layout.addComponent(tcs);
		
		
		layout.addComponent(new Label("————————————————————————————按钮组(单选)————————————————————————————"));
		
		// 按钮组(单选)
		final Panel sexPanel = new Panel("性别");
		final HorizontalLayout sexLayout = new HorizontalLayout();
		sexLayout.setMargin(true);
		sexPanel.setContent(sexLayout);
		final OptionGroup og = new OptionGroup();
		og.addItem("male");
		og.setItemCaption("male", "男");
		og.addItem("female");
		og.setItemCaption("female", "女");
		
		og.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 4865430161945287544L;
			@Override
			public void valueChange(ValueChangeEvent event) {
				Notification.show("您是一名" + og.getItemCaption(event.getProperty().getValue()) + "士");
			}
		});
		sexLayout.addComponent(og);
		
		layout.addComponent(sexPanel);
		
		
		layout.addComponent(new Label("———————————————————————————按钮组(多选)—————————————————————————————"));
		
		// 按钮组(多选)
		final OptionGroup og2 = new OptionGroup();
		og2.setMultiSelect(true);
		og2.addItem("qiezi");
		og2.setItemCaption("qiezi", "茄子");
		og2.addItem("boluo");
		og2.setItemCaption("boluo", "菠萝");
		
		og2.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = -1604157258550263655L;
			@SuppressWarnings("unchecked")
			@Override
			public void valueChange(ValueChangeEvent event) {
				Set<String> idSet = (Set<String>) event.getProperty().getValue();
				valueSet.clear();
				for(String itemId: idSet) {
					valueSet.add(og2.getItemCaption(itemId));
				}
				
				Notification.show("您喜欢吃的是 ：" + valueSet);
			}
		});
		
		layout.addComponent(og2);
	}

}
