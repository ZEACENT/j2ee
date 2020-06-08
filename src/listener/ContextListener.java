package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener, ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent e) {
        System.out.println("app增加属性 ");
        System.out.println("属性是" + e.getName());
        System.out.println("值是" + e.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent e) {
        // TODO Auto-generated method stub
        System.out.println("app移除属性 ");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent e) {
        // TODO Auto-generated method stub
        System.out.println("替换属性");
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("web 应用销毁  ");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("web 应用初始化 ");
    }
}