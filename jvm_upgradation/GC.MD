# 垃圾手机算法
## 引用计数算法
* 引用计数算法比较简单，对每个对象保存一个整型的引用计数器属性。用于记录对象被引用的情况。
* 对一个对象A，只要有任何一个对象引用了A，则的引用计数器就会加1，当引用失效时，引用计数器就减一。只要对象A的引用计数器的值为0,即表示对象A
  不可能在被使用了，可以进行回收
* 优点：
    * 实现简单，垃圾对象便于辨识；判定效率搞，回收没有延迟性。
* 缺点:
    * 它需要单独的字段存储计数器，这样就增加了存储空间的开销。
    * 每次赋值都需要更新计数器，伴随着假发和减法的操作，这增加了时间的开销
    * 引用计数器有一个严重的问题，即无法处理循环引用的情况。这是一条致命的缺陷，导致在Java的垃圾回收器中没有使用这类算法。


## 可达性分析(或根搜索算法，追踪性垃圾收集)
* 相对于引用计数算法而言，可达性分析算法不仅可同样具备实现简单和执行高效等特点，更重要的是搞算法可以有效的解决在引用计数算法中循环引用的问题，
  防止内存泄露的发生。
* 相较于引用计数算法，这里的可达性分析就是Java、C#选择的。这种类型的垃圾收集通常也叫做追踪性垃圾收集(Tracing Garbage Collection)

* GC Roots根集合就是一组必须活跃的引用
* 基本思路：
  * 可达性分析算法是以根对象集合(GC Roots)为起始点，按照从上至下的方式搜索被根对象集合所连接的目标对象是否可达。
  * 使用可达性分析算法后，内存中存货的对象都会被根对象集合直接或者简单的连接这，搜索所走过的路径称为引用链(Reference Chain)
  * 如果目标对象没有任何引用链，则是不可达的，就以为着该对象已经死亡，可以标记为垃圾对象
  * 在可达性分析算法中，只有能够被根对象集合直接或者间接连接的对象才是存货的对象
* Java语言中，GC Roots包括了一下几类元素：
  * 虚拟机栈中引用的对象
    * 比如：各个线程被调用的方法中使用到的参数、局部变量等。
  * 本地方法真内JNI(通常说的本地方法)引用的对象
  * 方法区中静态属性引用的对象
    * 比如：Java类的引用类型静态变量
  * 方法区中常量应用的对象
    * 比如：字符串常量池(String Table)里的引用
  * 所有被同步锁synchronized持有的对象
  * Java虚拟机内部的引用
    * 基本数据类型对于的Class对象，一些常珠的异常对象(如果NullPointerException、OutOfMemoryError),系统类加载器。
  * 反映Java虚拟机内部情况的JMXBean、JVMTI中注册的回调、本地代码缓存等.

* 除了以上固定的GC Roots集合以外，根据用户所选择用的垃圾收集器以及当前回收的内存区域不同，还可以有其他对象的”临时性“地加入，共同
完整GC Roots集合。比如:粉黛收集和局部回收(Partial GC)。
  * 如果值针对Java堆中地某一块区域进行垃圾回收(比如:典型的值针对新生代)，必须考虑到内存区域是虚拟机自己的实现细节，更不是孤立封闭的，
    这个区域的对象完全有可能被其他区域的对象所引用，这时候就需要一并将关联的区域对象也加入GC Roots集合中去考虑，才能保证可达性分析的准确性。
* 小技巧:
  * 由于Root采用栈方式存放变量和指针，所以如果一个指针，它保存了堆内存里面的对象，但是，自己有不存放在堆内存里面，那它就是一个Root。

* 注意：
  * 如果要使用可达性分析算法来判断内存是否可以回收，那么分析工作必须在一个能够保障一致性的快照中进行。这点不满足的话分析结果的准确性就无法得到保障。
  * 这点也是导致GC进行时必须”Stop The World“的一个重要原有。
    * 即时时号称(几乎)不会发生停顿的CMS收集器中，美剧根节点时也是必须要停顿的。


