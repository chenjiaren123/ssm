package cn.itcast.factory;

import cn.itcast.service.AccountService;
import cn.itcast.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class BeanFactory {
    @Autowired
    private TransactionManager transactionManager;
    @Autowired
    @Qualifier("accountService")
    private AccountService accountService;

    public AccountService getAccountService(){
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object o=null;
                try {
                    transactionManager.beginTransaction();
                    o=method.invoke(accountService,args);
                    transactionManager.commit();
                    return o;
                } catch (Exception e) {
                    transactionManager.rollback();
                    throw new RuntimeException("e");
                } finally {
                    transactionManager.release();
                }
            }
        });
    }
}
