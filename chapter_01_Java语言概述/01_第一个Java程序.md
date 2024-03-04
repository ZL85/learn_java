# 01_第一个Java程序

```java
public class HelloJava {
    public static void main(String[] args) {
        System.out.println("Hello Java!");
    }
}
```

如何保存文件、编译和运行程序？

```bash
javac HelloJava.java
java HelloJava
```

关于Java程序需要注意的地方：

- 区分大小写：Java区分大小写，这意味着标识符Hello和Hello在Java中具有不同的含义。
- 类名：对于所有类名，第一个字母应为大写。如果用几个单词组成一个类的名称，每个内部单词的第一个字母应该是大写。
- 方法名称：所有方法名称都应以小写字母开头。如果使用多个单词构成方法的名称，则每个内部单词的第一个字母应为大写。
- 程序文件名：程序文件的名称应与类名完全匹配。

> 但请注意，如果文件中没有公共类，则文件名可以与类名不同。文件中也不一定要有公共类。

- `public static void main(Stringargs[])`：Java程序处理从`main()`方法开始，`main()`是每个Java程序的必需部分。

Java标识符：

- 所有标识符都应以字母(a到Z或a到Z)、货币字符($)或下划线(_)开头。
- 在第一个字符之后，标识符可以具有任何字符组合。
- 关键字不能用作标识符。
- 标识符区分大小写。