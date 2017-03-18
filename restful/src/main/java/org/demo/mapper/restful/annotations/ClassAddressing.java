package org.demo.mapper.restful.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类FieldAddressing.java的实现描述：用于可以相互可进行自动化转换的类型的重复key的数据寻址装配
 * 
 * @author wb199502 2017年3月8日 下午3:38:12
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR })
public @interface ClassAddressing {

    Class<?> sourceClazz();

    Class<?> targetClazz();

}
