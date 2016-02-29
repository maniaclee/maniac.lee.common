package maniac.lee.common.test;

import maniac.lee.common.tool.BeanConverterFactory;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;

/**
 * Created by peng on 16/2/29.
 */
public class TestCase {


    @Test
    public void sdf() throws Exception {
        B b = new B();
        b.setB("fuck");
        b.set_a(-1);

        BeanConverterFactory<B, BCopy> c = BeanConverterFactory.create(B.class, BCopy.class);
        System.out.println(ToStringBuilder.reflectionToString(b));
        System.out.println(ToStringBuilder.reflectionToString(c.to(b)));
    }
}
