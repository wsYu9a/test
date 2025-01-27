package com.vivo.mobilead.unified.nativead;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.vivo.ad.model.AdError;
import com.vivo.ad.model.w;
import com.vivo.ad.model.y;
import com.vivo.ad.view.n;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.framework.ViewManager;
import com.vivo.advv.vaf.virtualview.Helper.ImageLoader;
import com.vivo.advv.vaf.virtualview.core.ELIllegalArgumentException;
import com.vivo.advv.vaf.virtualview.core.IContainer;
import com.vivo.advv.vaf.virtualview.core.Layout;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.mobilead.i.m;
import com.vivo.mobilead.model.a;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.g.b.a;
import com.vivo.mobilead.unified.base.g.b.c;
import com.vivo.mobilead.unified.base.g.b.d;
import com.vivo.mobilead.unified.base.g.b.e;
import com.vivo.mobilead.unified.base.view.s.a;
import com.vivo.mobilead.util.VOpenLog;
import com.vivo.mobilead.util.a1;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.p;
import com.vivo.mobilead.util.u;
import com.vivo.mobilead.util.y0;
import com.vivo.mobilead.util.z;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a extends com.vivo.mobilead.unified.a {
    private com.vivo.mobilead.unified.base.view.u.b A;
    private n B;
    private View.OnClickListener C;
    private com.vivo.mobilead.unified.base.callback.d D;
    private a.f E;
    protected UnifiedVivoNativeExpressAdListener t;
    private com.vivo.mobilead.unified.base.view.s.a u;
    private VivoNativeExpressView v;
    private long w;
    private long x;
    private Future<Object> y;
    private boolean z;

    /* renamed from: com.vivo.mobilead.unified.nativead.a$a */
    class C0656a implements a.f {
        C0656a() {
        }

        @Override // com.vivo.mobilead.unified.base.view.s.a.f
        public void a(com.vivo.mobilead.unified.base.view.s.a aVar) {
            int[] iArr;
            String str;
            a aVar2 = a.this;
            if (aVar2.t != null) {
                if (aVar != null) {
                    aVar2.u = aVar;
                    a.this.u.setBiddingImpl(a.this);
                    a.this.v = new VivoNativeExpressView(((com.vivo.mobilead.unified.a) a.this).f29661a, a.this.u);
                    a aVar3 = a.this;
                    aVar3.t.onAdReady(aVar3.v);
                    a.this.m();
                    return;
                }
                if (((com.vivo.mobilead.unified.a) aVar2).f29666f != null) {
                    str = ((com.vivo.mobilead.unified.a) a.this).f29666f.P();
                    iArr = ((com.vivo.mobilead.unified.a) a.this).f29666f.J();
                } else {
                    iArr = null;
                    str = "";
                }
                VivoAdError vivoAdError = new VivoAdError(402126, "渲染视图出现异常");
                a.this.c(new AdError(vivoAdError.getCode(), vivoAdError.getMsg(), str, iArr));
                a.this.a(vivoAdError);
            }
        }
    }

    class b extends ImageLoader.DefaultImageLoaderAdapter {

        /* renamed from: a */
        final /* synthetic */ AtomicBoolean f30455a;

        /* renamed from: com.vivo.mobilead.unified.nativead.a$b$a */
        class RunnableC0657a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ImageLoader.Listener f30457a;

            /* renamed from: b */
            final /* synthetic */ Drawable f30458b;

            RunnableC0657a(b bVar, ImageLoader.Listener listener, Drawable drawable) {
                this.f30457a = listener;
                this.f30458b = drawable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f30457a.onImageLoadSuccess(this.f30458b);
            }
        }

        /* renamed from: com.vivo.mobilead.unified.nativead.a$b$b */
        class RunnableC0658b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ImageLoader.Listener f30459a;

            RunnableC0658b(b bVar, ImageLoader.Listener listener) {
                this.f30459a = listener;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f30459a.onImageLoadFailed();
            }
        }

        class c implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ImageLoader.Listener f30460a;

            c(b bVar, ImageLoader.Listener listener) {
                this.f30460a = listener;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f30460a.onImageLoadFailed();
            }
        }

        class d extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ ImageLoader.Listener f30461a;

            /* renamed from: b */
            final /* synthetic */ byte[] f30462b;

            /* renamed from: c */
            final /* synthetic */ File f30463c;

            d(b bVar, ImageLoader.Listener listener, byte[] bArr, File file) {
                this.f30461a = listener;
                this.f30462b = bArr;
                this.f30463c = file;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                this.f30461a.onImageLoadSuccess(this.f30462b, this.f30463c);
            }
        }

        class e implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ImageLoader.Listener f30464a;

            /* renamed from: b */
            final /* synthetic */ Bitmap f30465b;

            e(b bVar, ImageLoader.Listener listener, Bitmap bitmap) {
                this.f30464a = listener;
                this.f30465b = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f30464a.onImageLoadSuccess(this.f30465b);
            }
        }

        class f implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ImageLoader.Listener f30466a;

            f(b bVar, ImageLoader.Listener listener) {
                this.f30466a = listener;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f30466a.onImageLoadFailed();
            }
        }

        class g implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ImageLoader.Listener f30467a;

            g(b bVar, ImageLoader.Listener listener) {
                this.f30467a = listener;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f30467a.onImageLoadFailed();
            }
        }

        b(AtomicBoolean atomicBoolean) {
            this.f30455a = atomicBoolean;
        }

        @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.DefaultImageLoaderAdapter, com.vivo.advv.vaf.virtualview.Helper.ImageLoader.IImageLoaderAdapter
        public boolean checkExist(String str, ViewBase viewBase) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (str.startsWith("@assets/") || com.vivo.mobilead.h.b.a().b(str) != null) {
                return true;
            }
            this.f30455a.set(true);
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.DefaultImageLoaderAdapter, com.vivo.advv.vaf.virtualview.Helper.ImageLoader.IImageLoaderAdapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void getBitmap(boolean r6, java.lang.String r7, com.vivo.advv.vaf.virtualview.core.ViewBase r8, int r9, int r10, com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener r11) {
            /*
                Method dump skipped, instructions count: 281
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.unified.nativead.a.b.getBitmap(boolean, java.lang.String, com.vivo.advv.vaf.virtualview.core.ViewBase, int, int, com.vivo.advv.vaf.virtualview.Helper.ImageLoader$Listener):void");
        }

        @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.DefaultImageLoaderAdapter, com.vivo.advv.vaf.virtualview.Helper.ImageLoader.IImageLoaderAdapter
        public void getBlurBitmap(Bitmap bitmap, ViewBase viewBase, float f2, int i2, ImageLoader.Listener listener) {
            if (f2 != 0.0f) {
                p.a(bitmap, 1.0f / f2, i2, new h(this, listener));
            }
        }

        class h implements p.b {

            /* renamed from: a */
            final /* synthetic */ ImageLoader.Listener f30468a;

            h(b bVar, ImageLoader.Listener listener) {
                this.f30468a = listener;
            }

            @Override // com.vivo.mobilead.util.p.b
            public void a(Bitmap bitmap) {
                ImageLoader.Listener listener = this.f30468a;
                if (listener != null) {
                    listener.onImageLoadSuccess(bitmap);
                }
            }

            @Override // com.vivo.mobilead.util.p.b
            public void a() {
                ImageLoader.Listener listener = this.f30468a;
                if (listener != null) {
                    listener.onImageLoadFailed();
                }
            }
        }
    }

    class c extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ AdError f30469a;

        c(AdError adError) {
            this.f30469a = adError;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            a.super.a(this.f30469a);
            a.this.a(new VivoAdError(this.f30469a.getErrorCode(), this.f30469a.getErrorMsg()));
        }
    }

    class d extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ AdError f30471a;

        d(AdError adError) {
            this.f30471a = adError;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            a.super.b(this.f30471a);
        }
    }

    class e extends com.vivo.mobilead.util.f1.b {
        e() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            a aVar = a.this;
            a.super.a(((com.vivo.mobilead.unified.a) aVar).f29666f);
        }
    }

    class f extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.model.b f30474a;

        f(com.vivo.mobilead.model.b bVar) {
            this.f30474a = bVar;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            com.vivo.mobilead.unified.nativead.b.a(((com.vivo.mobilead.unified.a) a.this).f29661a, ((com.vivo.mobilead.unified.a) a.this).f29666f, ((com.vivo.mobilead.unified.a) a.this).f29662b, a.this.C, a.this.B, a.this.D, a.this.E, a.this.A, this.f30474a);
        }
    }

    class g implements m {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.model.b f30476a;

        g(com.vivo.mobilead.model.b bVar) {
            this.f30476a = bVar;
        }

        @Override // com.vivo.mobilead.i.m
        public void a() {
            com.vivo.mobilead.unified.nativead.b.a(((com.vivo.mobilead.unified.a) a.this).f29661a, ((com.vivo.mobilead.unified.a) a.this).f29666f, ((com.vivo.mobilead.unified.a) a.this).f29662b, a.this.C, a.this.B, a.this.D, a.this.E, a.this.A, this.f30476a);
        }

        @Override // com.vivo.mobilead.i.m
        public void a(AdError adError) {
            com.vivo.mobilead.unified.nativead.b.a(((com.vivo.mobilead.unified.a) a.this).f29661a, ((com.vivo.mobilead.unified.a) a.this).f29666f, ((com.vivo.mobilead.unified.a) a.this).f29662b, a.this.C, a.this.B, a.this.D, a.this.E, a.this.A, this.f30476a);
        }
    }

    class h implements com.vivo.mobilead.unified.base.view.u.b {
        h(a aVar) {
        }

        @Override // com.vivo.mobilead.unified.base.view.u.b
        public void a(double d2, double d3) {
        }

        @Override // com.vivo.mobilead.unified.base.view.u.b
        public void a(int i2, double d2, View view, int i3, int i4, int i5, int i6) {
        }
    }

    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((com.vivo.mobilead.unified.a) a.this).f29666f != null && ((com.vivo.mobilead.unified.a) a.this).f29666f.a() != null && !((com.vivo.mobilead.unified.a) a.this).f29666f.a().d()) {
                ((com.vivo.mobilead.unified.a) a.this).f29666f.a().b(true);
                k0.a(((com.vivo.mobilead.unified.a) a.this).f29666f, ((com.vivo.mobilead.unified.a) a.this).f29662b.getSourceAppend(), a.this.k(), -1, -1, 13);
            }
            a.this.u.e();
            a aVar = a.this;
            UnifiedVivoNativeExpressAdListener unifiedVivoNativeExpressAdListener = aVar.t;
            if (unifiedVivoNativeExpressAdListener != null) {
                unifiedVivoNativeExpressAdListener.onAdClose(aVar.v);
            }
        }
    }

    class k implements com.vivo.mobilead.unified.base.callback.d {
        k() {
        }

        @Override // com.vivo.mobilead.unified.base.callback.d
        public void a() {
            int i2;
            int i3;
            int i4;
            if (((com.vivo.mobilead.unified.a) a.this).f29666f != null && ((com.vivo.mobilead.unified.a) a.this).f29666f.m() == 2) {
                a aVar = a.this;
                if (!aVar.a(((com.vivo.mobilead.unified.a) aVar).f29666f, ((com.vivo.mobilead.unified.a) a.this).q) && !a.this.z) {
                    a aVar2 = a.this;
                    if (aVar2.t != null) {
                        aVar2.z = true;
                        a.this.c();
                    }
                }
            }
            a aVar3 = a.this;
            int i5 = 0;
            aVar3.a(((com.vivo.mobilead.unified.a) aVar3).f29666f, 1, ((com.vivo.mobilead.unified.a) a.this).q, 0);
            if (((com.vivo.mobilead.unified.a) a.this).f29666f == null || ((com.vivo.mobilead.unified.a) a.this).f29666f.a().f()) {
                return;
            }
            ((com.vivo.mobilead.unified.a) a.this).f29666f.a().d(true);
            if (a.this.u != null) {
                Rect bounds = a.this.u.getBounds();
                i5 = bounds.left;
                i2 = bounds.top;
                int i6 = bounds.right;
                int i7 = bounds.bottom;
                if (!y0.a(a.this.u, 95)) {
                    k0.a(((com.vivo.mobilead.unified.a) a.this).f29666f, 1, ((com.vivo.mobilead.unified.a) a.this).f29662b.getSourceAppend());
                }
                i4 = i7;
                i3 = i6;
            } else {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            }
            k0.a(((com.vivo.mobilead.unified.a) a.this).f29666f, i5, i2, i3, i4, a.this.k(), ((com.vivo.mobilead.unified.a) a.this).f29662b.getSourceAppend(), 0);
            k0.a(((com.vivo.mobilead.unified.a) a.this).f29666f, a.EnumC0603a.SHOW, -999, -999, -999, -999, i5, i2, i3, i4, ((com.vivo.mobilead.unified.a) a.this).f29662b.getSourceAppend());
            a aVar4 = a.this;
            UnifiedVivoNativeExpressAdListener unifiedVivoNativeExpressAdListener = aVar4.t;
            if (unifiedVivoNativeExpressAdListener != null) {
                unifiedVivoNativeExpressAdListener.onAdShow(aVar4.v);
            }
        }
    }

    public a(Context context, AdParams adParams, UnifiedVivoNativeExpressAdListener unifiedVivoNativeExpressAdListener) {
        super(context, adParams);
        this.A = new h(this);
        this.B = new i();
        this.C = new j();
        this.D = new k();
        this.E = new C0656a();
        this.t = unifiedVivoNativeExpressAdListener;
    }

    @Override // com.vivo.mobilead.unified.a
    protected int f() {
        return 5;
    }

    @Override // com.vivo.mobilead.unified.a
    protected String k() {
        return "4";
    }

    @Override // com.vivo.mobilead.unified.a
    public void l() {
        a(1, 1, -1, false);
    }

    private boolean c(com.vivo.ad.model.b bVar) {
        if (bVar == null) {
            return false;
        }
        if (bVar.Q() == null || TextUtils.isEmpty(bVar.Q().g())) {
            return (bVar.f() == null || bVar.f().b() == null || bVar.f().b().isEmpty()) ? false : true;
        }
        return true;
    }

    @Override // com.vivo.mobilead.unified.a, com.vivo.mobilead.unified.base.callback.f
    public void b(@NonNull AdError adError) {
        z.b().a(new d(adError));
    }

    @Override // com.vivo.mobilead.unified.a
    protected void c() {
        UnifiedVivoNativeExpressAdListener unifiedVivoNativeExpressAdListener = this.t;
        if (unifiedVivoNativeExpressAdListener != null) {
            unifiedVivoNativeExpressAdListener.onAdFailed(new VivoAdError(402136, "二价计费广告位，未传入价格或传入值无效"));
        }
    }

    @Override // com.vivo.mobilead.unified.a, com.vivo.mobilead.unified.base.callback.j
    public void a(@NonNull AdError adError) {
        z.b().a(new c(adError));
    }

    class i extends n {
        i() {
        }

        @Override // com.vivo.ad.view.l
        public void a(View view, int i2, int i3, int i4, int i5, double d2, double d3, boolean z) {
            if (((com.vivo.mobilead.unified.a) a.this).f29666f != null) {
                if (com.vivo.mobilead.util.c.a(view, ((com.vivo.mobilead.unified.a) a.this).f29666f)) {
                    return;
                }
                boolean a2 = com.vivo.mobilead.util.e.a(view, ((com.vivo.mobilead.unified.a) a.this).f29666f);
                k0.a(((com.vivo.mobilead.unified.a) a.this).f29666f, z, i2, i3, i4, i5, a.this.k(), u.a(((com.vivo.mobilead.unified.a) a.this).f29661a, ((com.vivo.mobilead.unified.a) a.this).f29666f, a2, z, ((com.vivo.mobilead.unified.a) a.this).f29662b.getSourceAppend(), a.this.k(), ((com.vivo.mobilead.unified.a) a.this).f29662b.getBackUrlInfo(), 0, ((com.vivo.mobilead.unified.a) a.this).f29668h), ((com.vivo.mobilead.unified.a) a.this).f29662b.getSourceAppend(), 0, view instanceof com.vivo.ad.view.i, a.this.u != null && a.this.u.f(), a2);
                if (!((com.vivo.mobilead.unified.a) a.this).f29666f.a().c()) {
                    k0.a(((com.vivo.mobilead.unified.a) a.this).f29666f, a.EnumC0603a.CLICK, i2, i3, i4, i5, (w) null, -999, -999, -999, -999, ((com.vivo.mobilead.unified.a) a.this).f29662b.getSourceAppend());
                    ((com.vivo.mobilead.unified.a) a.this).f29666f.a().a(true);
                }
            }
            a aVar = a.this;
            UnifiedVivoNativeExpressAdListener unifiedVivoNativeExpressAdListener = aVar.t;
            if (unifiedVivoNativeExpressAdListener != null) {
                unifiedVivoNativeExpressAdListener.onAdClick(aVar.v);
            }
        }

        @Override // com.vivo.ad.view.n
        public void a(View view, int i2, int i3, int i4, int i5, boolean z, String str, int i6) {
            if (((com.vivo.mobilead.unified.a) a.this).f29666f != null) {
                k0.a(((com.vivo.mobilead.unified.a) a.this).f29666f, z, i2, i3, i4, i5, (w) null, a.this.k(), u.a(((com.vivo.mobilead.unified.a) a.this).f29661a, ((com.vivo.mobilead.unified.a) a.this).f29666f, z, z, ((com.vivo.mobilead.unified.a) a.this).f29662b.getSourceAppend(), a.this.k(), ((com.vivo.mobilead.unified.a) a.this).f29662b.getBackUrlInfo(), 0, ((com.vivo.mobilead.unified.a) a.this).f29668h), ((com.vivo.mobilead.unified.a) a.this).f29662b.getSourceAppend(), 0, false, false, str, i6, z);
                if (!((com.vivo.mobilead.unified.a) a.this).f29666f.a().c()) {
                    k0.a(((com.vivo.mobilead.unified.a) a.this).f29666f, a.EnumC0603a.CLICK, i2, i3, i4, i5, -999, -999, -999, -999, ((com.vivo.mobilead.unified.a) a.this).f29662b.getSourceAppend());
                    ((com.vivo.mobilead.unified.a) a.this).f29666f.a().a(true);
                }
            }
            a aVar = a.this;
            UnifiedVivoNativeExpressAdListener unifiedVivoNativeExpressAdListener = aVar.t;
            if (unifiedVivoNativeExpressAdListener != null) {
                unifiedVivoNativeExpressAdListener.onAdClick(aVar.v);
            }
        }
    }

    @Override // com.vivo.mobilead.unified.a, com.vivo.mobilead.unified.base.callback.f
    public void a(@NonNull com.vivo.ad.model.b bVar) {
        z.b().a(new e());
        z.b().a(new f(a(this.y)));
    }

    @Override // com.vivo.mobilead.unified.a
    protected boolean a(long j2) {
        this.w = j2;
        this.x = System.currentTimeMillis();
        e();
        this.f29666f.a().a(1);
        if (!c(this.f29666f)) {
            a(new AdError(40219, "没有广告素材，建议重试", this.f29666f.P(), this.f29666f.J()));
            return false;
        }
        ArrayList arrayList = new ArrayList();
        try {
            if (this.f29666f.Q() == null || TextUtils.isEmpty(this.f29666f.Q().g())) {
                arrayList.addAll(this.f29666f.f().b());
            }
        } catch (Exception unused) {
        }
        if (this.f29666f.M() != null && Build.VERSION.SDK_INT > 22) {
            this.y = a1.a(com.vivo.mobilead.unified.base.d.a().a(this.f29666f).a(com.vivo.mobilead.util.m.c(this.f29661a)));
        }
        if (arrayList.isEmpty()) {
            y0.a(this.f29666f, new g(a(this.y)));
            ArrayList arrayList2 = new ArrayList();
            String c2 = com.vivo.mobilead.util.d.c(this.f29666f);
            if (!TextUtils.isEmpty(c2)) {
                arrayList2.add(c2);
            }
            a1.c(com.vivo.mobilead.unified.base.b.a().a(10000L).a(arrayList2));
        } else {
            y0.a(this.f29666f, (m) null);
            a1.c(com.vivo.mobilead.unified.base.b.a().a(this.f29666f).a(j2).a(arrayList).a(this.f29666f.M() == null).a(this));
        }
        return true;
    }

    public void a(VivoAdError vivoAdError) {
        UnifiedVivoNativeExpressAdListener unifiedVivoNativeExpressAdListener = this.t;
        if (unifiedVivoNativeExpressAdListener != null) {
            unifiedVivoNativeExpressAdListener.onAdFailed(vivoAdError);
        }
    }

    private com.vivo.mobilead.model.b a(Future future) {
        y M = this.f29666f.M();
        com.vivo.mobilead.model.b bVar = null;
        if (M != null && future != null) {
            if (com.vivo.mobilead.util.m.c(this.f29661a) == 1) {
                M.a(1);
            } else {
                M.a(2);
            }
            long j2 = M.j();
            if (j2 > 0) {
                long currentTimeMillis = this.w - (System.currentTimeMillis() - this.x);
                try {
                    if (currentTimeMillis > j2) {
                        future.get(j2, TimeUnit.MILLISECONDS);
                    } else {
                        future.get(currentTimeMillis, TimeUnit.MILLISECONDS);
                    }
                } catch (TimeoutException e2) {
                    k0.a(k(), this.f29666f, 0, 1, "");
                    VOpenLog.w("BaseNativeExpressAdWrap", "waitDynamicInfo1::" + e2.getMessage());
                } catch (Throwable th) {
                    String message = th.getMessage();
                    if (TextUtils.isEmpty(message)) {
                        message = "";
                    } else if (message.length() > 108) {
                        message = message.substring(0, 108);
                    }
                    k0.a(k(), this.f29666f, 0, 2, message);
                    VOpenLog.w("BaseNativeExpressAdWrap", "waitDynamicInfo2::" + th.getMessage());
                }
            }
            String h2 = M.h();
            String i2 = M.i();
            String b2 = com.vivo.mobilead.h.b.a().b(this.f29661a, h2);
            if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(i2)) {
                k0.a(k(), this.f29666f, 1, -1, "");
                bVar = a(b2, i2);
            }
            if (bVar == null) {
                M.a(false);
            } else {
                M.a(true);
                k0.b(k(), this.f29666f, 1, 1, "");
            }
        }
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.vivo.mobilead.model.b a(String str, String str2) {
        String str3 = "";
        try {
            VafContext vafContext = new VafContext(this.f29661a);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            vafContext.setImageLoaderAdapter(new b(atomicBoolean));
            ViewManager viewManager = vafContext.getViewManager();
            Context context = this.f29661a;
            viewManager.init(context, com.vivo.mobilead.util.n.b(context));
            viewManager.setUedScreen(DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED);
            viewManager.getViewFactory().registerBuilder(8001, new a.c());
            viewManager.getViewFactory().registerBuilder(8002, new e.a());
            viewManager.getViewFactory().registerBuilder(8003, new d.a());
            viewManager.getViewFactory().registerBuilder(8004, new c.a());
            viewManager.loadBinFileSync(str);
            View container = vafContext.getContainerService().getContainer(str2, true, com.vivo.mobilead.unified.base.view.s.c.a(this.f29662b, this.f29661a, this.f29666f.F()), null);
            if (container == 0) {
                k0.b(k(), this.f29666f, 0, 1, "");
                return null;
            }
            if ((container instanceof ViewGroup) && ((ViewGroup) container).getChildCount() == 0) {
                k0.b(k(), this.f29666f, 0, 1, "viewType error");
                return null;
            }
            y M = this.f29666f.M();
            if (M != null && M.d() != null) {
                String a2 = M.a();
                if (TextUtils.isEmpty(a2)) {
                    k0.b(k(), this.f29666f, 0, 1, "dynamicConfigValue empty");
                    return null;
                }
                ((IContainer) container).getVirtualView().setVData(new JSONObject(a2));
                if (atomicBoolean.get()) {
                    k0.b(k(), this.f29666f, 0, 3, "getImage null");
                    return null;
                }
                Layout.Params comLayoutParams = ((IContainer) container).getVirtualView().getComLayoutParams();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(comLayoutParams.mLayoutWidth, comLayoutParams.mLayoutHeight);
                layoutParams.leftMargin = comLayoutParams.mLayoutMarginLeft;
                layoutParams.topMargin = comLayoutParams.mLayoutMarginTop;
                layoutParams.rightMargin = comLayoutParams.mLayoutMarginRight;
                layoutParams.bottomMargin = comLayoutParams.mLayoutMarginBottom;
                container.setLayoutParams(layoutParams);
                return new com.vivo.mobilead.model.b(vafContext, container);
            }
            k0.b(k(), this.f29666f, 0, 1, "styleData null");
            return null;
        } catch (ELIllegalArgumentException e2) {
            String message = e2.getMessage();
            if (!TextUtils.isEmpty(message)) {
                str3 = message.length() > 108 ? message.substring(0, 108) : message;
            }
            k0.b(k(), this.f29666f, 0, 2, str3);
            VOpenLog.w("BaseNativeExpressAdWrap", "getDynamicInfo1-->" + e2.getMessage());
            return null;
        } catch (Throwable th) {
            String message2 = th.getMessage();
            if (!TextUtils.isEmpty(message2)) {
                str3 = message2.length() > 108 ? message2.substring(0, 108) : message2;
            }
            k0.b(k(), this.f29666f, 0, 4, str3);
            VOpenLog.w("BaseNativeExpressAdWrap", "getDynamicInfo2-->" + th.getMessage());
            return null;
        }
    }
}
