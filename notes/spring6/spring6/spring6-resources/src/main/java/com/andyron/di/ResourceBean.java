package com.andyron.di;

import org.springframework.core.io.Resource;

/**
 * @author andyron
 **/
public class ResourceBean {
    private Resource res;

    public Resource getRes() {
        return res;
    }

    public void setRes(Resource res) {
        this.res = res;
    }

    public void parse(){
        System.out.println(res.getFilename());
        System.out.println(res.getDescription());
    }
}
