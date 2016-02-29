package maniac.lee.common.tool;

import net.sf.cglib.beans.BeanCopier;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by peng on 16/2/28.
 */
public class BeanConverterFactory<S, T> implements BeanConverter<S, T> {
    private final Class<S> src;
    private final Class<T> des;
    BeanCopier src2des;
    BeanCopier des2src;

    private BeanConverterFactory(Class<S> src, Class<T> des) {
        this.src = src;
        this.des = des;
        this.src2des = BeanCopier.create(src, des, false);
        this.des2src = BeanCopier.create(des, src, true);
    }

    public static <S, T> BeanConverterFactory<S, T> create(Class<S> src, Class<T> des) {
        return new BeanConverterFactory<>(src, des);
    }


    public T to(S src) {
        try {
            T re = this.des.newInstance();
            src2des.copy(src, re, null);
            return re;
        } catch (Exception e) {
            throw new RuntimeException("error new instance " + des.getClass().getName(), e);
        }
    }

    public S from(T src) {
        try {
            S re = this.src.newInstance();
            des2src.copy(src, re, null);
            return re;
        } catch (Exception e) {
            throw new RuntimeException("error new instance " + des.getClass().getName());
        }
    }

    @Deprecated
    private static Map<String, PropertyDescriptor> getPropertyByIntrospector(Class clz) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(clz, Object.class);
            PropertyDescriptor[] proDescrtptors = beanInfo.getPropertyDescriptors();
            if (proDescrtptors != null && proDescrtptors.length > 0) {
                return Arrays.asList(proDescrtptors).stream().collect(Collectors.toMap(PropertyDescriptor::getDisplayName, p -> p));
            }
        } catch (IntrospectionException e) {
            throw new RuntimeException("error parsing class:" + clz.getName(), e);
        }
        return new HashMap<>();
    }
}
