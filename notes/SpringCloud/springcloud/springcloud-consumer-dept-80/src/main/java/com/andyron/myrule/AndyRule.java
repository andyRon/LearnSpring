package com.andyron.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

public class AndyRule {

    @Bean
    public IRule myRule() {
        return new AndyRandomRule();
    }
}
