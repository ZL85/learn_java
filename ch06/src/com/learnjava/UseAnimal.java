package com.learnjava;

public class UseAnimal {
    public void adopt(Animal animal) {
        animal.eat();
        animal.jump();
    }

    public static void main(String[] args) {
        UseAnimal useAnimal = new UseAnimal();

        //多态性
        useAnimal.adopt(new Cat());
        useAnimal.adopt(new Dog());

        //向下转型
        Animal animal = new Cat();
        Cat cat = (Cat) animal;
        cat.swim();
        System.out.println(cat == animal);  //true 指向堆空间中的同一个对象

        Animal animal1 = new Dog();
        //a instanceof A : 判断对象a是否是类A的实例
        //加强代码的健壮性
        if (animal1 instanceof Animal) {
            Dog dog = (Dog) animal1;
            dog.keepDoor();
            System.out.println(dog == animal1);  //true 指向堆空间中的同一个对象
        }
    }
}
