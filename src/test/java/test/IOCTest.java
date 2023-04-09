package test;

import com.ian.config.MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String name : beanDefinitionNames){
            System.out.println(name);
        }

    }

}
