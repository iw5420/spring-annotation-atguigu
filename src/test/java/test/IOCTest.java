package test;

import com.ian.bean.Person;
import com.ian.config.MainConfig;
import com.ian.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IOCTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void test03(){
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //獲取環境變量的值, Windows 10
        String property = environment.getProperty("os.name");
        System.out.println(property);
        for(String name : beanNamesForType){
            System.out.println(name);
        }
        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);
    }

    @Test
    public void test02(){

//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        for(String name : beanDefinitionNames){
//            System.out.println(name);
//        }
        System.out.println("ioc容器創建完成");
        Object bean = applicationContext.getBean("person");
        Object bean2 = applicationContext.getBean("person");
        System.out.println(bean == bean2);
    }

    @Test
    public void test01(){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String name : beanDefinitionNames){
            System.out.println(name);
        }
    }

}
