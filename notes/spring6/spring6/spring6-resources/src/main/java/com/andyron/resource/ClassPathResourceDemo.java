package com.andyron.resource;

import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;

/**
 * @author andyron
 **/
public class ClassPathResourceDemo {
    public static void main(String[] args) {
        loadClassPath("andy.txt");
    }

    public static void loadClassPath(String path) {
        ClassPathResource resource = new ClassPathResource(path);
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());
        try {
            InputStream in = resource.getInputStream();
            byte[] b = new byte[1024]; // TODO 读取文件的方法
            while (in.read(b) != -1) {
                System.out.println(new String(b));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
