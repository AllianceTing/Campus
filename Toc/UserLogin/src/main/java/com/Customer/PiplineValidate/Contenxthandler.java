package com.Customer.PiplineValidate;
/*
 * PROJECT_NAME Contenxthandler
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~10:20
 */

public interface Contenxthandler<T extends PiepleContent> {
    /**
     * @param context - > PiepleContent
     * @return Boolean ? else
     */
    boolean handle(T context); //定义每一个分支任务的顶级父接口
}
