package cn.itcast.factory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class BeanFactory {
    private static Properties properties;
    private static Map<String, Object> bean;

    static {
        try {
            properties=new Properties();
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties"));
            bean=new HashMap<String, Object>();
            Set<Object> set = properties.keySet();
            for (Object o : set) {
                String s = properties.getProperty((String) o);
                Class<?> aClass = Class.forName(s);
                Object instance = aClass.newInstance();
                bean.put((String) o, instance);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static Object getBean(String beanName) {
        return bean.get(beanName);
    }
}
