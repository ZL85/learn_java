package com.project;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class CustomerList {
    private Customer[] customers;  //保存客户对象的数组
    private int totalNum = 0;  //记录已保存客户对象的数量

    /**
     * 用途：用来初始化customers数组
     *
     * @param totalNum //指定customers数组的最大空间
     */
    public CustomerList(int totalNum) {
        customers = new Customer[totalNum];
    }

    /**
     * 用途：将参数customer添加到数组最后一个客户记录之后
     *
     * @param customer //指定要添加的对象
     * @return
     */
    public boolean addCustomer(Customer customer) {
        if (totalNum < customers.length) {
            customers[totalNum++] = customer;
            return true;
        }

        return false;
    }

    /**
     * 用途: 用参数customer替换数组中由index指定的对象
     *
     * @param index    //index指定所替换对象在数组中的位置，从0开始
     * @param customer //customer指定替换的新客户对象
     * @return
     */
    public boolean replaceCustomer(int index, Customer customer) {
        if (index >= 0 && index < totalNum) {
            customers[index] = customer;
            return true;
        }
        return false;
    }

    /**
     * 用途: 从数组中删除参数index指定索引位置的客户对象记录
     *
     * @param index //index指定所删除对象在数组中的索引位置，从0开始
     * @return
     */
    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= totalNum) {
            return false;
        }
        for (int i = index; i < totalNum - 1; i++) {
            customers[i] = customers[i + 1];
        }

        //将有效数据最后一个位置置空
        customers[--totalNum] = null;
        return true;
    }


    /**
     * 用途: 返回数组中记录的所有客户对象
     *
     * @return Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同
     */
    public Customer[] getAllCustomers() {
        Customer[] customer = new Customer[totalNum];
        for (int i = 0; i < customers.length; i++) {
            customer[i] = customers[i];
        }
        return customer;
    }

    public Customer getCustomer(int index) {
        if (index < 0 || index >= totalNum) {
            return null;
        } else {
            return customers[index];
        }
    }

    public int getTotalNum() {
        return totalNum;
    }
}
