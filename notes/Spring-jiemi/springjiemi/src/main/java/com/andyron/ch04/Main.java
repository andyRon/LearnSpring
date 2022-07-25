package com.andyron.ch04;

import com.andyron.ch02.ch21.DowJonesNewsListener;
import com.andyron.ch02.ch21.DowJonesNewsPersister;
import com.andyron.ch02.ch21.FXNewsProvider;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 通过编码方式使用BeanFactory实现FX新闻相关类的注册及绑定
 */
public class Main {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();

//        BeanFactory container = (BeanFactory) bindViaCode(beanRegistry);
        BeanFactory container = (BeanFactory) bindViaXMLFile(beanRegistry);

        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("djNewsProvider");
        newsProvider.getAndPersistNews();
    }

//    private static BeanFactory bindViaCode(BeanDefinitionRegistry registry)  {
//        // 定义Bean
//        AbstractBeanDefinition newsProvider = new RootBeanDefinition(FXNewsProvider.class, true);
//        AbstractBeanDefinition newsListener = new RootBeanDefinition(DowJonesNewsListener.class, true);
//        AbstractBeanDefinition newsPersister = new RootBeanDefinition(DowJonesNewsPersister.class, true);
//
//        // 将bean定义到容器中
//        registry.registerBeanDefinition("djNewsProvider", newsProvider);
//        registry.registerBeanDefinition("djNewsListener", newsListener);
//        registry.registerBeanDefinition("djNewsPersister", newsPersister);
//
//        // 指定依赖关系
//        //   1 通过构造方法注入
//        ConstructorArgumentValues argValues = new ConstructorArgumentValues();
//        argValues.addIndexedArgumentValue(0, newsListener);
//        argValues.addIndexedArgumentValue(1, newsPersister);
//        newsProvider.setConstructorArgumentValues(argValues);
//        //   2 或通过setter方法注入
////        MutablePropertyValues propertyValues = new MutablePropertyValues();
////        propertyValues.addPropertyValue(new PropertyValue("newsListener", newsListener));
////        propertyValues.addPropertyValue(new PropertyValue("newsPersister", newsPersister));
////        newsProvider.setPropertyValues(propertyValues);
//
//        return (BeanFactory) registry;
//    }

    private static BeanFactory bindViaPropertiesFile(BeanDefinitionRegistry registry) {
        return null;
    }

    private static BeanFactory bindViaXMLFile(BeanDefinitionRegistry registry) {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
        reader.loadBeanDefinitions("beans.xml");
        return (BeanFactory) registry;
    }
}
