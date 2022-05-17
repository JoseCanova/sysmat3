package br.com.connemat.model.entity.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.connemat.Base;

public class BaseConstraintValidator implements ConstraintValidator<BaseConstraint, Base<?>> {

	public BaseConstraintValidator() {
	}

	@Override
	public boolean isValid(Base<?> value, ConstraintValidatorContext context) {
		if (value!=null && isNullOrEmpty(value.getId()))
			return false;
		return true;
		
	}

	private boolean isNullOrEmpty(Object id) {
		return id == null || id.toString().trim().length() == 0;
	}

}
