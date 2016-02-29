package maniac.lee.common.test;

import java.io.Serializable;

/**
 * Created by peng on 16/2/29.
 */
public class B extends A implements Serializable{
    private static final long serialVersionUID = -1471893528572230690L;
    private String b;
    private int b_num;

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public int getB_num() {
        return b_num;
    }

    public void setB_num(int b_num) {
        this.b_num = b_num;
    }
}
