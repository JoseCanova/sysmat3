package br.com.connemat.model.entity.validation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

@Documented
@Constraint(validatedBy = {})
@Retention(RUNTIME)
@Target({ElementType.TYPE  , ElementType.FIELD})
@ReportAsSingleViolation
public @interface BaseConstraint {
	
	  String message() default "{id.invalid}";

	  Class<?>[] groups() default { };

	  Class<? extends Payload>[] payload() default { };

}
