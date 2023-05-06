package com.andyron.resourceloader;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * @author andyron
 **/
public class ResourceLoaderDemo {
    @Test
    void demo1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext();
        Resource res = ctx.getResource("andyron.txt");
        System.out.println(res.getFilename());
    }

    @Test
    void demo2() {
        ApplicationContext ctx = new FileSystemXmlApplicationContext();
        Resource res = ctx.getResource("andyron.txt");
        System.out.println(res.getFilename());
    }
}
