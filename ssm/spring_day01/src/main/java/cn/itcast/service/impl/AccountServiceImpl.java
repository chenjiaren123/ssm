package cn.itcast.service.impl;

import cn.itcast.dao.AccountDao;
import cn.itcast.dao.impl.AccountDaoImpl;
import cn.itcast.service.AccountService;

import java.util.*;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao = new AccountDaoImpl();
    private String name;
    private Integer age;
    private Date date;
    private String[] myStrs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myPros;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String[] getMyStrs() {
        return myStrs;
    }

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public List<String> getMyList() {
        return myList;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public Set<String> getMySet() {
        return mySet;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public Map<String, String> getMyMap() {
        return myMap;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public Properties getMyPros() {
        return myPros;
    }

    public void setMyPros(Properties myPros) {
        this.myPros = myPros;
    }

    public AccountServiceImpl() {
        System.out.println("AccountService对象被创建了");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }

    public void init() {
        System.out.println("对象初始化");
    }

    public void destroy() {
        System.out.println("对象被销毁");
    }

    public AccountServiceImpl(String name, Integer age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }

    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                "accountDao=" + accountDao +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", myStrs=" + Arrays.toString(myStrs) +
                ", myList=" + myList +
                ", mySet=" + mySet +
                ", myMap=" + myMap +
                ", myPros=" + myPros +
                '}';
    }
}
