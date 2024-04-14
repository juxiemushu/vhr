package org.javaboy.vhr.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.util.Locale;

@Component
public class SpringContextHolder implements BeanFactoryPostProcessor, ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringContextHolder.class);

    /** ApplicationContext */
    private static ApplicationContext context;

    /** ServletContext */
    private static ServletContext servletContext;

    /** Environment */
    private static Environment environment;

    /** MessageSourceAccessor */
    private static MessageSourceAccessor messages;

    private SpringContextHolder() {
    }

    public static ApplicationContext getSpringContext() {
        return context;
    }

    public static ServletContext getServletContext() {
        return servletContext;
    }

    public static Environment getEnvironment() {
        return environment;
    }

    public static Object getBean(String name) {
        return context.getBean(name);
    }

    public static <T> T getBean(Class<T> requiredType) {
        return context.getBean(requiredType);
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        return context.getBean(name, requiredType);
    }

    public static String getProperty(String key) {
        return environment.getProperty(key);
    }

    public static String getRequiredProperty(String key) {
        return environment.getRequiredProperty(key);
    }

    public static void setServletContext(ServletContext sc) {
        servletContext = sc;
    }

    public static MessageSourceAccessor getMessageSourceAccessor() {
        return messages;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        LOGGER.info("Spring context holder initialized successful");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        init(applicationContext);
    }

    /**
     * 对相关的属性进行赋值<br/>
     *
     * @param applicationContext ApplicationContext
     */
    private static void init(ApplicationContext applicationContext) {
        context = applicationContext;
        environment = context.getEnvironment();

        if (context instanceof WebApplicationContext) {
            servletContext = ((WebApplicationContext) context).getServletContext();
        }
        messages = new MessageSourceAccessor(context, Locale.SIMPLIFIED_CHINESE);
    }

}
