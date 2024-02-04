package com.andyron.resource;

import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;

/**
 * @author andyron
 **/
public class UrlResourceDemo {
    public static void main(String[] args) {
//        loadUrlResource("http://www.baidu.com");
        loadUrlResource("file:andyron.txt");
    }
    public static void loadUrlResource(String path) {
        try {
            UrlResource url = new UrlResource(path);
            System.out.println(url.getFilename());
            System.out.println(url.getURI());
            System.out.println(url.getDescription());
            System.out.println(url.getInputStream().read()); // 首个字符的十进制数 l 108
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
