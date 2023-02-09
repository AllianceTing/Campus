package com.compus.ASPECT;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * PROJECT_NAME PhoneCheck
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~19:59
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
@Constraint(validatedBy = PhoneValidateByConstriant.class)
public @interface PhoneCheck {
    String value() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
