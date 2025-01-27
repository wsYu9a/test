package com.opos.mobad.o.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class h extends a {

    /* renamed from: a */
    private boolean f23023a;

    /* renamed from: com.opos.mobad.o.b.h$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f23023a) {
                return;
            }
            h hVar = h.this;
            if (hVar.f22995e != null) {
                hVar.B = 0;
                hVar.f22996f.setProgress(0);
            }
        }
    }

    /* renamed from: com.opos.mobad.o.b.h$10 */
    class AnonymousClass10 implements Runnable {
        AnonymousClass10() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f23023a) {
                return;
            }
            h.this.ab();
        }
    }

    /* renamed from: com.opos.mobad.o.b.h$11 */
    class AnonymousClass11 implements Runnable {
        AnonymousClass11() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f23023a) {
                return;
            }
            h.this.ac();
        }
    }

    /* renamed from: com.opos.mobad.o.b.h$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            ImageView imageView = hVar.l;
            if (imageView != null) {
                hVar.f22994d.removeView(imageView);
            }
            Bitmap bitmap = h.this.m;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            h.this.m.recycle();
        }
    }

    /* renamed from: com.opos.mobad.o.b.h$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f23028a;

        /* renamed from: com.opos.mobad.o.b.h$3$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f23030a;

            AnonymousClass1(Bitmap bitmap) {
                a3 = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.l.setImageBitmap(a3);
            }
        }

        AnonymousClass3(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String a2 = com.opos.cmn.d.d.a(h.this.f22992b, str);
            boolean isEmpty = TextUtils.isEmpty(a2);
            if (isEmpty) {
                a2 = str;
            }
            Bitmap a3 = com.opos.mobad.r.a.c.a(a2, isEmpty);
            if (a3 == null) {
                return;
            }
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.o.b.h.3.1

                /* renamed from: a */
                final /* synthetic */ Bitmap f23030a;

                AnonymousClass1(Bitmap a32) {
                    a3 = a32;
                }

                @Override // java.lang.Runnable
                public void run() {
                    h.this.l.setImageBitmap(a3);
                }
            });
        }
    }

    /* renamed from: com.opos.mobad.o.b.h$4 */
    class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextView textView;
            if (h.this.f23023a) {
                return;
            }
            h hVar = h.this;
            hVar.a(hVar.f22993c);
            h hVar2 = h.this;
            if (hVar2.f22995e != null && (textView = hVar2.f22998h) != null) {
                textView.setText(com.opos.mobad.cmn.a.b.e.a(k.a().d(h.this.A)));
            }
            h.this.ad();
            h hVar3 = h.this;
            d dVar = hVar3.u;
            if (dVar != null) {
                dVar.a(hVar3.n, hVar3.f22993c);
            }
        }
    }

    /* renamed from: com.opos.mobad.o.b.h$5 */
    class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f23023a) {
                return;
            }
            h hVar = h.this;
            if (hVar.f22995e != null) {
                hVar.f22996f.setProgress(100);
            }
            h.this.ag();
            h hVar2 = h.this;
            d dVar = hVar2.u;
            if (dVar != null) {
                dVar.b(hVar2.n, hVar2.f22993c);
            }
        }
    }

    /* renamed from: com.opos.mobad.o.b.h$6 */
    class AnonymousClass6 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f23034a;

        /* renamed from: b */
        final /* synthetic */ String f23035b;

        AnonymousClass6(int i2, String str) {
            i2 = i2;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f23023a) {
                return;
            }
            h.this.ah();
            d dVar = h.this.u;
            if (dVar != null) {
                dVar.a(i2, str);
            }
        }
    }

    /* renamed from: com.opos.mobad.o.b.h$7 */
    class AnonymousClass7 implements Runnable {
        AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f23023a) {
                return;
            }
            h hVar = h.this;
            if (hVar.f22995e != null && hVar.f22998h != null && hVar.f22997g != null) {
                com.opos.cmn.an.f.a.b("MediaCreative", "onResume:" + com.opos.mobad.cmn.a.b.e.a(k.a().d(h.this.A)));
                long d2 = k.a().d(h.this.A);
                h.this.f22998h.setText(com.opos.mobad.cmn.a.b.e.a(d2));
                long e2 = k.a().e(h.this.A);
                h.this.f22997g.setText(com.opos.mobad.cmn.a.b.e.a(e2));
                if (d2 != 0) {
                    int i2 = (int) ((e2 * 100) / d2);
                    h.this.f22996f.setProgress(i2);
                    h.this.B = i2;
                }
            }
            h.this.af();
            h hVar2 = h.this;
            d dVar = hVar2.u;
            if (dVar != null) {
                dVar.b(hVar2.n, hVar2.f22993c, k.a().e(h.this.A));
            }
        }
    }

    /* renamed from: com.opos.mobad.o.b.h$8 */
    class AnonymousClass8 implements Runnable {
        AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f23023a) {
                return;
            }
            h.this.ae();
            h hVar = h.this;
            d dVar = hVar.u;
            if (dVar != null) {
                dVar.a(hVar.n, hVar.f22993c, k.a().e(h.this.A));
            }
        }
    }

    /* renamed from: com.opos.mobad.o.b.h$9 */
    class AnonymousClass9 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f23039a;

        /* renamed from: b */
        final /* synthetic */ long f23040b;

        AnonymousClass9(String str, long j2) {
            str = str;
            j2 = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f23023a) {
                return;
            }
            if (!TextUtils.isEmpty(h.this.A) && h.this.A.equals(str)) {
                com.opos.cmn.an.f.a.b("MediaCreative", "mCountDown:" + k.a().e(h.this.A));
                h hVar = h.this;
                if (hVar.C && hVar.f22995e != null) {
                    h.this.a(j2, hVar.R());
                }
                h hVar2 = h.this;
                d dVar = hVar2.u;
                if (dVar != null) {
                    dVar.c(hVar2.n, hVar2.f22993c, j2);
                }
            }
            h.this.s();
        }
    }

    public h(Context context, d dVar, FrameLayout frameLayout, boolean z) {
        super(context, dVar, frameLayout, z);
        this.f23023a = false;
    }

    private void a(Context context, String str) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.o.b.h.3

            /* renamed from: a */
            final /* synthetic */ String f23028a;

            /* renamed from: com.opos.mobad.o.b.h$3$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Bitmap f23030a;

                AnonymousClass1(Bitmap a32) {
                    a3 = a32;
                }

                @Override // java.lang.Runnable
                public void run() {
                    h.this.l.setImageBitmap(a3);
                }
            }

            AnonymousClass3(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String a2 = com.opos.cmn.d.d.a(h.this.f22992b, str);
                boolean isEmpty = TextUtils.isEmpty(a2);
                if (isEmpty) {
                    a2 = str;
                }
                Bitmap a32 = com.opos.mobad.r.a.c.a(a2, isEmpty);
                if (a32 == null) {
                    return;
                }
                com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.o.b.h.3.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f23030a;

                    AnonymousClass1(Bitmap a322) {
                        a3 = a322;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.l.setImageBitmap(a3);
                    }
                });
            }
        });
    }

    @Override // com.opos.mobad.o.b.a
    protected void O() {
        com.opos.cmn.an.f.a.b("MediaCreative", "resetDisappearTime");
        this.G.removeMessages(1);
        if ((this.x || this.v) && !this.w) {
            this.G.sendMessageDelayed(this.G.obtainMessage(1), 3000L);
        }
    }

    @Override // com.opos.mobad.o.b.a
    protected void P() {
        com.opos.cmn.an.f.a.b("MediaCreative", "ChangeUIOnTouch");
        int c2 = k.a().c(this.A);
        if (c2 == 2) {
            com.opos.cmn.an.f.a.b("MediaCreative", "ChangeUIOnTouch isShowPauseCover" + this.x);
            if (this.x) {
                G();
                A();
            } else {
                F();
                z();
            }
        }
        if (c2 != 3) {
            return;
        }
        com.opos.cmn.an.f.a.b("MediaCreative", "ChangeUIOnTouch isShowContinueCover" + this.w);
        if (this.w) {
            C();
            A();
        } else {
            B();
            z();
        }
    }

    public void Q() {
        com.opos.cmn.an.f.a.b("MediaCreative", "pauseVideo");
        k.a().b(this.A);
    }

    protected long R() {
        if (k.a() != null) {
            return k.a().d(this.A);
        }
        return -1L;
    }

    protected void S() {
        k.a().c();
    }

    protected void T() {
        this.G.removeMessages(1);
    }

    protected void U() {
        d dVar = this.u;
        if (dVar != null) {
            dVar.a(k.a().e(this.A));
        }
    }

    protected void V() {
        d dVar = this.u;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void W() {
        this.f23023a = true;
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.o.b.h.2
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h hVar = h.this;
                ImageView imageView = hVar.l;
                if (imageView != null) {
                    hVar.f22994d.removeView(imageView);
                }
                Bitmap bitmap = h.this.m;
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                h.this.m.recycle();
            }
        });
    }

    protected void X() {
        com.opos.cmn.an.f.a.b("MediaCreative", "ShowInitCoverStatus");
        r();
        D();
        y();
        u();
        K();
        I();
        w();
        u();
    }

    protected void Y() {
        com.opos.cmn.an.f.a.b("MediaCreative", "ShowInitBufferCoverStatus");
        r();
        L();
        C();
        G();
        K();
    }

    protected void Z() {
        com.opos.cmn.an.f.a.b("MediaCreative", "ShowInitWifiCoverStatus");
        r();
        v();
        C();
        G();
        K();
        u();
    }

    @Override // com.opos.mobad.c.c.b
    public void a(int i2, String str) {
        com.opos.cmn.an.f.a.b("MediaCreative", "onError,url:" + this.A);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.o.b.h.6

            /* renamed from: a */
            final /* synthetic */ int f23034a;

            /* renamed from: b */
            final /* synthetic */ String f23035b;

            AnonymousClass6(int i22, String str2) {
                i2 = i22;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f23023a) {
                    return;
                }
                h.this.ah();
                d dVar = h.this.u;
                if (dVar != null) {
                    dVar.a(i2, str);
                }
            }
        });
    }

    protected void a(long j2, long j3) {
        if (this.f22995e == null || k.a().c(this.A) != 2) {
            return;
        }
        com.opos.cmn.an.f.a.b("MediaCreative", "currentPosition=" + j2 + ",totalPosition=" + j3);
        if (j2 < 0 || j3 <= 0) {
            this.f22996f.setProgress(0);
            return;
        }
        this.f22997g.setText(com.opos.mobad.cmn.a.b.e.a(500 + j2));
        int i2 = (int) ((j2 * 100) / j3);
        com.opos.cmn.an.f.a.b("MediaCreative", "currentProgress=" + i2 + ",mLastProgress=" + this.B);
        if (i2 - this.B >= 1) {
            this.f22996f.setProgress(i2);
        }
        this.B = i2;
    }

    protected abstract void a(String str);

    @Override // com.opos.mobad.o.b.f
    public void a(String str, long j2) {
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.o.b.h.9

            /* renamed from: a */
            final /* synthetic */ String f23039a;

            /* renamed from: b */
            final /* synthetic */ long f23040b;

            AnonymousClass9(String str2, long j22) {
                str = str2;
                j2 = j22;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f23023a) {
                    return;
                }
                if (!TextUtils.isEmpty(h.this.A) && h.this.A.equals(str)) {
                    com.opos.cmn.an.f.a.b("MediaCreative", "mCountDown:" + k.a().e(h.this.A));
                    h hVar = h.this;
                    if (hVar.C && hVar.f22995e != null) {
                        h.this.a(j2, hVar.R());
                    }
                    h hVar2 = h.this;
                    d dVar = hVar2.u;
                    if (dVar != null) {
                        dVar.c(hVar2.n, hVar2.f22993c, j2);
                    }
                }
                h.this.s();
            }
        });
    }

    protected boolean a(AdItemData adItemData) {
        MaterialData materialData;
        ImageView imageView = this.l;
        if (imageView != null) {
            if (imageView.getDrawable() != null) {
                com.opos.cmn.an.f.a.b("MediaCreative", "createAndLoadCoverImg cover is not null ");
                return true;
            }
            if (adItemData != null && (materialData = adItemData.i().get(0)) != null) {
                List<MaterialFileData> f2 = materialData.f();
                if (f2 != null && f2.size() > 0 && f2.get(0) != null) {
                    String a2 = f2.get(0).a();
                    if (!TextUtils.isEmpty(a2)) {
                        if (com.opos.cmn.an.d.b.a.a(a2)) {
                            a(a2);
                            return true;
                        }
                        com.opos.cmn.an.f.a.b("MediaCreative", "file not exit" + a2);
                    }
                }
                List<MaterialFileData> F = materialData.F();
                if (F != null && F.size() > 0) {
                    String a3 = F.get(0).a();
                    if (!TextUtils.isEmpty(a3)) {
                        a(this.f22992b, a3);
                        return true;
                    }
                    com.opos.cmn.an.f.a.b("MediaCreative", "videoUrl is empty");
                }
            }
        }
        return false;
    }

    protected void aa() {
        com.opos.cmn.an.f.a.b("MediaCreative", "ShowInitClickBufferStatus");
        L();
        w();
        u();
        G();
        C();
    }

    protected void ab() {
        L();
        w();
        C();
        G();
        u();
    }

    protected void ac() {
        M();
    }

    protected void ad() {
        p();
        M();
        s();
        E();
        w();
        K();
        u();
        G();
    }

    protected void ae() {
        I();
        M();
        K();
        u();
        B();
    }

    protected void af() {
        p();
        M();
        s();
        K();
        E();
        w();
        u();
        F();
        O();
    }

    protected void ag() {
        M();
        G();
        C();
        q();
        r();
        J();
    }

    protected void ah() {
        M();
        G();
        C();
        w();
        t();
    }

    @Override // com.opos.mobad.c.c.b
    public void c() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onPrepare,url:" + this.A);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.o.b.h.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f23023a) {
                    return;
                }
                h hVar = h.this;
                if (hVar.f22995e != null) {
                    hVar.B = 0;
                    hVar.f22996f.setProgress(0);
                }
            }
        });
    }

    @Override // com.opos.mobad.c.c.b
    public void d() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onStart,url:" + this.A);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.o.b.h.4
            AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public void run() {
                TextView textView;
                if (h.this.f23023a) {
                    return;
                }
                h hVar = h.this;
                hVar.a(hVar.f22993c);
                h hVar2 = h.this;
                if (hVar2.f22995e != null && (textView = hVar2.f22998h) != null) {
                    textView.setText(com.opos.mobad.cmn.a.b.e.a(k.a().d(h.this.A)));
                }
                h.this.ad();
                h hVar3 = h.this;
                d dVar = hVar3.u;
                if (dVar != null) {
                    dVar.a(hVar3.n, hVar3.f22993c);
                }
            }
        });
    }

    @Override // com.opos.mobad.c.c.b
    public void e() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onComplete,url:" + this.A);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.o.b.h.5
            AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f23023a) {
                    return;
                }
                h hVar = h.this;
                if (hVar.f22995e != null) {
                    hVar.f22996f.setProgress(100);
                }
                h.this.ag();
                h hVar2 = h.this;
                d dVar = hVar2.u;
                if (dVar != null) {
                    dVar.b(hVar2.n, hVar2.f22993c);
                }
            }
        });
    }

    @Override // com.opos.mobad.c.c.b
    public void f() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onResume,url:" + this.A);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.o.b.h.7
            AnonymousClass7() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f23023a) {
                    return;
                }
                h hVar = h.this;
                if (hVar.f22995e != null && hVar.f22998h != null && hVar.f22997g != null) {
                    com.opos.cmn.an.f.a.b("MediaCreative", "onResume:" + com.opos.mobad.cmn.a.b.e.a(k.a().d(h.this.A)));
                    long d2 = k.a().d(h.this.A);
                    h.this.f22998h.setText(com.opos.mobad.cmn.a.b.e.a(d2));
                    long e2 = k.a().e(h.this.A);
                    h.this.f22997g.setText(com.opos.mobad.cmn.a.b.e.a(e2));
                    if (d2 != 0) {
                        int i2 = (int) ((e2 * 100) / d2);
                        h.this.f22996f.setProgress(i2);
                        h.this.B = i2;
                    }
                }
                h.this.af();
                h hVar2 = h.this;
                d dVar = hVar2.u;
                if (dVar != null) {
                    dVar.b(hVar2.n, hVar2.f22993c, k.a().e(h.this.A));
                }
            }
        });
    }

    @Override // com.opos.mobad.c.c.b
    public void g() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onPause,url:" + this.A);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.o.b.h.8
            AnonymousClass8() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f23023a) {
                    return;
                }
                h.this.ae();
                h hVar = h.this;
                d dVar = hVar.u;
                if (dVar != null) {
                    dVar.a(hVar.n, hVar.f22993c, k.a().e(h.this.A));
                }
            }
        });
    }

    @Override // com.opos.mobad.c.c.b
    public void h() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onBufferingStart");
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.o.b.h.10
            AnonymousClass10() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f23023a) {
                    return;
                }
                h.this.ab();
            }
        });
    }

    @Override // com.opos.mobad.c.c.b
    public void i() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onBufferingEnd");
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.o.b.h.11
            AnonymousClass11() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f23023a) {
                    return;
                }
                h.this.ac();
            }
        });
    }

    @Override // com.opos.mobad.c.c.b
    public void j() {
    }

    @Override // com.opos.mobad.o.b.a
    protected void r() {
        ImageView imageView;
        if (this.f22993c == null || (imageView = this.l) == null || imageView.getDrawable() != null || a(this.f22993c)) {
            super.r();
        } else {
            s();
        }
    }
}
