package chap1.com.aris.learningvaadin.Field;

import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.util.converter.StringToIntegerConverter;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.IntegerRangeValidator;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.Slider;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class FieldValidatorUI extends UI {
	private static final long serialVersionUID = 836267177906552985L;

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		final TextField name = new TextField("姓名");
		name.setValue("your name");
		name.addValidator(new StringLengthValidator("The name must be 1 - 10 letters (was {0})", 1, 10, true));
		name.setDescription("<p style=\"color:" + "red\">" + "请输入姓名"  + "<p>");
		layout.addComponent(name);
		
		final TextField age = new TextField("年龄");
		age.setValue("20");
		age.addValidator(new IntegerRangeValidator("The age must be between 20 ~ 100 (was {0})", 20, 100));
		age.setDescription("<p style=\"color:" + "red\">" + "请输入年龄"  + "<p>");
		age.setConverter(new StringToIntegerConverter());
		layout.addComponent(age);
		
		// 展开的日期选择器
		final InlineDateField birthday = new InlineDateField("生日");
		birthday.setValue(new java.util.GregorianCalendar().getTime());
		layout.addComponent(birthday);
		
		// 弹出式日期选择器
		final PopupDateField birthday2 = new PopupDateField("生日");
		birthday2.setValue(new java.util.GregorianCalendar().getTime());
		layout.addComponent(birthday2);
		
		
		final Panel hobby = new Panel("爱好");
		hobby.setWidthUndefined();
		final HorizontalLayout hobbyLayout = new HorizontalLayout();
		hobby.setContent(hobbyLayout);
		final CheckBox hobby1 = new CheckBox("听音乐");
		final CheckBox hobby2 = new CheckBox("读书");
		hobbyLayout.addComponent(hobby1);
		hobbyLayout.addComponent(hobby2);
		
		layout.addComponent(hobby);
		
		
		final TextField email = new TextField("Email");
		email.addValidator(new EmailValidator("must be an email"));
		layout.addComponent(email);
		
		/*
		 * 自动校验
		 */
		final TextField mobile = new TextField("手机");
		mobile.setImmediate(true);
		// 正则表法式校验器来验证手机号码
		mobile.addValidator(new RegexpValidator("^[1][358][0-9]{9}$", "手机号码必须是13,15,18开头的"));
		layout.addComponent(mobile);
		
		
		/*
		 * 显示校验
		 */
		final TextField desc = new TextField("描述"); 
		desc.addValidator(new StringLengthValidator("must less than 100 words", 0, 100, true));
		layout.addComponent(desc);
		
		
		/*
		 * 自定义校验: 设计自己的校验类
		 */
		final RichTextArea feedback = new RichTextArea("您的意见");
		feedback.addValidator(new MyValidator());
		feedback.setImmediate(true);
		layout.addComponent(feedback);
		
		// 拖动条
		Slider slider = new Slider("音量");
		layout.addComponent(slider);
		
		layout.addComponent(new Button("Ok", new Button.ClickListener() {
			private static final long serialVersionUID = -6813954701469080576L;

			@Override
			public void buttonClick(ClickEvent event) {
				/*if(!email.isValid()) {
					email.clear();
					email.focus();
				} else {
					Notification.show("Success");
				}*/
				
				desc.setValidationVisible(false);
				
				try {
					desc.validate();
					
					
					
				} catch (InvalidValueException e) {
					Notification.show(e.getMessage());
					desc.setValidationVisible(true);
				}
			}
		}));
	}

}
