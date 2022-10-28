package com.dotk.core.utils.valid;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

/**
 * 枚举校验注解
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {EnumValue.Validator.class})
public @interface EnumValue {
    String message() default "枚举值传参错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] strValues() default {};

    int[] intValues() default {};

    boolean allowNull() default false; // 是否允许为空

    class Validator implements ConstraintValidator<EnumValue, Object> {
        private EnumValue enumValue;


        @Override
        public void initialize(EnumValue enumValue) {
            this.enumValue = enumValue;
        }

        @Override
        public boolean isValid(Object value, ConstraintValidatorContext context) {
            if (value == null) {
                return enumValue.allowNull();
            }

            if (value instanceof String) {
                for (String s : enumValue.strValues()) {
                    if (s.equals(value)) {
                        return true;
                    }
                }
            } else if (value instanceof Integer) {
                for (int s : enumValue.intValues()) {
                    if (s == (Integer) value) {
                        return true;
                    }
                }
            }

            return false;
        }
    }
}
