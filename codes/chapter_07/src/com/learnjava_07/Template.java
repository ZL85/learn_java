package com.learnjava_07;

public abstract class Template {
    //计算某段代码执行时间
    public void runTime() {
        long start = System.currentTimeMillis();
        code();
        long end = System.currentTimeMillis();
        System.out.println("code runtime is " + (end - start));
    }

    public abstract void code();
}
