package pg;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    public String f29878a;

    /* renamed from: b */
    public int f29879b;

    /* renamed from: c */
    public int f29880c;

    /* renamed from: d */
    public int f29881d;

    /* renamed from: e */
    public Map<String, String> f29882e;

    public static class a {

        /* renamed from: a */
        public String f29883a;

        /* renamed from: b */
        public int f29884b = 3;

        /* renamed from: c */
        public int f29885c;

        /* renamed from: d */
        public int f29886d;

        /* renamed from: e */
        public Map<String, String> f29887e;

        public a(String str) {
            this.f29883a = str;
        }

        public a b(int i10) {
            this.f29884b = i10;
            return this;
        }

        public a c(String str, String str2) {
            if (this.f29887e == null) {
                this.f29887e = new HashMap(16);
            }
            this.f29887e.put(str, str2);
            return this;
        }

        public d d() {
            return new d(this);
        }

        public a f(int i10) {
            this.f29886d = i10;
            return this;
        }

        public a h(int i10) {
            this.f29885c = i10;
            return this;
        }
    }

    public d(a aVar) {
        this.f29878a = aVar.f29883a;
        this.f29879b = aVar.f29884b;
        this.f29880c = aVar.f29885c;
        this.f29881d = aVar.f29886d;
        this.f29882e = aVar.f29887e;
    }

    public String a() {
        return this.f29878a;
    }

    public int b() {
        return this.f29879b;
    }
}
