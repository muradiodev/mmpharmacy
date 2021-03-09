//package com.mmpharmacy.mmpharmacy.security;
//
//import org.hibernate.validator.HibernateValidatorConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class[] { HibernateValidatorConfiguration.class, WebSecurityConfigurerAdapter.class };
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class[] { WebMvcConfigurer.class };
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[] { "/" };
//    }
//}
