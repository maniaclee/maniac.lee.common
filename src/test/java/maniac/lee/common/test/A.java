package maniac.lee.common.test;

import java.io.Serializable;

/**
 * Created by peng on 16/2/28.
 */
public class A implements Serializable {

    private static final long serialVersionUID = -2633776835022303765L;
    private String a;
    private int _a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public int get_a() {
        return _a;
    }

    public void set_a(int _a) {
        this._a = _a;
    }
}
