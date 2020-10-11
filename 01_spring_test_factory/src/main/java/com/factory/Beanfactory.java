package com.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 创建bean对象的工厂
 */
public class Beanfactory {
    //定义一个properties对象
    private static Properties pros;

    //定义一个Map，用于存放我们要创建的对象，我们把它成为容器
    private static Map<String, Object> beans;
    //使用静态代码块为properties对象赋值
    static {
        try {
            //实例化对象
            pros = new Properties();
            //获取properties流对象
            InputStream in = Beanfactory.class.getClassLoader().getResourceAsStream("bean.properties");
            pros.load(in);


            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的key
            Enumeration keys = pros.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获得value
                String beanPath = pros.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器中
                beans.put(key, value);
            }

        }catch (Exception e){
            throw new ExceptionInInitializerError("初始化Properties失败!");
        }
    }



    /**
     * 根据bean的name获取bean对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }


    /*public static Object getBean(String beanName){
        Object bean = null;
        try {
            String beanPath = pros.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }*/
}
