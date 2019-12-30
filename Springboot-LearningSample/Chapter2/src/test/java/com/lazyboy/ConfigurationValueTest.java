package com.lazyboy;

import com.lazyboy.model.AdvancedModelProperties;
import com.lazyboy.model.BasicModelProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith注解会指定一个类来运行Junit Test,而不是使用默认的Junit内置的运行程序
//SpringRunner是SpringJUnit4ClassRunner的子类,提供了Spring的测试环境
//@RunWith+SpringRunner 就等于以Spring环境运行Junit测试,可以利用Spring的容器更方便的获取bean
@RunWith(SpringRunner.class)
//以基于SpringBoot测试运行该测试类
@SpringBootTest
@Slf4j
public class ConfigurationValueTest {

    @Autowired
    private BasicModelProperties basicModelProperties;
    @Autowired
    private AdvancedModelProperties advancedModelProperties;

    @Test
    public void basicModelPropertiesTests() {
        Assert.assertEquals(basicModelProperties.getName(), "lazyboy");
        Assert.assertEquals(basicModelProperties.getTitle(), "Springboot-LearningSample");
        log.info(basicModelProperties.getValue());
        log.info("随机整形:" + basicModelProperties.getNumber());
        log.info("随机long型:" + basicModelProperties.getBignumber());
        log.info("随机10以内的整数:" + basicModelProperties.getMaxTen());
        log.info("随机uuid:" + basicModelProperties.getUuid());
        log.info("随机10-20以内的整数:" + basicModelProperties.getMin2max());
    }

    @Test
    public void advancedModelPropertiesTests() {
        log.info(advancedModelProperties.getPhoneList().toString());
        log.info(advancedModelProperties.getPhoneName().toString());
    }

}
