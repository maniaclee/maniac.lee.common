package maniac.lee.common.tool;

/**
 * Created by peng on 16/2/28.
 */
public interface BeanConverter<S, T> {

    T to(S src);

    S from(T src);

}
