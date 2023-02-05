package com.Customer.Aop;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * PROJECT_NAME PhoneValidateByConstriant
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~20:00
 */

public class PhoneValidateByConstriant implements ConstraintValidator<PhoneCheck, String> {

    static final Logger logger = Logger.getLogger(PhoneValidateByConstriant.class.getName());
    private static final int PHONE_LENGTH = 11;

    private static final Pattern pattern = Pattern.compile("^[1][3,4,5,6,7,8,9][0-9]{9}$");

    @Override
    public void initialize(PhoneCheck constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }


    @Override
    public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {
        //todo phone check
        if (phone == null) {
            logger.log(Level.WARNING, "PhoneValidator phone is blank, phone = {}");
            return false;
        }

        if (phone.length() != PHONE_LENGTH) {
            logger.log(Level.WARNING, "PhoneValidator phone length valid fail, phone = {}", phone);
            return false;
        }


        if (!pattern.matcher(phone).matches()) {
            logger.log(Level.WARNING, "PhoneValidator phone pattern valid fail, phone = {}", phone);
            return false;
        }

        return true;

    }
}
