package b.d.c.b;

import java.util.List;

/* loaded from: classes2.dex */
public class m<T> extends b<List<T>> {

    /* renamed from: c */
    private int f4464c;

    /* renamed from: d */
    private String f4465d;

    /* renamed from: e */
    private int f4466e;

    public m() {
    }

    public int e() {
        return this.f4464c;
    }

    public String f() {
        return this.f4465d;
    }

    public c g() {
        return new c(this.f4464c, this.f4465d);
    }

    public List<T> h() {
        return c();
    }

    public T i() {
        if (c() == null || c().isEmpty()) {
            return null;
        }
        return c().get(0);
    }

    public int j() {
        return this.f4466e;
    }

    public boolean k() {
        return this.f4464c != this.f4466e;
    }

    public void l(int errcode) {
        this.f4464c = errcode;
    }

    public void m(String errmsg) {
        this.f4465d = errmsg;
    }

    public void n(int succCode) {
        this.f4466e = succCode;
    }

    public m(List<T> data) {
        super(data);
    }

    public m(int errcode, String errmsg) {
        this.f4464c = errcode;
        this.f4465d = errmsg;
    }
}
