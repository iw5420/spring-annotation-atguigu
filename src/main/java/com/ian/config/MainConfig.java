package com.ian.config;

import com.ian.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Configuration.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(value="com.ian", excludeFilters = {
        @ComponentScan.Filter(type=FilterType.ANNOTATION, classes = {Controller.class})})
//@ComponentScan value:指定要掃描的包
//excludeFilters = Filter[], 指定掃描的時候按照什麼規則排除那些組件
//includeFilters = Filter[], 指定掃描的時候只需要包含哪些組件
public class MainConfig {

    @Bean("person")
    public Person person(){
        return new Person("list", 20);
    }
}
