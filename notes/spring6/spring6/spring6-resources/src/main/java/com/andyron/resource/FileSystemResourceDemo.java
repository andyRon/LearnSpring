package com.andyron.resource;

import org.springframework.core.io.FileSystemResource;

import java.io.InputStream;

/**
 * @author andyron
 **/
public class FileSystemResourceDemo {
    public static void loadAndReadUrlResource(String path) throws Exception{
        //相对路径
        FileSystemResource resource = new FileSystemResource("andyron.txt");
        //绝对路径
        //FileSystemResource resource = new FileSystemResource("~/andyron.txt");
        // 获取文件名
        System.out.println("resource.getFileName = " + resource.getFilename());
        // 获取文件描述
        System.out.println("resource.getDescription = "+ resource.getDescription());
        //获取文件内容
        InputStream in = resource.getInputStream();
        byte[] b = new byte[1024];
        while(in.read(b)!=-1) {
            System.out.println(new String(b));
        }
    }

    public static void main(String[] args) throws Exception {
        loadAndReadUrlResource("andyron.txt");
    }
}
