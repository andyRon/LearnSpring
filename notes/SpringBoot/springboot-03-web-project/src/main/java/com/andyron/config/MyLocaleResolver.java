package com.andyron.config;

import org.apache.logging.log4j.util.Strings;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author Andy Ron
 */
public class MyLocaleResolver implements LocaleResolver {

    // 解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取请求中的语言参数
        String l = request.getParameter("l");

        Locale locale = Locale.getDefault(); //
        //
        if (!Strings.isEmpty(l)) {
            String[] split = l.split("_");
            locale = new Locale(split[0], split[1]); // 国家，地区
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
