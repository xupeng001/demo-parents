package org.demo.mapper.restful;

import java.lang.reflect.Field;
import java.util.List;

import org.demo.mapper.restful.annotations.ClassAddressing;
import org.demo.mapper.restful.annotations.FieldAddressing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;


/**
 * 类BuildUtils.java的实现描述：支持bean拷贝 支持vo装配
 * @author xupeng 2017年3月9日 下午2:57:04
 */
public class BuildUtils {

    private static Logger log = LoggerFactory.getLogger(BuildUtils.class);

    /**
     * 支持自定义赋值的多对象数据组装
     * 
     * @param protocolVo
     * @param callback
     * @param dtos
     * @return
     */
    public static <T extends Object> T handleObject(T protocolVo, ICallback<T> callback, Object... dtos) {
        if (protocolVo == null || dtos == null) {
            return null;
        }
        if (dtos.length == 1) {
            Object dto = dtos[0];
            Class<? extends Object> clazz = protocolVo.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    if ("serialVersionUID".equals(field.getName())) {
                        continue;
                    }
                    FieldAddressing annotation = field.getAnnotation(FieldAddressing.class);
                    if (annotation != null) {
                        /***
                         * 基于注解转换
                         */
                        Class<? extends Object> sourceClazz = annotation.clazz();
                        String sourceName = annotation.fieldName();
                        if (sourceClazz.equals(dto.getClass())) {
                            Field annoFile = sourceClazz.getDeclaredField(sourceName);
                            Field f = null;
                            f = dto.getClass().getDeclaredField(annoFile.getName());
                            if (f == null)
                                continue;
                            f.setAccessible(true);
                            Object value = f.get(dto);
                            if (value == null) {
                                continue;
                            }
                            field.set(protocolVo, value);
                        }
                    } else {
                        /***
                         * 基于file转换
                         */
                        Field f = null;
                        f = dto.getClass().getDeclaredField(field.getName());
                        if (f == null)
                            continue;
                        f.setAccessible(true);
                        Object value = f.get(dto);
                        if (value == null) {
                            continue;
                        }
                        field.set(protocolVo, value);
                    }

                } catch (NoSuchFieldException e) {
                    log.info(" not have this file {}  ", field.getName());
                } catch (IllegalAccessException e) {
                    log.info(" field type difference   {} : {}", field.getName(), e.getMessage());
                } catch (IllegalArgumentException e) {
                    log.info(" field type difference   {} : {}", field.getName(), e.getMessage());
                }
            }
        } else {
            for (Object object : dtos) {
                handleObject(protocolVo, callback, object);
            }
        }
        callback.callback(protocolVo);
        return protocolVo;
    }

    /**
     * 基于注解多bean中的list数据赋值
     * 
     * @param protocolVo
     * @param dtos
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T extends Object> T handleObject(T protocolVo, List<?>... dtos) {
        if (protocolVo == null || dtos == null) {
            return null;
        }
        if (dtos.length < 1) {
            throw new RuntimeException("数据源缺失");
        } else if (dtos.length == 1) {
            if (CollectionUtils.isEmpty(dtos[0])) {
                return protocolVo;
            }
            Class<? extends Object> dtoClass = dtos[0].get(0).getClass();
            Field[] fields = protocolVo.getClass().getDeclaredFields();
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    ClassAddressing annotation = field.getAnnotation(ClassAddressing.class);
                    if (annotation != null) {
                        Class<?> sourceClass = annotation.sourceClazz();
                        if (dtoClass.isAssignableFrom(sourceClass)) {
                            Class<?> targetClazz = annotation.targetClazz();
                            @SuppressWarnings("rawtypes")
                            List list = Lists.newArrayList();
                            for (Object obj : dtos[0]) {
                                T vo = null;
                                try {
                                    vo = (T) targetClazz.newInstance();
                                } catch (InstantiationException e) {
                                    log.error(" java bean  newInstance exception {} ", targetClazz);
                                }
                                handleObject(vo, obj);
                                list.add(vo);
                            }
                            field.set(protocolVo, list);
                        }
                    }

                } catch (IllegalAccessException e) {
                    log.info(" field type difference   {} : {}", field.getName(), e.getMessage());
                }
            }

        } else {
            for (List<?> list : dtos) {
                handleObject(protocolVo, list);
            }
        }
        return protocolVo;
    }

    /**
     * 多对象数据组装
     * 
     * @param protocolVo
     * @param dtos
     * @return
     */
    public static <T extends Object> T handleObject(T protocolVo, Object... dtos) {
        if (protocolVo == null || dtos == null) {
            return null;
        }
        if (dtos.length < 1) {
            throw new RuntimeException("数据源缺失");
        } else if (dtos.length == 1) {
            Object dto = dtos[0];
            Class<? extends Object> clazz = protocolVo.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    if ("serialVersionUID".equals(field.getName())) {
                        continue;
                    }
                    FieldAddressing annotation = field.getAnnotation(FieldAddressing.class);
                    if (annotation != null) {
                        /***
                         * 基于注解转换
                         */
                        Class<? extends Object> sourceClazz = annotation.clazz();
                        String sourceName = annotation.fieldName();
                        if (sourceClazz.equals(dto.getClass())) {
                            Field annoFile = sourceClazz.getDeclaredField(sourceName);
                            Field f = null;
                            f = dto.getClass().getDeclaredField(annoFile.getName());
                            if (f == null)
                                continue;
                            f.setAccessible(true);
                            Object value = f.get(dto);
                            if (value == null) {
                                continue;
                            }
                            field.set(protocolVo, value);
                        }
                    } else {
                        /***
                         * 基于file转换
                         */
                        Field f = null;
                        f = dto.getClass().getDeclaredField(field.getName());
                        if (f == null)
                            continue;
                        f.setAccessible(true);
                        Object value = f.get(dto);
                        if (value == null) {
                            continue;
                        }
                        field.set(protocolVo, value);
                    }

                } catch (NoSuchFieldException e) {
                    log.info(" not have this file {}  ", field.getName());
                } catch (IllegalAccessException e) {
                    log.info(" field type difference   {} : {}", field.getName(), e.getMessage());
                } catch (IllegalArgumentException e) {
                    log.info(" field type difference   {} : {}", field.getName(), e.getMessage());
                }
            }
        } else {
            for (Object object : dtos) {
                handleObject(protocolVo, object);
            }
        }
        return protocolVo;
    }

    public static <T extends Object> List<T> handleList(List<T> protocolVos, Class<T> voClass, List<?>... dtos) {
        if (protocolVos == null || dtos == null) {
            return null;
        }
        if (dtos.length < 1) {
            throw new RuntimeException("数据源缺失");
        } else if (dtos.length == 1) {
            if (CollectionUtils.isEmpty(dtos[0])) {
                return protocolVos;
            }
            if (protocolVos.size() > 0) {
                for (int i = 0; i < dtos[0].size(); i++) {
                    handleObject(protocolVos.get(i), dtos[0].get(i));
                }
            } else {
                T vo;
                for (Object obj : dtos[0]) {
                    try {
                        vo = voClass.newInstance();
                        handleObject(vo, obj);
                        protocolVos.add(vo);
                    } catch (InstantiationException e) {
                        log.error(" java bean  newInstance exception {} ", voClass);
                    } catch (IllegalAccessException e) {
                        log.error(" java bean  newInstance exception {} ", voClass);
                    }
                }
            }
        } else {
            for (List<?> list : dtos) {
                handleList(protocolVos, voClass, list);
            }
        }
        return protocolVos;
    }

    public static void copyProperties(Object source, Object target) {
        if (source == null || target == null) {
            return;
        }
        Field[] fields = target.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if ("serialVersionUID".equals(field.getName())) {
                continue;
            }
            Object value;
            try {
                Field declaredField = source.getClass().getDeclaredField(field.getName());
                declaredField.setAccessible(true);
                value = declaredField.get(source);
                if (value == null) {
                    continue;
                }
                field.set(target, value);
            } catch (NoSuchFieldException e) {
                log.info(" not have this file {}  ", field.getName());
            } catch (IllegalAccessException e) {
                log.info(" field type difference   {} : {}", field.getName(), e.getMessage());
            } catch (IllegalArgumentException e) {
                log.info(" field type difference   {} : {}", field.getName(), e.getMessage());
            }
        }
    }

}
