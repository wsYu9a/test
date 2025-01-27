package com.opos.mobad.f.a.a;

import com.opos.mobad.ad.b;
import com.opos.mobad.f.a.a.t;
import com.opos.mobad.f.a.c.a;
import com.opos.mobad.f.a.m;
import com.opos.mobad.service.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class i<T extends com.opos.mobad.ad.b> extends com.opos.mobad.l.j implements n<T> {

    /* renamed from: a */
    private String f20607a;

    /* renamed from: b */
    protected Map<Integer, T> f20608b;

    /* renamed from: c */
    protected HashMap<Integer, e.a> f20609c;

    /* renamed from: d */
    private int f20610d;

    /* renamed from: g */
    private int f20611g;

    /* renamed from: h */
    private t<e.a> f20612h;

    /* renamed from: i */
    private u f20613i;

    /* renamed from: j */
    private j f20614j;
    private Map<Integer, e.a> k;
    private e.a l;
    private CountDownLatch m;
    private com.opos.mobad.f.a.c.a n;
    private v o;
    private Map<Integer, Integer> p;
    private com.opos.mobad.f.a.m<a.C0445a> q;
    private int r;
    private String s;
    private int t;

    /* renamed from: com.opos.mobad.f.a.a.i$1 */
    class AnonymousClass1 implements m.a<a.C0445a> {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.f.a.m.a
        public void a(a.C0445a c0445a) {
            if (c0445a == null) {
                return;
            }
            i.this.b(c0445a.f20680b, "" + c0445a.f20681c);
        }
    }

    /* renamed from: com.opos.mobad.f.a.a.i$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f20616a;

        /* renamed from: b */
        final /* synthetic */ int f20617b;

        /* renamed from: c */
        final /* synthetic */ String f20618c;

        AnonymousClass2(int i2, int i3, String str) {
            size = i2;
            i2 = i3;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.opos.cmn.an.f.a.a("SyncStateController", "countdown:" + size + "," + i2 + ",posid=" + i.this.f20607a);
            try {
                i.this.a(str, i.this.m.await(i2, TimeUnit.MILLISECONDS));
            } catch (InterruptedException e2) {
                com.opos.cmn.an.f.a.b("", "", e2);
                i.this.a(str, false);
            }
        }
    }

    /* renamed from: com.opos.mobad.f.a.a.i$3 */
    class AnonymousClass3 implements com.opos.cmn.i.e<e.a, Boolean> {
        AnonymousClass3() {
        }

        @Override // com.opos.cmn.i.e
        public Boolean a(e.a aVar) {
            return Boolean.valueOf(i.this.a(aVar));
        }
    }

    /* renamed from: com.opos.mobad.f.a.a.i$4 */
    class AnonymousClass4 implements Callable<Boolean> {

        /* renamed from: a */
        final /* synthetic */ String f20621a;

        /* renamed from: b */
        final /* synthetic */ int f20622b;

        AnonymousClass4(String str, int i2) {
            str = str;
            i2 = i2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            i.this.c(str, i2);
            return Boolean.TRUE;
        }
    }

    public i(String str, int i2, com.opos.mobad.f.a.c.a aVar, List<e.a> list, e.a aVar2, long j2, int i3, com.opos.mobad.f.a.b.a<T> aVar3, b.a aVar4) {
        super(aVar4);
        this.f20611g = -1;
        this.m = null;
        this.r = -1;
        this.s = "unknown error.";
        this.n = aVar;
        this.o = new v(str, i3, j2);
        this.p = new HashMap();
        this.f20607a = str;
        this.t = i3;
        this.f20610d = i2;
        this.f20608b = new ConcurrentHashMap(list.size());
        this.f20609c = new HashMap<>(list.size());
        this.k = new HashMap(list.size());
        a(list, aVar3);
        if (aVar2 != null) {
            a(aVar2, aVar3);
        }
        this.q = new com.opos.mobad.f.a.m<>(new m.a<a.C0445a>() { // from class: com.opos.mobad.f.a.a.i.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.f.a.m.a
            public void a(a.C0445a c0445a) {
                if (c0445a == null) {
                    return;
                }
                i.this.b(c0445a.f20680b, "" + c0445a.f20681c);
            }
        });
    }

    private void a(e.a aVar, com.opos.mobad.f.a.b.a<T> aVar2) {
        if (!this.f20608b.containsKey(Integer.valueOf(aVar.f23520a))) {
            T b2 = aVar2.b(aVar, this);
            if (b2 == null) {
                com.opos.cmn.an.f.a.d("delegator", "disable main");
                return;
            }
            a(aVar, (e.a) b2);
        }
        this.l = aVar;
    }

    public void a(String str, boolean z) {
        int i2;
        e.a p = this.t == 3 ? p() : null;
        if (p != null) {
            h();
        } else {
            p = q();
            if (p == null) {
                com.opos.cmn.an.f.a.a("delegator", "deal rank but fail,deal percent");
                e.a r = r();
                if (r != null) {
                    i2 = r.f23520a;
                    e(str, i2);
                }
                com.opos.cmn.an.f.a.a("delegator", "deal fail ,posid=" + this.f20607a);
                if (!z) {
                    l();
                    this.o.b(-2);
                    return;
                }
                int i3 = this.r;
                if (i3 == -1) {
                    b(-7, this.r + "," + this.s);
                } else {
                    b(i3, this.s);
                }
                this.o.b(-7);
                return;
            }
        }
        i2 = p.f23520a;
        e(str, i2);
    }

    private void a(List<e.a> list, com.opos.mobad.f.a.b.a<T> aVar) {
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        t.a aVar2 = new t.a();
        com.opos.cmn.an.f.a.b("delegator", "channel size:" + list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            e.a aVar3 = list.get(i2);
            this.k.put(Integer.valueOf(aVar3.f23520a), aVar3);
            T b2 = aVar.b(aVar3, this);
            if (b2 == null) {
                sb = new StringBuilder();
                sb.append("ad null with channel:");
                sb.append(aVar3);
            } else {
                a(aVar3, (e.a) b2);
                arrayList.add(aVar3);
                int i3 = aVar3.f23525f;
                if (i3 <= 0) {
                    sb = new StringBuilder();
                    sb.append("percent fail with channel:");
                    sb.append(aVar3.f23520a);
                } else {
                    aVar2.a(aVar3, i3);
                }
            }
            com.opos.cmn.an.f.a.b("delegator", sb.toString());
        }
        this.f20612h = aVar2.a();
        this.f20613i = new u(arrayList);
        this.f20614j = new j(arrayList);
    }

    public boolean a(e.a aVar) {
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("delegator", "check to select but entity is null");
            return false;
        }
        if (f(aVar.f23520a)) {
            return true;
        }
        Integer num = this.p.get(Integer.valueOf(aVar.f23520a));
        if (num == null) {
            num = -2;
        }
        this.o.a(aVar.f23520a, num.intValue());
        return false;
    }

    private void e(String str, int i2) {
        this.q.a();
        a.C0445a a2 = this.n.a(this.f20607a, i2);
        if (a2.f20679a) {
            c(new Callable<Boolean>() { // from class: com.opos.mobad.f.a.a.i.4

                /* renamed from: a */
                final /* synthetic */ String f20621a;

                /* renamed from: b */
                final /* synthetic */ int f20622b;

                AnonymousClass4(String str2, int i22) {
                    str = str2;
                    i2 = i22;
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() {
                    i.this.c(str, i2);
                    return Boolean.TRUE;
                }
            });
        } else {
            b(a2.f20680b, a2.f20681c);
            this.o.b(a2.f20680b);
        }
    }

    private void h() {
        Map<Integer, T> map = this.f20608b;
        if (map == null) {
            return;
        }
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (!f(intValue)) {
                Integer num = this.p.get(Integer.valueOf(intValue));
                if (num == null) {
                    num = -2;
                }
                this.o.a(intValue, num.intValue());
            }
        }
    }

    private e.a p() {
        this.o.c();
        return m();
    }

    private e.a q() {
        T t;
        e.a aVar = this.l;
        if (aVar != null && (t = this.f20608b.get(Integer.valueOf(aVar.f23520a))) != null) {
            int c2 = t.c();
            com.opos.cmn.an.f.a.b("delegator", "deal rank dispatchMode =" + c2);
            if (c2 > 0) {
                this.f20613i.a();
                this.o.b();
                e.a a2 = this.f20613i.a(c2, new com.opos.cmn.i.e<e.a, Boolean>() { // from class: com.opos.mobad.f.a.a.i.3
                    AnonymousClass3() {
                    }

                    @Override // com.opos.cmn.i.e
                    public Boolean a(e.a aVar2) {
                        return Boolean.valueOf(i.this.a(aVar2));
                    }
                });
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return null;
    }

    private e.a r() {
        this.o.a();
        this.f20612h.b();
        for (int i2 = 0; i2 < this.f20608b.size(); i2++) {
            e.a a2 = this.f20612h.a();
            if (a(a2)) {
                return a2;
            }
        }
        return null;
    }

    @Override // com.opos.mobad.f.a.a.n
    public final void a(int i2, int i3, String str) {
        com.opos.cmn.an.f.a.a("delegator", "onChannelRankFailed:" + i2 + ",code: " + i3 + ", msg:" + str);
        this.r = i3;
        this.s = str;
        this.p.put(Integer.valueOf(i2), Integer.valueOf(i3));
        CountDownLatch countDownLatch = this.m;
        if (countDownLatch != null) {
            try {
                countDownLatch.countDown();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("delegator", "fail:" + i2, e2);
            }
        }
    }

    protected void a(e.a aVar, T t) {
        this.f20608b.put(Integer.valueOf(aVar.f23520a), t);
    }

    protected void a(String str, List<Integer> list, int i2) {
        if (list == null || list.isEmpty()) {
            com.opos.cmn.an.f.a.a("SyncStateController", "error Map to load");
            return;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            T t = this.f20608b.get(Integer.valueOf(intValue));
            if (t != null) {
                if (intValue == 1) {
                    t.a(str, i2);
                } else {
                    t.a(str);
                }
            }
        }
    }

    protected boolean a(T t, int i2) {
        if (t == null) {
            return false;
        }
        return t.e();
    }

    protected boolean a(Map.Entry<Integer, T> entry, T t) {
        a.C0445a a2;
        return (entry.getKey().intValue() == 1 || this.f20611g == entry.getKey().intValue() || t.d() != 2 || !t.e()) && (a2 = this.n.a(entry.getKey().intValue())) != null && a2.f20679a;
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        if (this.o != null && d() == 1) {
            this.o.b(-6);
        }
        this.f20612h.b();
        this.f20613i.a();
        super.b();
        Iterator<T> it = this.f20608b.values().iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    @Override // com.opos.mobad.l.j
    protected boolean b(String str) {
        return true;
    }

    @Override // com.opos.mobad.l.j
    protected boolean b(String str, int i2) {
        com.opos.cmn.an.f.a.b("delegator", "doload:" + str);
        this.o.a(str);
        a.C0445a a2 = this.n.a(this.f20607a);
        if (a2.f20679a) {
            this.q.a();
            this.f20612h.b();
            this.f20613i.a();
            this.p.clear();
            d(str, Math.min(i2, this.f20610d));
            return true;
        }
        com.opos.cmn.an.f.a.b("delegator", "intercept " + a2.f20681c);
        this.q.a(500L, a2);
        this.o.c(a2.f20680b);
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return 0;
    }

    protected void c(String str, int i2) {
        com.opos.cmn.an.f.a.b("delegator", "select:" + i2);
        this.f20611g = i2;
        this.o.a(i2);
    }

    @Override // com.opos.mobad.f.a.a.n
    public final void d(int i2) {
        com.opos.cmn.an.f.a.b("delegator", "onChannelRankSucc channel:" + i2);
        CountDownLatch countDownLatch = this.m;
        if (countDownLatch != null) {
            try {
                countDownLatch.countDown();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("delegator", "succ:" + i2, e2);
            }
        }
    }

    protected void d(String str, int i2) {
        List<Integer> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, T> entry : this.f20608b.entrySet()) {
            T value = entry.getValue();
            if (value == null) {
                com.opos.cmn.an.f.a.b("delegator", "error disable ad");
            } else if (a((Map.Entry<Integer, Map.Entry<Integer, T>>) entry, (Map.Entry<Integer, T>) value)) {
                com.opos.cmn.an.f.a.a("SyncStateController", "add load ad channel:" + entry.getKey());
                arrayList.add(entry.getKey());
            }
        }
        this.f20611g = -1;
        int size = arrayList.size();
        if (size <= 0) {
            com.opos.cmn.an.f.a.a("SyncStateController", "not need to load");
            a(str, true);
        } else {
            this.m = new CountDownLatch(size);
            a(str, arrayList, i2);
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.f.a.a.i.2

                /* renamed from: a */
                final /* synthetic */ int f20616a;

                /* renamed from: b */
                final /* synthetic */ int f20617b;

                /* renamed from: c */
                final /* synthetic */ String f20618c;

                AnonymousClass2(int size2, int i22, String str2) {
                    size = size2;
                    i2 = i22;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.opos.cmn.an.f.a.a("SyncStateController", "countdown:" + size + "," + i2 + ",posid=" + i.this.f20607a);
                    try {
                        i.this.a(str, i.this.m.await(i2, TimeUnit.MILLISECONDS));
                    } catch (InterruptedException e2) {
                        com.opos.cmn.an.f.a.b("", "", e2);
                        i.this.a(str, false);
                    }
                }
            });
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
        if (2 != d()) {
            return false;
        }
        return a((i<T>) this.f20608b.get(Integer.valueOf(this.f20611g)), this.f20611g);
    }

    protected boolean f(int i2) {
        return a((i<T>) this.f20608b.get(Integer.valueOf(i2)), i2);
    }

    @Override // com.opos.mobad.f.a.a.n
    public T i() {
        return this.f20608b.get(Integer.valueOf(this.f20611g));
    }

    @Override // com.opos.mobad.f.a.a.n
    public int j() {
        int i2;
        if (2 != d() || (i2 = this.f20611g) == -1) {
            return -1;
        }
        return i2;
    }

    @Override // com.opos.mobad.f.a.a.n
    public e.a k() {
        return this.k.get(Integer.valueOf(j()));
    }

    protected e.a m() {
        return this.f20614j.a(this.f20608b);
    }
}
