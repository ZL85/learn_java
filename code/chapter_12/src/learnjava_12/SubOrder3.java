package learnjava_12;

//SubOrder3是泛型类
public class SubOrder3<T> extends Order<T> {
    public void show(T t) {
        System.out.println(t);
    }
}
