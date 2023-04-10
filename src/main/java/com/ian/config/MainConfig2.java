package com.ian.config;

import com.ian.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MainConfig2 {

    //默認是單例的
    /*
    ConfigurableBeanFactory.SCOPE_PROTOTYPE, prototype
    ConfigurableBeanFactory.SCOPE_SINGLETON, singleton
    org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST, request
    org.springframework.web.context.WebApplicationContext.SCOPE_SESSION, value session

    prototype 多實例的
    singleton 單實例的 ioc容器啟動會調用方法創建對象放到ioc容器中,
        以後每次獲取就是直接從容器中(map.get())拿
    request 同一個請求創建一個實例
    session 同一個session創建一個實例
    **/
    @Scope
    @Bean("person")
    public Person person(){
        System.out.println("給容器添加person");
        return new Person("張三", 25);
    }
}
