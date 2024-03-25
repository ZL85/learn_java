# 05_Map接口及其不同实现类

`java.util.Map`：存储一对一对的数据 (key-value 对)。

- `HashMap`：主要实现类，线程不安全，效率高；可以添加`null`的 key 和 value 值；底层使用数组+单向链表+红黑树结构存储 (jdk8)。

  ```java
  @Test
  public void test1(){
      Map map = new HashMap();
  
      map.put(null,null);
  
      System.out.println(map);
  }
  ```

  - `LinkedHashMap`：是`HashMap`的子类，在`HashMap`使用的数据结构的基础上增加了一对双向链表，用于记录添加元素的先后顺序，进而我们在遍历元素时，就可以按照添加的顺序显示。开发中，对于频繁的便利操作，建议使用此类。

    ```java
    @Test
    public void test3(){
        LinkedHashMap map = new LinkedHashMap();
    
        map.put("Tom",23);
        map.put("a",new Date());
        map.put(1,"b");
    
        System.out.println(map);
    }
    ```

- `HashTable`：古老实现类，线程安全，效率低；底层使用数组+单向链表结构存储 (jdk8)。

  ```java
  @Test
  public void test2(){
      Map map = new Hashtable();
  
      //        map.put("a",null); //NullPointerException
      //        map.put(null,1); //NullPointerException
      map.put("a",1);
  
      System.out.println(map);
  }
  ```

- `TreeMap`：底层使用红黑树存储；可以按照添加的 key-value 中 key 元素的指定属性的大小顺序进行遍历，需要考虑使用自然排序或定制排序。

  - `Properties`：其 key 和 value 值都是`String`类型，常用来处理属性文件。

`HashMap`中元素的特点：

- `HashMap`中所有的 key 彼此之间是不可重复的，无序的，所有的 key 就构成一个`Set`集合 (key 所在类要重写`hashCode()`和`equals()`方法)。
- `HashMap`中所有的 value 彼此之间是可重复的，无序的，所有的 value 就构成一个`Collection`集合 (value 所在类要重写`equals()`方法)。
- `HashMap`中的一个 key-value，就构成了一个 entry。
- `HashMap`中所有的 entry 之间是不可重复的，无序的，所有的 key 就构成一个`Set`集合。

