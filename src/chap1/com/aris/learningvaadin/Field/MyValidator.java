package chap1.com.aris.learningvaadin.Field;

import com.vaadin.data.Validator;

public class MyValidator implements Validator {
	private static final long serialVersionUID = 2790157351743312481L;

	@Override
	public void validate(Object value) throws InvalidValueException {
		if (! (value instanceof String && ((String)value).equals("Hello") ))
			throw new InvalidValueException("Your are impolite");
	}

}
