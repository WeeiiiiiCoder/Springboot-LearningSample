# 问题总结
- SpringBoot单元测试加`@Transactional`注解事务自动回滚
  SpringBoot单元测试不加`@Transactional`是会正常向数据库中添加测试数据,并且不会回滚,但是如果在单元测试类上加上`@Transactional`会默认回滚。
  如果测试类不加`@Transactional`,但是注入一个启用`@Transactional`的`Service`业务类,那么单元测试不会回滚。
  只要测试类加`@Transactional`就会回滚,可以通过`@RollBack(false)`取消回滚。
- SpringBoot单元测试报错日志:Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test
  无法找到SpringBoot配置,需要指定SpringBoot配置。原因一般是没有添加SpringBoot启动类或者启动类和测试类不在同一级目录下