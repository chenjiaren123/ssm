package cn.itcast.ui;

import cn.itcast.dao.AccountDao;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        /*AccountService accountService = (AccountService)context.getBean("AccountService");
        AccountDao accountDao = context.getBean("AccountDao", AccountDao.class);*/

        /*---------------------------------------------------------------------------
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("bean.xml"));
        AccountService accountService = factory.getBean("accountService", AccountService.class);
        AccountDao accountDao = factory.getBean("accountDao", AccountDao.class);
        System.out.println(accountService);
        System.out.println(accountDao);
        -----------------------------------------------------------------------------*/

        AccountService accountService = (AccountService)context.getBean("accountService");
        ((ClassPathXmlApplicationContext)context).close();
        System.out.println(accountService);
    }
}
