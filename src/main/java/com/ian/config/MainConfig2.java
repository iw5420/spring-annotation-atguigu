package com.ian.config;

import com.ian.bean.Person;
import com.ian.condition.LinuxCondition;
import com.ian.condition.WindowsCondition;
import org.springframework.context.annotation.*;

@Configuration
public class MainConfig2 {

    //默認是單例的
    /*
    ConfigurableBeanFactory.SCOPE_PROTOTYPE, prototype
    ConfigurableBeanFactory.SCOPE_SINGLETON, singleton
    org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST, request
    org.springframework.web.context.WebApplicationContext.SCOPE_SESSION, value session
    @Scope: 調整作用域
    prototype 多實例的 ioc容器啟動並不會去調用方法創建對象放在容器中
        每次獲取的時候才會調用方法創建對象
    singleton 單實例的 ioc容器啟動會調用方法創建對象放到ioc容器中,
        以後每次獲取就是直接從容器中(map.get())拿
    request 同一個請求創建一個實例
    session 同一個session創建一個實例

    * 懶加載
            單例Bean, 默認在容器啟動的時候創建對象;
            懶加載, 容器啟動不創建對象, 第一次使用(獲取)Bean創建對象, 並初始化
    **/
    //    @Scope("prototype")
    @Lazy
    @Bean("person")
    public Person person(){
        System.out.println("給容器添加person");
        return new Person("張三", 25);
    }

    /*
        @Conditional({Condition}), 按照一定的條件進行判斷, 滿足條件給容器中註冊bean

        要求
        如果系統是windows, 給容器中註冊("bill")
        如果系統是linux, 給容器中註冊("linus")
     */

    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates", 62);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02(){
        return new Person("linus", 48);
    }
}
