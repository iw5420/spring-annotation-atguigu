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
    singleton 單實例的
    request 同一個請求創建一個實例
    session 同一個session創建一個實例
    **/
    @Scope("prototype")
    @Bean
    public Person person(){
        return new Person("張三", 25);
    }
}
