package chap1.com.aris.learningvaadin.Field;

import java.text.ParseException;

import com.ibm.icu.text.SimpleDateFormat;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.converter.StringToIntegerConverter;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class TypeConvertUI extends UI {
	private static final long serialVersionUID = -4172997486226421729L;

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		final TextField tf = new TextField("Name"); 
		final ObjectProperty<Integer> property = new ObjectProperty<Integer>(42);
		tf.setConverter(new StringToIntegerConverter());
		tf.setPropertyDataSource(property);
		
		tf.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 3005665158541668249L;
			
			@Override
			public void valueChange(ValueChangeEvent event) {
				Notification.show("value=" + Integer.parseInt(tf.getValue()));
			}
		});
		
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		final TextField tf_df = new TextField("日期");
		final DateField df = new DateField();
		df.setValue(new java.util.GregorianCalendar().getTime());
		
		tf_df.setPropertyDataSource(df);
		tf_df.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 9222094013896129126L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				
				java.util.Date value = null;
				try {
					value = sdf.parse(tf_df.getValue() + " 0:00:00");
				} catch (ParseException e) {
					Notification.show("Please input a valid date, like '2015-09-21'");
				}
				
				df.setValue(value);
			}
		});
		
		
		layout.addComponents(tf, tf_df, df);
	}

}
