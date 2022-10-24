package com.dotk.core.utils.valid;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 枚举校验注解
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {EnumClass.Validator.class})
public @interface EnumClass {
    String message() default "枚举值传参错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<?> enumClass();

    String enumMethod() default "getCode";

    boolean allowNull() default false; // 是否允许为空

    class Validator implements ConstraintValidator<EnumClass, Object> {
        private EnumClass enumValue;

        @Override
        public void initialize(EnumClass enumValue) {
            this.enumValue = enumValue;
        }

        @Override
        public boolean isValid(Object value, ConstraintValidatorContext context) {
            if (value == null) {
                return enumValue.allowNull();
            }

            Object[] objects = enumValue.enumClass().getEnumConstants();

            try {
                Method method = enumValue.enumClass().getMethod(enumValue.enumMethod());

                for (Object o : objects) {

                    if (method.invoke(o) instanceof String) {
                        if (method.invoke(o).equals(value)) {
                            return true;
                        }
                    } else if (value instanceof Integer) {
                        if (method.invoke(o) == value) {
                            return true;
                        }
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            return false;
        }
    }

}
