package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.a;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import ff.d;
import hf.e;
import ze.c;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: d */
    public static final String f16340d = "b";

    /* renamed from: e */
    public static final String f16341e = "Initialize ImageLoader with configuration";

    /* renamed from: f */
    public static final String f16342f = "Destroy ImageLoader";

    /* renamed from: g */
    public static final String f16343g = "Load image from memory cache [%s]";

    /* renamed from: h */
    public static final String f16344h = "Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.";

    /* renamed from: i */
    public static final String f16345i = "Wrong arguments were passed to displayImage() method (ImageView reference must not be null)";

    /* renamed from: j */
    public static final String f16346j = "ImageLoader must be init with configuration before using";

    /* renamed from: k */
    public static final String f16347k = "ImageLoader configuration can not be initialized with null";

    /* renamed from: l */
    public static volatile b f16348l;

    /* renamed from: a */
    public ImageLoaderConfiguration f16349a;

    /* renamed from: b */
    public c f16350b;

    /* renamed from: c */
    public final ff.a f16351c = new d();

    /* renamed from: com.nostra13.universalimageloader.core.b$b */
    public static class C0545b extends d {

        /* renamed from: a */
        public Bitmap f16352a;

        public C0545b() {
        }

        public Bitmap b() {
            return this.f16352a;
        }

        @Override // ff.d, ff.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            this.f16352a = bitmap;
        }

        public /* synthetic */ C0545b(a aVar) {
            this();
        }
    }

    public static Handler g(com.nostra13.universalimageloader.core.a aVar) {
        Handler y10 = aVar.y();
        if (aVar.J()) {
            return null;
        }
        return (y10 == null && Looper.myLooper() == Looper.getMainLooper()) ? new Handler() : y10;
    }

    public static b v() {
        if (f16348l == null) {
            synchronized (b.class) {
                try {
                    if (f16348l == null) {
                        f16348l = new b();
                    }
                } finally {
                }
            }
        }
        return f16348l;
    }

    public synchronized void A(ImageLoaderConfiguration imageLoaderConfiguration) {
        try {
            if (imageLoaderConfiguration == null) {
                throw new IllegalArgumentException(f16347k);
            }
            if (this.f16349a == null) {
                hf.d.a(f16341e, new Object[0]);
                this.f16350b = new c(imageLoaderConfiguration);
                this.f16349a = imageLoaderConfiguration;
            } else {
                hf.d.i(f16344h, new Object[0]);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public boolean B() {
        return this.f16349a != null;
    }

    public void C(String str, af.c cVar, com.nostra13.universalimageloader.core.a aVar, ff.a aVar2) {
        D(str, cVar, aVar, aVar2, null);
    }

    public void D(String str, af.c cVar, com.nostra13.universalimageloader.core.a aVar, ff.a aVar2, ff.b bVar) {
        c();
        if (cVar == null) {
            cVar = this.f16349a.b();
        }
        if (aVar == null) {
            aVar = this.f16349a.f16226r;
        }
        r(str, new ef.c(str, cVar, ViewScaleType.CROP), aVar, aVar2, bVar);
    }

    public void E(String str, af.c cVar, ff.a aVar) {
        D(str, cVar, null, aVar, null);
    }

    public void F(String str, com.nostra13.universalimageloader.core.a aVar, ff.a aVar2) {
        D(str, null, aVar, aVar2, null);
    }

    public void G(String str, ff.a aVar) {
        D(str, null, null, aVar, null);
    }

    public Bitmap H(String str) {
        return J(str, null, null);
    }

    public Bitmap I(String str, af.c cVar) {
        return J(str, cVar, null);
    }

    public Bitmap J(String str, af.c cVar, com.nostra13.universalimageloader.core.a aVar) {
        if (aVar == null) {
            aVar = this.f16349a.f16226r;
        }
        com.nostra13.universalimageloader.core.a u10 = new a.b().A(aVar).T(true).u();
        C0545b c0545b = new C0545b();
        C(str, cVar, u10, c0545b);
        return c0545b.b();
    }

    public Bitmap K(String str, com.nostra13.universalimageloader.core.a aVar) {
        return J(str, null, aVar);
    }

    public void L() {
        this.f16350b.p();
    }

    public void M() {
        this.f16350b.r();
    }

    public void N() {
        this.f16350b.s();
    }

    public void a(ImageView imageView) {
        this.f16350b.d(new ef.b(imageView));
    }

    public void b(ef.a aVar) {
        this.f16350b.d(aVar);
    }

    public final void c() {
        if (this.f16349a == null) {
            throw new IllegalStateException(f16346j);
        }
    }

    @Deprecated
    public void d() {
        e();
    }

    public void e() {
        c();
        this.f16349a.f16223o.clear();
    }

    public void f() {
        c();
        this.f16349a.f16222n.clear();
    }

    public void h(boolean z10) {
        this.f16350b.f(z10);
    }

    public void i() {
        if (this.f16349a != null) {
            hf.d.a(f16342f, new Object[0]);
        }
        N();
        this.f16349a.f16223o.close();
        this.f16350b = null;
        this.f16349a = null;
    }

    public void j(String str, ImageView imageView) {
        r(str, new ef.b(imageView), null, null, null);
    }

    public void k(String str, ImageView imageView, com.nostra13.universalimageloader.core.a aVar) {
        r(str, new ef.b(imageView), aVar, null, null);
    }

    public void l(String str, ImageView imageView, com.nostra13.universalimageloader.core.a aVar, ff.a aVar2) {
        m(str, imageView, aVar, aVar2, null);
    }

    public void m(String str, ImageView imageView, com.nostra13.universalimageloader.core.a aVar, ff.a aVar2, ff.b bVar) {
        r(str, new ef.b(imageView), aVar, aVar2, bVar);
    }

    public void n(String str, ImageView imageView, ff.a aVar) {
        r(str, new ef.b(imageView), null, aVar, null);
    }

    public void o(String str, ef.a aVar) {
        r(str, aVar, null, null, null);
    }

    public void p(String str, ef.a aVar, com.nostra13.universalimageloader.core.a aVar2) {
        r(str, aVar, aVar2, null, null);
    }

    public void q(String str, ef.a aVar, com.nostra13.universalimageloader.core.a aVar2, ff.a aVar3) {
        r(str, aVar, aVar2, aVar3, null);
    }

    public void r(String str, ef.a aVar, com.nostra13.universalimageloader.core.a aVar2, ff.a aVar3, ff.b bVar) {
        c();
        if (aVar == null) {
            throw new IllegalArgumentException(f16345i);
        }
        if (aVar3 == null) {
            aVar3 = this.f16351c;
        }
        ff.a aVar4 = aVar3;
        if (aVar2 == null) {
            aVar2 = this.f16349a.f16226r;
        }
        if (TextUtils.isEmpty(str)) {
            this.f16350b.d(aVar);
            aVar4.onLoadingStarted(str, aVar.getWrappedView());
            if (aVar2.N()) {
                aVar.setImageDrawable(aVar2.z(this.f16349a.f16209a));
            } else {
                aVar.setImageDrawable(null);
            }
            aVar4.onLoadingComplete(str, aVar.getWrappedView(), null);
            return;
        }
        af.c e10 = hf.b.e(aVar, this.f16349a.b());
        String d10 = e.d(str, e10);
        this.f16350b.q(aVar, d10);
        aVar4.onLoadingStarted(str, aVar.getWrappedView());
        Bitmap bitmap = this.f16349a.f16222n.get(d10);
        if (bitmap == null || bitmap.isRecycled()) {
            if (aVar2.P()) {
                aVar.setImageDrawable(aVar2.B(this.f16349a.f16209a));
            } else if (aVar2.I()) {
                aVar.setImageDrawable(null);
            }
            LoadAndDisplayImageTask loadAndDisplayImageTask = new LoadAndDisplayImageTask(this.f16350b, new ze.d(str, aVar, e10, d10, aVar2, aVar4, bVar, this.f16350b.i(str)), g(aVar2));
            if (aVar2.J()) {
                loadAndDisplayImageTask.run();
                return;
            } else {
                this.f16350b.t(loadAndDisplayImageTask);
                return;
            }
        }
        hf.d.a(f16343g, d10);
        if (!aVar2.L()) {
            aVar2.w().a(bitmap, aVar, LoadedFrom.MEMORY_CACHE);
            aVar4.onLoadingComplete(str, aVar.getWrappedView(), bitmap);
            return;
        }
        ze.e eVar = new ze.e(this.f16350b, bitmap, new ze.d(str, aVar, e10, d10, aVar2, aVar4, bVar, this.f16350b.i(str)), g(aVar2));
        if (aVar2.J()) {
            eVar.run();
        } else {
            this.f16350b.u(eVar);
        }
    }

    public void s(String str, ef.a aVar, ff.a aVar2) {
        r(str, aVar, null, aVar2, null);
    }

    @Deprecated
    public te.b t() {
        return u();
    }

    public te.b u() {
        c();
        return this.f16349a.f16223o;
    }

    public String w(ImageView imageView) {
        return this.f16350b.h(new ef.b(imageView));
    }

    public String x(ef.a aVar) {
        return this.f16350b.h(aVar);
    }

    public xe.c y() {
        c();
        return this.f16349a.f16222n;
    }

    public void z(boolean z10) {
        this.f16350b.l(z10);
    }
}
