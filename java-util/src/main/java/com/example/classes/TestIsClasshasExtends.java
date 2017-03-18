package com.example.classes;

import org.junit.Test;

/**
 * 类TestIsClasshasExtends.java的实现描述：类型的检查的操作
 * 
 * @author wb199502 2017年3月8日 下午4:01:06
 */
public class TestIsClasshasExtends {

    @Test
    public void test() {
        //        isInstance
        //        public boolean isInstance(Object obj)判定指定的 Object 是否与此 Class 所表示的对象赋值兼容。此方法是 Java 语言 instanceof 运算符的动态等效方法。如果指定的 Object 参数非空，且能够在不引发 ClassCastException 的情况下被强制转换成该 Class 对象所表示的引用类型，则该方法返回 true；否则返回 false。 
        //        特别地，当该 Class 对象表示一个已声明的类时，若指定的 Object 参数是所表示类（或其任一子类）的一个实例，则此方法返回 true；否则返回 false。如果此 Class 对象表示一个数组类，且通过身份转换或扩展引用转换，指定的 Object 参数能转换为一个数组类的对象，则返回 true；否则返回 false。如果此 Class 对象表示一个接口，且指定 Object 参数的类或任一超类实现了此接口，则此方法返回 true；否则返回 false。如果此 Class 对象表示一个基本类型，则此方法返回 false。 
        //
        //
        //        参数：
        //        obj - 要检查的对象 
        //        返回：
        //        如果 obj 是此类的实例，则返回 true
        //        从以下版本开始： 
        //        JDK1.1 

        System.out.println(Student.class.isInstance(new Student()));
        System.out.println(Student.class.isInstance(new Person()));
        System.out.println(Person.class.isInstance(new Student()));
        System.out.println(Person.class.isInstance(new Person()));

        //       isAssignableFrom
        //       isAssignableFrom
        //       public boolean isAssignableFrom(Class<?> cls)判定此 Class 对象所表示的类或接口与指定的 Class 参数所表示的类或接口是否相同，或是否是其超类或超接口。如果是则返回 true；否则返回 false。如果该 Class 表示一个基本类型，且指定的 Class 参数正是该 Class 对象，则该方法返回 true；否则返回 false。 
        //       特别地，通过身份转换或扩展引用转换，此方法能测试指定 Class 参数所表示的类型能否转换为此 Class 对象所表示的类型。有关详细信息，请参阅 Java Language Specification 的第 5.1.1 和 5.1.4 节。 
        //
        //
        //       参数：
        //       cls - 要检查的 Class 对象 
        //       返回：
        //       表明 cls 类型的对象能否赋予此类对象的 boolean 值 
        //       抛出： 
        //       NullPointerException - 如果指定的 Class 参数为 null。
        //       从以下版本开始： 
        //       JDK1.1 

        System.out.println(Student.class.isAssignableFrom(Student.class));
        System.out.println(Student.class.isAssignableFrom(Person.class));
        System.out.println(Person.class.isAssignableFrom(Student.class));
        System.out.println(Person.class.isAssignableFrom(Person.class));
    }

    class Person {

    }

    class Student extends Person {

    }
}
