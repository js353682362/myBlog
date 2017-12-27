package com.jsen.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author jsen
 */
@SpringBootApplication
@Configuration
@ComponentScan(value = "com.jsen.blog.study.controller")
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
    /**
     * condition 测试 未通过
     * 
     * @param args
     */
    // //todo
    // public static void main(String[] args) {
    // AnnotationConfigApplicationContext context = new
    // AnnotationConfigApplicationContext(ConditionConfig.class);
    // ListService listService = context.getBean(ListService.class);
    //
    // System.out.println(context.getEnvironment().getProperty("os.name") +
    // "系统下的列表命令为" + listService.showListCmd());
    // }

    // public static void main(String[] args) {
    // AnnotationConfigApplicationContext context = new
    // AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
    // }

    // public static void main(String[] args) {
    // AnnotationConfigApplicationContext context = new
    // AnnotationConfigApplicationContext(TaskExcuterConfig.class);
    // AsyncTaskService asyncTaskService =
    // context.getBean(AsyncTaskService.class);
    // for(int i = 0; i < 10; i++){
    // asyncTaskService.executeAsyncTask(i);
    // asyncTaskService.executeAsyncTaskPlus(i);
    // }
    // context.close();
    // }

    // public static void main(String[] args) {
    // AnnotationConfigApplicationContext context = new
    // AnnotationConfigApplicationContext(AwareConfig.class);
    // AwareService awareService = context.getBean(AwareService.class);
    // awareService.outputResult();
    //
    // context.close();
    // }

    // public static void main(String[] args) {
    // AnnotationConfigApplicationContext context = new
    // AnnotationConfigApplicationContext();
    // context.getEnvironment().setActiveProfiles("dev");
    // context.register(ProfileConfig.class);
    // context.refresh();
    // DemoBean demoBean = context.getBean(DemoBean.class);
    // System.out.println(demoBean.getContent());
    // context.close();
    // }

    // public static void main(String[] args) {
    // AnnotationConfigApplicationContext context = new
    // AnnotationConfigApplicationContext(
    // ScopeConfig.class);
    // SingletonTest singletonTest1 = context.getBean(SingletonTest.class);
    // SingletonTest singletonTest2 = context.getBean(SingletonTest.class);
    // System.out.println("singleton test：" +
    // singletonTest1.equals(singletonTest2));
    //
    // PrototypeService prototypeService1 =
    // context.getBean(PrototypeService.class);
    // PrototypeService prototypeService2 =
    // context.getBean(PrototypeService.class);
    // System.out.println("prototype test：" +
    // prototypeService1.equals(prototypeService2));
    //
    // SpringApplication.run(BlogApplication.class, args);
    // }
}
