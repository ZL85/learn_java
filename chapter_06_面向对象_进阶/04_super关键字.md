# 04_super关键字

子类继承父类以后，对父类的方法进行了重写，如何在子类中对父类中被重写的方法进行调用？

子类继承父类以后，如何区分子类和父类中同名的属性？

使用`super`关键字，有`super.`的就是父类的，没有`super.`就是子类自己的。

```java
public class Mankind {
    private int gender;
    private double salary;

    public Mankind() {
    }

    public Mankind(int gender, double salary) {
        this.gender = gender;
        this.salary = salary;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void maleOrFemale() {
        if (gender == 1) {
            System.out.println("male");
        } else if (gender == 0) {
            System.out.println("female");
        }
    }

    public void employed() {
        if (salary == 0) {
            System.out.println("have no job");
        } else {
            System.out.println("have job");
        }
    }
}
```

```java
public class Kid extends Mankind {
    private int age;

    
    public void setAge(int age) {
        this.age = age;
    }

    public void getAge() {
        System.out.println("age: " + age);
    }

    //重写父类方法
    //用super调用父类方法
    public void employed() {
        super.employed();
        System.out.println("kid should study and have no job");
    }

    public void getInfo() {
        System.out.println("kid' info");
    }
}
```

