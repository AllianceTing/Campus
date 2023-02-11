package com.Customer.UserLoginMoudle.PiplineValidate;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * PROJECT_NAME RegistryPiepleContentValidatePreChecker
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~10:34
 */

@Component
public class PiepleContentSensitiveValidatePreChecker implements Contenxthandler<UserLoginReuestContent> {
    // todo: implements huge number of sensitive word checking

    /**
     * @param context - > RegistryPiepleContent
     * @return Boolean ? else
     */
    @Override
    public boolean handle(UserLoginReuestContent context) {
        if (!sensitiveWordList.contains(context)) {
            return true;
        }
        return false;
    }

    static final List sensitiveWordList = new LinkedList();

    static {
        sensitiveWordList.add("shabi");
        sensitiveWordList.add("2b");
    }
}
