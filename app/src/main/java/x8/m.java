package x8;

import java.util.List;

/* loaded from: classes3.dex */
public class m<T> extends b<List<T>> {

    /* renamed from: c */
    public int f31911c;

    /* renamed from: d */
    public String f31912d;

    /* renamed from: e */
    public int f31913e;

    public m() {
    }

    public int e() {
        return this.f31911c;
    }

    public String f() {
        return this.f31912d;
    }

    public c g() {
        return new c(this.f31911c, this.f31912d);
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
        return this.f31913e;
    }

    public boolean k() {
        return this.f31911c != this.f31913e;
    }

    public void l(int i10) {
        this.f31911c = i10;
    }

    public void m(String str) {
        this.f31912d = str;
    }

    public void n(int i10) {
        this.f31913e = i10;
    }

    public m(List<T> list) {
        super(list);
    }

    public m(int i10, String str) {
        this.f31911c = i10;
        this.f31912d = str;
    }

    public m(int i10, String str, List<T> list) {
        super(list);
        this.f31911c = i10;
        this.f31912d = str;
    }
}
