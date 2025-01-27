package com.opos.mobad.l;

import android.os.Handler;
import android.os.Looper;
import com.opos.mobad.ad.g;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public abstract class f<T> extends g.a implements com.opos.mobad.ad.b {

    /* renamed from: a */
    protected Handler f21182a;

    /* renamed from: b */
    private com.opos.mobad.ad.c.a<T> f21183b;

    /* renamed from: c */
    private o f21184c = l.a();

    /* renamed from: d */
    private p f21185d;

    /* renamed from: com.opos.mobad.l.f$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.h();
        }
    }

    /* renamed from: com.opos.mobad.l.f$2 */
    class AnonymousClass2 implements Callable<Boolean> {

        /* renamed from: a */
        final /* synthetic */ String f21187a;

        /* renamed from: b */
        final /* synthetic */ int f21188b;

        AnonymousClass2(String str, int i2) {
            str = str;
            i2 = i2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            return Boolean.valueOf(f.this.b(str, i2));
        }
    }

    /* renamed from: com.opos.mobad.l.f$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f21190a;

        /* renamed from: b */
        final /* synthetic */ String f21191b;

        AnonymousClass3(int i2, String str) {
            i2 = i2;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int a2 = f.this.f21184c.a(1, 0);
            com.opos.cmn.an.f.a.b("SyncStateController", "state=" + a2 + ",Ad = " + this);
            if (5 == a2 || f.this.f21183b == null) {
                return;
            }
            f.this.f21183b.a(i2, str);
        }
    }

    public f(com.opos.mobad.ad.c.a<T> aVar) {
        Handler handler = new Handler(Looper.getMainLooper());
        this.f21182a = handler;
        this.f21185d = new p(handler, new Runnable() { // from class: com.opos.mobad.l.f.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.h();
            }
        });
        this.f21183b = aVar;
    }

    private final void a(Callable<Boolean> callable) {
        int a2 = this.f21184c.a(1, callable);
        com.opos.cmn.an.f.a.b("", "loadAd state=" + a2 + ",Ad =" + this);
        if (1 == a2) {
            return;
        }
        if (5 == a2) {
            com.opos.mobad.ad.c.a<T> aVar = this.f21183b;
            if (aVar != null) {
                aVar.a(11001, "ad has destroyed.");
                return;
            }
            return;
        }
        com.opos.mobad.ad.c.a<T> aVar2 = this.f21183b;
        if (aVar2 != null) {
            aVar2.a(-1, "load with illegal state:" + a2);
        }
    }

    public void a() {
        a(m.a());
    }

    @Override // com.opos.mobad.ad.b
    public void a(int i2) {
        a(m.a(), i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i2, String str) {
        this.f21185d.a();
        this.f21182a.post(new Runnable() { // from class: com.opos.mobad.l.f.3

            /* renamed from: a */
            final /* synthetic */ int f21190a;

            /* renamed from: b */
            final /* synthetic */ String f21191b;

            AnonymousClass3(int i22, String str2) {
                i2 = i22;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                int a2 = f.this.f21184c.a(1, 0);
                com.opos.cmn.an.f.a.b("SyncStateController", "state=" + a2 + ",Ad = " + this);
                if (5 == a2 || f.this.f21183b == null) {
                    return;
                }
                f.this.f21183b.a(i2, str);
            }
        });
    }

    @Override // com.opos.mobad.ad.b
    public void a(String str) {
        com.opos.cmn.an.f.a.b("", "loadAd:" + str);
        a(str, 30000);
    }

    @Override // com.opos.mobad.ad.b
    public void a(String str, int i2) {
        com.opos.cmn.an.f.a.b("", "loadAd :" + str + ", " + i2);
        a(new Callable<Boolean>() { // from class: com.opos.mobad.l.f.2

            /* renamed from: a */
            final /* synthetic */ String f21187a;

            /* renamed from: b */
            final /* synthetic */ int f21188b;

            AnonymousClass2(String str2, int i22) {
                str = str2;
                i2 = i22;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(f.this.b(str, i2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(List<T> list) {
        com.opos.mobad.ad.c.a<T> aVar;
        this.f21185d.a();
        if (2 != this.f21184c.a(2) || (aVar = this.f21183b) == null) {
            return;
        }
        aVar.a(list);
    }

    public void b() {
        this.f21185d.b();
        this.f21184c.a(5);
    }

    protected abstract boolean b(String str);

    protected boolean b(String str, int i2) {
        if (i2 > 0) {
            this.f21185d.a(i2);
        } else {
            this.f21185d.a();
        }
        return b(str);
    }

    @Override // com.opos.mobad.ad.b
    public int d() {
        return this.f21184c.a();
    }

    public boolean e() {
        return false;
    }

    protected void h() {
        com.opos.mobad.ad.c.a<T> aVar;
        this.f21185d.a();
        int a2 = this.f21184c.a(6);
        com.opos.cmn.an.f.a.b("SyncStateController", "onTimeout state=" + a2 + ",Ad = " + this);
        if (6 != a2 || (aVar = this.f21183b) == null) {
            return;
        }
        aVar.a(-1, "load ad timeout");
    }
}
