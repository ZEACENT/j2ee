package listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent e) {
        System.out.println("session 增加属性 ");
        System.out.println("属性是" + e.getName());
        System.out.println("值是" + e.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent e) {
        // TODO Auto-generated method stub
        System.out.println("session 移除属性 ");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent e) {
        // TODO Auto-generated method stub
        System.out.println("session 替换属性 ");
    }

    @Override
    public void sessionCreated(HttpSessionEvent e) {
        System.out.println("监听到 session 创建, sessionid 是： " + e.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent e) {
        System.out.println("监听到 session 销毁, sessionid 是： " + e.getSession().getId());
    }
}