package com.opos.mobad.l;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.opos.mobad.ad.b;
import com.opos.mobad.ad.g;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public abstract class j extends g.a implements com.opos.mobad.ad.b {

    /* renamed from: a */
    private b.a f21198a;

    /* renamed from: b */
    private int f21199b;

    /* renamed from: c */
    private long f21200c;

    /* renamed from: d */
    private p f21201d;

    /* renamed from: e */
    protected Handler f21202e;

    /* renamed from: f */
    o f21203f;

    /* renamed from: com.opos.mobad.l.j$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.l();
        }
    }

    /* renamed from: com.opos.mobad.l.j$2 */
    class AnonymousClass2 implements Callable<Boolean> {

        /* renamed from: a */
        final /* synthetic */ String f21205a;

        /* renamed from: b */
        final /* synthetic */ int f21206b;

        AnonymousClass2(String str, int i2) {
            str = str;
            i2 = i2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            return Boolean.valueOf(j.this.b(str, i2));
        }
    }

    /* renamed from: com.opos.mobad.l.j$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f21208a;

        /* renamed from: b */
        final /* synthetic */ String f21209b;

        AnonymousClass3(int i2, String str) {
            i2 = i2;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (6 == j.this.f21203f.a()) {
                com.opos.cmn.an.f.a.b("SyncStateController", "onAdFailed but timeout");
                return;
            }
            int a2 = j.this.f21203f.a(1, 0);
            com.opos.cmn.an.f.a.b("SyncStateController", "onLoadFailed state=" + a2 + ",Ad = " + this);
            if (5 == a2 || j.this.f21198a == null) {
                return;
            }
            j.this.f21198a.a(i2, str);
        }
    }

    /* renamed from: com.opos.mobad.l.j$4 */
    class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f21211a;

        /* renamed from: b */
        final /* synthetic */ String f21212b;

        AnonymousClass4(int i2, String str) {
            i2 = i2;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int a2 = j.this.f21203f.a(0);
            com.opos.cmn.an.f.a.b("SyncStateController", "onAdFailed state=" + a2 + ",Ad = " + this);
            if (5 == a2 || j.this.f21198a == null) {
                return;
            }
            j.this.f21198a.a(i2, str);
        }
    }

    /* renamed from: com.opos.mobad.l.j$5 */
    class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.f21198a != null) {
                j.this.f21198a.a();
            }
        }
    }

    /* renamed from: com.opos.mobad.l.j$6 */
    class AnonymousClass6 implements Runnable {
        AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.f21198a != null) {
                j.this.f21198a.a();
            }
        }
    }

    public j(int i2, b.a aVar) {
        n();
        Handler handler = new Handler(Looper.getMainLooper());
        this.f21202e = handler;
        this.f21201d = new p(handler, new Runnable() { // from class: com.opos.mobad.l.j.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                j.this.l();
            }
        });
        this.f21198a = aVar;
        this.f21199b = i2;
    }

    public j(b.a aVar) {
        this(-1, aVar);
    }

    public void a() {
        a(m.a());
    }

    @Override // com.opos.mobad.ad.b
    public void a(int i2) {
        a(m.a(), i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.f21202e.post(runnable);
        }
    }

    public void a(String str) {
        com.opos.cmn.an.f.a.b("", "loadAd:" + str);
        a(str, 30000);
    }

    public void a(String str, int i2) {
        com.opos.cmn.an.f.a.b("", "loadAd :" + str + ", " + i2);
        b(new Callable<Boolean>() { // from class: com.opos.mobad.l.j.2

            /* renamed from: a */
            final /* synthetic */ String f21205a;

            /* renamed from: b */
            final /* synthetic */ int f21206b;

            AnonymousClass2(String str2, int i22) {
                str = str2;
                i2 = i22;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(j.this.b(str, i2));
            }
        });
    }

    protected void a(Callable<Boolean> callable) {
        b.a aVar;
        this.f21201d.a();
        int a2 = this.f21203f.a(6, callable);
        com.opos.cmn.an.f.a.b("SyncStateController", "onTimeout state=" + a2 + ",Ad = " + this);
        if (6 != a2 || (aVar = this.f21198a) == null) {
            return;
        }
        aVar.a(-1, "load ad timeout");
    }

    public void b() {
        this.f21201d.b();
        this.f21203f.a(5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(int i2, String str) {
        this.f21201d.a();
        this.f21202e.post(new Runnable() { // from class: com.opos.mobad.l.j.3

            /* renamed from: a */
            final /* synthetic */ int f21208a;

            /* renamed from: b */
            final /* synthetic */ String f21209b;

            AnonymousClass3(int i22, String str2) {
                i2 = i22;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (6 == j.this.f21203f.a()) {
                    com.opos.cmn.an.f.a.b("SyncStateController", "onAdFailed but timeout");
                    return;
                }
                int a2 = j.this.f21203f.a(1, 0);
                com.opos.cmn.an.f.a.b("SyncStateController", "onLoadFailed state=" + a2 + ",Ad = " + this);
                if (5 == a2 || j.this.f21198a == null) {
                    return;
                }
                j.this.f21198a.a(i2, str);
            }
        });
    }

    final void b(Callable<Boolean> callable) {
        int a2 = this.f21203f.a(1, callable);
        com.opos.cmn.an.f.a.b("SyncStateController", "loadAd state=" + a2 + ",Ad =" + this);
        if (1 == a2) {
            return;
        }
        if (5 == a2) {
            b.a aVar = this.f21198a;
            if (aVar != null) {
                aVar.a(11001, "ad has destroyed.");
                return;
            }
            return;
        }
        b.a aVar2 = this.f21198a;
        if (aVar2 != null) {
            aVar2.a(-1, "load with illegal state:" + a2);
        }
    }

    protected abstract boolean b(String str);

    protected boolean b(String str, int i2) {
        if (i2 > 0) {
            this.f21201d.a(i2);
        } else {
            this.f21201d.a();
        }
        return b(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(int i2, String str) {
        this.f21201d.a();
        this.f21202e.post(new Runnable() { // from class: com.opos.mobad.l.j.4

            /* renamed from: a */
            final /* synthetic */ int f21211a;

            /* renamed from: b */
            final /* synthetic */ String f21212b;

            AnonymousClass4(int i22, String str2) {
                i2 = i22;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                int a2 = j.this.f21203f.a(0);
                com.opos.cmn.an.f.a.b("SyncStateController", "onAdFailed state=" + a2 + ",Ad = " + this);
                if (5 == a2 || j.this.f21198a == null) {
                    return;
                }
                j.this.f21198a.a(i2, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(Callable<Boolean> callable) {
        this.f21201d.a();
        if (2 == this.f21203f.a(2, callable)) {
            this.f21200c = SystemClock.elapsedRealtime();
            a(new Runnable() { // from class: com.opos.mobad.l.j.6
                AnonymousClass6() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f21198a != null) {
                        j.this.f21198a.a();
                    }
                }
            });
        }
    }

    @Override // com.opos.mobad.ad.b
    public int d() {
        return this.f21203f.a();
    }

    public boolean e() {
        int i2;
        return 2 == d() && ((i2 = this.f21199b) <= 0 || this.f21200c + ((long) i2) >= SystemClock.elapsedRealtime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i_() {
        b.a aVar = this.f21198a;
        if (aVar != null) {
            aVar.b();
        }
    }

    protected void l() {
        b.a aVar;
        this.f21201d.a();
        int a2 = this.f21203f.a(6);
        com.opos.cmn.an.f.a.b("SyncStateController", "onTimeout state=" + a2 + ",Ad = " + this);
        if (6 != a2 || (aVar = this.f21198a) == null) {
            return;
        }
        aVar.a(-1, "load ad timeout");
    }

    void n() {
        this.f21203f = l.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o() {
        this.f21201d.a();
        if (2 == this.f21203f.a(2)) {
            this.f21200c = SystemClock.elapsedRealtime();
            a(new Runnable() { // from class: com.opos.mobad.l.j.5
                AnonymousClass5() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f21198a != null) {
                        j.this.f21198a.a();
                    }
                }
            });
        }
    }
}
