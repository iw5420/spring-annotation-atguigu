package com.ian.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

//判斷是否linux系統
public class LinuxCondition implements Condition {

    /**
     * ConditionContext, 判斷條件能使用的上下文(環境)
     * AnnotatedTypeMetadata, 注視信息
     */

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //判斷使否linux系統
        //1.能獲取到當時ioc使用的beanfactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2.獲取類加仔器
        ClassLoader classLoader = context.getClassLoader();
        //3.獲取當前的環境變量
        Environment environment = context.getEnvironment();
        //4.獲取到bean定義的註冊類
        BeanDefinitionRegistry registry = context.getRegistry();

        //判斷操作系統用environment
        String property = environment.getProperty("os.name");
        if(property.contains("linux")){
            return true;
        }
        //另一個舉例, 判斷是否容器中有person這個bean, 也可以給容器中註冊bean
        boolean person = registry.containsBeanDefinition("person");
        return false;
    }
}
