package com.opos.mobad.o.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/* loaded from: classes4.dex */
public class k {

    /* renamed from: a */
    private static volatile k f23059a;

    /* renamed from: b */
    private RelativeLayout.LayoutParams f23060b;

    /* renamed from: c */
    private boolean f23061c = false;

    /* renamed from: d */
    private Handler f23062d = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    private Runnable f23063e = new Runnable() { // from class: com.opos.mobad.o.b.k.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.this.f23066h != null && k.this.f23066h.i() == 2 && k.this.f23067i != null) {
                k.this.f23067i.a(k.this.f23065g, k.this.f23066h.d());
            }
            k.this.f23062d.postDelayed(k.this.f23063e, 1000L);
        }
    };

    /* renamed from: f */
    private boolean f23064f;

    /* renamed from: g */
    private String f23065g;

    /* renamed from: h */
    private com.opos.mobad.c.c.a f23066h;

    /* renamed from: i */
    private a f23067i;

    /* renamed from: com.opos.mobad.o.b.k$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.this.f23066h != null && k.this.f23066h.i() == 2 && k.this.f23067i != null) {
                k.this.f23067i.a(k.this.f23065g, k.this.f23066h.d());
            }
            k.this.f23062d.postDelayed(k.this.f23063e, 1000L);
        }
    }

    /* renamed from: com.opos.mobad.o.b.k$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.c.c.a f23069a;

        AnonymousClass2(com.opos.mobad.c.c.a aVar) {
            aVar2 = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.opos.mobad.c.c.a aVar = aVar2;
            if (aVar != null) {
                aVar.h();
            }
        }
    }

    private class a implements f {

        /* renamed from: b */
        private boolean f23072b = true;

        /* renamed from: c */
        private f f23073c;

        /* renamed from: com.opos.mobad.o.b.k$a$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (k.this.f23066h != null && k.this.f23061c) {
                    com.opos.cmn.an.f.a.b("VideoPlayer", "onStart but pauseVideo");
                    k.this.f23066h.f();
                }
                k.this.f23061c = false;
            }
        }

        public a(f fVar) {
            this.f23073c = fVar;
        }

        public void a() {
            this.f23072b = false;
        }

        @Override // com.opos.mobad.c.c.b
        public void a(int i2, String str) {
            if (this.f23072b) {
                k.this.f23064f = false;
            }
            f fVar = this.f23073c;
            if (fVar != null) {
                fVar.a(i2, str);
            }
        }

        public void a(f fVar) {
            this.f23073c = fVar;
        }

        @Override // com.opos.mobad.o.b.f
        public void a(String str, long j2) {
            f fVar = this.f23073c;
            if (fVar != null) {
                fVar.a(str, j2);
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void c() {
            if (this.f23072b) {
                k.this.f23064f = true;
            }
            k.this.f23062d.post(k.this.f23063e);
            f fVar = this.f23073c;
            if (fVar != null) {
                fVar.c();
            }
            k.this.f23061c = false;
            com.opos.cmn.an.f.a.b("VideoPlayer", "onPrepare url:" + k.this.f23065g);
        }

        @Override // com.opos.mobad.c.c.b
        public void d() {
            if (this.f23072b) {
                k.this.f23064f = true;
            }
            f fVar = this.f23073c;
            if (fVar != null) {
                fVar.d();
            }
            if (k.this.f23061c) {
                k.this.f23062d.post(new Runnable() { // from class: com.opos.mobad.o.b.k.a.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (k.this.f23066h != null && k.this.f23061c) {
                            com.opos.cmn.an.f.a.b("VideoPlayer", "onStart but pauseVideo");
                            k.this.f23066h.f();
                        }
                        k.this.f23061c = false;
                    }
                });
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void e() {
            if (this.f23072b) {
                k.this.f23064f = false;
                k.this.c();
            }
            k.this.f23062d.removeCallbacks(k.this.f23063e);
            f fVar = this.f23073c;
            if (fVar != null) {
                fVar.e();
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void f() {
            if (this.f23072b) {
                k.this.f23064f = true;
            }
            k.this.f23062d.post(k.this.f23063e);
            f fVar = this.f23073c;
            if (fVar != null) {
                fVar.f();
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void g() {
            if (this.f23072b) {
                k.this.f23064f = false;
            }
            k.this.f23062d.removeCallbacks(k.this.f23063e);
            f fVar = this.f23073c;
            if (fVar != null) {
                fVar.g();
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void h() {
            f fVar = this.f23073c;
            if (fVar != null) {
                fVar.h();
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void i() {
            f fVar = this.f23073c;
            if (fVar != null) {
                fVar.i();
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void j() {
        }
    }

    private k() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.f23060b = layoutParams;
        layoutParams.addRule(13);
    }

    public static k a() {
        k kVar = f23059a;
        if (kVar == null) {
            synchronized (k.class) {
                kVar = f23059a;
                if (kVar == null) {
                    kVar = new k();
                    f23059a = kVar;
                }
            }
        }
        return kVar;
    }

    public void a(Context context, String str, int i2, RelativeLayout relativeLayout, f fVar, boolean z) {
        if (context == null || TextUtils.isEmpty(str) || b()) {
            com.opos.cmn.an.f.a.a("VideoPlayer", "play with params null context=" + context + ",isplay:" + b() + ",url=" + str);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (this.f23066h != null) {
            if (!TextUtils.isEmpty(this.f23065g) && this.f23065g.equals(str)) {
                this.f23066h.f();
                View b2 = this.f23066h.b();
                ViewGroup viewGroup = (ViewGroup) b2.getParent();
                if (viewGroup == null || relativeLayout != viewGroup) {
                    com.opos.cmn.an.f.a.b("VideoPlayer", "play to other media view");
                    if (viewGroup != null) {
                        viewGroup.removeView(b2);
                    }
                    relativeLayout.removeAllViews();
                    b2.setLayoutParams(this.f23060b);
                    relativeLayout.addView(b2);
                    relativeLayout.bringToFront();
                }
                this.f23067i.a(fVar);
                com.opos.mobad.c.c.a aVar = this.f23066h;
                if (z) {
                    aVar.a(1.0f);
                } else {
                    aVar.a(0.0f);
                }
                this.f23066h.g();
                return;
            }
            c();
        }
        a aVar2 = new a(fVar);
        this.f23067i = aVar2;
        com.opos.mobad.c.c.a a2 = com.opos.mobad.r.a.d.a(applicationContext, i2, aVar2);
        this.f23066h = a2;
        this.f23065g = str;
        this.f23064f = true;
        a2.a(str);
        com.opos.mobad.c.c.a aVar3 = this.f23066h;
        if (z) {
            aVar3.a(1.0f);
        } else {
            aVar3.a(0.0f);
        }
        this.f23066h.b().setLayoutParams(this.f23060b);
        relativeLayout.addView(this.f23066h.b());
    }

    public void a(String str, ViewGroup viewGroup) {
        com.opos.mobad.c.c.a aVar;
        if (TextUtils.isEmpty(this.f23065g) || !this.f23065g.equals(str) || (aVar = this.f23066h) == null) {
            return;
        }
        View b2 = aVar.b();
        ViewGroup viewGroup2 = (ViewGroup) b2.getParent();
        if (viewGroup2 != null && viewGroup != viewGroup2) {
            com.opos.cmn.an.f.a.b("VideoPlayer", "play to other media view");
            viewGroup2.removeView(b2);
            viewGroup.removeAllViews();
            viewGroup.addView(b2);
            viewGroup.bringToFront();
        }
        this.f23066h.g();
    }

    public void a(String str, boolean z) {
        com.opos.mobad.c.c.a aVar;
        if (TextUtils.isEmpty(this.f23065g) || !this.f23065g.equals(str) || (aVar = this.f23066h) == null) {
            return;
        }
        aVar.a(z ? 1.0f : 0.0f);
    }

    public boolean a(String str) {
        return !TextUtils.isEmpty(this.f23065g) && this.f23065g.equals(str);
    }

    public void b(Context context, String str, int i2, RelativeLayout relativeLayout, f fVar, boolean z) {
        if (context == null || TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.a("VideoPlayer", "play with params null context=" + context + ",url=" + str);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (this.f23066h != null) {
            if (!TextUtils.isEmpty(this.f23065g) && this.f23065g.equals(str)) {
                this.f23066h.f();
                View b2 = this.f23066h.b();
                ViewGroup viewGroup = (ViewGroup) b2.getParent();
                if (viewGroup == null || relativeLayout != viewGroup) {
                    com.opos.cmn.an.f.a.b("", "play to other media view");
                    if (viewGroup != null) {
                        viewGroup.removeView(b2);
                    }
                    relativeLayout.removeAllViews();
                    b2.setLayoutParams(this.f23060b);
                    relativeLayout.addView(b2);
                    relativeLayout.bringToFront();
                }
                this.f23067i.a(fVar);
                com.opos.mobad.c.c.a aVar = this.f23066h;
                if (z) {
                    aVar.a(1.0f);
                } else {
                    aVar.a(0.0f);
                }
                this.f23066h.g();
                return;
            }
            c();
        }
        a aVar2 = new a(fVar);
        this.f23067i = aVar2;
        com.opos.mobad.c.c.a a2 = com.opos.mobad.r.a.d.a(applicationContext, i2, aVar2);
        this.f23066h = a2;
        this.f23065g = str;
        this.f23064f = true;
        a2.a(str);
        com.opos.mobad.c.c.a aVar3 = this.f23066h;
        if (z) {
            aVar3.a(1.0f);
        } else {
            aVar3.a(0.0f);
        }
        this.f23066h.b().setLayoutParams(this.f23060b);
        relativeLayout.addView(this.f23066h.b());
    }

    public void b(String str) {
        if (TextUtils.isEmpty(this.f23065g) || !this.f23065g.equals(str) || this.f23066h == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("VideoPlayer", "mExoVideoPlayer.getState()=" + this.f23066h.i());
        if (this.f23066h.i() == 1) {
            this.f23061c = true;
        } else {
            this.f23066h.f();
        }
    }

    public boolean b() {
        return this.f23064f;
    }

    public int c(String str) {
        com.opos.mobad.c.c.a aVar;
        if (TextUtils.isEmpty(this.f23065g) || !this.f23065g.equals(str) || (aVar = this.f23066h) == null) {
            return 0;
        }
        return aVar.i();
    }

    public void c() {
        com.opos.cmn.an.f.a.b("VideoPlayer", "video player release");
        if (this.f23066h != null) {
            a aVar = this.f23067i;
            if (aVar != null) {
                aVar.a();
                this.f23067i = null;
            }
            this.f23062d.removeCallbacks(this.f23063e);
            this.f23066h.f();
            com.opos.cmn.an.j.b.d(new Runnable() { // from class: com.opos.mobad.o.b.k.2

                /* renamed from: a */
                final /* synthetic */ com.opos.mobad.c.c.a f23069a;

                AnonymousClass2(com.opos.mobad.c.c.a aVar2) {
                    aVar2 = aVar2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.opos.mobad.c.c.a aVar2 = aVar2;
                    if (aVar2 != null) {
                        aVar2.h();
                    }
                }
            });
            this.f23066h = null;
            this.f23065g = null;
            this.f23064f = false;
        }
    }

    public void c(Context context, String str, int i2, RelativeLayout relativeLayout, f fVar, boolean z) {
        if (context == null || TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.a("VideoPlayer", "play with params null");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        com.opos.mobad.c.c.a aVar = this.f23066h;
        if (aVar != null) {
            aVar.h();
        }
        a aVar2 = new a(fVar);
        this.f23067i = aVar2;
        com.opos.mobad.c.c.a a2 = com.opos.mobad.r.a.d.a(applicationContext, i2, aVar2);
        this.f23066h = a2;
        a2.b().setLayoutParams(this.f23060b);
        relativeLayout.addView(this.f23066h.b());
        this.f23065g = str;
        this.f23064f = true;
        this.f23066h.a(z ? 1.0f : 0.0f);
        this.f23066h.a(str);
    }

    public long d(String str) {
        com.opos.mobad.c.c.a aVar;
        if (TextUtils.isEmpty(this.f23065g) || !this.f23065g.equals(str) || (aVar = this.f23066h) == null) {
            return 0L;
        }
        return aVar.c();
    }

    public long e(String str) {
        com.opos.mobad.c.c.a aVar;
        if (TextUtils.isEmpty(this.f23065g) || !this.f23065g.equals(str) || (aVar = this.f23066h) == null) {
            return 0L;
        }
        return aVar.d();
    }
}
