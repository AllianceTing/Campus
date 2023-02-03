package com.Customer.chains;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * PROJECT_NAME piepleContentValidatePreChecker
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~10:34
 */
@Service
@Component
public class piepleContentValidatePreChecker implements Contenxthandler<UserLoginReuestContent> {
    // todo: implements huge number of sensitive word checking

    /**
     * @param context - > piepleContent
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
