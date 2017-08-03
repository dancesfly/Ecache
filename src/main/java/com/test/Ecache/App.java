package com.test.Ecache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main(String[] args) {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	Ecache ecache = (Ecache) ctx.getBean("ecache");
    	ecache.setCacheByKeyAndName("selectMonth", "b", "c");
    	System.out.println(ecache.getCacheByKeyAndName("selectMonth", "b"));
    }
}
