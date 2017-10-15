package org.reflect.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ReflectDemo {

    /**
     * 反射在类对象上的应用
     */
    @Test
    public void classInfo() throws Exception {
        /**
         * 通过反射获取到student的一个实例对象
         */
        Class<?> stuClass = Class.forName("org.reflect.demo.Student");
        Object stu = stuClass.newInstance();

        assertThat(stu instanceof Student).isTrue();

        Class<?> stuClass_2 = Class.forName("org.reflect.demo.Student", true, ClassLoader.getSystemClassLoader());
        //        Class<?> stuClass_2 = Class.forName("org.reflect.demo.Student", true, new ClassLoader() {
        //        });
        Object stu_2 = stuClass_2.newInstance();

        assertThat(stu_2 == stu).isFalse();

        assertThat(stuClass_2 == stuClass).isTrue();
        assertThat(stuClass_2.getClassLoader() == stuClass.getClassLoader()).isTrue();

        assertThat(stu_2 instanceof Student).isTrue();
        /**
         * 获取父类
         */
        System.out.println(stuClass.getGenericSuperclass());
        /**
         * 获取接口
         */
        Type[] genericInterfaces = stuClass.getGenericInterfaces();
        for (Type type : genericInterfaces) {
            System.out.println(type.getTypeName());
        }
    }

    /**
     * 反射在方法上的使用
     */
    @Test
    public void methodInfo() throws Exception {
        Class<Student> stuClass = Student.class;
        System.out.println("********************************");
        /**
         * 获取本类的所有方法（包含父类）
         */
        Method[] methods = stuClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("********************************");
        /**
         * 获取本类的所有非私有方法
         */
        Method[] declaredMethods = stuClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName());
        }
        System.out.println("********************************");
        /**
         * 获取指定方法名称的方法并赋值
         */
        Method method = stuClass.getMethod("setStuId", Long.class);
        System.out.println(method.getName());
        Student stu = stuClass.newInstance();
        method.invoke(stu, 10L);
        System.out.println(stu.getStuId());
        System.out.println("********************************");
        /**
         * 获取注解
         */
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.toString());
        }
        Deprecated annotation = method.getAnnotation(Deprecated.class);
        System.out.println(annotation.toString());
        /**
         * 获取构造方法
         */
        Constructor<?>[] constructors = stuClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.toGenericString());
        }
    }

    /**
     * 反射在属性上的应用
     */
    @Test
    public void fieldInfo() throws Exception {
        Class<Student> stuClass = Student.class;

        /**
         * 获取所有的共有的属性包含父类的
         */
        Field[] fields = stuClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println("********************************");

        /**
         * declared 公开的 获取本类所有属性
         */
        Field[] declaredFields = stuClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field.getName());
        }
        System.out.println("********************************");
        Student stu = stuClass.newInstance();
        /**
         * 获取当前类的指定属性
         */
        Field field = stuClass.getDeclaredField("stuId");
        /**
         * 开启暴力反射才可以执行属性赋值
         */
        field.setAccessible(true);
        field.set(stu, 10L);
        System.out.println(stu.getStuId());
        System.out.println("********************************");
    }

}
