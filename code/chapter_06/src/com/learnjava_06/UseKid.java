package com.learnjava_06;

public class UseKid {
    public static void main(String[] args) {
        Kid kid = new Kid();

        kid.setGender(1);
        kid.setSalary(30000.0);
        kid.setAge(25);

        kid.employed();
        kid.maleOrFemale();
        kid.getAge();

        //多态性
        Mankind mankindKid = new Kid();
        //虚拟方法调用：编译看左边，运行看右边
        //无法调用kid里的特有的属性和方法
        mankindKid.employed();

        //向下转型
        Kid kid1 = (Kid) mankindKid;
        kid1.getInfo();
    }
}
