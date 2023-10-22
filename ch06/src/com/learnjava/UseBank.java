package com.learnjava;

public class UseBank {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addCustomer("l", "z");
        bank.addCustomer("h", "w");

        bank.getCustomer(0).setAccount(new Account(1000));
        bank.getCustomer(0).getAccount().withdraw(50);

        System.out.println("账户余额为：" + bank.getCustomer(0).getAccount().getBalance());
    }
}