## 对象的finalization机制
* Java语言提供了对象终止(finalization)机制来允许开发人员提供对象销毁之前的自定义处理逻辑。
* 当垃圾收集器发现没有引用执行一个对象，即：垃圾回收此对象之前，总会先调用这个对象的finalize()方法
* finalize()方法允许在子类中被重写，用于在对象被回收时进行资源释放。通常在这个方法中进行一些资源的释放
  和清理的工作，比如关闭文件、套接字和数据库连接等。

* 注意：
  * 不要主动调用某个对象的finalize()方法，应该交给垃圾回收机制调用。理由包括以下三点:
    * finalize()时可能导致对象复活。
    * finalize()方法的执行时间是没有保障的，它完全由GC线程决定，极端的情况下，若不发生GC，则finalize()方法将不会被执行。
    * 一个糟糕的finalize()会严重的影响GC的性能。
  * 从功能上看，finalize()方法和C++的析构函数比较相似，但是Java采用的是基于垃圾回收器的自动内存管理机制，所以fianlize()方法在本只上不同于C++
    的析构函数
* 由于finalize()方法的存在，虚拟机中的对象一般处于三种可能的状态。
  * 如果从根节点都无法访问到某个对象，说明对象以及不再使用了。一般来说，此对象就需要被回收。但是，事实上，也并非是”非死不可“的，这时候他们暂时
    处于”缓刑“阶段。一个无法触及的对象有可能在某一个条件下”复活“自己，如果这样，那么对它的回收就是不合理的，为此，定义虚拟机中的对象可能存在
    三种状态：
    * 可触及的：从根节点开始，可以到达的对象。
    * 可复活的：对象的所有引用都被释放，但是对象可能在finalize()复活
    * 不可触及的：对象的finalize()被调用，并且么有复活，那就会进入不可触及的状态。不可触及的对象不可能被复活，以为fianlize()指挥被调用一次。
  * 以上2种状态种，是由finalize*)方法的村子啊，进行区分。只有在对象不可触及时才可以被回收。

* finalization机制执行的过程
![finalization机制执行的过程](./files/finalization机制-1.PNG)

finalize()方法复活对象示例：
```java
package chapter15;

/**
 * finalize()方法将对象复活
 *
 *
 */
public class CanReliveObj {
    public static CanReliveObj canReliveObj;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("重写了对象的finalize()方法");
        canReliveObj = this;
    }

    /**
     * 执行结果：
     * 重写了对象的finalize()方法
     * 第一次调用GC
     * canReliveObj still alive
     * 第二次GC
     * canReliveObj is dead
     */
    public static void main(String[] args) throws InterruptedException {
        canReliveObj = new CanReliveObj();
        canReliveObj=null;
        System.gc();
        System.out.println("第一次调用GC");
        Thread.sleep(2000L);
        if (canReliveObj==null){
            System.out.println("canReliveObj is dead");
        }else {
            System.out.println("canReliveObj still alive");
        }
        System.out.println("第二次GC");
        canReliveObj=null;
        System.gc();
        Thread.sleep(2000L);
        if (canReliveObj==null){
            System.out.println("canReliveObj is dead");
        }else {
            System.out.println("canReliveObj still alive");
        }
    }
}

```

## MAT查看GC Roots
![生成GC Roots](./files/MAT查看GC Roots-1.PNG)
![销毁GC Roots](./files/MAT查看GC Roots-2.PNG)




## Jprofiler查看GC Roots



## 垃圾收集算法

### 标记-清楚算法

### 复制算法

### 标记-整理算法



### 分代收集算法
JVM虚拟机的内存时按照代去划分的，比如年轻代，老年代，永久代等，每个代的生命周期都是不一样的，
那么根据上面垃圾收集算法算法的不同的优缺点就需要选择性的去使用，这样才能提供垃圾收集的效率。

### 增量收集算法
本只上就是复制算法和标记清除算法，只是每次都只是执行一小片区域的垃圾收集，该区域垃圾收集完成之后
就迅速的切换到用户线程执行，使得垃圾收集和用户线程可以交替使用，而不至于使得用户等待，但是这个方式
需要不断的切换线程，其实线程的切换也是很耗费资源的。


### 分区算法




[垃圾收集的示例](./src/main/java/chapter16/LocalVariableGC.java)


























































































