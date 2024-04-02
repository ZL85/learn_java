package learnjava_17;

import org.junit.jupiter.api.Test;

public class SealedTest {

    //sealed修饰类
    sealed class Person permits Student, Teacher {
    }

    //要求指定子类必须是final、sealed或者non-sealed
    final class Student extends Person {
    }

    non-sealed class Teacher extends Person {
    }


    //sealed修饰接口
    sealed interface Animal permits Cat, Dog {
    }

    final class Cat implements Animal {
    }

    final class Dog implements Animal {
    }
}
