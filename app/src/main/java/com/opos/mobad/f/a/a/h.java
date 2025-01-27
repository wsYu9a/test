package com.opos.mobad.f.a.a;

import com.opos.mobad.ad.b;
import com.opos.mobad.f.a.a.t;
import com.opos.mobad.f.a.c.a;
import com.opos.mobad.f.a.m;
import com.opos.mobad.service.a.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public abstract class h<T extends com.opos.mobad.ad.b> extends com.opos.mobad.l.j implements n<T> {

    /* renamed from: a */
    private String f20591a;

    /* renamed from: b */
    protected Map<Integer, T> f20592b;

    /* renamed from: c */
    private String f20593c;

    /* renamed from: d */
    private int f20594d;

    /* renamed from: g */
    private int f20595g;

    /* renamed from: h */
    private int f20596h;

    /* renamed from: i */
    private com.opos.mobad.f.a.m<a.C0445a> f20597i;

    /* renamed from: j */
    private com.opos.mobad.f.a.n f20598j;
    private t<e.a> k;
    private Map<Integer, Boolean> l;
    private Map<Integer, e.a> m;
    private e.a n;
    private com.opos.mobad.f.a.c.a o;
    private w p;
    private int q;
    private String r;

    /* renamed from: com.opos.mobad.f.a.a.h$1 */
    class AnonymousClass1 implements m.a<a.C0445a> {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.f.a.m.a
        public void a(a.C0445a c0445a) {
            if (c0445a == null) {
                return;
            }
            h.this.b(c0445a.f20680b, "" + c0445a.f20681c);
        }
    }

    /* renamed from: com.opos.mobad.f.a.a.h$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f20600a;

        AnonymousClass2(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.opos.cmn.an.f.a.a("delegator", "timeout for next =" + str);
            if (1 != h.this.d()) {
                com.opos.cmn.an.f.a.b("delegator", "start with error state");
            } else {
                h.this.p.a(h.this.f20596h, -2);
                h.this.a(-1, com.opos.mobad.ad.a.a(-1));
            }
        }
    }

    /* renamed from: com.opos.mobad.f.a.a.h$3 */
    class AnonymousClass3 implements Callable<Boolean> {
        AnonymousClass3() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            h.this.f20597i.a();
            h.this.f20598j.a();
            if (h.this.f20596h != -1) {
                h.this.p.a(h.this.f20596h, -2);
            }
            h.this.p.b(-2);
            return Boolean.TRUE;
        }
    }

    /* renamed from: com.opos.mobad.f.a.a.h$4 */
    class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f20603a;

        AnonymousClass4(int i2) {
            i5 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.i(i5);
        }
    }

    /* renamed from: com.opos.mobad.f.a.a.h$5 */
    class AnonymousClass5 implements Callable<Boolean> {

        /* renamed from: a */
        final /* synthetic */ int f20605a;

        AnonymousClass5(int i2) {
            i2 = i2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            h.this.f(i2);
            return Boolean.TRUE;
        }
    }

    public h(String str, int i2, com.opos.mobad.f.a.c.a aVar, List<e.a> list, e.a aVar2, long j2, com.opos.mobad.f.a.b.a<T> aVar3, b.a aVar4) {
        super(aVar4);
        this.f20595g = -1;
        this.f20596h = -1;
        this.f20593c = str;
        this.f20594d = i2;
        this.o = aVar;
        this.p = new w(str, j2);
        this.f20597i = new com.opos.mobad.f.a.m<>(new m.a<a.C0445a>() { // from class: com.opos.mobad.f.a.a.h.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.f.a.m.a
            public void a(a.C0445a c0445a) {
                if (c0445a == null) {
                    return;
                }
                h.this.b(c0445a.f20680b, "" + c0445a.f20681c);
            }
        });
        this.f20598j = new com.opos.mobad.f.a.n(new Runnable() { // from class: com.opos.mobad.f.a.a.h.2

            /* renamed from: a */
            final /* synthetic */ String f20600a;

            AnonymousClass2(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.a("delegator", "timeout for next =" + str);
                if (1 != h.this.d()) {
                    com.opos.cmn.an.f.a.b("delegator", "start with error state");
                } else {
                    h.this.p.a(h.this.f20596h, -2);
                    h.this.a(-1, com.opos.mobad.ad.a.a(-1));
                }
            }
        });
        this.f20592b = new ConcurrentHashMap(list.size());
        this.l = new ConcurrentHashMap(list.size());
        this.m = new HashMap(list.size());
        a(list, aVar3);
        if (aVar2 != null) {
            a(aVar2, aVar3);
        }
    }

    private void a(e.a aVar, com.opos.mobad.f.a.b.a<T> aVar2) {
        if (!this.f20592b.containsKey(Integer.valueOf(aVar.f23520a))) {
            T b2 = aVar2.b(aVar, this);
            if (b2 == null) {
                com.opos.cmn.an.f.a.d("delegator", "disable reserve");
                return;
            }
            this.f20592b.put(Integer.valueOf(aVar.f23520a), b2);
        }
        this.n = aVar;
    }

    private void a(List<e.a> list, com.opos.mobad.f.a.b.a<T> aVar) {
        StringBuilder sb;
        t.a aVar2 = new t.a();
        com.opos.cmn.an.f.a.b("delegator", "channel size:" + list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            e.a aVar3 = list.get(i2);
            this.m.put(Integer.valueOf(aVar3.f23520a), aVar3);
            if (aVar3.f23525f <= 0) {
                sb = new StringBuilder();
                sb.append("percent fail with channel:");
                sb.append(aVar3.f23520a);
            } else {
                T b2 = aVar.b(aVar3, this);
                if (b2 == null) {
                    sb = new StringBuilder();
                    sb.append("ad null with channel:");
                    sb.append(aVar3);
                } else {
                    this.f20592b.put(Integer.valueOf(aVar3.f23520a), b2);
                    aVar2.a(aVar3, aVar3.f23525f);
                }
            }
            com.opos.cmn.an.f.a.a("delegator", sb.toString());
        }
        this.k = aVar2.a();
    }

    private void d(int i2, String str) {
        this.q = i2;
        this.r = str;
        e.a a2 = this.k.a();
        if (a2 == null) {
            com.opos.cmn.an.f.a.b("delegator", "reserve:" + this.n + ",current:" + this.f20596h);
            a2 = this.n;
            if (a2 == null || this.f20596h == a2.f23520a) {
                b(i2, str);
                this.p.b(-7);
                return;
            }
        }
        int i3 = a2.f23520a;
        this.f20596h = i3;
        a.C0445a a3 = this.o.a(i3);
        if (a3 != null && !a3.f20679a) {
            this.p.a(a2.f23520a, a3.f20680b);
            d(i2, str);
            return;
        }
        com.opos.cmn.an.f.a.b("delegator", "start:" + a2.f23520a);
        int i4 = a2.f23520a;
        if (i4 != 1 && this.l.containsKey(Integer.valueOf(i4)) && this.l.get(Integer.valueOf(a2.f23520a)).booleanValue() && g(a2.f23520a)) {
            int i5 = a2.f23520a;
            com.opos.cmn.an.f.a.b("delegator", "cache");
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.f.a.a.h.4

                /* renamed from: a */
                final /* synthetic */ int f20603a;

                AnonymousClass4(int i52) {
                    i5 = i52;
                }

                @Override // java.lang.Runnable
                public void run() {
                    h.this.i(i5);
                }
            });
        } else {
            a(this.f20591a, a2);
            com.opos.cmn.an.f.a.b("delegator", "timeout:" + a2.f23522c);
            this.f20598j.a(a2.f23522c);
        }
    }

    public void i(int i2) {
        this.f20597i.a();
        this.f20598j.a();
        a.C0445a a2 = this.o.a(this.f20593c, i2);
        if (a2.f20679a) {
            c(new Callable<Boolean>() { // from class: com.opos.mobad.f.a.a.h.5

                /* renamed from: a */
                final /* synthetic */ int f20605a;

                AnonymousClass5(int i22) {
                    i2 = i22;
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() {
                    h.this.f(i2);
                    return Boolean.TRUE;
                }
            });
        } else {
            b(a2.f20680b, a2.f20681c);
            this.p.b(a2.f20680b);
        }
    }

    @Override // com.opos.mobad.f.a.a.n
    public final void a(int i2, int i3, String str) {
        com.opos.cmn.an.f.a.a("delegator", "onChannelPercentFailed :" + i2 + ",code: " + i3 + ", msg:" + str);
        if (i2 != this.f20596h) {
            return;
        }
        if (1 != d()) {
            com.opos.cmn.an.f.a.b("delegator", "start with error state");
        } else {
            this.p.a(i2, i3);
            a(i3, str);
        }
    }

    protected final void a(int i2, String str) {
        if (1 != d()) {
            com.opos.cmn.an.f.a.b("delegator", "start with error state");
        } else {
            d(i2, str);
        }
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void a(String str) {
        a(str, this.f20594d);
    }

    protected void a(String str, e.a aVar) {
        T t = this.f20592b.get(Integer.valueOf(aVar.f23520a));
        if (aVar.f23520a == 1) {
            t.a(str, (int) aVar.f23522c);
        } else {
            t.a(str);
        }
    }

    protected boolean a(T t, int i2) {
        if (t == null) {
            return false;
        }
        return t.e();
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        this.f20597i.b();
        this.f20598j.b();
        if (this.p != null && d() == 1) {
            this.p.b(-6);
        }
        this.k.b();
        super.b();
        Iterator<Integer> it = this.f20592b.keySet().iterator();
        while (it.hasNext()) {
            this.f20592b.get(it.next()).b();
        }
    }

    protected boolean b(int i2, int i3, String str) {
        return false;
    }

    @Override // com.opos.mobad.l.j
    protected boolean b(String str) {
        com.opos.cmn.an.f.a.b("delegator", "doload:" + str);
        a.C0445a a2 = this.o.a(this.f20593c);
        this.p.a(str);
        this.p.a();
        if (!a2.f20679a) {
            com.opos.cmn.an.f.a.b("delegator", "intercept " + a2.f20681c);
            this.f20597i.a(500L, a2);
            this.p.c(a2.f20680b);
            return true;
        }
        this.f20595g = -1;
        this.f20596h = -1;
        this.f20591a = str;
        this.f20597i.a();
        this.f20598j.a();
        this.k.b();
        d(-1, com.opos.mobad.ad.a.a(-1));
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return 0;
    }

    @Override // com.opos.mobad.f.a.a.n
    public final void d(int i2) {
        com.opos.cmn.an.f.a.a("delegator", "onChannelPercentSucc :" + i2);
        this.l.put(Integer.valueOf(i2), Boolean.TRUE);
        if (d() == 1 && i2 == this.f20596h && !b(i2, this.q, this.r)) {
            i(i2);
        }
    }

    @Override // com.opos.mobad.f.a.a.n
    public void e(int i2) {
        if (i2 == j()) {
            i_();
        }
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public boolean e() {
        return a((h<T>) this.f20592b.get(Integer.valueOf(this.f20595g)), this.f20595g);
    }

    protected void f(int i2) {
        com.opos.cmn.an.f.a.a("delegator", "percent select:" + i2);
        this.p.a(i2);
        this.l.put(Integer.valueOf(i2), Boolean.FALSE);
        this.f20595g = i2;
    }

    protected boolean g(int i2) {
        return a((h<T>) this.f20592b.get(Integer.valueOf(i2)), i2);
    }

    protected void h(int i2) {
        this.l.put(Integer.valueOf(i2), Boolean.FALSE);
    }

    @Override // com.opos.mobad.f.a.a.n
    public T i() {
        return this.f20592b.get(Integer.valueOf(this.f20595g));
    }

    @Override // com.opos.mobad.f.a.a.n
    public int j() {
        int i2;
        if (2 != d() || (i2 = this.f20595g) == -1) {
            return -1;
        }
        return i2;
    }

    @Override // com.opos.mobad.f.a.a.n
    public e.a k() {
        return this.m.get(Integer.valueOf(j()));
    }

    @Override // com.opos.mobad.l.j
    protected void l() {
        a(new Callable<Boolean>() { // from class: com.opos.mobad.f.a.a.h.3
            AnonymousClass3() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                h.this.f20597i.a();
                h.this.f20598j.a();
                if (h.this.f20596h != -1) {
                    h.this.p.a(h.this.f20596h, -2);
                }
                h.this.p.b(-2);
                return Boolean.TRUE;
            }
        });
    }
}
