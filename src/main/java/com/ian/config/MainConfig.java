package com.ian.config;

import com.ian.bean.Person;
import com.ian.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Configuration.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration
//@ComponentScan(value="com.ian", includeFilters = {
//        @ComponentScan.Filter(type=FilterType.ANNOTATION, classes = {Controller.class})},
//        useDefaultFilters = false)
@ComponentScans(value={
        @ComponentScan(value="com.ian", includeFilters = {
//                @ComponentScan.Filter(type=FilterType.ANNOTATION, classes = {Controller.class}),
//                @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
                @ComponentScan.Filter(type=FilterType.CUSTOM, classes = {MyTypeFilter.class})},
                useDefaultFilters = false)
})
//@ComponentScan value:指定要掃描的包
//excludeFilters = Filter[], 指定掃描的時候按照什麼規則排除那些組件
//includeFilters = Filter[], 指定掃描的時候只需要包含哪些組件
//FilterType.ANNOTATION 按照註解
//FilterType.ASSIGNABLE_TYPE 按照給定的類型
//FilterType.ASPECTJ 使用ASPECTJ表達示
//FilterType.REGEX 使用正則指定
//FilterType.CUSTOM 使用自訂義
// Filter candidates using a given custom org.springframework.core.type.filter.TypeFilter implementation. 必須是TypeFilter實現類
public class MainConfig {

    @Bean("person")
    public Person person(){
        return new Person("list", 20);
    }
}
