package maniac.lee.common.tool;

import maniac.lee.common.exception.ManiacException;

import java.lang.reflect.Field;

/**
 * Created by peng on 16/2/28.
 */
public class Reflections {

    public static final int BeanConvertStrategy_SamePropertyName = 0;

    public static <T> T convert(Object a, Class<T> clz, int strategy) {
        if (clz == null)
            return null;
        try {
            T t = clz.newInstance();
            Class<?> srcClz = a.getClass();
            Class<?> desClz = clz;
            for (; ; ) {
                if (strategy == BeanConvertStrategy_SamePropertyName) {
                    for (Field field : desClz.getDeclaredFields()) {
                    }
                }
                desClz = clz.getSuperclass();
                if (desClz == null)
                    return t;
            }
        } catch (InstantiationException e) {
            throw ManiacException.create("failed to instance clz :" + clz.getName());
        } catch (IllegalAccessException e) {
            throw ManiacException.create("failed to access clz :" + clz.getName());
        }
    }

    public static void setProperty(Object a, String property, Object value) {
        try {
            setProperty(a, a.getClass().getDeclaredField(property), value);
        } catch (NoSuchFieldException e) {
        }
    }

    public static void setProperty(Object a, Field declaredField, Object value) {
        try {
            if (declaredField != null) {
                declaredField.setAccessible(true);
                declaredField.set(a, value);
            }
        } catch (Exception e) {
        }
    }



}
