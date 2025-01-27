package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.c;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    public static final String f15960a = "d";

    /* renamed from: b */
    static final String f15961b = "Initialize ImageLoader with configuration";

    /* renamed from: c */
    static final String f15962c = "Destroy ImageLoader";

    /* renamed from: d */
    static final String f15963d = "Load image from memory cache [%s]";

    /* renamed from: e */
    private static final String f15964e = "Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.";

    /* renamed from: f */
    private static final String f15965f = "Wrong arguments were passed to displayImage() method (ImageView reference must not be null)";

    /* renamed from: g */
    private static final String f15966g = "ImageLoader must be init with configuration before using";

    /* renamed from: h */
    private static final String f15967h = "ImageLoader configuration can not be initialized with null";

    /* renamed from: i */
    private static volatile d f15968i;

    /* renamed from: j */
    private ImageLoaderConfiguration f15969j;
    private e k;
    private final com.nostra13.universalimageloader.core.k.a l = new com.nostra13.universalimageloader.core.k.d();

    private static class b extends com.nostra13.universalimageloader.core.k.d {

        /* renamed from: a */
        private Bitmap f15970a;

        private b() {
        }

        public Bitmap b() {
            return this.f15970a;
        }

        @Override // com.nostra13.universalimageloader.core.k.d, com.nostra13.universalimageloader.core.k.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            this.f15970a = bitmap;
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    protected d() {
    }

    private void c() {
        if (this.f15969j == null) {
            throw new IllegalStateException(f15966g);
        }
    }

    private static Handler g(c cVar) {
        Handler y = cVar.y();
        if (cVar.J()) {
            return null;
        }
        return (y == null && Looper.myLooper() == Looper.getMainLooper()) ? new Handler() : y;
    }

    public static d v() {
        if (f15968i == null) {
            synchronized (d.class) {
                if (f15968i == null) {
                    f15968i = new d();
                }
            }
        }
        return f15968i;
    }

    public synchronized void A(ImageLoaderConfiguration imageLoaderConfiguration) {
        if (imageLoaderConfiguration == null) {
            throw new IllegalArgumentException(f15967h);
        }
        if (this.f15969j == null) {
            b.g.a.b.d.a(f15961b, new Object[0]);
            this.k = new e(imageLoaderConfiguration);
            this.f15969j = imageLoaderConfiguration;
        } else {
            b.g.a.b.d.i(f15964e, new Object[0]);
        }
    }

    public boolean B() {
        return this.f15969j != null;
    }

    public void C(String str, c cVar, com.nostra13.universalimageloader.core.k.a aVar) {
        E(str, null, cVar, aVar, null);
    }

    public void D(String str, com.nostra13.universalimageloader.core.assist.c cVar, c cVar2, com.nostra13.universalimageloader.core.k.a aVar) {
        E(str, cVar, cVar2, aVar, null);
    }

    public void E(String str, com.nostra13.universalimageloader.core.assist.c cVar, c cVar2, com.nostra13.universalimageloader.core.k.a aVar, com.nostra13.universalimageloader.core.k.b bVar) {
        c();
        if (cVar == null) {
            cVar = this.f15969j.b();
        }
        if (cVar2 == null) {
            cVar2 = this.f15969j.r;
        }
        r(str, new com.nostra13.universalimageloader.core.j.c(str, cVar, ViewScaleType.CROP), cVar2, aVar, bVar);
    }

    public void F(String str, com.nostra13.universalimageloader.core.assist.c cVar, com.nostra13.universalimageloader.core.k.a aVar) {
        E(str, cVar, null, aVar, null);
    }

    public void G(String str, com.nostra13.universalimageloader.core.k.a aVar) {
        E(str, null, null, aVar, null);
    }

    public Bitmap H(String str) {
        return K(str, null, null);
    }

    public Bitmap I(String str, c cVar) {
        return K(str, null, cVar);
    }

    public Bitmap J(String str, com.nostra13.universalimageloader.core.assist.c cVar) {
        return K(str, cVar, null);
    }

    public Bitmap K(String str, com.nostra13.universalimageloader.core.assist.c cVar, c cVar2) {
        if (cVar2 == null) {
            cVar2 = this.f15969j.r;
        }
        c u = new c.b().A(cVar2).T(true).u();
        b bVar = new b();
        D(str, cVar, u, bVar);
        return bVar.b();
    }

    public void L() {
        this.k.p();
    }

    public void M() {
        this.k.r();
    }

    public void N() {
        this.k.s();
    }

    public void a(ImageView imageView) {
        this.k.d(new com.nostra13.universalimageloader.core.j.b(imageView));
    }

    public void b(com.nostra13.universalimageloader.core.j.a aVar) {
        this.k.d(aVar);
    }

    @Deprecated
    public void d() {
        e();
    }

    public void e() {
        c();
        this.f15969j.o.clear();
    }

    public void f() {
        c();
        this.f15969j.n.clear();
    }

    public void h(boolean z) {
        this.k.f(z);
    }

    public void i() {
        if (this.f15969j != null) {
            b.g.a.b.d.a(f15962c, new Object[0]);
        }
        N();
        this.f15969j.o.close();
        this.k = null;
        this.f15969j = null;
    }

    public void j(String str, ImageView imageView) {
        r(str, new com.nostra13.universalimageloader.core.j.b(imageView), null, null, null);
    }

    public void k(String str, ImageView imageView, c cVar) {
        r(str, new com.nostra13.universalimageloader.core.j.b(imageView), cVar, null, null);
    }

    public void l(String str, ImageView imageView, c cVar, com.nostra13.universalimageloader.core.k.a aVar) {
        m(str, imageView, cVar, aVar, null);
    }

    public void m(String str, ImageView imageView, c cVar, com.nostra13.universalimageloader.core.k.a aVar, com.nostra13.universalimageloader.core.k.b bVar) {
        r(str, new com.nostra13.universalimageloader.core.j.b(imageView), cVar, aVar, bVar);
    }

    public void n(String str, ImageView imageView, com.nostra13.universalimageloader.core.k.a aVar) {
        r(str, new com.nostra13.universalimageloader.core.j.b(imageView), null, aVar, null);
    }

    public void o(String str, com.nostra13.universalimageloader.core.j.a aVar) {
        r(str, aVar, null, null, null);
    }

    public void p(String str, com.nostra13.universalimageloader.core.j.a aVar, c cVar) {
        r(str, aVar, cVar, null, null);
    }

    public void q(String str, com.nostra13.universalimageloader.core.j.a aVar, c cVar, com.nostra13.universalimageloader.core.k.a aVar2) {
        r(str, aVar, cVar, aVar2, null);
    }

    public void r(String str, com.nostra13.universalimageloader.core.j.a aVar, c cVar, com.nostra13.universalimageloader.core.k.a aVar2, com.nostra13.universalimageloader.core.k.b bVar) {
        c();
        if (aVar == null) {
            throw new IllegalArgumentException(f15965f);
        }
        if (aVar2 == null) {
            aVar2 = this.l;
        }
        com.nostra13.universalimageloader.core.k.a aVar3 = aVar2;
        if (cVar == null) {
            cVar = this.f15969j.r;
        }
        if (TextUtils.isEmpty(str)) {
            this.k.d(aVar);
            aVar3.onLoadingStarted(str, aVar.getWrappedView());
            if (cVar.N()) {
                aVar.setImageDrawable(cVar.z(this.f15969j.f15867a));
            } else {
                aVar.setImageDrawable(null);
            }
            aVar3.onLoadingComplete(str, aVar.getWrappedView(), null);
            return;
        }
        com.nostra13.universalimageloader.core.assist.c e2 = b.g.a.b.b.e(aVar, this.f15969j.b());
        String d2 = b.g.a.b.e.d(str, e2);
        this.k.q(aVar, d2);
        aVar3.onLoadingStarted(str, aVar.getWrappedView());
        Bitmap bitmap = this.f15969j.n.get(d2);
        if (bitmap == null || bitmap.isRecycled()) {
            if (cVar.P()) {
                aVar.setImageDrawable(cVar.B(this.f15969j.f15867a));
            } else if (cVar.I()) {
                aVar.setImageDrawable(null);
            }
            LoadAndDisplayImageTask loadAndDisplayImageTask = new LoadAndDisplayImageTask(this.k, new f(str, aVar, e2, d2, cVar, aVar3, bVar, this.k.i(str)), g(cVar));
            if (cVar.J()) {
                loadAndDisplayImageTask.run();
                return;
            } else {
                this.k.t(loadAndDisplayImageTask);
                return;
            }
        }
        b.g.a.b.d.a(f15963d, d2);
        if (!cVar.L()) {
            cVar.w().a(bitmap, aVar, LoadedFrom.MEMORY_CACHE);
            aVar3.onLoadingComplete(str, aVar.getWrappedView(), bitmap);
            return;
        }
        g gVar = new g(this.k, bitmap, new f(str, aVar, e2, d2, cVar, aVar3, bVar, this.k.i(str)), g(cVar));
        if (cVar.J()) {
            gVar.run();
        } else {
            this.k.u(gVar);
        }
    }

    public void s(String str, com.nostra13.universalimageloader.core.j.a aVar, com.nostra13.universalimageloader.core.k.a aVar2) {
        r(str, aVar, null, aVar2, null);
    }

    @Deprecated
    public b.g.a.a.a.b t() {
        return u();
    }

    public b.g.a.a.a.b u() {
        c();
        return this.f15969j.o;
    }

    public String w(ImageView imageView) {
        return this.k.h(new com.nostra13.universalimageloader.core.j.b(imageView));
    }

    public String x(com.nostra13.universalimageloader.core.j.a aVar) {
        return this.k.h(aVar);
    }

    public b.g.a.a.b.c y() {
        c();
        return this.f15969j.n;
    }

    public void z(boolean z) {
        this.k.l(z);
    }
}
