package com.Customer.UserLoginMoudle.PiplineValidate;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 管道路由的配置
 *
 * @author AllianceTing
 */
@Configuration
public class PipelineRouteConfig implements ApplicationContextAware {

    /**
     * 数据类型->管道中处理器类型列表 的路由
     */
    private static final
    Map<Class<? extends PiepleContent>,
            List<Class<? extends Contenxthandler<? extends PiepleContent>>>> PIPELINE_ROUTE_MAP = new HashMap<>(4);

    /*
     * 在这里配置各种上下文类型对应的处理管道：键为上下文类型，值为处理器类型的列表
     */
    static {
        PIPELINE_ROUTE_MAP.put(UserLoginReuestContent.class,
                Arrays.asList(
                        PiepleContentUserAPDataPreChecker.class,
                        PiepleContentSensitiveValidatePreChecker.class,
                        PiepleContentPhoneDataPreChecker.class,
                        PiepleContentMailDataPreChecker.class
                ));

    }

    /**
     * 在 Spring Start -- >  路由表生成对应的管道 链
     * PipelineExecutor 从这里获取处理器列表
     */
    @Bean("pipelineRouteMap")
    public Map<Class<? extends PiepleContent>, List<? extends Contenxthandler<? extends PiepleContent>>> getHandlerPipelineMap() {
        return PIPELINE_ROUTE_MAP.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, this::toPipeline));
    }

    /**
     * 根据给定的管道中 RegistryContenxthandler 的类型的列表，构建管道
     */
    private List<? extends Contenxthandler<? extends PiepleContent>> toPipeline(
            Map.Entry<Class<? extends PiepleContent>, List<Class<? extends Contenxthandler<? extends PiepleContent>>>> entry) {
        return entry.getValue()
                .stream()
                .map(appContext::getBean)
                .collect(Collectors.toList());
    }

    private ApplicationContext appContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appContext = applicationContext;
    }
}
